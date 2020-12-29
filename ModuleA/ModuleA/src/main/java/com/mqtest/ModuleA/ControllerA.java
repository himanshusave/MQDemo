package com.mqtest.ModuleA;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mqtest.ModuleA.service.ServiceA;

@RestController
public class ControllerA {
	
	@Autowired
	private ServiceA service;
	
	/*@RequestMapping(value="/invokeA", method = RequestMethod.POST)
	public void invokeA(@RequestBody RequestA request) throws InterruptedException {
		service.invoke(request);
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
			sb.append(resp.getRespA()+"\n");
			startIndex++;
		}
		Instant end = Instant.now();
		System.out.println("Time taken : " + Duration.between(start, end));
		return sb.toString();
		
	}*/

}
