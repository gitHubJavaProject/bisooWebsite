package com.demo.core.model;

import com.demo.core.model.base.BaseEntity;

import javax.persistence.Table;

/**
 * 权限
 */
@Table(name = "bsi_permission")
public class Permission extends BaseEntity {

    private static final long serialVersionUID = 2550175081043212315L;
    private String permissionName;//权限名
    private String permissionNid;//权限简写
    private String permissionLink;//权限链接
    private Integer type;//权限类型
    private String parentId;//父ID
    private String createAid;//添加人

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getPermissionNid() {
        return permissionNid;
    }

    public void setPermissionNid(String permissionNid) {
        this.permissionNid = permissionNid;
    }

    public String getPermissionLink() {
        return permissionLink;
    }

    public void setPermissionLink(String permissionLink) {
        this.permissionLink = permissionLink;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getCreateAid() {
        return createAid;
    }

    public void setCreateAid(String createAid) {
        this.createAid = createAid;
    }

}

