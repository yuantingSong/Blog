package com.yuanting.Blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yuanting.Blog.pojo.User;
import com.yuanting.Blog.service.UserService;

@Controller
public class indexController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String welcome() {
		User user = userService.findUserByUsername("1");
		System.out.println(user.getRoles().get(0));
		return "welcome";
	}
	
}
