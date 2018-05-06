package com.qianhe.service;

import java.util.List;
import com.qianhe.model.Slide;


/**
 * 首页幻灯片
 * @author Administrator
 *
 */
public interface SlideService {
	
	/**
	 * 查找所有首页幻灯片
	 * @return List<Photo>
	 */
	public List<Slide> findAllSlide();
	
	/**
	 * 新增幻灯片
	 * @return null
	 */
	public void saveSlide(Slide slide);
	
	/**
	 * 编辑幻灯片
	 * @return null
	 */
	public void editSlide(Slide slide);
	
	/**
	 *删除幻灯片
	 * @return null
	 */
	public void deleteSlide(Integer id);

	/**
	 * 通过id查找Slide
	 * @return Slide
	 */
	public Slide findSlideById(Integer id);
}
