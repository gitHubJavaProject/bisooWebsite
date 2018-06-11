package com.demo.service.impl;

import com.demo.core.mapper.NoticeMapper;
import com.demo.core.model.Notice;
import com.demo.core.model.base.BaseEntity;
import com.demo.core.model.base.DataBaseEntity;
import com.demo.mybatis.MyMapper;
import com.demo.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class NoticeServiceImpl extends BaseServiceImpl<Notice> implements NoticeService {

    @Autowired
    private NoticeMapper noticeMapper;

    @Override
    public List<Notice> findPageByNotice(Notice notice) {
        if (notice.getPage() <= 0) {
            notice.setPage(1);
        }
        return noticeMapper.findPageByNotice((notice.getPage()-1)*notice.getRows(), notice.getRows());
    }

    @Override
    public Notice queryNoticeByTypeAndTitle(Integer type, String title) {
        return noticeMapper.queryNoticeByTypeAndTitle(type, title);
    }

    @Override
    protected MyMapper<Notice> getMapper() {
        return noticeMapper;
    }

    public int count() {
        return noticeMapper.count();
    }

    public Notice findOne(String id) {
        return  noticeMapper.findOne(id);
    }

    @Override
    public DataBaseEntity update(Notice notice) {
        Assert.notNull(notice);
        Assert.notNull(notice.getId());
        int count = noticeMapper.updateByPrimaryKeySelective(notice);
        Notice existing = noticeMapper.findOne(notice.getId());
        return new DataBaseEntity(count>0,null==existing?"":existing.getId(),existing);
    }
}
