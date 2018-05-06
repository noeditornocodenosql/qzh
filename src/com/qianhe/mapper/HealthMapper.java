package com.qianhe.mapper;

import java.util.List;
import com.qianhe.model.Health;
import com.qianhe.model.Page;

public interface HealthMapper {
	public List<Health> findAllHealth(Page page);
	public Integer findAllHealthCounts();
	public Health findHealthById(Integer id);
	public Integer findHealthCategoryCounts(Integer type); //得到某个分类的总数
	public Integer findMaxHealthId(); //查询health最大的Id值
	public List<Health> findHealthByCategory(Integer type,Integer startPos,Integer pageSize);
	public void updateHealth(Health health);
	public void saveHealth(Health health);
	public void delHealth(Integer id);
	public void saveCount(Integer id);
}
