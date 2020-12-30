package com.mqtest.ModuleHelper;

import java.io.Serializable;

public class ResponseB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long a;
	private long b;
	private long respB;
	private String runId;
	private String error;

	public long getRespB() {
		return respB;
	}

	public void setRespB(long respB) {
		this.respB = respB;
	}

	public long getA() {
		return a;
	}

	public void setA(long a) {
		this.a = a;
	}

	public long getB() {
		return b;
	}

	public void setB(long b) {
		this.b = b;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getRunId() {
		return runId;
	}

	public void setRunId(String runId) {
		this.runId = runId;
	}

	@Override
	public String toString() {
		return "ResponseB [a=" + a + ", b=" + b + ", respB=" + respB + ", runId=" + runId + ", error=" + error + "]";
	}

}
