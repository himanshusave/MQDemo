package com.mqtest.ModuleA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.mqtest.ModuleHelper.RequestA;
import com.mqtest.ModuleHelper.RequestB;
import com.mqtest.ModuleHelper.ResponseA;
import com.mqtest.ModuleHelper.ResponseB;

@Service
public class ServiceA {

	@Autowired
	private RestTemplate restTemplate;

	public ResponseA invoke(RequestA request) throws InterruptedException {

		System.out.println("Inside service A");
		System.out.println("Received request : " + request);
		ResponseA resp = null;

		try {
			Thread.sleep(1000);
			System.out.println("Getting Response using responseEntity...");
			RequestB reqB = new RequestB();
			reqB.setB(request.getA());
			System.out.println(reqB);
			ResponseEntity<ResponseB> responseEntity = restTemplate
					.postForEntity("http://localhost:8080/ModuleB/invokeB", reqB, ResponseB.class);
			System.out.println("Got Response from API B : " + responseEntity.getBody().getRespB());
			resp = new ResponseA();
			resp.setRespA(responseEntity.getBody().getRespB());
			System.out.println("Response Generated");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Exception occurred : "+e);
		}

		return resp;

	}

}
