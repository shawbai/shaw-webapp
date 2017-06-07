package com.shaw.blog.controller;  
  
import org.springframework.web.bind.annotation.ControllerAdvice;  
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;  
  

@ControllerAdvice(basePackages = "com.shaw.blog.controller")  
public class JsonpAdvice extends AbstractJsonpResponseBodyAdvice{  
  
    public JsonpAdvice() {  
        super("callback","jsonp");  
    }  
}  