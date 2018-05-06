package com.qianhe.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qianhe.common.SendMail;
import com.qianhe.mapper.InvestmentMapper;
import com.qianhe.model.Investment;
import com.qianhe.model.Page;
import com.qianhe.service.InvestmentService;

@Transactional
@Service
public class InvestmentServiceImpl  implements InvestmentService{
	
	@Resource
	private InvestmentMapper investmentMapper;

	@Override
	public Integer saveInvestment(Investment investment) {
		try {
			SendMail.sendMail("465277288@qq.com","You have new mail, please check!");
			if(!"".equals(investment.getEmail())){
				SendMail.sendMail(investment.getEmail(),"Hello, you have just submitted the information we have received, we will contact you as soon as possible, to provide you with the most suitable for their own business plan.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return investmentMapper.saveInvestment(investment);
	}

	@Override
	public Integer findAllInvestmentCounts() {
		return investmentMapper.findAllInvestmentCounts();
	}

	@Override
	public List<Investment> findAllInvestment(Page page) {
		return investmentMapper.findAllInvestment(page);
	}

	@Override
	public Investment findInvestmentById(String id) {
		return investmentMapper.findInvestmentById(id);
	}

	@Override
	public void updateInvestment(String id) {
		investmentMapper.updateInvestment(id);
	}

	@Override
	public void delInvestment(String id) {
		investmentMapper.delInvestment(id);
	}

	@Override
	public int batchDel(List<String> list) {
		return investmentMapper.batchDel(list);
	}

}
