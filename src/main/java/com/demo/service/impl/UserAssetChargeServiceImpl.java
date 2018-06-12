package com.demo.service.impl;

import com.demo.core.mapper.UserAssetChargeMapper;
import com.demo.core.model.UserAssetCharge;
import com.demo.mybatis.MyMapper;
import com.demo.service.UserAssetChargeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAssetChargeServiceImpl extends BaseServiceImpl<UserAssetCharge> implements UserAssetChargeService {

    @Autowired
    private UserAssetChargeMapper userAssetChargeMapper;

    @Override
    protected MyMapper<UserAssetCharge> getMapper() {
        return userAssetChargeMapper;
    }
}
