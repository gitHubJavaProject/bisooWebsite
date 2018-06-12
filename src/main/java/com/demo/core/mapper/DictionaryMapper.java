package com.demo.core.mapper;

import com.demo.core.model.Dictionary;
import com.demo.mybatis.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DictionaryMapper extends MyMapper<Dictionary> {

    List<Dictionary> findPageByDictionary(@Param("offset") Integer offset,
                                          @Param("size") Integer size,
                                          @Param("name") String name,
                                          @Param("type") String type);

    long count(Dictionary dictionary);

    Dictionary findOne(Object id);

    List<Dictionary> findByType(@Param("type") String type);
}
