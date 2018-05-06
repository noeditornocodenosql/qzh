package com.qianhe.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.qianhe.model.Investment;
import com.qianhe.model.Page;
import com.qianhe.service.InvestmentService;


@Controller
public class InvestmentAction {
	
	@Autowired
	private InvestmentService investmentService;
	
	@RequestMapping({ "/investment" })
	@ResponseBody
	public void  saveInvestment(Investment investment) {
		 investmentService.saveInvestment(investment);
	}
	
	/**
	 * 后台 投资自助-列表
	 * @param pageNow
	 * @return investment.jsp
	 */
	@RequestMapping({ "/jcmx/i/{pageNow}" })
	public ModelAndView be(@PathVariable Integer pageNow) {
		ModelAndView mav=new ModelAndView("WEB-INF/backstage/investment");
		List<Investment> investmentList=null;
		Page page = null;
		int totalCount = investmentService.findAllInvestmentCounts();
		if (pageNow != null) {
			page = new Page(totalCount,pageNow);
			investmentList = investmentService.findAllInvestment(page);
		} else {
			page = new Page(totalCount, 1);
			investmentList = investmentService.findAllInvestment(page);
		}
		mav.addObject(page);
		mav.addObject(investmentList);
		return mav;
	}
	
	/**
	 * 后台 投资自助-查看
	 * @return see.jsp
	 */
	@RequestMapping({ "/jcmx/i/see" })
	@ResponseBody
	public void investmentSee(String id) {
		investmentService.updateInvestment(id);
	}
	
	/**
	 * 后台 投资自助-查看
	 * @return see.jsp
	 */
	@RequestMapping({ "/jcmx/i/del" })
	public String investmentDel(String id) {
		investmentService.delInvestment(id);
		return "redirect:/jcmx/i/1";
	}
	
	/**
	 *  批量删除
	 */
	@RequestMapping("/jcmx/i/batchDel")
	@ResponseBody
	public int backBatchDel(String ids){
		List<String> idsTemp = Arrays.asList(ids.split(","));  
		return investmentService.batchDel(idsTemp);
	}

}
