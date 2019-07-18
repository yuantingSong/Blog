package com.yuanting.Blog.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.yuanting.Blog.pojo.User;
 
@Mapper
public interface UserMapper {
 
	@Select("select userId from user where username=#{username}")
	Integer findUserIdByUsername(String username);
	
    @Select("select * from user where username=#{username}")
    User findUserByUsername(String username);
	 
    @Insert("insert into user(userId,username,password,email) values(#{userId},#{username},#{password},#{email})")
    void insert(User user);
    
}
