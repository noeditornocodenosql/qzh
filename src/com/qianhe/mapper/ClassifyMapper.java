package com.qianhe.mapper;

import java.util.List;
import com.qianhe.model.Classify;

public interface ClassifyMapper {
	
	public Classify findClassifyById(Integer id);
	public List<Classify> findAllClassify(Integer type);
	public void saveClassify(Classify classify);
	public void updateClassify(Classify classify);
	public void deleteClassify(Integer id);

}
