package com.qianhe.service;

import java.util.List;
import com.qianhe.model.Health;
import com.qianhe.model.Page;

public interface HealthService {
	public List<Health> findAllHealth(Page page);
	public Integer findAllHealthCounts();
	public Health findHealthById(Integer id);
	public Integer findMaxHealthId();
	public Integer findHealthCategoryCounts(Integer type);
	public List<Health> findHealthByCategory(Integer type,Integer startPos,Integer pageSize);
	public void updateHealth(Health health);
	public void saveHealth(Health health);
	public void delHealth(Integer id);
	public void saveCount(Integer id);
}
