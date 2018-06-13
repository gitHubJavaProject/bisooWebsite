package com.demo.core.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Repository
public interface UserAccountMapper {
    List<Map<String,BigDecimal>> findUserAccountByUserId(@Param("userId") String userId,
                                                         @Param("offset") Integer offset,
                                                         @Param("size") Integer size,
                                                         @Param("list") List<String> list);

    long count(@Param("userId") String userId);
}
