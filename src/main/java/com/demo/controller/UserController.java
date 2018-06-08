package com.demo.controller;

import com.demo.commons.CommonStatus;
import com.demo.core.model.User;
import com.demo.core.model.UserInfo;
import com.demo.core.model.base.ResultEntity;
import com.demo.service.UserInfoService;
import com.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;

    @RequestMapping("/list")
    public String list() {
        return "users";
    }

    @RequestMapping("")
    @ResponseBody
    public Object users(User user) {
        return convert(userService.findPageByUser(user), user);
    }

    private Map<String, Object> convert(List<User> users, User u) {
        Map<String, Object> map = new HashMap<>();
        for (User user : users) {
            if (null != user.getUserInfo()) {
                if (null != user.getUserInfo().getAdvancedTime()) {
                    user.setIsCard("高级");
                    continue;
                }
                if (null != user.getUserInfo().getPrimaryTime()) {
                    user.setIsCard("初级");
                    continue;
                }
            }
            user.setIsCard("×");
        }
        map.put("status", 200);
        map.put("msg", "");
        map.put("count", userService.count(u.getPhone(), u.getId(), u.getMail()));
        map.put("data",users);
        return map;
    }

    @RequestMapping(value = "/{id}")
    public String get(@PathVariable("id") String id, Model model) {
        User user = userService.findUserAndUserInfoById(id);
        if (null != user) {
            if (null == user.getUserInfo()) {
                user.setUserInfo(new UserInfo());
            }
        } else {
            user = new User();
        }
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    @ResponseBody
    public ResultEntity approval(@PathVariable("id") String id) {
        User user = userService.findUserAndUserInfoById(id);
        user.getUserInfo().setStatus(CommonStatus.APPROVAL);
        userInfoService.updateStatus(user.getUserInfo().getId(), user.getUserInfo().getStatus());
        return new ResultEntity(1, user);
    }

    @RequestMapping("/{id}/chart")
    public String getChart(@PathVariable("id") String id, Model model) {
        model.addAttribute("userId", id);
        return "user_chart";
    }

    @RequestMapping("/{id}/chartData")
    @ResponseBody
    public Object getChartData(@PathVariable("id") String id, String param) {
       List<Map<String, Object>> list = new ArrayList<>();
        Map map = new HashMap();
        map.put("subLevel", "80000001");
        map.put("createTime", "20180608");
        map.put("timeD", "20180101-201800201");
        map.put("account", 3);
        list.add(map);
        return list;
    }

}
