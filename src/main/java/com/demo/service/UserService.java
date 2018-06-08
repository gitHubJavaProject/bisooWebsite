package com.demo.service;

import com.demo.core.model.User;

import java.util.List;

public interface UserService extends BaseService<User> {

    List<User> findPageByUser(User user);

    User findUserAndUserInfoById(String id);

    int count(String phone, String userId, String mail);
}
