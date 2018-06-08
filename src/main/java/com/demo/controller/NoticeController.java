package com.demo.controller;

import com.demo.core.model.Notice;
import com.demo.core.model.base.DataBaseEntity;
import com.demo.core.model.base.ResultEntity;
import com.demo.service.NoticeService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/notices")
public class NoticeController {

    @Autowired
    private NoticeService noticeService;

    @RequestMapping("/list")
    public String list() {
        return "notices";
    }

    @RequestMapping("")
    @ResponseBody
    public Object notices(Notice notice) {
        return convert(noticeService.findPageByNotice(notice));
    }

    private Map<String, Object> convert(List<Notice> notices) {
        Map<String, Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("msg", "");
        map.put("count", noticeService.count());
        map.put("data",notices);
        return map;
    }

    @RequestMapping("/_")
    public String getCreatePage(Model model) {
        model.addAttribute("notice", new Notice());
        return "notice";
    }

    @RequestMapping("/{id}")
    public String getUpdatePage(@PathVariable("id") String id, Model model) {
        Notice notice = noticeService.findOne(id);
        model.addAttribute("notice", notice);
        return "notice";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResultEntity create(Notice notice) {
        Notice oldNotice = noticeService.queryNoticeByTypeAndTitle(notice.getTypeId(), notice.getTitle());
        if (null != oldNotice) {
            return new ResultEntity(0, "宣传已存在");
        }
        DataBaseEntity dataBaseEntity = noticeService.create(notice);
        return new ResultEntity(1, "新增成功", dataBaseEntity);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResultEntity delete(@PathVariable("id") String id, HttpSession session) {
        Notice notice = noticeService.findOne(id);
        if (null == notice) {
            return new ResultEntity(0, "资源不存在");
        }
        noticeService.delete(id);
        return new ResultEntity(1, "删除成功");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResultEntity update(@PathVariable("id") String id, Notice notice) {
        Notice oldNotice = noticeService.findOne(id);
        if (null == oldNotice) {
            return new ResultEntity(0, "资源不存在");
        }
        notice.setId(id);
        DataBaseEntity dataBaseEntity = noticeService.update(notice);
        return new ResultEntity(1, "修改成功", dataBaseEntity);
    }

}
