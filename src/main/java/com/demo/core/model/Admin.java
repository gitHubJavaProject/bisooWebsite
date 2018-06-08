package com.demo.core.model;

import com.demo.core.model.base.BaseEntity;

import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 管理员用户
 */
@Table(name = "bs_admin")
public class Admin extends BaseEntity {

    private static final long serialVersionUID = -7852409424955222683L;
    private Integer groupId;//所在工作组
    private String loginName;//登录名
    private String password;//密码
    private Integer jobNumber;//工号
    private String position;//职位
    private String createAid;//创建人id

    @Transient
    private Role roleInfo;

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreateAid() {
        return createAid;
    }

    public void setCreateAid(String createAid) {
        this.createAid = createAid;
    }

    public Role getRoleInfo() {
        return roleInfo;
    }

    public void setRoleInfo(Role roleInfo) {
        this.roleInfo = roleInfo;
    }

    public Integer getJobNumber() {
        return jobNumber;
    }

    public void setJobNumber(Integer jobNumber) {
        this.jobNumber = jobNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}