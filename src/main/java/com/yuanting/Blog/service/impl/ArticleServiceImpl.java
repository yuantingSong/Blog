package com.yuanting.Blog.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yuanting.Blog.mapper.ArticleMapper; 
import com.yuanting.Blog.service.ArticleService;

import com.yuanting.Blog.pojo.Article;
import com.yuanting.Blog.pojo.User; 

import org.markdown4j.Markdown4jProcessor;

@Service
public class ArticleServiceImpl implements ArticleService{
	
	
    @Autowired
	ArticleMapper articleMapper;
	
	@Override
	public void insertArticle(Article article) {  
		articleMapper.insertArticle(article);  
	}

	@Override
	public void deleteArticle(Article article) {
		articleMapper.deleteArticle(article);
	}

	@Override
	public void updateArticle(Article article) {
		articleMapper.updateArticle(article); 
	}

	@Override
	public Article getArticle(String articleTitle) { 
		return articleMapper.getArticleByTitle(articleTitle);
	}

	@Override
	public Article getArticle(long articleId) { 
		return articleMapper.getArticleById(articleId);
	}


	@Override
	public List<Article> listArticles() {
		return articleMapper.listArticles();
	}

	@Override
	public List<Article> listArticles(String authorName) {
		return articleMapper.listArticlesByAuthor(authorName);
	}

	@Override
	public boolean isAuthor(Article article, User user) {
		 
		return article.getAuthorName().equals(user.getUsername());
	}

	@Override
	public boolean modifyArticle(Article article, User user) { 
		if (isAuthor(article, user)) { 
			articleMapper.updateArticle(article);
			return true;
		} 
		return false;
	}

	@Override
	public String markdownToHtml(String markdown) {
		Markdown4jProcessor processor = new Markdown4jProcessor();
		try {
			return processor.process(markdown); 
		} catch (Exception e) {
			return e.toString();
		}
	}
  
}
