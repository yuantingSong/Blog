package com.yuanting.Blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yuanting.Blog.pojo.User;
import com.yuanting.Blog.service.UserService;

@RestController
public class userController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/register", method=RequestMethod.POST) 
    @ResponseBody
	public  String register(@RequestBody User user) {     
		System.out.println("user.getName() +  + " + user.getUsername());
		if (userService.existUser(user.getUsername())) {
			return "username existing";
		} 
		
		userService.registerUser(user);
		return "success";
	} 
}
