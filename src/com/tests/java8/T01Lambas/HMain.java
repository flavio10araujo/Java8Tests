package com.tests.java8.T01Lambas;

/**
 * Cast Context.
 * We can use a lambda expression preceded by a cast. The type specified in the cast is its target type.
 */
public class HMain {
	
	public static void main(String[] argv) {
		engine((IntCalculator2) ((x,y) -> x + y));
	}
	
	private static void engine(IntCalculator2 calculator) {
		int x = 2, y = 4;
		int result = calculator.calculate(x,y);
		System.out.println("IntCalculator2 = " + result);
	}
	
	private static void engine(LongCalculator2 calculator) {
		long x = 2, y = 4;
		long result = calculator.calculate(x,y);
		System.out.println("LongCalculator2" + result);
	}  
}

@FunctionalInterface
interface IntCalculator2 {
	int calculate(int x, int y);
}

@FunctionalInterface
interface LongCalculator2 {
	long calculate(long x, long y);
}