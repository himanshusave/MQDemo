package com.mqtest.ModuleC.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.mqtest.ModuleHelper.RequestC;
import com.mqtest.ModuleHelper.Response;
import com.mqtest.ModuleHelper.ResponseC;

@Service
public class ServiceC {
	
	@Value("${sleep.time}")
	private String sleepTime;
	
	public Response invoke(Message<Response> message) throws InterruptedException {
		
		Response responseReceived = message.getPayload(); 
		RequestC request = (RequestC)responseReceived.getData();
		System.out.println("Inside service C");
		System.out.println("Received request : " + request);
		
		System.out.println("Going to sleep for "+ sleepTime + " milliseconds");
		Thread.sleep(Long.valueOf(sleepTime));
		System.out.println("Generating Response...");
		Response response = new Response();
		request.setC(request.getB()*10);
		ResponseC resp = new ResponseC();
		resp.setA(request.getA());
		resp.setB(request.getB());
		resp.setC(request.getC());
		response.setData(resp);
		response.setRunId(responseReceived.getRunId());
		System.out.println("Response Generated in Service C : " +resp);
		return response;
	}

}
