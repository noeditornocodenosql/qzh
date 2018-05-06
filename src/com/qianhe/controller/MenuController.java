package com.qianhe.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qianhe.model.MenuFirst;
import com.qianhe.service.MenuService;

@Controller
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping("/jcmx/menu")
	public String menuStart(ModelMap map){
		List<MenuFirst> menuList=menuService.findAllMenus();
		map.put("menuList", menuList);
		return "WEB-INF/backstage/column";
	}
	
	@RequestMapping("/jcmx/menu/tu")
	public String menuToUpdate(String fid,HttpServletRequest request){
		MenuFirst menuFirst=menuService.findMenuById(fid);
		request.setAttribute("menuFirst", menuFirst);
		return "WEB-INF/backstage/columnu";
	}
	
	@RequestMapping("/jcmx/menu/u")
	public String menuUpdate(MenuFirst menuFirst){
		menuService.updateMenu(menuFirst);
		return "redirect:/jcmx/menu";
	}
	
	@RequestMapping("/jcmx/menu/ts")
	public String menuToSave(){
		return "WEB-INF/backstage/columns";
	}
	
	@RequestMapping("/jcmx/menu/s")
	public String menuSave(MenuFirst menuFirst){
		menuService.saveMenu(menuFirst);
		return "redirect:/jcmx/menu";
	}
	
	@RequestMapping("/jcmx/menu/d")
	public String menuDel(String fid){
		menuService.delMenu(fid);
		return "redirect:/jcmx/menu";
	}


}
