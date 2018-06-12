package com.demo.controller;

import com.demo.core.model.Dictionary;
import com.demo.core.model.MarketInfo;
import com.demo.service.MarketInfoService;
import com.demo.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("marketInfo")
public class MarketInfoController {

    @Autowired
    private MarketInfoService marketInfoService;

    @RequestMapping("list")
    public String list() {
        return "marketInfo";
    }

    /**
     * 查询产品分类
     * @return
     */
    @RequestMapping(value="",method= RequestMethod.GET)
    @ResponseBody
    public JsonResult getMarketInfo(){

        JsonResult result = new JsonResult();

        try{

            result = marketInfoService.getMarketAssetIdInfo();

        }catch (Exception e){
            e.printStackTrace();

            return JsonResult.build(2001,"出现异常","");
        }

        return result;

    }


    /**
     * 下架产品信息
     * @param marketInfo
     * @param request
     * @return
     */
    @RequestMapping(value = "/modifyDealAssetMarketInfo",method=RequestMethod.POST)
    public JsonResult modifyDealAssetMarketInfo(MarketInfo marketInfo, HttpServletRequest request){

        JsonResult result = new JsonResult();

        try{

            result = marketInfoService.modifyMarketDealAsset(marketInfo);

        }catch (Exception e){
            e.printStackTrace();

            return JsonResult.build(2001,"出现异常","");
        }

        return result;
    }


    /**
     * 添加平台资产信息
     * @param marketInfo
     * @param request
     * @return
     */
    @RequestMapping(value = "/addDealAssetMarketInfo",method=RequestMethod.POST)
    public JsonResult addDealAssetMarketInfo(MarketInfo marketInfo, HttpServletRequest request){

        JsonResult result = new JsonResult();

        try{

            result = marketInfoService.insertMarketInfo(marketInfo);

        }catch (Exception e){
            e.printStackTrace();

            return JsonResult.build(2001,"出现异常","");
        }

        return result;
    }
}
