package com.demo.core.model;

import com.demo.core.model.base.BaseEntity;

import javax.persistence.Table;

/**
 * 角色权限表
 */
@Table(name="bs_role_permission")
public class RolePermission extends BaseEntity {

    private static final long serialVersionUID = 1643928993735272743L;
    private String roleId;//角色id
    private String permissionId;//权限id
    private String createAid;//创建人id


    public String getRoleId() {
        return roleId;
    }
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public String getPermissionId() {
        return permissionId;
    }
    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }
    public String getCreateAid() {
        return createAid;
    }
    public void setCreateAid(String createAid) {
        this.createAid = createAid;
    }
}

