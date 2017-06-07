package com.shaw.blog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *         页面跳转
 */
@Controller
@RequestMapping("/page")
public class PageController {
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);


    @RequestMapping("/index")
    public String goToIndex(Model model) {
    	logger.info("跳转首页");
    	model.addAttribute("msg", "Hello World");
    	model.addAttribute("test", 0);
        return "index";
    }
    
    @RequestMapping("/manage")
    public String goToManage(Model model) {
    	logger.info("跳转管理");
    	model.addAttribute("msg", "管理");
    	model.addAttribute("test", 1);
        return "index";
    }

}
