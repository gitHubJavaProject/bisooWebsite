package com.demo.core.model;

import com.demo.core.model.base.BaseEntity;

import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "bs_user_info")
public class UserInfo extends BaseEntity {

    private static final long serialVersionUID = 6039392241293113276L;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 身份证号
     */
    private String idCard;
    /**
     * 身份证前面
     */
    private String idcardFront;
    /**
     * 身份证后面
     */
    private String idcardBack;
    /**
     * 手持身份证
     */
    private String idcardHandheld;
    /**
     * 认证状态
     */
    private Integer status;
    /**
     * 初级认证时间
     */
    private Timestamp primaryTime;
    /**
     * 高级认证时间
     */
    private Timestamp advancedTime;

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getIdcardFront() {
        return idcardFront;
    }

    public void setIdcardFront(String idcardFront) {
        this.idcardFront = idcardFront;
    }

    public String getIdcardBack() {
        return idcardBack;
    }

    public void setIdcardBack(String idcardBack) {
        this.idcardBack = idcardBack;
    }

    public String getIdcardHandheld() {
        return idcardHandheld;
    }

    public void setIdcardHandheld(String idcardHandheld) {
        this.idcardHandheld = idcardHandheld;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getPrimaryTime() {
        return primaryTime;
    }

    public void setPrimaryTime(Timestamp primaryTime) {
        this.primaryTime = primaryTime;
    }

    public Timestamp getAdvancedTime() {
        return advancedTime;
    }

    public void setAdvancedTime(Timestamp advancedTime) {
        this.advancedTime = advancedTime;
    }
}
