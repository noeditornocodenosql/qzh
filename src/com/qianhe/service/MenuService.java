package com.qianhe.service;

import java.util.List;

import com.qianhe.model.MenuFirst;

public interface MenuService {
	public List<MenuFirst>findAllMenus();

	public MenuFirst findMenuById(String fid);

	public void updateMenu(MenuFirst menuFirst);

	public void saveMenu(MenuFirst menuFirst);

	public void delMenu(String fid);
}
