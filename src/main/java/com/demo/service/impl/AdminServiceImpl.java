package com.demo.service.impl;

import com.demo.core.mapper.AdminMapper;
import com.demo.core.model.Admin;
import com.demo.mybatis.MyMapper;
import com.demo.service.AdminService;
import com.demo.util.DigestUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
