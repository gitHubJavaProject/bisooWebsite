package com.demo.core.mapper;

import com.demo.core.model.Admin;
import com.demo.mybatis.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminMapper extends MyMapper<Admin> {

    /**
     * 根据用户姓名获取用户以及权限信息
     * @param loginName - 用户名
     * @return
     */
    public Admin getUserByName(@Param("loginName") String loginName);

    /**
     * 查询校验用户密码
     * @param userId - 用户id
     * @param oldPass - 旧密码
     * @return
     */
    public List<Admin> getAdminPassById(@Param("userId") String userId, @Param("oldPass") String oldPass);

    /**
     * 获取后台用户列表
     * @param admin
     * @return
     */
    public List<Admin> getAdminList(@Param("admin") Admin admin);
}
