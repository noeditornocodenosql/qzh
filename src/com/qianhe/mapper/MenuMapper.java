package com.qianhe.mapper;

import java.util.List;

import com.qianhe.model.MenuFirst;

public interface MenuMapper {
	public List<MenuFirst>findAllMenus();

	public MenuFirst findMenuById(String fid);

	public void updateMenu(MenuFirst menuFirst);

	public void saveMenu(MenuFirst menuFirst);

	public void delMenu(String fid);

}
