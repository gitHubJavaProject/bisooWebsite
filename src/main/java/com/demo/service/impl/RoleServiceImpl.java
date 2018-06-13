package com.demo.service.impl;

import com.demo.core.mapper.RoleMapper;
import com.demo.core.model.Role;
import com.demo.mybatis.MyMapper;
import com.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl extends BaseServiceImpl<Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    protected MyMapper<Role> getMapper() {
        return roleMapper;
    }
}
