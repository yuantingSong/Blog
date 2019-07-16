package com.yuanting.Blog.service.impl;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanting.Blog.mapper.RoleMapper;
import com.yuanting.Blog.pojo.Role; 
import com.yuanting.Blog.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleMapper roleMapper;
	
	@Override
	public Role findRoleByRoleId(Integer roleId) {
		return roleMapper.findRoleByRoleId(roleId);
	}

	@Override
	public List<Role> listRoles() {
		return roleMapper.listRoles();
	}

	@Override
	public void insertRole(long userId, int roleId) {
		roleMapper.insertRole(userId, roleId);
	}

	@Override
	public List<Integer> findRoleIdsByUserId(long userId) {
		return roleMapper.findRoleIdsByUserId(userId);
	}
 
	
	@Override
	public List<Role> findRolesByUserId(long userId) {
		return roleMapper.findRolesByUserId(userId);
	}
	

}
