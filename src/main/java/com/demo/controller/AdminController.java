package com.demo.controller;

import com.demo.core.model.Admin;
import com.demo.core.model.base.DataBaseEntity;
import com.demo.core.model.base.ResultEntity;
import com.demo.service.AdminService;
import com.demo.util.DigestUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admins")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 跳转登录页
     */
    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    /**
     * 登录验证
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam(value = "loginName") String loginName,
                        @RequestParam(value = "password") String password,
                        HttpSession session,
                        Model model) {
        model.addAttribute("loginName", loginName);
        model.addAttribute("password", password);
        if (StringUtils.isBlank(loginName)) {
            model.addAttribute("msg", "用户名不能为空");
            return "login";
        }
        if (StringUtils.isBlank(password)) {
            model.addAttribute("msg", "用户密码不能为空");
            return "login";
        }
        Admin admin = adminService.queryUserByName(loginName);
        if (null == admin) {
            model.addAttribute("msg", "用户名不正确");
            return "login";
        }
        if (!admin.getPassword().equals(DigestUtil.MD5Encode(password))) {
            model.addAttribute("msg", "密码不正确");
            return "login";
        }
        session.setAttribute("loginAdmin", admin);
        return "home";
    }

    /**
     * 跳转到修改密码页面
     */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
    public String updatePassword(HttpSession session) {
        return "updatePassword";
    }

    /**
     * 处理修改密码请求
     */
    @RequestMapping(value = "/updatePassword", method = RequestMethod.PATCH)
    @ResponseBody
    public ResultEntity updatePassword(@RequestParam(value = "oldPass") String oldPass,
                                       @RequestParam(value = "newPass") String newPass,
                                       @RequestParam(value = "reNewPass") String reNewPass,
                                       HttpServletRequest request) {
        String userId = ((Admin)request.getSession().getAttribute("loginAdmin")).getId();
        if (StringUtils.isBlank(oldPass)) {
            return new ResultEntity(0, "原密码不能空");
        }
        if (!adminService.findByIdAndPassword(userId, oldPass)) {
            return new ResultEntity(0, "原密码输入不正确");
        }
        if (StringUtils.isBlank(newPass)) {
            return new ResultEntity(0, "新密码不能为空");
        }
        if (newPass.length() < 6 || newPass.length() > 20) {
            return new ResultEntity(0, "密码必须6到20位");
        }
        if (oldPass.equals(newPass)) {
            return new ResultEntity(0, "新密码不能与旧密码相同");
        }
        if (StringUtils.isBlank(reNewPass)) {
            return new ResultEntity(0, "重复密码不能为空");
        }
        if (!reNewPass.equals(newPass)) {
            return new ResultEntity(0, "重复密码与新密码不同");
        }
        Admin admin = new Admin();
        admin.setId(userId);
        admin.setPassword(DigestUtil.MD5Encode(newPass));
        DataBaseEntity dataBaseEntity = adminService.update(admin);
        if (!dataBaseEntity.isSuccess()) {
            return new ResultEntity(0, "系统繁忙，请重试");
        }
        return new ResultEntity(1, "密码修改成功");
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResultEntity create(Admin admin) {
        Admin oldAdmin = adminService.queryUserByName(admin.getLoginName());
        if (null != oldAdmin) {
            return new ResultEntity(0, "用户名已存在");
        }
        admin.setPassword(DigestUtil.MD5Encode(admin.getPassword()));
        DataBaseEntity dataBaseEntity = adminService.create(admin);
        return new ResultEntity(1, "新增成功", dataBaseEntity);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResultEntity delete(@PathVariable("id") String id, HttpSession session) {
        Admin admin = adminService.findOne(id);
        if (null == admin) {
            return new ResultEntity(0, "资源不存在");
        }
        adminService.delete(id);
        return new ResultEntity(1, "删除成功");
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResultEntity update(@PathVariable("id") String id, Admin admin) {
        Admin oldAdmin = adminService.findOne(id);
        if (null == oldAdmin) {
            return new ResultEntity(0, "资源不存在");
        }
        admin.setId(id);
        DataBaseEntity dataBaseEntity = adminService.update(admin);
        return new ResultEntity(1, "修改成功", dataBaseEntity);
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public ResultEntity list(Admin admin) {
        return  new ResultEntity(1, adminService.getAdminList(admin));
    }
}
