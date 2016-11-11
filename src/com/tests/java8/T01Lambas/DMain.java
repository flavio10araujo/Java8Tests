package com.tests.java8.T01Lambas;

public class DMain {
	
	public static void main(String[] argv) {
		
		Processor stringProcessor = (String str) -> str.length();
		
		SecondProcessor secondProcessor = (String str) -> str.length();
		
		//stringProcessor = secondProcessor; //compile error
		
		String name = "Java Lambda";
		
		int length = stringProcessor.getStringLength(name);
		
		System.out.println(length);
	}
}

@FunctionalInterface
interface Processor {
	int getStringLength(String str);
}

@FunctionalInterface
interface SecondProcessor {
	int noName(String str);
}