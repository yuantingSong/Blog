package com.yuanting.Blog.service;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

import com.yuanting.Blog.pojo.Role;

@Service
public interface RoleService {
	 
 
	Role findRoleByRoleId(Integer roleId);
	 
	List<Role> listRoles();
	 
	void insertRole(@Param("userId") long userId, @Param("roleId") int roleId);
	 
	List<Integer> findRoleIdsByUserId(@Param("userId") long userId);
	  
	List<Role> findRolesByUserId(long userId);

}
