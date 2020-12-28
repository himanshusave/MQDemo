package com.mqtest.ModuleC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:ModuleC-integration-config.xml")
public class ModuleCApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ModuleCApplication.class, args);
	}

}
