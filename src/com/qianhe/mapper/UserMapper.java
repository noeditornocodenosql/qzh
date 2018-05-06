package com.qianhe.mapper;

import java.util.List;

import com.qianhe.model.User;

public interface UserMapper {
	public User checkLogin(User user);

	/**
	 * 查找用户
	 * @return
	 */
	public List<User> findUserList();

	/**
	 * 添加用户
	 * @param user
	 */
	public void saveUser(User user);

	/**
	 * 通过id查找用户
	 * @param id
	 * @return User
	 */
	public User findUserById(int id);

	/**
	 * 修改用户
	 * @param user
	 */
	public void updateUser(User user);

	/**
	 * 删除用户
	 * @param user
	 */
	public void deleteUser(int id);
}
