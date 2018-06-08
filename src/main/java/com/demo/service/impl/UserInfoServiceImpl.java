package com.demo.service.impl;

import com.demo.core.mapper.UserInfoMapper;
import com.demo.core.model.UserInfo;
import com.demo.mybatis.MyMapper;
import com.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo> implements UserInfoService{

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    protected MyMapper<UserInfo> getMapper() {
        return userInfoMapper;
    }

    public void updateStatus(String id, Integer status) {
       userInfoMapper.updateStatus(id, status);
    }
}
