package com.demo.service;

import com.demo.core.model.Admin;

import java.util.List;

public interface AdminService extends BaseService<Admin>{
    /**
     * 登录验证
     * @param userName
     * @return
     */
    Admin queryUserByName(String userName);

    boolean findByIdAndPassword(String userId, String oldPass);

    List<Admin> getAdminList(Admin admin);
}

