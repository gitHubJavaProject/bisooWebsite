package com.demo.service;

import com.demo.core.model.Notice;

import java.util.List;

public interface NoticeService extends BaseService<Notice> {

    List<Notice> findPageByNotice(Notice notice);

    Notice queryNoticeByTypeAndTitle(Integer type, String title);

    int count();

}
