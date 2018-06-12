package com.demo.core.model.chargeAndWithdrawOutData;

import com.demo.core.model.base.BaseEntity;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

public class ChargeAndWithdraw extends BaseEntity {

    private static final long serialVersionUID = -5040673498564870796L;

    /**
     * 结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date finishTime;
    /**
     * 用户ID
     */
    private String userId;
    /**
     * 类型（0充币 | 1提币）
     */
    private String type;
    /**
     * 资产id
     */
    private String assetId;
    /**
     * 资产名称
     */
    private String assetName;
    /**
     * 充提币数量
     */
    private BigDecimal amount;
    /**
     *地址
     */
    private String withdrawAddress;

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getWithdrawAddress() {
        return withdrawAddress;
    }

    public void setWithdrawAddress(String withdrawAddress) {
        this.withdrawAddress = withdrawAddress;
    }
}
