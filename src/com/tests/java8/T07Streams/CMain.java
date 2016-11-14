package com.tests.java8.T07Streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CMain {

	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
		
		List<Integer> twoEvenSquares = numbers.stream()
				.filter( n -> {
					System.out.println("filtering " + n);
					return n % 2 == 0;
				})
				.map(n -> {
					System.out.println("mapping " + n);
					return n * n;
				})
				.limit(2)
				.collect(Collectors.toList());
		
		// It will print:
		// filtering 1
		// filtering 2
		// mapping 2
		// filtering 3
		// filtering 4
		// mapping 4
		
		// ###################################
		
		List<Integer> numbers2 = Arrays.asList(1, 1, 3, 2, 3, 1, 1, 4);
		
		List<Integer> uniqueNumbers = numbers2.stream()
				.distinct()
				.collect(Collectors.toList());
		
		uniqueNumbers.forEach(item -> System.out.println(item));
		
		// It will print:
		// 1
		// 3
		// 2
		// 4
		
		// ###################################
		
		List<Integer> uniqueNumbersOrdered = numbers2.stream()
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		
		uniqueNumbersOrdered.forEach(item -> System.out.println(item));
		
		// It will print:
		// 1
		// 2
		// 3
		// 4
		
		// ###################################
		
		List<Integer> numbers3 = Arrays.asList(1, 2, 3);
		
		int sum1 = numbers3.stream().reduce(0, (a, b) -> a + b);
		System.out.println("Sum = " + sum1); // Sum = 6
		
		int sum2 = numbers3.stream().reduce(3, (a, b) -> a + b);
		System.out.println("Sum = " + sum2); // Sum = 9
		
		int sum3 = numbers3.stream().reduce(0, Integer::sum);
		System.out.println("Sum = " + sum3); // Sum = 6
	}
}