package com.yuanting.Blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yuanting.Blog.pojo.Article;
import com.yuanting.Blog.service.ArticleService;
 

@Controller
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	@GetMapping(value="/article") 
	public String geArticles(){
		return "article";
	}
	
	@GetMapping(value="/articles") 
	@ResponseBody
	public List<Article> getListArticles(){
		return articleService.listArticles(); 
	}
	
	@GetMapping(value="/articles/{id}")
	public String getViewArticle(Model model,@PathVariable Long id) { 
		Article article = articleService.getArticle(id); 
		model.addAttribute("article", article);
		return "articleShow";
		
	}
	
	@GetMapping(value="/article/modify/{id}")
	public String getModifyArticle(Long id) {
		return null;
	}
	
	@PostMapping(value="/article/modify/{id}")
	public String modifyArticle(Long id) {
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
