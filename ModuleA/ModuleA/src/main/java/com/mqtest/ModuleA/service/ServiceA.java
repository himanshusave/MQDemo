package com.mqtest.ModuleA.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mqtest.ModuleHelper.RequestA;
import com.mqtest.ModuleHelper.RequestB;
import com.mqtest.ModuleHelper.ResponseC;

@Service
public class ServiceA {
	
	@Value("${sleep.time}")
	private String sleepTime;
	
	public RequestB invoke(RequestA request) throws InterruptedException {
		
		System.out.println("Inside service A");
		System.out.println("Received request : " + request);
		
		System.out.println("Going to sleep for " + sleepTime + " milliseconds");
		Thread.sleep(Long.valueOf(sleepTime));
		RequestB reqB = new RequestB();
		reqB.setB(request.getA());
		System.out.println("Creating Request for Module B");
		System.out.println(reqB);
		System.out.println("Invoking Module B");
		return reqB;
	}
	
	public void receive(ResponseC response) {
		
		System.out.println("Inside Service A : received response from Module C");
		System.out.println("Got Response from API C : "+response.getRespC());
		System.out.println("Response Generated : " +response);
		
	}

}
