package com.mqtest.ModuleB.service;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.mqtest.ModuleHelper.RequestB;
import com.mqtest.ModuleHelper.RequestC;
import com.mqtest.ModuleHelper.Response;
import com.mqtest.ModuleHelper.ResponseB;

@Service
public class ServiceB {
	
	@Value("${sleep.time}")
	private String sleepTime;
	
	public Response invoke(Message<Response> message) throws InterruptedException {
		
		Response responseReceived = message.getPayload();
		RequestB request = (RequestB)responseReceived.getData();
		System.out.println("Inside service B");
		System.out.println("Received request : " + request);
		RequestC reqC = null;
		
		Response response = new Response();
		response.setRunId(responseReceived.getRunId());
		try {
			reqC = new RequestC();
			System.out.println("Going to sleep for " + sleepTime + " milliseconds");
			Thread.sleep(Long.valueOf(sleepTime));
			//System.out.println("Introducing ecxeption");
			//reqC = null;
			reqC.setA(request.getA());
			reqC.setB(request.getA()*10);
			response.setData(reqC);
			response.setHeaderMsg("HM_SUCCESS");
			System.out.println("Creating request for Module C :" + reqC);
			System.out.println("Invoking Module C");
		}catch (Exception e) {
			ResponseB responseB = new ResponseB();
			responseB.setA(request.getA());
			responseB.setB(request.getB());
			response.setData(responseB);
			response.setHeaderMsg("HM_FAILED");
			response.setErrorMsg(ExceptionUtils.getStackTrace(e));
		}
		
		return response;
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
