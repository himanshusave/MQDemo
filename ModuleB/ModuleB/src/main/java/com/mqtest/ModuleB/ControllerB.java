package com.mqtest.ModuleB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mqtest.ModuleB.service.ServiceB;
import com.mqtest.ModuleHelper.RequestB;
import com.mqtest.ModuleHelper.ResponseB;

@RestController
public class ControllerB {
	
	@Autowired
	ServiceB service;
	
	@RequestMapping(value="/invokeB" , method=RequestMethod.POST)
	public ResponseB invokeB(@RequestBody RequestB request) throws InterruptedException {
		return service.invoke(request);
	}

}
