package com.qianhe.service.impl;

import com.qianhe.mapper.ExampleMapper;
import com.qianhe.model.Example;
import com.qianhe.model.Page;
import com.qianhe.service.ExampleService;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class ExampleServiceImpl implements ExampleService {

	@Resource
	private ExampleMapper exampleMapper;

	@Override
	public List<Example> findAllCase(Page page) {
		return exampleMapper.findAllCase(page);
	}

	@Override
	public int findAllCaseCounts() {
		return exampleMapper.findAllCaseCounts();
	}

	@Override
	public Example findCaseById(Integer id) {
		return exampleMapper.findCaseById(id);
	}

	@Override
	public List<Example> getCaseWithNoPage() {
		return exampleMapper.getCaseWithNoPage();
	}

	@Override
	public List<Example> findExampleByCategory(Integer type, Integer startPos, Integer pageSize) {
		return exampleMapper.findExampleByCategory(type, startPos, pageSize);
	}

	@Override
	public int findCaseCountsByType(Integer type) {
		return exampleMapper.findCaseCountsByType(type);
	}

	@Override
	public void updateExample(Example example) {
		exampleMapper.updateExample(example);
		
	}

	@Override
	public void saveExample(Example example) {
		exampleMapper.saveExample(example);
		
	}

	@Override
	public void delExample(Integer id) {
		exampleMapper.delExample(id);
		
	}

}
