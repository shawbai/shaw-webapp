package com.shaw.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shaw.blog.server.ArticleService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShawWebappApplicationTests {

	@Autowired
	ArticleService articleService;
	
	@Test
	public void contextLoads() {
		System.out.println("!!!!!!!!!!"+articleService.findAllArticle().size());
	}

}
