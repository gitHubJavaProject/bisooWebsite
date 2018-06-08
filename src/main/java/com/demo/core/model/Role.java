package com.demo.core.model;

import com.demo.core.model.base.BaseEntity;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.List;

/**
 * 角色
 */
@Table(name = "bs_role")
public class Role extends BaseEntity {

    private static final long serialVersionUID = -2822014810075964024L;
    private String roleName; //角色名
    private String createAid; //创建人id
    @Transient
    private List<Permission> permissionInfo;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getCreateAid() {
        return createAid;
    }

    public void setCreateAid(String createAid) {
        this.createAid = createAid;
    }

    public List<Permission> getPermissionInfo() {
        return permissionInfo;
    }

    public void setPermissionInfo(List<Permission> permissionInfo) {
        this.permissionInfo = permissionInfo;
    }


}