package com.yuanting.Blog.pojo;

 
public class Article {

	private long articleId;
	
	private String articleTitle;
	 
	private String authorName;
	
	private String publishDate;
	
	private String updateDate;
	
	private String content;
	
	private String html;
	
	private boolean published;
	 
	public Article() {
		// TODO Auto-generated constructor stub
	}

	public long getArticleId() {
		return articleId;
	}

	public void setArticleId(long articleId) {
		this.articleId = articleId;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	public String getPublishDate() {
		return publishDate;
	}

	public void setPublishDate(String publishDate) {
		this.publishDate = publishDate;
	}

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean published) {
		this.published = published;
	}

	public String getHtml() {
		return html;
	}

	public void setHtml(String html) {
		this.html = html;
	}

}
