package com.demo.service.impl;

import com.demo.core.mapper.AdminMapper;
import com.demo.core.model.Admin;
import com.demo.core.model.MarketInfo;
import com.demo.core.model.Notice;
import com.demo.core.model.Permission;
import com.demo.core.model.base.DataBaseEntity;
import com.demo.mybatis.MyMapper;
import com.demo.service.AdminService;
import com.demo.util.ConvertTimeUtil;
import com.demo.util.DigestUtil;
import com.demo.util.IdGen;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService{

    @Autowired
    private AdminMapper adminMapper;

    @Autowired
    private HttpSession session;

    @Override
    public Admin queryUserByName(String userName) {
        return adminMapper.getUserByName(userName);
    }

    @Override
    public boolean findByIdAndPassword(String userId, String oldPass) {
        List<Admin> admin = adminMapper.getAdminPassById(userId, DigestUtil.MD5Encode(oldPass));
        if (null != admin && admin.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    protected MyMapper<Admin> getMapper() {
        return adminMapper;
    }

    public List<Admin> getAdminList(Admin admin) {
        if (admin.getPage() < 1) {
            admin.setPage(1);
        }
        return adminMapper.getAdminList((admin.getPage()-1)*admin.getRows(), admin.getRows());
    }

    public Admin findOne(String id) {
        return  adminMapper.findOne(id);
    }

    @Override
    public DataBaseEntity update(Admin admin) {
        Assert.notNull(admin);
        createRoleAndPermission(admin);
        Assert.notNull(admin.getId());
        int count = adminMapper.updateByPrimaryKeySelective(admin);
        Admin existing = adminMapper.findOne(admin.getId());
        return new DataBaseEntity(count>0,null==existing?"":existing.getId(),existing);
    }

    public DataBaseEntity create(Admin admin) {
        Assert.notNull(admin);
        admin.setCreateAid(getLoginAdmin());
        DataBaseEntity dataBaseEntity = super.create(admin);
        createRoleAndPermission((Admin)dataBaseEntity.getEntity());
        return dataBaseEntity;
    }

    private String getLoginAdmin() {
        return ((Admin)session.getAttribute("loginAdmin")).getId();
    }

    private Admin createRoleAndPermission(Admin admin) {
        adminMapper.deleteAdminRole(admin.getId());
        if (null != admin.getRole()) {
            adminMapper.deleteRolePermission(admin.getRole().getId());
        }
        Timestamp createTime = ConvertTimeUtil.getNowTimestamp();
        if (null != admin.getRole() && null != admin.getPermissions()) {
            adminMapper.createAdminRole(admin.getId(), admin.getRole().getId(), createTime, getLoginAdmin());
            List<Map<String, Object>> list = new ArrayList<>();
            for (Permission permission : admin.getPermissions()) {
                if (StringUtils.isNotBlank(permission.getId())) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("roleId", admin.getRole().getId());
                    map.put("permissionId", permission.getId());
                    map.put("createTime", createTime);
                    map.put("createAid", getLoginAdmin());
                    list.add(map);
                }
            }
            adminMapper.createRolePermission(list);
        }
        return admin;
    }
}
