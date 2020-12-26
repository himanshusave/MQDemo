package com.mqtest.ModuleHelper;

import java.io.Serializable;

public class ResponseC implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private long respC;

	public long getRespC() {
		return respC;
	}

	public void setRespC(long respC) {
		this.respC = respC;
	}

	@Override
	public String toString() {
		return "ResponseC [respC=" + respC + "]";
	}

}
