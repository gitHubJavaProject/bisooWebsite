package com.demo.service.impl;

import com.demo.core.mapper.AdminMapper;
import com.demo.core.model.Admin;
import com.demo.core.model.Notice;
import com.demo.core.model.base.DataBaseEntity;
import com.demo.mybatis.MyMapper;
import com.demo.service.AdminService;
import com.demo.util.DigestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class AdminServiceImpl extends BaseServiceImpl<Admin> implements AdminService{

    @Autowired
    private AdminMapper adminMapper;
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
        return adminMapper.getAdminList(admin);
    }

    public Admin findOne(String id) {
        return  adminMapper.findOne(id);
    }

    @Override
    public DataBaseEntity update(Admin admin) {
        Assert.notNull(admin);
        Assert.notNull(admin.getId());
        int count = adminMapper.updateByPrimaryKeySelective(admin);
        Admin existing = adminMapper.findOne(admin.getId());
        return new DataBaseEntity(count>0,null==existing?"":existing.getId(),existing);
    }
}
