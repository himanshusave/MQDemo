package com.mqtest.ModuleC.service;

import org.springframework.stereotype.Service;

import com.mqtest.ModuleHelper.RequestC;
import com.mqtest.ModuleHelper.ResponseC;

@Service
public class ServiceC {
	
	public ResponseC invoke(RequestC request) throws InterruptedException {
		
		System.out.println("Inside service C");
		System.out.println("Received request : " + request);
		Thread.sleep(1000);
		System.out.println("Generating Response...");
		ResponseC resp = new ResponseC();
		resp.setRespC(request.getC()*10);
		System.out.println("Response Generated in Service C : " +resp);
		return resp;
	}

}
