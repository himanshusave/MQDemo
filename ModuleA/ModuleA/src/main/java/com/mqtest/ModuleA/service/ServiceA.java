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
import org.springframework.stereotype.Service;

import com.mqtest.ModuleHelper.RequestA;
import com.mqtest.ModuleHelper.RequestB;
import com.mqtest.ModuleHelper.ResponseC;

@Service
public class ServiceA {

	@Value("${sleep.time}")
	private String sleepTime;
	private static final Random random = new Random();
	private DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:sss");

	public RequestB invoke(RequestA request) throws InterruptedException {

		System.out.println("Inside service A");
		System.out.println("Received request : " + request);

		System.out.println("Going to sleep for " + sleepTime + " milliseconds");
		Thread.sleep(Long.valueOf(sleepTime));
		RequestB reqB = new RequestB();
		reqB.setA(request.getA());
		reqB.setRunId(request.getRunId());
		System.out.println("Creating Request for Module B");
		System.out.println("Request Created is : " + reqB);
		System.out.println(reqB);
		System.out.println("Invoking Module B");
		return reqB;
	}

	public void receive(ResponseC response) {

		System.out.println("Inside Service A : received response from Module C");
		System.out.println("Response Generated : " + response);
		String fileName = response.getRunId();
		writeToFile(createLogMsg(response), fileName);
	}

	private String createLogMsg(ResponseC response) {

		String msg = getCurrentTime() + " ResponseC [a=" + response.getA() + ", b="
				+ response.getB() + ", c=" + response.getC() + "]";
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
