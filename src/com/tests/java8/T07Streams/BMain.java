package com.tests.java8.T07Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class BMain {

	private enum Gender  { MALE, FEMALE }

	public static void main(String[] args) {

		List<Person> persons = new ArrayList<Person>();
		
		persons.add(new Person("Albert", 80, Gender.MALE));
		persons.add(new Person("Ben", 15, Gender.MALE));
		persons.add(new Person("Charlote", 20, Gender.FEMALE));
		persons.add(new Person("Dean", 6, Gender.MALE));
		persons.add(new Person("Elaine", 17, Gender.FEMALE));

		// How much code would you need to do the following without Lambdas?
		System.out.println("----------Printing Persons with age less than 18----------");
		
		printNames(persons, p -> ((Person) p).getAge() < 18);
		
		System.out.println("\n--------Printing all Males-------------");
		
		printNames(persons, p -> ((Person) p).getGender() == Gender.MALE);
		
		System.out.println("\n---------Printing Persons with Names starting With C------------");
		
		printNames(persons, p -> ((Person) p).getName().startsWith("C"));
	}

	// O uso do streams é nesse método:
	// Predicate é uma das interfaces funcionais prontas do java 8.
	// Predicate tem o mesmo efeito que eu criar uma interface funcional com o método public boolean test(T  t);
	private static void printNames(List<Person> persons, Predicate<Person> predicate) {
		persons.stream()
		.filter(predicate)
		.map(p -> ((Person) p).getName())
		.forEach(name -> System.out.println(name));
	}
	
	private static class Person {
		private final String name;
		private final int age;
		private final Gender gender;

		public Person(String name, int age, Gender gender) {
			this.name = name;
			this.age = age;
			this.gender = gender;
		}

		public String getName() {
			return name;
		}

		public int getAge() {
			return age;
		}

		public Gender getGender() {
			return gender;
		}
	}
}