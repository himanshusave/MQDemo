package com.mqtest.ModuleHelper;

import java.io.Serializable;

public class Response implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Object data;
	private String runId;
	private String errorMsg;
	private String headerMsg;
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getHeaderMsg() {
		return headerMsg;
	}
	public void setHeaderMsg(String headerMsg) {
		this.headerMsg = headerMsg;
	}
	public String getRunId() {
		return runId;
	}
	public void setRunId(String runId) {
		this.runId = runId;
	}

}
