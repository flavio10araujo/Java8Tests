package com.tests.java8.T02Interfaces;

public interface ComMetodoDefault {
	
	// Interfaces now allow default methods, the implementer may or may not implement (override) them.
	default String metodoDefault() {
		return "ISSO VEM DA INTERFACE";
	}
}