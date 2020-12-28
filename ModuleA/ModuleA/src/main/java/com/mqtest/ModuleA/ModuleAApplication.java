package com.mqtest.ModuleA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.messaging.SubscribableChannel;

@SpringBootApplication
@ImportResource("classpath:http-integration-config.xml")
public class ModuleAApplication extends SpringBootServletInitializer{

	@Autowired
	SubscribableChannel moduleAInboundChannel;
	
	@Autowired
	SubscribableChannel moduleAOutboundChannel;
	
	@Autowired
	SubscribableChannel moduleARespFromBChannel;
	
	public static void main(String[] args) {
		SpringApplication.run(ModuleAApplication.class, args);
	}

}
