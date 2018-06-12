package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
	
	@RequestMapping(value = "")
	public String list() {
		return "欢迎光临";
	}


	@RequestMapping("xx")
	public String getPage(){
		return "charge_withdraw";
	}
}
