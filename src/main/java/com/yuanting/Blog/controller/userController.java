package com.yuanting.Blog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class userController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/register", method=RequestMethod.POST) 
    @ResponseBody
	public  Map<String, Object> register(@RequestBody User user) {      
		Map<String, Object> json = new HashMap<>();
		if (userService.existUser(user.getUsername())) { 
			json.put("msg","username existing");
			return json;
		} 
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));  
		userService.registerUser(user);  
		json.put("msg","success");
		return json;
	} 
}
