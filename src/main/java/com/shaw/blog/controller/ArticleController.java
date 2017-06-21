package com.shaw.blog.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.shaw.blog.config.WebConfig;
import com.shaw.blog.model.Article;
import com.shaw.blog.server.ArticleService;
import com.shaw.common.pojo.BaseResponse;

@RequestMapping(WebConfig.serverName+"/v1/articles")
@Controller
public class ArticleController {

	private Logger log = LoggerFactory.getLogger(ArticleController.class);

	@Autowired
	ArticleService articleService;

	@Autowired
	HttpSession session;
	/**
	 * 查询所有文章
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Object findAllArticle(HttpServletRequest request) {
		return BaseResponse.success(articleService.findAllArticle());
	}

	/**
	 * 获取文章列表
	 * @param request
	 * @param article 参数
	 * @return 文章列表
	 */
	@RequestMapping(value = "/page", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Object findArticles(HttpServletRequest request,Article article) {
//		log.info("获取文章列表入参:{}",article);
		if (article.getPage() != null && article.getRows() != null) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("pageInfo", new PageInfo<Article>(articleService.findArticleByPage(article)));
			map.put("queryParam", article);
			map.put("page", article.getPage());
			map.put("rows", article.getRows());
//			log.info("获取文章列表出参:{}",map);
			return BaseResponse.success(map);
		} else {
			return BaseResponse.error("请传入分页参数");
		}
	}
	
	/**
	 * 根据ID获取文章
	 * @param request
	 * @param id 文章ID
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Object getArticle(HttpServletRequest request,@PathVariable Long id) {
		log.info("获取文章列表入参:{}",id);
		if (id != null) {
			Article article = articleService.getArticleById(id);
			log.info("获取文章列表入参:{}",article);
			return BaseResponse.success(article);
		} else {
			return BaseResponse.error("请传入ID");
		}
	}
	
	
	
	
	
	
	/**
	 * 测试
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/test", method = RequestMethod.POST, produces = "application/json")
	@ResponseBody
	public Object test(HttpServletRequest request) {
			System.out.println(request.getHeader("Origin"));
		
			return BaseResponse.success();
	}
	
	
	
	
	
	
}
