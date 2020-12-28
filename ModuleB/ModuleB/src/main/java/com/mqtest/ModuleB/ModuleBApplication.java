package com.mqtest.ModuleB;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:ModuleB-integration-config.xml")
public class ModuleBApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ModuleBApplication.class, args);
	}

}
