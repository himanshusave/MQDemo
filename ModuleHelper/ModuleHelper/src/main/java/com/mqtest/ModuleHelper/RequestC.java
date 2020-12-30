package com.mqtest.ModuleHelper;

import java.io.Serializable;

public class RequestC implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private long a;
	private long b;
	private long c;

	public long getC() {
		return c;
	}

	public void setC(long c) {
		this.c = c;
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

	@Override
	public String toString() {
		return "RequestC [a=" + a + ", b=" + b + ", c=" + c + "]";
	}

}
