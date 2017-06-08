package com.shaw.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ShawWebappApplication  extends SpringBootServletInitializer {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ShawWebappApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ShawWebappApplication.class, args);
	}


}
 