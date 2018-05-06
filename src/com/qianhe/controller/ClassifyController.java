package com.qianhe.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qianhe.model.Classify;
import com.qianhe.service.ClassifyService;

@Controller
public class ClassifyController {
	
	@Autowired
	private ClassifyService classifyService;
	

	@RequestMapping({ "/classify/{type}" })
	public String classifyInfo(@PathVariable Integer type,ModelMap map){
		List<Classify> classifyList=classifyService.findAllClassify(type);
		map.addAttribute("classifyList", classifyList);
		map.addAttribute("type", type);
		return "WEB-INF/backstage/classifyListResult";
	}
	
	@RequestMapping({ "/preSaveClassify/{type}" })
	public String preSaveClassify(@PathVariable Integer type,ModelMap map){
		map.put("type", type);
		return "WEB-INF/backstage/classifyAdd";
	}
	
	@RequestMapping({ "/saveClassify/{type}" })
	public String saveClassify(Classify classify,@PathVariable Integer type){
		classifyService.saveClassify(classify);
		return "redirect:/classify/{type}";
	}
	
	@RequestMapping({ "/preEditClassify/{id}/{type}" })
	public String preEditClassify(@PathVariable Integer id,ModelMap map,@PathVariable Integer type){
		Classify classify=classifyService.findClassifyById(id);
		map.addAttribute("classify", classify);
		return "WEB-INF/backstage/classifyForm";
	}
	
	@RequestMapping({ "/editClassify/{type}" })
	public String editClassify(@PathVariable Integer type,Classify classify){
		classifyService.updateClassify(classify);
		return "redirect:/classify/{type}";
	}
	
	@RequestMapping({ "/delClassify/{id}/{type}" })
	public String delClassify(@PathVariable Integer type,Classify classify,@PathVariable Integer id){
		classifyService.deleteClassify(id);
		return "redirect:/classify/{type}";
	}

}
