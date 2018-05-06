package com.qianhe.model;

public class Photo {
	private Integer id;
	private Integer thumbnailType; //缩略图
	private String thumbnailPath; //缩略图路径
	private Integer imageType;//图片
	private String imagePath; //图片路径
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getThumbnailPath() {
		return thumbnailPath;
	}
	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	public Integer getThumbnailType() {
		return thumbnailType;
	}
	public void setThumbnailType(Integer thumbnailType) {
		this.thumbnailType = thumbnailType;
	}
	public Integer getImageType() {
		return imageType;
	}
	public void setImageType(Integer imageType) {
		this.imageType = imageType;
	}
	

}
