package com.tests.java8.T01Lambas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BMain {

	public static void main(String[] args) {
		// Lambdas podem retornar valores.
		
		//List<String> mylist = List.of("a", "d", "b"); // Inicializando assim, o sort não funciona.
		List<String> mylist = new ArrayList<>();
		mylist.add("a");
		mylist.add("d");
		mylist.add("b");
		
		System.out.println("mylist ANTES de ordenar = " + mylist);
		
		//Arrays.asList("a", "d", "b").sort((e1, e2) -> e1.compareTo(e2));
		mylist.sort((e1, e2) -> e1.compareTo(e2));
		//Collections.sort(mylist); // usando o Collections para ordenar.
		
		System.out.println("mylist DEPOIS de ordenar = " + mylist);
		
		Arrays.asList(5, 10, 3).sort((e1, e2) -> {
			int result = e1.compareTo(e2);
			System.out.println("e1 = " + e1);
			System.out.println("e2 = " + e2);
			System.out.println("result = " + result);
			System.out.println();
			return result;
		});
		
		
		// Como era feito o Comparator antes dos lambdas:
		Comparator<String> stringComparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		};
		
		System.out.println(stringComparator.compare("aaa", "fff")); // -5
		System.out.println(stringComparator.compare("fff", "aaa")); // 5
		
		// Como o Comparator é feito com os lambdas:
		Comparator<String> stringComparatorLambda = (String o1, String o2) -> { return o1.compareTo(o2); };
		System.out.println(stringComparatorLambda.compare("aaa", "fff")); // -5
		System.out.println(stringComparatorLambda.compare("fff", "aaa")); // 5
		
		// Ou ainda mais resumido:
		Comparator<String> stringComparatorLambda2 = (o1, o2) -> o1.compareTo(o2);
		System.out.println(stringComparatorLambda2.compare("aaa", "fff")); // -5
		System.out.println(stringComparatorLambda2.compare("fff", "aaa")); // 5
	}
}