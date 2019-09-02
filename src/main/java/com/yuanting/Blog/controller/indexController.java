package com.yuanting.Blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yuanting.Blog.pojo.User;
import com.yuanting.Blog.service.MailService;
import com.yuanting.Blog.service.UserService;

@Controller
public class indexController {

	@Autowired
	UserService userService;
 
	@Autowired
	MailService mailService;
	
	@GetMapping("/test")
	public String test() { 
		//mailService.sendEmail("ytsong95@gmail.com");
		return "test";
	}
	
	@GetMapping(value = {"/"})
	public String getIndex() { 
		return "index";
	}
	
	@GetMapping(value = {"/home"})
	public String getHome() { 
		return "home";
	}

	@GetMapping("/users")
	public String user(Model model) { 
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		model.addAttribute("username", username);
		return "user";
	}
	
	@GetMapping("/resume")
	public String showResume() {
		return "resume";
	}
	
	@GetMapping("/contact")
	public String showContact() {
		return "contact";
	}
	
	

}
