package com.mqtest.ModuleA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:ModuleA-integration-config.xml")
public class ModuleAApplication extends SpringBootServletInitializer{
	
	public static void main(String[] args) {
		SpringApplication.run(ModuleAApplication.class, args);
	}

}
