package com.tests.java8.T01Lambas;

import java.util.Arrays;

public class BMain {

	public static void main(String[] args) {
		// Lambdas podem retornar valores.
		
		Arrays.asList("a", "b", "d").sort((e1, e2) -> e1.compareTo(e2));
		
		Arrays.asList(5, 10, 3).sort((e1, e2) -> {
			int result = e1.compareTo(e2);
			System.out.println(e1);
			System.out.println(e2);
			System.out.println(result);
			System.out.println();
			return result;
		});
	}
}