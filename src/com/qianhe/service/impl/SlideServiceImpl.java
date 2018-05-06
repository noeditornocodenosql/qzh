package com.qianhe.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.qianhe.mapper.SlideMapper;
import com.qianhe.model.Slide;
import com.qianhe.service.SlideService;

@Transactional
@Service
public class SlideServiceImpl implements SlideService {
	
	@Resource
	private  SlideMapper slideMapper;

	@Override
	public List<Slide> findAllSlide() {
		return slideMapper.findAllSlide();
	}

	@Override
	public void saveSlide(Slide slide) {
		slideMapper.saveSlide(slide);

	}

	@Override
	public void editSlide(Slide slide) {
		slideMapper.editSlide(slide);

	}

	@Override
	public void deleteSlide(Integer id) {
		slideMapper.deleteSlide(id);

	}

	@Override
	public Slide findSlideById(Integer id) {
		return slideMapper.findSlideById(id);
	}

}
