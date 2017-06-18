package com.shaw.blog;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shaw.blog.model.Article;
import com.shaw.blog.server.ArticleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShawWebappApplicationTests {

	@Autowired
	ArticleService articleService;
    private Logger logger = LoggerFactory.getLogger(getClass());
	@Test
	public void contextLoads() {
//		System.out.println("!!!!!!!!!!"+articleService.findAllArticle().size());
		logger.debug("debug!!!!!!!!!!!!!!");
		logger.info("info!!!!!!!!!!!!!");
		Article article = new Article();
//		List<Article> list = articleService.findArticleByPage(article);
//		for (Article article2 : list) {
//			logger.info(article2.toString());
//		}
	}
	
	@Test
	public void getArticle() {
		Article list = articleService.getArticleById(63L);
		System.out.println(list);
	}

}
