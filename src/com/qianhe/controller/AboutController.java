package com.qianhe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AboutController {
	
	@RequestMapping({ "/about" })
	public String aboutIndex() {
		return "about";
	}
	
	@RequestMapping({ "/aboutgy" })
	public String aboutGY() {
		return "about_gy";
	}
	
	@RequestMapping({ "/aboutwh" })
	public String aboutWH() {
		return "about_wh";
	}

}
