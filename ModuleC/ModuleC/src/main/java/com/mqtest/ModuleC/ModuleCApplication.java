package com.mqtest.ModuleC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.SubscribableChannel;

@SpringBootApplication
@ImportResource("classpath:ModuleC-integration-config.xml")
public class ModuleCApplication extends SpringBootServletInitializer{
	
	@Autowired
	SubscribableChannel moduleCInChannel;
	
	@Autowired
	SubscribableChannel moduleCOutChannel;

	public static void main(String[] args) {
		SpringApplication.run(ModuleCApplication.class, args);
	}

}
