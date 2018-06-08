package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@RequestMapping(value = "")
	public String list() {
		return "欢迎光临";
	}


	@RequestMapping("xx")
	public String getPage(){
		return "recharge_forward";
	}
}
