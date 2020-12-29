package com.mqtest.ModuleHelper;

import java.io.Serializable;

public class RequestA implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long a;
	private String runId;

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
		return "RequestA [a=" + a + ", runId=" + runId + "]";
	}
	

}
