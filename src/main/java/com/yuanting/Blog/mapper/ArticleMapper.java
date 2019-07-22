package com.yuanting.Blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.yuanting.Blog.pojo.Article; 
 
@Mapper 
public interface ArticleMapper {
  
    @Insert("insert into article(articleId,articleTitle,authorName,publishDate,updateDate,content) " +
            "values(#{articleId},#{articleTitle},#{authorName},#{publishDate},#{updateDate},#{content})")
    void insertArticle(Article article);
    
    @Delete("delete from article where articleId=#{articleId}")
    void deleteArticle(Article article);
    
    @Update("update article set articleTitle=#{articleTitle},updateDate=#{updateDate},content=#{content} where articleId=#{articleId}")
    void updateArticle(Article article);
    
    @Select("select * from article where articleTitle=#{articleTitle}")
    Article getArticleByTitle(String articleTitle);
    
    @Select("select * from article where articleId=#{articleId}")
    Article getArticleById(long articleId);
    
    @Select("select articleId, articleTitle, authorName from article order by articleId desc")
    List<Article> listArticles();
    
    @Select("select articleId, articleTitle, authorName from article where authorName=#{authorName} order by id desc")
    List<Article> listArticlesByAuthor(String authorName);
    
    
    
}
