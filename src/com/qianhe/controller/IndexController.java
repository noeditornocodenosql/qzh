package com.qianhe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qianhe.model.Contact;
import com.qianhe.model.MenuFirst;
import com.qianhe.service.ContactService;
import com.qianhe.service.MenuService;

@Controller
public class IndexController {
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private ContactService contactService;

	@RequestMapping({ "index" })
	public String index(HttpServletRequest request) {
		List<MenuFirst> menulist = menuService.findAllMenus();
		Contact contact = contactService.getAllContact();
		request.getSession().setAttribute("menulist", menulist);
		request.getSession().setAttribute("contact", contact);
		return "index";
	}
}
