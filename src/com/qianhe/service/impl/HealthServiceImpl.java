package com.qianhe.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qianhe.mapper.HealthMapper;
import com.qianhe.model.Health;
import com.qianhe.model.Page;
import com.qianhe.service.HealthService;

@Transactional
@Service
public class HealthServiceImpl implements HealthService {
	
	@Resource
	private HealthMapper healthMapper;
	
	@Override
	public List<Health> findHealthByCategory(Integer type,Integer startPos,Integer pageSize) {
		return healthMapper.findHealthByCategory(type,startPos,pageSize);
	}

	@Override
	public List<Health> findAllHealth(Page page) {
		return healthMapper.findAllHealth(page);
	}

	@Override
	public Integer findAllHealthCounts() {
		return healthMapper.findAllHealthCounts();
	}

	@Override
	public Health findHealthById(Integer id) {
		return healthMapper.findHealthById(id);
	}

	@Override
	public Integer findMaxHealthId() {
		return healthMapper.findMaxHealthId();
	}

	@Override
	public Integer findHealthCategoryCounts(Integer type) {
		return healthMapper.findHealthCategoryCounts(type);
	}

	@Override
	public void updateHealth(Health health) {
		healthMapper.updateHealth(health);
		
	}

	@Override
	public void saveHealth(Health health) {
		healthMapper.saveHealth(health);
		
	}

	@Override
	public void delHealth(Integer id) {
		healthMapper.delHealth(id);
		
	}

	@Override
	public void saveCount(Integer id) {
		healthMapper.saveCount(id);
	}

}
