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
 

@Controller
public class ArticleController {
 
	@GetMapping(value="/article/showAll") 
	public String getShowAllArticles(){
		return null; 
	}
	
	@GetMapping(value="/article/view/{id}")
	public String getViewArticle() {
		return null;
	}
	
	@GetMapping(value="/article/modify/{id}")
	public String getModifyArticle() {
		return null;
	}
	
	@PostMapping(value="/article/modify/{id}")
	public String modifyArticle() {
		return null;
	}
	
	@GetMapping(value="/article/write")
	public String getWriteArticle() {
		return null;
	}
	
	@PostMapping(value="/article/write")
	public String writeArticle() {
		return null;
	}
	 
}
