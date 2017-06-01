package com.shaw.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class ShawWebappApplication  extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer{

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(ShawWebappApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(ShawWebappApplication.class, args);
	}
	
    public void customize(ConfigurableEmbeddedServletContainer container) {  
        container.setPort(8081);  
    }  

}
