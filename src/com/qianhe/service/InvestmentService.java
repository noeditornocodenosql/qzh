package com.qianhe.service;


import java.util.List;

import com.qianhe.model.Investment;
import com.qianhe.model.Page;

public interface InvestmentService {
	
	public Integer saveInvestment(Investment investment);
	
	public Integer findAllInvestmentCounts(); //查询未读消息数量

	public List<Investment> findAllInvestment(Page page);//查询所有消息

	public Investment findInvestmentById(String id);//查看
	
	void updateInvestment(String id);

	public void delInvestment(String id);

	public int batchDel(List<String> list);

}
