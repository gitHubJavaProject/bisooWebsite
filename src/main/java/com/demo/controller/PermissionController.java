package com.demo.controller;

import com.demo.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("permissions")
public class PermissionController {

    @Autowired
    private PermissionService permissionService;

    @RequestMapping("")
    @ResponseBody
    public Object list() {
        return permissionService.findAll();
    }

    @RequestMapping("byRole/{id}")
    @ResponseBody
    public Object pers(@PathVariable("id") String id) {
        return permissionService.findByRole(id);
    }
}
