package com.mqtest.ModuleB.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mqtest.ModuleHelper.RequestB;
import com.mqtest.ModuleHelper.RequestC;
import com.mqtest.ModuleHelper.ResponseB;
import com.mqtest.ModuleHelper.ResponseC;

@Service
public class ServiceB {
	
	@Autowired
	private RestTemplate restTemplate;
	private static Random random = new Random();
	
	public ResponseB invoke(RequestB request) throws InterruptedException {
		
		System.out.println("Inside service B");
		System.out.println("Received request : " + request);
		
		int randomSleepTime = random.nextInt(9);
		System.out.println("Sleeping for " +randomSleepTime + " seconds");
		Thread.sleep(randomSleepTime*1000);
		System.out.println("Generating Response...");
		RequestC reqC = new RequestC();
		reqC.setC(request.getB()*10);
		ResponseC responseC = restTemplate.postForObject("http://localhost:8080/ModuleC/invokeC", reqC, ResponseC.class);
		System.out.println("Got Response from API C : "+responseC);
		
		ResponseB resp = new ResponseB();
		resp.setRespB(responseC.getRespC());
		System.out.println("Response Generated");
		return resp;
		
		
	}

}
