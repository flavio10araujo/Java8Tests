package com.tests.java8.T01Lambas;

import java.util.function.BooleanSupplier;

public class CMain {
	
	public static void main(String[] args) {
		
		/* WITHOUT LAMBDAS - BEGIN */
		Names nameInstance = new Names() {
			@Override
			public void sayName(String name) {
				System.out.println("My Name is " + name);
			}
		};
		
		myName(nameInstance, "John");
		/* WITHOUT LAMBDAS - END */
		
		
		/* WITH LAMBDAS - BEGIN */
		// lambda expression helps us write very simple code and also helped removed all those anonymous inner classes you would have had to create.
		myName(n -> System.out.println("My name is " + n), "John");
		/* WITH LAMBDAS - END */
		
		
		// A sintaxe do lambda é: (argumento) -> { o que deve fazer }
		// argumento pode ser vazio, 1 ou vários.
		// o que deve fazer é o que será feito com os argumentos.
		
		// Nesse caso, é o mesmo que dizer: 
		// - quero criar uma classe que implementa a interface Teste;
		// - e quero que o método único dessa classe faça "return i + 3;" onde i é o parâmetro que estou passando.
		teste(i -> {return i + 3;}, 10);
		teste(i -> {return i + 3;}, 20);
		
		// Aqui é o mesmo que dizer:
		// - quero criar uma classe que implementa a interface Teste2;
		// - o único método dessa interface não possui parâmetros, por isso o () no começo da expressão lambda.
		// - quero que esse método único sempre retorne a string "oi".
		teste2(() -> "oi");
		
		// Aqui é:
		// - o único método da interface Teste3 recebe uma String, então passe a string i para ele;
		// - pegue essa string e veja o tamanho dela.
		teste3((String i) -> i.length(), "testando");
		
		// Aqui estou instanciando uma classe sem nome que implementa a interface Teste4.
		// Além disso, estou dizendo que o único método dessa interface será implementado com a lógica s1 * 2.
		Teste4 minhaClasse = (Integer s1) -> s1 * 2;
		System.out.println(minhaClasse.calcIt(5));
		
		// Também é possível fazer a chamada sem identificar o tipo do parâmetro.
		Teste4 minhaClasse2 = s1 -> s1 * 2;
		System.out.println(minhaClasse2.calcIt(15));
		
		// 
		BooleanSupplier bs = () -> true;
	    System.out.println(bs.getAsBoolean()); // true

	    int x = 0, y= 1;
	    bs = () -> x > y;
	    System.out.println(bs.getAsBoolean()); // false
	}

	private static void myName(Names nameInstance, String name) {
		nameInstance.sayName(name);
	}
	
	public static void teste(Teste teste, int n) {
		System.out.println(teste.soma3(n));
	}
	
	public static void teste2(Teste2 teste2) {
		System.out.println(teste2.retornaTexto());
	}
	
	public static void teste3(Teste3 teste3, String txt) {
		System.out.println(teste3.retornaTamanhoDoTexto(txt));
	}
}

// Obrigatoriamente precisa ter apenas 1 método!
interface Names {
	public void sayName(String name);
	
	// Não posso criar esse método aqui, pois o lambda só funciona para interface functional, 
	// ou seja, com interface com apenas 1 método.
	// public void outroMetodo();
}

//Obrigatoriamente precisa ter apenas 1 método!
interface Teste {
	public int soma3(int n);
}

interface Teste2 {
	public String retornaTexto();
}

interface Teste3 {
	public int retornaTamanhoDoTexto(String texto);
}

interface Teste4 {
	public Integer calcIt(Integer s1);
}