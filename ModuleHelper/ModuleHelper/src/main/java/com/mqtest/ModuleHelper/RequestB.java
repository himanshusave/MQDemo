package com.mqtest.ModuleHelper;

import java.io.Serializable;

public class RequestB implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long b;

	public long getB() {
		return b;
	}

	public void setB(long b) {
		this.b = b;
	}

	@Override
	public String toString() {
		return "RequestB [b=" + b + "]";
	}

}
