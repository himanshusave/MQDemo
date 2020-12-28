package com.mqtest.ModuleB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.SubscribableChannel;

@SpringBootApplication
@ImportResource("classpath:http-inbound-config.xml")
public class ModuleBApplication extends SpringBootServletInitializer{
	
	@Autowired
	SubscribableChannel moduleBInChannel;
	
	@Autowired
	SubscribableChannel moduleBOutChannel;
	
	@Autowired
	SubscribableChannel moduleBRespFromCChannel;

	public static void main(String[] args) {
		SpringApplication.run(ModuleBApplication.class, args);
	}

}
