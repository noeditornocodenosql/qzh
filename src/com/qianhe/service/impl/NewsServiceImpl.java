package com.qianhe.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qianhe.mapper.NewsMapper;
import com.qianhe.model.News;
import com.qianhe.model.Page;
import com.qianhe.service.NewsService;

@Transactional
@Service
public class NewsServiceImpl implements NewsService{
	
	@Resource
	private NewsMapper newsMapper;

	@Override
	public List<News> findAllNews(Page page) {
		return newsMapper.findAllNews(page);
	}

	@Override
	public Integer findAllNewsCounts() {
		return newsMapper.findAllNewsCounts();
	}

	@Override
	public News findNewsById(Integer id) {
		return newsMapper.findNewsById(id);
	}

	@Override
	public Integer findNewsCategoryCounts(Integer type) {
		return newsMapper.findNewsCategoryCounts(type);
	}

	@Override
	public Integer findMaxNewsId() {
		return newsMapper.findMaxNewsId();
	}

	@Override
	public List<News> findNewsByCategory(Integer type, Integer startPos, Integer pageSize) {
		return newsMapper.findNewsByCategory(type, startPos, pageSize);
	}

	@Override
	public List<News> findAllNewsWithNoPage() {
		return newsMapper.findAllNewsWithNoPage();
	}

	@Override
	public List<News> findNewsByType(Integer type) {
		return newsMapper.findNewsByType(type);
	}

	@Override
	public void saveNews(News news) {
		newsMapper.saveNews(news);
		
	}

	@Override
	public void updateNews(News news) {
		newsMapper.updateNews(news);
		
	}

	@Override
	public void delNews(Integer id) {
		newsMapper.delNews(id);
		
	}

	@Override
	public void saveCount(Integer id) {
		newsMapper.saveCount(id);
		
	}

}
