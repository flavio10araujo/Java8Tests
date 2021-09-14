package com.tests.java8.T01Lambas;

import java.util.Arrays;
import java.util.List;

// Using method references.
public class JMain {

	public static void main(String[] args) {
		// Without method reference.
		Thread t1 = new Thread(() -> printMessage());
		t1.start();
		
		// With method reference.
		Thread t2 = new Thread(JMain::printMessage);
		t2.start();
		
		List<Person> people = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Caroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
		);
		
		// Without method reference.
		people.forEach(p -> System.out.println(p));
		
		// With method reference.
		people.forEach(System.out::println);
	}
	
	public static void printMessage() {
		System.out.println("Hello");
	}
	
	static class Person {
		String name;
		String lastName;
		int age;
		
		public Person(String name, String lastName, int age) {
			this.name = name;
			this.lastName = lastName;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}
		
		@Override
		public String toString() {
			return this.getName() + " " + this.getLastName();
		}
	}
}