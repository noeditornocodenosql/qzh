package com.qianhe.mapper;

import java.util.List;

import com.qianhe.model.Photo;

public interface PhotoMapper {
	public List<Photo> findPhotoByCategory(Integer thumbnailType,Integer imageType);

}
