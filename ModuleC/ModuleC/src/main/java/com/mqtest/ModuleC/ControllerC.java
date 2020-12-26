package com.mqtest.ModuleC;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mqtest.ModuleC.service.ServiceC;
import com.mqtest.ModuleHelper.RequestC;
import com.mqtest.ModuleHelper.ResponseC;

@RestController
public class ControllerC {
	
	@Autowired
	private ServiceC service;
	
	@RequestMapping(value="/invokeC",method=RequestMethod.POST)
	public ResponseC invokeC(@RequestBody RequestC request) throws InterruptedException {
		return service.invoke(request);
	}
	

}
