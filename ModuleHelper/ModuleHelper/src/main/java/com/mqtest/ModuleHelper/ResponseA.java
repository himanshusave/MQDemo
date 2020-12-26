package com.mqtest.ModuleHelper;

import java.io.Serializable;

public class ResponseA implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long respA;

	public long getRespA() {
		return respA;
	}

	public void setRespA(long respA) {
		this.respA = respA;
	}

	@Override
	public String toString() {
		return "ResponseA [respA=" + respA + "]";
	}

}
