package com.demo.controller;

import com.demo.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("roles")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("")
    @ResponseBody
    public Object list() {
        return roleService.findAll();
    }
}
