package com.tests.java8.T01Lambas;

/** 
 * Return Context.
 * We can use a lambda expression in a return statement, and its target type is declared in the method return type.
 */
public class GMain {
	
	public static void main(String[] argv) {
		System.out.println(create().calculate(18, 2));
	}
	
	private static Calculator2 create() {
		return (x, y) -> x / y;
	}  
}

@FunctionalInterface
interface Calculator2 {
	long calculate(long x, long y);
}