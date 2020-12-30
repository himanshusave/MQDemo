package com.mqtest.ModuleC.service;

import java.util.Random;

import org.springframework.stereotype.Service;

import com.mqtest.ModuleHelper.RequestC;
import com.mqtest.ModuleHelper.ResponseC;

@Service
public class ServiceC {
	
	private static Random random = new Random();
	
	public ResponseC invoke(RequestC request) throws InterruptedException {
		
		System.out.println("Inside service C");
		System.out.println("Received request : " + request);
		int randomSleepTime = random.nextInt(9);
		System.out.println("Sleeping for " +randomSleepTime + " seconds");
		Thread.sleep(randomSleepTime*1000);
		System.out.println("Generating Response...");
		ResponseC resp = new ResponseC();
		resp.setRespC(request.getC()*10);
		System.out.println("Response Generated");
		return resp;
		
	}

}
