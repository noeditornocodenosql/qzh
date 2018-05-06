package com.qianhe.service;

import java.util.List;
import com.qianhe.model.Photo;

public interface PhotoService {
	public List<Photo> findPhotoByCategory(Integer thumbnailType,Integer imageType);
}
