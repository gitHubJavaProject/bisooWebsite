package com.demo.core.mapper;

import com.demo.core.model.UserInfo;
import com.demo.mybatis.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserInfoMapper extends MyMapper<UserInfo> {

    void updateStatus(@Param("id") String id, @Param("status") Integer status);

    UserInfo findOne(Object id);
}
