package com.qianhe.mapper;

import java.util.List;

import com.qianhe.model.Investment;
import com.qianhe.model.Page;

public interface InvestmentMapper {

	Integer saveInvestment(Investment investment);

	Integer findAllInvestmentCounts();

	List<Investment> findAllInvestment(Page page);

	Investment findInvestmentById(String id);
	
	void updateInvestment(String id);

	void delInvestment(String id);

	int batchDel(List<String> list);

}
