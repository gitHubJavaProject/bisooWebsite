package com.demo.core.mapper;


import com.demo.core.model.MarketInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 平台市场Mapper
 */
public interface MarketInfoMapper {

    /**
     * 查询市场资产类型
     * @return
     * @throws Exception
     */
    public List<MarketInfo> getDealAssetIdInfo()throws Exception;

    /**
     * 按市场资产查询交易资产类型
     * @return
     * @throws Exception
     */
    public List<MarketInfo> getMarketAssetIdInfo()throws Exception;

    /**
     * 下架产品
     * @param marketInfo
     * @return
     * @throws Exception
     */
    public Integer modifyMarketDealAsset(MarketInfo marketInfo)throws Exception;

    /**
     * 查询币种是否唯一
     * @param marketInfo
     * @return
     * @throws Exception
     */
    public Integer getMarketInfoByMarketAssetId(MarketInfo marketInfo)throws Exception;

    /**
     * 添加平台资产信息
     * @param marketInfo
     * @return
     * @throws Exception
     */
    public Integer insertMarketInfo(MarketInfo marketInfo)throws Exception;


    /**
     * 查询所有品种
     * @return
     * @throws Exception
     */
    public List<MarketInfo> getAllMarketInfo()throws Exception;

}
