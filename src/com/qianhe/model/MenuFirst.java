package com.qianhe.model;

import java.util.List;

public class MenuFirst {
	
	private Integer fid;
	private String fname;
	private Integer ftype;
	private List<MenuTwo> menuTwoList;
	public Integer getFid() {
		return fid;
	}
	public void setFid(Integer fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public Integer getFtype() {
		return ftype;
	}
	public void setFtype(Integer ftype) {
		this.ftype = ftype;
	}
	public List<MenuTwo> getMenuTwoList() {
		return menuTwoList;
	}
	public void setMenuTwoList(List<MenuTwo> menuTwoList) {
		this.menuTwoList = menuTwoList;
	}

	
}
