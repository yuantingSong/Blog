package com.yuanting.Blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yuanting.Blog.pojo.Article;
import com.yuanting.Blog.pojo.User; 

@Service
public interface ArticleService {
	void createArticle(Article article);
	
	void deleteArticle(Article article, User user);
	  
	boolean updateArticle(Article article, User user);
	
	Article getArticle(String articleTitle);
	
	Article getArticle(long articleId);

	List<Article> listArticles();
	
	List<Article> listArticles(String authorName);
	
	
	//tool 
	boolean hasPermission(Article article, User user);
	
	boolean isAuthor(Article article, User user);
	
	boolean isAdmin(User user);
	
	String markdownToHtml(String markdown);
	
}
