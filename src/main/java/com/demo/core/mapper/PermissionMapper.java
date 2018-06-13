package com.demo.core.mapper;

import com.demo.core.model.Permission;
import com.demo.mybatis.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionMapper extends MyMapper<Permission> {
    List<Permission> findByRole(@Param("id") String id);
}
