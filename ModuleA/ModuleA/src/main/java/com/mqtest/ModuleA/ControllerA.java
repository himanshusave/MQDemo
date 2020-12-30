package com.mqtest.ModuleA;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mqtest.ModuleA.service.ServiceA;
import com.mqtest.ModuleHelper.RequestA;

@RestController
public class ControllerA {
	
	@Autowired
	private ServiceA service;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@RequestMapping(value="/invokeMultiple/{endIndex}", method = RequestMethod.POST)
	public String invokeMulti(@PathVariable("endIndex") long endIndex) throws InterruptedException {
		
		System.out.println("Controller A invoked");
		String runId = service.generateRunId();
		service.writeToFile(service.getCurrentTime() + " Started File Generation", runId);
		Instant start = Instant.now();
		long startIndex = 1;
		while (startIndex<=endIndex) {
			RequestA req = new RequestA();
			req.setA(startIndex);
			req.setRunId(runId);
			restTemplate.postForObject("http://localhost:8080/ModuleA/invokeA", req, Void.class);
			startIndex++;
		}
		Instant end = Instant.now();
		Duration timeTaken = Duration.between(start, end);
		System.out.println("Time taken : " + timeTaken);
		return "Successfully pushed all records in : " + timeTaken;
		
	}
	

}
