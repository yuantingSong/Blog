package com.yuanting.Blog.controller;

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

@Controller
public class indexController {

	@Autowired
	UserService userService;
	
	@GetMapping("/")
	public String welcome() { 
		return "welcome";
	}
	
	@GetMapping("/test")
	public String test() { 
		return "test";
	}
	@GetMapping("/home")
	public String home() { 
		return "home";
	}
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}


}
