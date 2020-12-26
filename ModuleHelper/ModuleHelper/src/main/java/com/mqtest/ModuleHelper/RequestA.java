package com.mqtest.ModuleHelper;

import java.io.Serializable;

public class RequestA implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long a;

	public long getA() {
		return a;
	}

	public void setA(long a) {
		this.a = a;
	}

	@Override
	public String toString() {
		return "RequestA [a=" + a + "]";
	}

}
