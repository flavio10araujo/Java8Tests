package com.tests.java8.T05TypeInference;

/**
 * The type parameter of Value.defaultValue() is inferred and is not required to be provided.
 * In Java 7, the same example will not compile and should be rewritten to Value.<String>defaultValue().
 *
 */
public class TypeInference {
	
	public static void main(String[] args) {
		
		final Value<String> value = new Value<>();
		
		System.out.println(value.getOrDefault("22", Value.defaultValue())); // 22
	}
}