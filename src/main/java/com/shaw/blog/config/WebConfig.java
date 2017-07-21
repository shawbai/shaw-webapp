package com.shaw.blog.config;

import javax.servlet.Filter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.shaw.blog.interceptor.MyInterceptor;

@Configuration
@EnableWebMvc
@MapperScan(basePackages = "com.shaw.blog.mapper")
@EnableConfigurationProperties(MyProperties.class)
public class WebConfig extends WebMvcConfigurerAdapter implements
		CommandLineRunner {
	
    @Autowired
    private MyProperties properties;
	
	public static final String serverName = "/myblog";

	// 添加拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
	
	 @Override
	 public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**").allowedOrigins("*")
	                .allowedMethods("GET", "HEAD", "POST","PUT", "DELETE", "OPTIONS")
	                .allowCredentials(false).maxAge(3600);
	 }

	// 视图解析器
	@Bean
	public ViewResolver viewResoler() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public Filter characterEncodingFilter() {
		CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
		characterEncodingFilter.setEncoding("UTF-8");
		characterEncodingFilter.setForceEncoding(true);
		return characterEncodingFilter;
	}

	// 静态资源转发
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/app/**").addResourceLocations("/app/");
		registry.addResourceHandler("/dist/**").addResourceLocations("/dist/");
		registry.addResourceHandler("/blog/**").addResourceLocations("/vue-blog/index.html");
		registry.addResourceHandler("/blog/static/**").addResourceLocations("/vue-blog/static/");
	}

	//跳转
    public void addViewControllers( ViewControllerRegistry registry ) {
        registry.addViewController( "/" ).setViewName( "forward:/page/index" );
        registry.setOrder( Ordered.HIGHEST_PRECEDENCE );
        super.addViewControllers( registry );
    } 
	
	@Override
	public void run(String... arg0) throws Exception {
		
		System.out.println("!!!!!!!!!!!!"+properties.getServerName());
	}

}
