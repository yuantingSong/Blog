package com.yuanting.Blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanting.Blog.mapper.RoleMapper;
import com.yuanting.Blog.mapper.UserMapper;
import com.yuanting.Blog.pojo.Role;
import com.yuanting.Blog.pojo.User;

import com.yuanting.Blog.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper userMapper;

	@Autowired
	RoleMapper roleMapper;

	@Override
	public User findUserByUsername(String username) {
		User user = userMapper.findUserByUsername(username);
		if (user == null) { 
			return null;
		} 
		List<Role> roles = roleMapper.findRolesByUserId(user.getUserId()); 
		user.setRoles(roles); 
		return user;
	}

	@Override
	public Integer findUserIdByUsername(String username) {
		return userMapper.findUserIdByUsername(username);
	}

	@Override
	public void registerUser(User user) {
		userMapper.insert(user);
		int userId = userMapper.findUserIdByUsername(user.getUsername());
		Role role = roleMapper.findRoleByRoleName("USER");
		roleMapper.insertRole(userId, role.getRoleId());
	}

	@Override
	public boolean existUser(String username) {
		return this.findUserIdByUsername(username) != null;
	}

	
}
