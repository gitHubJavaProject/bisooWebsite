package com.demo.core.mapper;

import com.demo.core.model.User;
import com.demo.mybatis.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends MyMapper<User> {

    List<User> findPageByUser(@Param("phone") String phone,
                              @Param("userId") String userId,
                              @Param("mail") String mail,
                              @Param("offset") Integer offset,
                              @Param("size") Integer size);

    User findUserAndUserInfoById(@Param("id") String id);

    int count(@Param("phone") String phone,
              @Param("userId") String userId,
              @Param("mail") String mail);

}
