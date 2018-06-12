package com.demo.service.impl;

import com.demo.core.mapper.UserAssetWithdrawMapper;
import com.demo.core.model.UserAssetWithdraw;
import com.demo.mybatis.MyMapper;
import com.demo.service.UserAssetWithdrawService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAssetWithdrawServiceImpl extends BaseServiceImpl<UserAssetWithdraw>  implements UserAssetWithdrawService {

    @Autowired
    private UserAssetWithdrawMapper userAssetWithdrawMapper;

    @Override
    protected MyMapper<UserAssetWithdraw> getMapper() {
        return userAssetWithdrawMapper;
    }
}
