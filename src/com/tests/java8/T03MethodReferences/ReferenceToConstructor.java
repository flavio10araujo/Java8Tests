package com.tests.java8.T03MethodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

/**
 * Reference To Constructor.
 */
public class ReferenceToConstructor {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(4, 9, 16, 25, 36);
		
		// This is very similar to reference to a static method.
		// The difference between the two is, the constructor reference method name is new.
		
		// Lambda Form:
		//List<Integer> squaredNumbers = ReferenceToConstructor.findSquareRoot(numbers, x -> new Integer(x));
		// Method Reference:
		// List<Integer> squaredNumbers = ReferenceToConstructor.findSquareRoot(numbers, Integer::new);
		
		List<Integer> squaredNumbers = ReferenceToConstructor.findSquareRoot(numbers, Integer::new);
		
		System.out.println("Square root of numbers = "+squaredNumbers);
	}

	private static List<Integer> findSquareRoot(List<Integer> list, Function<Integer, Integer> f) {
		List result = new ArrayList();
		
		list.forEach(x -> result.add(Math.sqrt(f.apply(x))));
		
		return result;
	}
}