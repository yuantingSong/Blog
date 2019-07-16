package com.yuanting.Blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select; 

import com.yuanting.Blog.pojo.Role;
 
@Mapper 
public interface RoleMapper {
 
    @Select("select * from role where roleId=#{roleId}")
    Role findRoleByRoleId(@Param("roleId") int roleId);
    
    @Select("select * from role where roleName=#{roleName}")
    Role findRoleByRoleName(String roleName);
    
    @Select("select * from role")
    List<Role> listRoles();
    
    @Insert("insert into user_role(User_id, Role_id) values (#{userId}, #{roleId})")
    void insertRole(@Param("userId") long userId, @Param("roleId") int roleId);
	
    @Select("select roleId from user_role where userId=#{userId}")
    List<Integer> findRoleIdsByUserId(@Param("userId") long userId);
    
    @Select("select * from role where roleId in (select roleId from user_role where userId=#{userId})")
    List<Role> findRolesByUserId(long userId);
}
