package com.demo.core.model;


import com.demo.core.model.base.BaseEntity;
import javax.persistence.Table;

/**
 * 平台市场表
 */
@Table(name = "bs_market_info")
public class MarketInfo extends BaseEntity {

    private static final long serialVersionUID = 8227088435984193541L;

    //private String id;            //编号

    private String marketAssetId;   //市场资产

    private String dealAssetId;     //交易资产

    private Boolean status;         //币种的上下架(0、下架 1、上架)

    //private Timestamp createTime; //添加时间

    //private Timestamp updateTime; //更新时间

    private String portfolioAssets; //市场资产/交易资产

    public String getMarketAssetId() {
        return marketAssetId;
    }

    public void setMarketAssetId(String marketAssetId) {
        this.marketAssetId = marketAssetId;
    }

    public String getDealAssetId() {
        return dealAssetId;
    }

    public void setDealAssetId(String dealAssetId) {
        this.dealAssetId = dealAssetId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getPortfolioAssets() {
        return portfolioAssets;
    }

    public void setPortfolioAssets(String portfolioAssets) {
        this.portfolioAssets = portfolioAssets;
    }
}
