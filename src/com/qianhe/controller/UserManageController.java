package com.qianhe.controller;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.qianhe.model.Contact;
import com.qianhe.model.User;
import com.qianhe.service.ContactService;
import com.qianhe.service.InvestmentService;
import com.qianhe.service.RecordService;
import com.qianhe.service.UserService;

@Controller
public class UserManageController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecordService recordService;
	
	@Autowired
	private InvestmentService investmentService;
	
	@Autowired
	private ContactService contactService;
	
	private String message;
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	/**
	 * 进入后台
	 * @return
	 */
	@RequestMapping(value="/ks_2017",method=RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView mav=new ModelAndView("WEB-INF/backstage/loginLine");
		return mav;
	}
	
	/**
	 * 登录验证
	 * @param admin
	 * @param attr
	 * @param session
	 * @return
	 */
	@RequestMapping(value="/ks_2017/main",method=RequestMethod.POST)
	public ModelAndView login(User user,RedirectAttributes attr,HttpSession session){
		ModelAndView mav=new ModelAndView("WEB-INF/backstage/main");
		User currentUser=userService.checkLogin(user);
		Integer counts = investmentService.findAllInvestmentCounts();
		if(currentUser != null){
			session.setAttribute("currentUser", currentUser);
			session.setAttribute("userName", currentUser.getUserName());
			session.setAttribute("counts", counts);
			recordService.savaRecord(currentUser.getUserName()+"登录成功",currentUser.getUserName());
  		return mav;
		}else{
			 message="登录失败:用户名?密码错误?用户未激活?";
			 attr.addFlashAttribute("message", message);
			return new ModelAndView("redirect:/ks_2017");
		}
	}
	
	/**
	 * 密码修改
	 * @return
	 */
	@RequestMapping(value="/jcmx/pcp",method=RequestMethod.GET)
	public String  prepareChangePassWord(){
		return "WEB-INF/backstage/pass";
	}
	
	/**
	 * 密码修改
	 * @return
	 */
	@RequestMapping(value="/jcmx/cp",method=RequestMethod.POST)
	public String  changePassWord(User user){
		userService.updateUser(user);
		return "WEB-INF/backstage/tips";
	}
	
	
	/**
	 * 跳转到后台主页
	 * @return
	 */
	@RequestMapping(value="/jcmx/bmain",method=RequestMethod.GET)
	public String bMain(){
		return "WEB-INF/backstage/main";
	}
	
	@RequestMapping(value="/jcmx/keyword")
	public String  keyword(ModelMap map){
		Contact contact = contactService.getAllContact();
		map.put("contact", contact);
		return "WEB-INF/backstage/keyword";
	}
	
	@RequestMapping(value="/jcmx/upKeyword",method=RequestMethod.POST)
	public String  upKeyword(Contact contact){
		contactService.updateContact(contact);
		return "WEB-INF/backstage/tips";
	}
	
}
