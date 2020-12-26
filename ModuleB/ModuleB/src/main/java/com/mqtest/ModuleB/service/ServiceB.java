package com.mqtest.ModuleB.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mqtest.ModuleHelper.RequestB;
import com.mqtest.ModuleHelper.RequestC;
import com.mqtest.ModuleHelper.ResponseB;
import com.mqtest.ModuleHelper.ResponseC;

@Service
public class ServiceB {
	
	private RestTemplate restTemplate;
	
	public ResponseB invoke(RequestB request) throws InterruptedException {
		
		System.out.println("Inside service B");
		System.out.println("Received request : " + request);
		
		Thread.sleep(1000);
		System.out.println("Generating Response...");
		RequestC reqC = new RequestC();
		reqC.setC(request.getB()*10);
		restTemplate = new RestTemplate();
		ResponseC responseC = restTemplate.postForObject("http://localhost:8080/ModuleC/invokeC", reqC, ResponseC.class);
		System.out.println("Got Response from API C : "+responseC);
		
		ResponseB resp = new ResponseB();
		resp.setRespB(responseC.getRespC());
		System.out.println("Response Generated");
		return resp;
		
		
	}

}
