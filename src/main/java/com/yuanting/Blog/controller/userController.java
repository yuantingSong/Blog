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
	
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@GetMapping("/register")
	public String showRegister() { 
		return "register";
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST) 
    @ResponseBody
	public Map<String, Object> register(@RequestBody User user) {   
		Map<String, Object> json = new HashMap<>();
		if (userService.existUser(user.getUsername())) { 
			json.put("message","username existing");
			return json;
		} 
		user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));  
		userService.registerUser(user);  
		json.put("message","success");  
		return json;
	} 
	
	@RequestMapping(value="/checkUsername", method=RequestMethod.POST) 
    @ResponseBody
	public Map<String, Object> checkUsername(@RequestBody User user) {    
		Map<String, Object> json = new HashMap<>();
		if (userService.existUser(user.getUsername())) { 
			json.put("message","existing"); 
			return json; 
		}
		json.put("message","username available");
		System.out.println(json.get("msg"));
		return json;
	} 
	
	@GetMapping(value="/profile")
	public String getUserProfle() {
		return null;
	}
	
	@PostMapping(value="/profile")
	public String updateProfile() {
		return null;
	}
	
}
