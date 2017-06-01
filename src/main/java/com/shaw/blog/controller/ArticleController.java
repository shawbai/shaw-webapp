package com.shaw.blog.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shaw.blog.server.ArticleService;

@RequestMapping("/article")
@Controller
public class ArticleController {

	private Logger log = LoggerFactory.getLogger(ArticleController.class);


	@Autowired
	ArticleService articleService;

	@Autowired
	HttpSession session;
	
	@RequestMapping(value = "/findAllOrder", produces = "application/json")
	@ResponseBody
	public Object findAllOrder(HttpServletRequest request) {
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("Articlelist", articleService.findAllArticle());
		return map;
	}
	

}
