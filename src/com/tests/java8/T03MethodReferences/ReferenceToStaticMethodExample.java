package com.tests.java8.T03MethodReferences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

/**
 * Reference to a Static Method.
 */
public class ReferenceToStaticMethodExample {
	
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 15, 16);
		
		
		// Method reference is very similar to Lambda.
		// Lambda Form:
		// List<Integer> primeNumbers = ReferenceToStaticMethod.testPredicate(numbers, a -> ReferenceToStaticMethod.isPrime(a));
		// Method Reference:
		// List<Integer> primeNumbers = ReferenceToStaticMethod.testPredicate(numbers, ReferenceToStaticMethod::isPrime);
		
		List<Integer> primeNumbers = ReferenceToStaticMethodExample.findPrimeNumbers(numbers, number -> ReferenceToStaticMethodExample.isPrime((int) number));

		System.out.println("Prime Numbers are " + primeNumbers);
	}

	public static boolean isPrime(int number) {
		if (number == 1) {
			return false;
		}
		
		for (int i = 2; i < number; i++) { 
			if (number % i == 0) { 
				return false; 
			} 
		} 
		
		return true; 
	} 
	
	public static List<Integer> findPrimeNumbers(List<Integer> list, Predicate predicate) { 
		List<Integer> sortedNumbers = new ArrayList<Integer>(); 
		
		list.stream().filter((i) -> (predicate.test(i))).forEach((i) -> {
			sortedNumbers.add(i);
		});
		
		return sortedNumbers;
	}
}