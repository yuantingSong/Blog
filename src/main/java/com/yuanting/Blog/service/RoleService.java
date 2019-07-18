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
	 
	void insertRole(@Param("userId") int userId, @Param("roleId") int roleId);
	 
	List<Integer> findRoleIdsByUserId(@Param("userId") int userId);
	  
	List<Role> findRolesByUserId(int userId);

}
