package com.mqtest.ModuleHelper;

import java.io.Serializable;

public class RequestB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long a;
	private long b;
	private String runId;

	public long getB() {
		return b;
	}

	public void setB(long b) {
		this.b = b;
	}

	public long getA() {
		return a;
	}

	public void setA(long a) {
		this.a = a;
	}

	public String getRunId() {
		return runId;
	}

	public void setRunId(String runId) {
		this.runId = runId;
	}

	@Override
	public String toString() {
		return "RequestB [a=" + a + ", b=" + b + ", runId=" + runId + "]";
	}
	
}
