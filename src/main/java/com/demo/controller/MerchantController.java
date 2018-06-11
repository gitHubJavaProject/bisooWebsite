package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("merchants")
public class MerchantController {


    @RequestMapping("list")
    public String getListPage() {
        return "merchants";
    }

}
