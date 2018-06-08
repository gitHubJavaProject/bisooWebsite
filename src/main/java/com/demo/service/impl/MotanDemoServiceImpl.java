package com.demo.service.impl;

import com.demo.core.model.base.BaseEntity;
import com.demo.mybatis.MyMapper;
import com.demo.service.MotanDemoService;

public class MotanDemoServiceImpl extends BaseServiceImpl<BaseEntity> implements
		MotanDemoService {

	@Override
	protected MyMapper<BaseEntity> getMapper() {
		return null;
	}

	@Override
	public String hello(String name) {
		System.out.println(name + " invoked rpc service");
		return "hello " + name;
	}

}
