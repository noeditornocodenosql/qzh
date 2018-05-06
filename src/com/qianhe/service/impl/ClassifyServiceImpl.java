package com.qianhe.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qianhe.mapper.ClassifyMapper;
import com.qianhe.model.Classify;
import com.qianhe.service.ClassifyService;

@Transactional
@Service
public class ClassifyServiceImpl implements ClassifyService {
	
	@Resource
	private ClassifyMapper classifyMapper;

	@Override
	public Classify findClassifyById(Integer id) {
		return classifyMapper.findClassifyById(id);
	}

	@Override
	public List<Classify> findAllClassify(Integer type) {
		return classifyMapper.findAllClassify(type);
	}

	@Override
	public void saveClassify(Classify classify) {
		classifyMapper.saveClassify(classify);

	}

	@Override
	public void updateClassify(Classify classify) {
		classifyMapper.updateClassify(classify);

	}

	@Override
	public void deleteClassify(Integer id) {
		classifyMapper.deleteClassify(id);

	}

}
