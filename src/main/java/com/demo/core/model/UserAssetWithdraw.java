package com.demo.core.model;

import com.demo.core.model.base.BaseEntity;

import javax.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Table(name = "bs_user_asset_withdraw")
public class UserAssetWithdraw extends BaseEntity {

    private static final long serialVersionUID = 7151501450207576638L;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 提币数量
     */
    private BigDecimal amount;
    /**
     * 提币手续费
     */
    private BigDecimal fee;
    /**
     * 提币状态
     */
    private Integer status;
    /**
     *提币地址
     */
    private String withdrawAddress;
    /**
     * 资产类型
     */
    private String assetId;
    /**
     * 结束时间
     */
    private Timestamp finishTime;
    /**
     * 添加时间
     */
    private Timestamp createTime;
    /**
     * IP
     */
    private String ip;
    /**
     * 添加方式
     */
    private Integer source;
    /**
     * 手机码
     */
    private String imei;
    /**
     * 备注
     */
    private String remark;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getWithdrawAddress() {
        return withdrawAddress;
    }

    public void setWithdrawAddress(String withdrawAddress) {
        this.withdrawAddress = withdrawAddress;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public Timestamp getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Timestamp finishTime) {
        this.finishTime = finishTime;
    }

    @Override
    public Timestamp getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getSource() {
        return source;
    }

    public void setSource(Integer source) {
        this.source = source;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
