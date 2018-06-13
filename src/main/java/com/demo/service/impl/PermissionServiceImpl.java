package com.demo.service.impl;

import com.demo.core.mapper.PermissionMapper;
import com.demo.core.model.Permission;
import com.demo.mybatis.MyMapper;
import com.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl extends BaseServiceImpl<Permission> implements PermissionService {

    @Autowired
    private PermissionMapper permissionMapper;

    @Override
    protected MyMapper<Permission> getMapper() {
        return permissionMapper;
    }

    @Override
    public List<Permission> findByRole(String id) {
        return permissionMapper.findByRole(id);
    }
}
