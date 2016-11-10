package com.tests.java8.T03MethodReferences;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Reference To an Instance Method Of An Arbitrary Object Of A Particular Type.
 */
public class ReferenceToInstanceMethodAOPT {

	public static void main(String[] args) {

		List<Person> persons = new ArrayList<Person>();
		
		persons.add(new Person("Albert", 80));
		persons.add(new Person("Ben", 15));
		persons.add(new Person("Charlote", 20));
		persons.add(new Person("Dean", 6));
		persons.add(new Person("Elaine", 17));

		// This mean providing reference to any of the persons object in the List of a particular type which is the Person.
		// So the containing type is persons and the method name is getAge();
		
		// Lambda Form:
		// List allAges = ReferenceToInstanceMethodAOPT.listAllAges(persons, x -> x.getAge());
		// Method Reference:
		// List allAges = ReferenceToInstanceMethodAOPT.listAllAges(persons, Person::getAge);
		
		List<Integer> allAges = ReferenceToInstanceMethodAOPT.listAllAges(persons, Person::getAge);
		
		System.out.println("Printing out all ages \n" + allAges);
	}

	private static List<Integer> listAllAges(List<Person> person, Function<Person, Integer> f) {		
		
		List<Integer> result = new ArrayList<Integer>();
		
		person.forEach(x -> result.add(f.apply(x)));
		
		return result;
	}
	
	private static class Person {
		private final String name;
		private final int age;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}
	}
}