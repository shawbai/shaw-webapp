package com.shaw.blog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.shaw.blog.model.Article;


public interface ArticleMapper{

	@Select("SELECT article.article_id AS articleId, article.create_time AS createTime, article.modify_time AS modifyTime, article.version, article.article_name AS articleName, article.article_ip AS articleIp, article.article_click AS articleClick, article.sort_article_id AS sortArticleId, article.member_id AS memberId, article.article_type AS articleType, article.article_keyword AS articleKeyword, article.article_content AS articleContent, article.article_up AS articleUp, article.article_support AS articleSupport, article.pictures FROM article")
	public List<Article> getArticleList();
	
	
	
    
}