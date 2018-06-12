package com.demo.service.impl;

import com.demo.core.mapper.MarketInfoMapper;
import com.demo.core.model.MarketInfo;
import com.demo.service.MarketInfoService;
import com.demo.util.IdGen;
import com.demo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 市场资产业务Service
 */
@Service
public class MarketInfoServiceImpl implements MarketInfoService {

    @Autowired
    private MarketInfoMapper marketInfoMapper;              //市场资产Mapper


    @Override
    public JsonResult getDealAssetIdInfo() throws Exception {
        return null;
    }

    @Override
    public JsonResult getMarketAssetIdInfo() throws Exception {

        List<Map<String, Object>> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();

        List<MarketInfo> dealAssetIdList = marketInfoMapper.getDealAssetIdInfo();       //交易资产分类

        List<MarketInfo> marketAssetIdList = marketInfoMapper.getMarketAssetIdInfo();   //币币对比

        List<MarketInfo> marketList = new ArrayList<>();

        MarketInfo market = null;

        for (MarketInfo dealAssetId : dealAssetIdList) {

            for (MarketInfo marketInfo : marketAssetIdList) {

                if (dealAssetId.getDealAssetId().equals(marketInfo.getDealAssetId())) {

                    market = new MarketInfo();

                    market.setPortfolioAssets(marketInfo.getMarketAssetId() + "/" + dealAssetId.getDealAssetId());
                    market.setStatus(marketInfo.getStatus());
                    market.setId(marketInfo.getId());

                    marketList.add(marketInfo);

                }

            }

            map.put("dealAssetId", dealAssetId.getDealAssetId());
            map.put("list", marketList);

            list.add(map);

            marketList = new ArrayList<>();
            map = new HashMap<>();


        }

        return JsonResult.build(200, "查询产品信息", list);
    }

    @Override
    public JsonResult modifyMarketDealAsset(MarketInfo marketInfo) throws Exception {

        Integer num = marketInfoMapper.modifyMarketDealAsset(marketInfo);
        if (num == 0) {
            return JsonResult.build(2002, "产品下架失败", "");
        }

        return JsonResult.build(200, "产品下架成功", num);
    }

    @Override
    public JsonResult insertMarketInfo(MarketInfo marketInfo) throws Exception {

        Integer exists = marketInfoMapper.getMarketInfoByMarketAssetId(marketInfo);

        if (exists > 0) {
            return JsonResult.build(2002, "该产品已存在", "");
        }

        marketInfo.setId(IdGen.uuid());     //生成UUID
        Integer num = marketInfoMapper.insertMarketInfo(marketInfo);
        if (num == 0) {
            return JsonResult.build(2002, "添加平台资产信息失败", "");
        }

        return JsonResult.build(200, "添加平台资产信息成功", num);
    }

    @Override
    public JsonResult getAllMarketInfo() throws Exception {

        List<MarketInfo> marketInfoList = marketInfoMapper.getAllMarketInfo();
        return JsonResult.build(200, "查询平台资产所有品种", marketInfoList);
    }

    @Override
    public JsonResult getAssetOrderHistoryList() throws Exception {
        return null;
    }


}
