package com.tests.java8.T02Interfaces;

public class BMain {

	public static void main(String[] args) {
		
		ComMetodoDefault defaulable = ComMetodoStatic.create(ComMetodoDefaultImpl::new);
		
		System.out.println(defaulable.metodoDefault());
		
		defaulable = ComMetodoStatic.create(ComMetodoDefaultOverrideImpl::new);
		
		System.out.println(defaulable.metodoDefault());
	}
}