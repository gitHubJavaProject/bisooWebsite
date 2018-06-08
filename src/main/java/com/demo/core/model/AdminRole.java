package com.demo.core.model;

import com.demo.core.model.base.BaseEntity;

import javax.persistence.Table;

/**
 * 用户角色
 */
@Table(name="bs_admin_role")
public class AdminRole extends BaseEntity {

    private static final long serialVersionUID = 474606535058881527L;
    private String adminId;//管理员id
    private String roleId;//角色id
    private String createAid;//创建人id

    public String getAdminId() {
        return adminId;
    }
    public void setAdminId(String adminId) {
        this.adminId = adminId;
    }
    public String getRoleId() {
        return roleId;
    }
    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }
    public String getCreateAid() {
        return createAid;
    }
    public void setCreateAid(String createAid) {
        this.createAid = createAid;
    }

}
