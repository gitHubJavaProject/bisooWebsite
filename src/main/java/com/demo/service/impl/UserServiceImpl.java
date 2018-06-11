package com.demo.service.impl;

import com.demo.core.mapper.UserMapper;
import com.demo.core.model.Notice;
import com.demo.core.model.User;
import com.demo.core.model.base.DataBaseEntity;
import com.demo.mybatis.MyMapper;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService{
    @Autowired
    private UserMapper userMapper;

    @Override
    protected MyMapper<User> getMapper() {
        return userMapper;
    }


    @Override
    public List<User> findPageByUser(User user) {
        if (user.getPage() <= 0) {
            user.setPage(1);
        }
        return userMapper.findPageByUser(user.getPhone(), user.getId(), user.getMail(), (user.getPage()-1)*user.getRows(), user.getRows());
    }

    @Override
    public User findUserAndUserInfoById(String id) {
        return userMapper.findUserAndUserInfoById(id);
    }

    @Override
    public int count(String phone, String userId, String mail) {
        return userMapper.count(phone, userId, mail);
    }

    public User findOne(String id) {
        return  userMapper.findOne(id);
    }

    @Override
    public DataBaseEntity update(User user) {
        Assert.notNull(user);
        Assert.notNull(user.getId());
        int count = userMapper.updateByPrimaryKeySelective(user);
        User existing = userMapper.findOne(user.getId());
        return new DataBaseEntity(count>0,null==existing?"":existing.getId(),existing);
    }
}
