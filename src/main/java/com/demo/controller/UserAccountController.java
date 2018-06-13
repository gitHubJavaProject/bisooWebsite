package com.demo.controller;

import com.demo.service.UserAccountService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("userAccounts")
public class UserAccountController {

    @Autowired
    private UserAccountService userAccountService;

    @RequestMapping("")
    @ResponseBody
    public Object list(String userId, Integer page, Integer rows) {
        return convert(userAccountService.findUserAccountByUserId(userId,page,rows), userId);
    }

    private Map<String, Object> convert(List<Map<String, BigDecimal>> list, String userId) {
        Map<String,Object> map = new HashMap<>();
        map.put("status", 200);
        map.put("msg", "");
        map.put("data", list);
        map.put("count", userAccountService.count(userId));
        return map;
    }

    @RequestMapping("types")
    @ResponseBody
    public Object types() {
        return userAccountService.types();
    }
}
