package com.tests.java8.T02Interfaces;

public class AMain {

	public static void main(String[] args) {
		ComMetodoDefault c = new ComMetodoDefaultImpl();
		
		String t = c.metodoDefault();
		
		System.out.println(t);
		
		ComMetodoDefault d = new ComMetodoDefaultOverrideImpl();
		t = d.metodoDefault();
		
		System.out.println(t);
	}
}
