package com.yuanting.Blog.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yuanting.Blog.pojo.Article;
import com.yuanting.Blog.pojo.User; 

@Service
public interface ArticleService {
	
	Article getArticle(String articleTitle);
	
	Article getArticle(long articleId);
	
	void insertArticle(Article article);
	
	void deleteArticle(Article article);
	
	void updateArticle(Article article);
	
	List<Article> listArticles();
	
	List<Article> listArticles(String authorName);
	
	boolean isAuthor(Article article, User user);
	
	boolean modifyArticle(Article article, User user);
	
	
	
}
