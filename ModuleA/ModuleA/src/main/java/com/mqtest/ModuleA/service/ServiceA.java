package com.mqtest.ModuleA.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mqtest.ModuleHelper.RequestA;
import com.mqtest.ModuleHelper.RequestB;
import com.mqtest.ModuleHelper.ResponseA;
import com.mqtest.ModuleHelper.ResponseB;

@Service
public class ServiceA {
	
	private RestTemplate restTemplate;
	
	public ResponseA invoke(RequestA request) throws InterruptedException {
		
		System.out.println("Inside service A");
		System.out.println("Received request : " + request);
		
		Thread.sleep(1000);
		System.out.println("Getting Response using responseEntity...");
		RequestB reqB = new RequestB();
		reqB.setB(request.getA());
		restTemplate = new RestTemplate();
		System.out.println(reqB);
		ResponseEntity<ResponseB> responseEntity = restTemplate.postForEntity("http://localhost:8080/ModuleB/invokeB", reqB, ResponseB.class);
		System.out.println("Got Response from API B : "+responseEntity.getBody().getRespB());
		
		ResponseA resp = new ResponseA();
		resp.setRespA(responseEntity.getBody().getRespB());
		System.out.println("Response Generated");
		return resp;
		
		
	}

}
