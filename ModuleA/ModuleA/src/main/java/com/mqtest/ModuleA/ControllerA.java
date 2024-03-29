package com.mqtest.ModuleA;

import java.time.Duration;
import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mqtest.ModuleA.service.ServiceA;
import com.mqtest.ModuleHelper.RequestA;
import com.mqtest.ModuleHelper.ResponseA;

@RestController
public class ControllerA {
	
	@Autowired
	private ServiceA service;
	
	@RequestMapping(value="/invokeA", method = RequestMethod.POST)
	public ResponseA invokeA(@RequestBody RequestA request) throws InterruptedException {
		return service.invoke(request);
	}
	
	@RequestMapping(value="/invokeMultiple/{endIndex}", method = RequestMethod.POST)
	public String invokeMulti(@PathVariable("endIndex") long endIndex) throws InterruptedException {
		
		Instant start = Instant.now();
		long startIndex = 1;
		StringBuilder sb = new StringBuilder();
		while (startIndex<=endIndex) {
			RequestA req = new RequestA();
			req.setA(startIndex);
			ResponseA resp = service.invoke(req);
			if(null!=resp) {
				sb.append(resp.getRespA()+"\n");
			}else {
				sb.append("Error\n");
			}
			startIndex++;
		}
		Instant end = Instant.now();
		System.out.println("Time taken : " + Duration.between(start, end));
		return sb.toString();
		
	}

}
