package com.mqtest.ModuleA.service;

import org.springframework.stereotype.Service;

import com.mqtest.ModuleHelper.RequestA;
import com.mqtest.ModuleHelper.RequestB;
import com.mqtest.ModuleHelper.ResponseB;

@Service
public class ServiceA {
	
	public RequestB invoke(RequestA request) throws InterruptedException {
		
		System.out.println("Inside service A");
		System.out.println("Received request : " + request);
		
		Thread.sleep(1000);
		RequestB reqB = new RequestB();
		reqB.setB(request.getA());
		System.out.println("Creating Request for Module B");
		System.out.println(reqB);
		System.out.println("Invoking Module B");
		return reqB;
	}
	
	public void receiveB(ResponseB response) {
		
		System.out.println("Inside Service A : received response from Module B");
		System.out.println("Got Response from API B : "+response.getRespB());
		System.out.println("Response Generated : " +response);
		
	}

}
