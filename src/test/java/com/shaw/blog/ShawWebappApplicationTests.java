package com.shaw.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.shaw.blog.model.Article;
import com.shaw.blog.server.ArticleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShawWebappApplicationTests {

	@Autowired
	ArticleService articleService;
	
	@Autowired
	private StringRedisTemplate template;
	
    private Logger logger = LoggerFactory.getLogger(getClass());
	@Test
	public void contextLoads() {
//		System.out.println("!!!!!!!!!!"+articleService.findAllArticle().size());
		logger.debug("debug!!!!!!!!!!!!!!");
		logger.info("info!!!!!!!!!!!!!");
		Article article = new Article();
		article.setPage(3);
		article.setRows(4);
		articleService.findArticleByPage(article);
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
