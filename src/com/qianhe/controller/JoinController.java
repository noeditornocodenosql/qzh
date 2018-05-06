package com.qianhe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class JoinController {
	@RequestMapping({ "/join" })
	public String joinIndex() {
		return "join";
	}
}
