package com.qianhe.service;

import java.util.List;

import com.qianhe.model.Classify;

public interface ClassifyService {

	public Classify findClassifyById(Integer id);
	public List<Classify> findAllClassify(Integer type);
	public void saveClassify(Classify classify);
	public void updateClassify(Classify classify);
	public void deleteClassify(Integer id);
}
