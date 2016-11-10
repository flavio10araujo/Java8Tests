package com.tests.java8.T01Lambas;

import java.util.ArrayList;
import java.util.List;

public class AMain {

	public static void main(String[] args) {
		// Supondo que eu preciso iterar uma lista e mostrar o conteúdo com letras maiúsculas.
		System.out.println("### EXEMPLO 01 ###");
		
		// Como era sem os lamdas:
		System.out.println("LIST SEM LAMBDAS");
		
		List<String> t1 = new ArrayList<String>();
		
		t1.add("a");
		t1.add("b");
		t1.add("d");
		
		for (String s : t1) {
			System.out.println(s.toUpperCase());
		}
		
		// Para um array, sem lambdas:
		System.out.println("ARRAY SEM LAMBDAS");
		
		String[] t2 = {"a", "b", "c"};
		
		for (String s : t2) {
			System.out.println(s.toUpperCase());
		}
		
		// Como é com os lamdas:
		System.out.println("COM LAMBDAS");
		
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
	}
}