package com.qianhe.service.impl;

import java.util.List;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.qianhe.mapper.UserMapper;
import com.qianhe.model.User;
import com.qianhe.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService{
	
	@Resource
	private UserMapper userMapper;

	@Override
	public User checkLogin(User user) {
		return userMapper.checkLogin(user);
	}

	@Override
	public List<User> findUserList() {
		return userMapper.findUserList();
	}

	@Override
	public void saveUser(User user) {
		userMapper.saveUser(user);
		
	}

	@Override
	public User findUserById(int id) {
		return userMapper.findUserById(id);
	}

	@Override
	public void updateUser(User user) {
		userMapper.updateUser(user);
		
	}

	@Override
	public void deleteUser(int id) {
		userMapper.deleteUser(id);
		
	}

}
