package com.qianhe.service;

import com.qianhe.model.Example;
import com.qianhe.model.Page;
import java.util.List;

public interface ExampleService {

	public List<Example> findAllCase(Page page);

	public int findAllCaseCounts();

	public Example findCaseById(Integer id);

	public List<Example> getCaseWithNoPage();
	
	public List<Example> findExampleByCategory(Integer type,Integer startPos,Integer pageSize);

	public int findCaseCountsByType(Integer type);
	
	public void updateExample(Example example);
	
	public void saveExample(Example example);
	
	public void delExample(Integer id);

}
