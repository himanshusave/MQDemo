package com.mqtest.ModuleA.service;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import com.mqtest.ModuleHelper.RequestA;
import com.mqtest.ModuleHelper.RequestB;
import com.mqtest.ModuleHelper.Response;
import com.mqtest.ModuleHelper.ResponseB;
import com.mqtest.ModuleHelper.ResponseC;

@Service
public class ServiceA {

	@Value("${sleep.time}")
	private String sleepTime;
	private static final Random random = new Random();
	private DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:sss");

	public Response invoke(RequestA request) throws InterruptedException {

		System.out.println("Inside service A");
		System.out.println("Received request : " + request);

		System.out.println("Going to sleep for " + sleepTime + " milliseconds");
		Thread.sleep(Long.valueOf(sleepTime));
		RequestB reqB = new RequestB();
		reqB.setA(request.getA());
		Response response = new Response();
		response.setRunId(request.getRunId());
		response.setData(reqB);
		System.out.println("Creating Request for Module B");
		System.out.println("Request Created is : " + reqB);
		System.out.println(reqB);
		System.out.println("Invoking Module B");
		return response;
	}

	public void receive(Message<Response> message) {

		Response responseReceived = message.getPayload();
		System.out.println("Inside Service A : received response");
		String fileName = responseReceived.getRunId();
		writeToFile(createLogMsg(responseReceived), fileName);
	}

	private String createLogMsg(Response response) {

		String msg = null;
		
		if(response.getData() instanceof ResponseC) {
			ResponseC resp = (ResponseC)response.getData();
			msg = " ResponseC [a=" + resp.getA() + ", b="+ resp.getB() + ", c=" + resp.getC() + "]";
		}else if(response.getData() instanceof ResponseB) {
			ResponseB resp = (ResponseB)response.getData();
			msg = " ResponseB [a=" +resp.getA()+ ", b=" + resp.getB()+"] Error : " + response.getErrorMsg();
		}
		msg = getCurrentTime() + msg;
		System.out.println(msg);
		return msg;

	}
	
	public String getCurrentTime() {
		Date currentTime = Date.from(Instant.now());
		return "Time : [" + formatter.format(currentTime) + "]";
	}

	public void writeToFile(String msg, String fileName) {

		try {
			Path root = FileSystems.getDefault().getPath("").toAbsolutePath();
			String absolutePath = root.toString() + File.separator + "GeneratedFiles" + File.separator + fileName
					+ ".txt";
			Path path = Paths.get(absolutePath);
			Files.write(path, (msg + System.lineSeparator()).getBytes(StandardCharsets.UTF_8),
					Files.exists(path) ? StandardOpenOption.APPEND : StandardOpenOption.CREATE);
		} catch (IOException e) {
			System.out.println("Exception occured : " + e);
			e.printStackTrace();
		}
	}

	public String generateRunId() {

		int randomNumber = random.nextInt(100);
		String runId = "RUN" + randomNumber + "D" + System.currentTimeMillis();
		return runId;
	}

}
