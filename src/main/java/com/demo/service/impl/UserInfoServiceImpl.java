package com.demo.service.impl;

import com.demo.core.mapper.UserInfoMapper;
import com.demo.core.model.User;
import com.demo.core.model.UserInfo;
import com.demo.core.model.base.DataBaseEntity;
import com.demo.mybatis.MyMapper;
import com.demo.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

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

    public UserInfo findOne(String id) {
        return  userInfoMapper.findOne(id);
    }

    @Override
    public DataBaseEntity update(UserInfo userInfo) {
        Assert.notNull(userInfo);
        Assert.notNull(userInfo.getId());
        int count = userInfoMapper.updateByPrimaryKeySelective(userInfo);
        UserInfo existing = userInfoMapper.findOne(userInfo.getId());
        return new DataBaseEntity(count>0,null==existing?"":existing.getId(),existing);
    }
}
