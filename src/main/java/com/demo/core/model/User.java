package com.demo.core.model;

import com.demo.core.model.base.BaseEntity;

import javax.persistence.Table;
import javax.persistence.Transient;

@Table(name = "bs_user")
public class User extends BaseEntity{

    private static final long serialVersionUID = 7934126019624297057L;
    /**
     * 手机号
     */
    private String phone;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 头像
     */
    private String imageId;
    /**
     * 邀请码
     */
    private String inviteNum;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 性别
     */
    private Integer sex;
    /**
     * 标签
     */
    private String tag;
    /**
     * 个性标签
     */
    private String signature;
    /**
     * 注册ip
     */
    private String ip;
    /**
     * 手机码
     */
    private String imei;
    /**
     * 邀请人
     */
    private String recommendId;
    /**
     * 注册类型
     */
    private Integer regType;

    /**
     *用户信息
     */
    @Transient
    private UserInfo userInfo;

    /**
     * 是否实名认证
     */
    @Transient
    private String isCard;

    public String getIsCard() {
        return isCard;
    }

    public void setIsCard(String isCard) {
        this.isCard = isCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getImageId() {
        return imageId;
    }

    public void setImageId(String imageId) {
        this.imageId = imageId;
    }

    public String getInviteNum() {
        return inviteNum;
    }

    public void setInviteNum(String inviteNum) {
        this.inviteNum = inviteNum;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getRecommendId() {
        return recommendId;
    }

    public void setRecommendId(String recommendId) {
        this.recommendId = recommendId;
    }

    public Integer getRegType() {
        return regType;
    }

    public void setRegType(Integer regType) {
        this.regType = regType;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
}
