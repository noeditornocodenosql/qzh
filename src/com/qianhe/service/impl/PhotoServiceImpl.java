package com.qianhe.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qianhe.mapper.PhotoMapper;
import com.qianhe.model.Photo;
import com.qianhe.service.PhotoService;

@Transactional
@Service
public class PhotoServiceImpl implements PhotoService {

	@Resource
	private PhotoMapper photoMapper;
	
	@Override
	public List<Photo> findPhotoByCategory(Integer thumbnailType, Integer imageType) {
		return photoMapper.findPhotoByCategory(thumbnailType, imageType);
	}

}
