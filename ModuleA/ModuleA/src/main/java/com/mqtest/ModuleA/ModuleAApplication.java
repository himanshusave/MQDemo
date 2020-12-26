package com.mqtest.ModuleA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class ModuleAApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(ModuleAApplication.class, args);
	}

}
