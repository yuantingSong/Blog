package com.yuanting.Blog.service;

import org.springframework.stereotype.Service;

import com.yuanting.Blog.pojo.User;

@Service
public interface UserService {

	void registerUser(User user);
	
	void update(User user);
	
	User findUserByUsername(String username);
	
	Integer findUserIdByUsername(String username);
	
 
	//tool
	boolean existUser(String username);
	
}
