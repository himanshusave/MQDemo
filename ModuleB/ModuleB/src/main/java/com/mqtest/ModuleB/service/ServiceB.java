package com.mqtest.ModuleB.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mqtest.ModuleHelper.RequestB;
import com.mqtest.ModuleHelper.RequestC;

@Service
public class ServiceB {
	
	@Value("${sleep.time}")
	private String sleepTime;
	
	public RequestC invoke(RequestB request) throws InterruptedException {
		
		System.out.println("Inside service B");
		System.out.println("Received request : " + request);
		
		System.out.println("Going to sleep for " + sleepTime + " milliseconds");
		Thread.sleep(Long.valueOf(sleepTime));
		RequestC reqC = new RequestC();
		reqC.setC(request.getB()*10);
		System.out.println("Creating request for Module C :" + reqC);
		System.out.println("Invoking Module C");
		return reqC;
	}
	
	/*public ResponseB receiveC(ResponseC response) {
		
		System.out.println("Inside Service B : received response from Module C");
		System.out.println("Got Response from API C : "+ response.getRespC());
		System.out.println("Response Generated : " +response);
		ResponseB responseB = new ResponseB();
		responseB.setRespB(response.getRespC());
		return responseB;
	}*/

}
