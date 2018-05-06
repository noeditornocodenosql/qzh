package com.qianhe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ServiceController {
	
	@RequestMapping({ "/service" })
	public String serviceIndex() {
		return "service/index";
	}

}
