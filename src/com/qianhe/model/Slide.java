package com.qianhe.model;

/**
 * 幻灯片
 * @author Administrator
 *
 */
public class Slide {
	
	private int id;
	private String slideName; //幻灯片名称
	private String myFile; //图片路径
	private int sort; // 图片排序
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSlideName() {
		return slideName;
	}
	public void setSlideName(String slideName) {
		this.slideName = slideName;
	}

	public String getMyFile() {
		return myFile;
	}
	public void setMyFile(String myFile) {
		this.myFile = myFile;
	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}

}
