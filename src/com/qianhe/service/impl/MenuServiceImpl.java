package com.qianhe.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qianhe.mapper.MenuMapper;
import com.qianhe.mapper.MenutMapper;
import com.qianhe.model.MenuFirst;
import com.qianhe.service.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Resource
	private MenuMapper menuMapper;
	
	@Resource
	private MenutMapper menutMapper;
	

	@Override
	public List<MenuFirst> findAllMenus() {
	/*	List<MenuFirst>  mfList = menuMapper.findAllMenus();
		for (MenuFirst menuFirst : mfList) {
			List<MenuTwo>  mtList = menutMapper.findMenuTwo(menuFirst.getFid());
			menuFirst.setMenuTwoList(mtList);
		}
		return  mfList;*/
		return menuMapper.findAllMenus();
	}


	@Override
	public MenuFirst findMenuById(String fid) {
		return menuMapper.findMenuById(fid);
	}


	@Override
	public void updateMenu(MenuFirst menuFirst) {
		menuMapper.updateMenu(menuFirst);
		
	}


	@Override
	public void saveMenu(MenuFirst menuFirst) {
		menuMapper.saveMenu(menuFirst);
		
	}


	@Override
	public void delMenu(String fid) {
		menuMapper.delMenu(fid);
	}

}
