package com.demo.service.impl;

import com.demo.core.mapper.MarketInfoMapper;
import com.demo.core.mapper.UserAccountMapper;
import com.demo.core.model.MarketInfo;
import com.demo.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class UserAccountServiceImpl implements UserAccountService {
    @Autowired
    private UserAccountMapper userAccountMapper;

    @Autowired
    private MarketInfoMapper marketInfoMapper;

    @Override
    public List<Map<String,BigDecimal>> findUserAccountByUserId(String userId, Integer page, Integer size) {
        if (page < 1) {
            page = 1;
        }
        List<String> list = types();
        return userAccountMapper.findUserAccountByUserId(userId, (page-1)*size, size, list);
    }

    @Override
    public long count(String userId) {
        return userAccountMapper.count(userId);
    }

    @Override
    public List<String> types() {
        List<String> list = new ArrayList<>();
        try {
            List<MarketInfo> marketInfos = marketInfoMapper.getDealAssetIdInfo();
            for (MarketInfo marketInfo : marketInfos) {
                list.add(marketInfo.getDealAssetId());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
