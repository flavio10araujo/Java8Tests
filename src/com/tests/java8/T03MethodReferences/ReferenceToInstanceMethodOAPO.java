package com.tests.java8.T03MethodReferences;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Reference To An Instance Method Of A Particular Object.
 */
public class ReferenceToInstanceMethodOAPO {

	public static void main(String[] args) {
		List<String> names = new ArrayList<String>();
		
		names.add("David");
		names.add("Richard");
		names.add("Samuel");
		names.add("Rose");
		names.add("John");

		// Since System.out is an instance of type PrintStream, we then call the println method of the instance.
		
		// Lambda Form:
		// ReferenceToInstanceMethodOAPO.printNames(names, x -> System.out.println(x));
		// Method Reference
		// ReferenceToInstanceMethodOAPO.printNames(names, System.out::println);
		
		ReferenceToInstanceMethodOAPO.printNames(names, System.out::println);
	}

	private static void printNames(List<String> list, Consumer c) {
		list.forEach(x -> c.accept(x));
	}
}