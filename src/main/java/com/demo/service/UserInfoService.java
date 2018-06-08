package com.demo.service;

import com.demo.core.model.UserInfo;
import com.demo.core.model.base.DataBaseEntity;

public interface UserInfoService extends BaseService<UserInfo> {

    void updateStatus(String id, Integer status);
}
