package com.qianhe.mapper;

import java.util.List;
import com.qianhe.model.News;
import com.qianhe.model.Page;

public interface NewsMapper {
	public List<News> findAllNews(Page page);
	public Integer findAllNewsCounts();
	public News findNewsById(Integer id);
	public Integer findNewsCategoryCounts(Integer type); //得到某个分类的总数
	public Integer findMaxNewsId(); //查询News最大的Id值
	public List<News> findNewsByCategory(Integer type,Integer startPos,Integer pageSize);
	public List<News> findAllNewsWithNoPage();
	public List<News> findNewsByType(Integer type);
	public void saveNews(News news);
	public void updateNews(News news);
	public void delNews(Integer id);
	public void saveCount(Integer id);
}
