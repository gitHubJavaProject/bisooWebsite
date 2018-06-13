package com.demo.core.mapper;

import com.demo.core.model.Admin;
import com.demo.mybatis.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Repository
public interface AdminMapper extends MyMapper<Admin> {

    /**
     * 根据用户姓名获取用户以及权限信息
     * @param loginName - 用户名
     * @return
     */
     Admin getUserByName(@Param("loginName") String loginName);

    /**
     * 查询校验用户密码
     * @param userId - 用户id
     * @param oldPass - 旧密码
     * @return
     */
     List<Admin> getAdminPassById(@Param("userId") String userId, @Param("oldPass") String oldPass);

    /**
     * 获取后台用户列表
     * @param admin
     * @return
     */
     List<Admin> getAdminList(@Param("offset") Integer offset,
                              @Param("size") Integer size);

     Admin findOne(Object id);

    void deleteAdminRole(@Param("id") String id);

    void deleteRolePermission(@Param("id") String id);

    void createAdminRole(@Param("adminId") String adminId,
                         @Param("roleId") String roleId,
                         @Param("createTime") Timestamp createTime,
                         @Param("createAid") String createAid);

    void createRolePermission(@Param("list") List<Map<String, Object>> list);
}
