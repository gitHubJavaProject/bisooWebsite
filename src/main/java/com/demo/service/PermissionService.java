package com.demo.service;

import com.demo.core.model.Permission;

import java.util.List;

public interface PermissionService extends BaseService<Permission> {
    List<Permission> findByRole(String id);
}
