package com.tests.java8.T01Lambas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AMain {

	public static void main(String[] args) {
		// Supondo que eu preciso iterar uma lista e mostrar o conteúdo com letras maiúsculas.
		System.out.println("### EXEMPLO 01 ###");
		
		// Como era sem os lambdas:
		System.out.println("LIST SEM LAMBDAS");
		
		List<String> t1 = new ArrayList<String>();
		
		t1.add("a");
		t1.add("b");
		t1.add("d");
		
		for (String s : t1) {
			System.out.println(s.toUpperCase());
		}
		
		// Para um array, sem lambdas:
		String[] t2 = {"a", "b", "c"};
		
		System.out.println("ARRAY SEM LAMBDAS");
		for (String s : t2) {
			System.out.println(s.toUpperCase());
		}
		
		System.out.println("ARRAY COM LAMBDAS");
		Arrays.asList(t2).forEach(item -> System.out.println(item.toUpperCase()));		
		
		// Como é com os lambdas:
		System.out.println("LIST COM LAMBDAS");
		
		List<String> t3 = new ArrayList<String>();
		
		t3.add("a");
		t3.add("b");
		t3.add("d");
		
		t3.forEach(item -> System.out.println(item.toUpperCase()));
		
		// Mesma coisa se eu precisar fazer alguma validação. Por exemplo, pegar apenas o valor que seja igual a "b":
		System.out.println("### EXEMPLO 02 ###");
		
		t3.forEach(item -> {
			if (item.equals("b")) {
				System.out.println(item);
			}
		});
		
		
		System.out.println("### EXEMPLO 03 ###");
		// Como era pra iterar um Map.
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		for (Map.Entry<String, Integer> entry : items.entrySet()) {
			System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
		}
		
		// Como é pra iterar um Map com lambda.
		Map<String, Integer> items2 = new HashMap<>();
		items2.put("A", 10);
		items2.put("B", 20);
		items2.put("C", 30);
		items2.put("D", 40);
		items2.put("E", 50);
		items2.put("F", 60);

		items2.forEach((k, v) -> System.out.println("Item : " + k + " Count : " + v));

		items2.forEach((k, v) -> {
			System.out.println("Item : " + k + " Count : " + v);
			if ("E".equals(k)) {
				System.out.println("Hello E!");
			}
		});
	}
}