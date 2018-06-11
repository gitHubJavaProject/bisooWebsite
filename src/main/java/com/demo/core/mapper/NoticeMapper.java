package com.demo.core.mapper;

import com.demo.core.model.Notice;
import com.demo.mybatis.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeMapper extends MyMapper<Notice> {

    List<Notice> findPageByNotice(@Param("offset") Integer offset,
                                  @Param("size") Integer size);

    Notice queryNoticeByTypeAndTitle(@Param("typeId") Integer typeId,
                                     @Param("title") String title);

    int count();

    Notice findOne(Object id);
}
