package com.yuanting.Blog.service;

import org.springframework.stereotype.Service;

import com.yuanting.Blog.pojo.User;

@Service
public interface UserService {
	
	User findUserByUsername(String username);
	
	Integer findUserIdByUsername(String username);
	
	void registerUser(User user);
 
	boolean existUser(String username);
	
}
