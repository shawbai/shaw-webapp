package com.shaw.blog.server;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.shaw.blog.mapper.ArticleMapper;
import com.shaw.blog.model.Article;

@Service
public class ArticleService {

	@Autowired
	ArticleMapper articleMapper;

	public List<Article> findAllArticle() {
		return articleMapper.selectAll();
	}

	
	 public List<Article> findArticleByPage(Article article) {
	        if (article.getPage() != null && article.getRows() != null) {
	            PageHelper.startPage(article.getPage(), article.getRows());
	        }
	        return articleMapper.selectAll();
	    }

}
