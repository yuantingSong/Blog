package com.yuanting.Blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yuanting.Blog.pojo.Article;
import com.yuanting.Blog.service.ArticleService;
import com.yuanting.Blog.service.UserService;
 

@Controller
public class ArticleController {
	
	@Autowired
	ArticleService articleService;
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/articleCenter") 
	public String getArticleCenter(){
		return "articleCenter";
	}
	@GetMapping(value="/articles") 
	@ResponseBody
	public List<Article> getArticles(){
		return articleService.listArticles(); 
	}
	
	@PostMapping(value="/articles")
	@ResponseBody
	public Map<String, Object> postArticles(@RequestBody Article article) {
		Map<String, Object> json = new HashMap<>();
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		if (username == null) {
			json.put("message","fail");
			return json;
		}
		article.setAuthorName(username);
		articleService.createArticle(article);
		article = articleService.getArticle(article.getArticleTitle());
		json.put("message","success");
		json.put("article", article);
		return json;
	}
	
	//todo : change url to /user/id/articles
	@GetMapping(value="/myarticles") 
	@ResponseBody
	public List<Article> getMyArticles(){ 
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		return articleService.listArticles(username); 
	}
	
	
	@GetMapping(value="/articlepage") 
	public String getArticlePage(){
		return "article";
	}
	
	@GetMapping(value="/articles/{id}")
	public String getViewArticle(Model model,@PathVariable Long id) { 
		Article article = articleService.getArticle(id); 
		model.addAttribute("article", article);
		return "editArticle";
	}
	
	
	@PutMapping(value="/articles/{id}") 
	@ResponseBody
	public Map<String, Object> updateArticle(@PathVariable Long id, @RequestBody  Article article) {  
		Map<String, Object> json = new HashMap<>();  
		System.out.println(article.toString());
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = null;
		if (principal instanceof UserDetails) {
			username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		} 
		articleService.updateArticle(article, userService.findUserByUsername(username)); 
		json.put("message","success"); 
		return json;
	}
	
	@GetMapping(value="/article/write")
	public String getWriteArticle(Model model) {
		Article article = new Article();
		model.addAttribute("article", article);
		return "writeArticle";
	}
	
	
	@PostMapping(value="/article/write")
	@ResponseBody
	public Map<String, Object> writeArticle(@RequestBody Article article) { 
		Map<String, Object> json = new HashMap<>();
		System.out.println("writing");
		System.out.println(article.getContent());
		articleService.createArticle(article);
		
		json.put("val", articleService.markdownToHtml(article.getContent()));
		return json;
	} 
 
	
}
