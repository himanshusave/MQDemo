package com.mqtest.ModuleC;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ModuleCApplication extends SpringBootServletInitializer{
	
	@Bean
	public RestTemplate restTemplate() {
		RestTemplate resttemplate = new RestTemplate();
		HttpComponentsClientHttpRequestFactory factory = new HttpComponentsClientHttpRequestFactory();
		factory.setReadTimeout(10000);
		factory.setConnectTimeout(10000);
		resttemplate.setRequestFactory(factory);
		return resttemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(ModuleCApplication.class, args);
	}

}
