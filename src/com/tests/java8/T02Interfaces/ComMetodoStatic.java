package com.tests.java8.T02Interfaces;

import java.util.function.Supplier;

public interface ComMetodoStatic {

	// Interfaces now allow static methods.
	static ComMetodoDefault create(Supplier<ComMetodoDefault> supplier) {
		return supplier.get();
	}
}