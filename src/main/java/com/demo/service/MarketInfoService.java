package com.demo.service;

import com.demo.core.model.MarketInfo;
import com.demo.util.JsonResult;

import java.util.List;

/**
 * 市场资产Service
 */
public interface MarketInfoService {

    /**
     * 查询市场资产类型
     * @return
     * @throws Exception
     */
    public JsonResult getDealAssetIdInfo()throws Exception;

    /**
     * 按市场资产查询交易资产类型
     * @return
     * @throws Exception
     */
    public JsonResult getMarketAssetIdInfo()throws Exception;

    /**
     * 下架产品
     * @param marketInfo
     * @return
     * @throws Exception
     */
    public JsonResult modifyMarketDealAsset(MarketInfo marketInfo)throws Exception;

    /**
     * 添加平台资产信息
     * @param marketInfo
     * @return
     * @throws Exception
     */
    public JsonResult insertMarketInfo(MarketInfo marketInfo)throws Exception;

    /**
     * 查询所有品种
     * @return
     * @throws Exception
     */
    public JsonResult getAllMarketInfo()throws Exception;


    public JsonResult getAssetOrderHistoryList()throws Exception;


}
