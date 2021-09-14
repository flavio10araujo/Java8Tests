package com.tests.java8.T12Comparing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AMain {

	public static void main(String[] args) {
		
		List<Person> peopleJava7 = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Caroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
		);
		
		List<Person> peopleJava8 = Arrays.asList(
				new Person("Charles", "Dickens", 60),
				new Person("Lewis", "Caroll", 42),
				new Person("Thomas", "Carlyle", 51),
				new Person("Charlotte", "Bronte", 45),
				new Person("Matthew", "Arnold", 39)
		);
		
		// ### Step 1 : Sort list by last name.
		// Without lambda:
		peopleJava7.sort(new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});
		// Or:
		/*Collections.sort(peopleJava7, new Comparator<Person>() {
			public int compare(Person o1, Person o2) {
				return o1.getLastName().compareTo(o2.getLastName());
			}
		});*/
		
		// With lambda:
		peopleJava8.sort((o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
		
		// ### Step 2 : Create a method that prints all elements in the list.
		// Without lambda:
		printAllJava7(peopleJava7);
		// With lamda:
		printJava8(peopleJava8, p -> true);
		
		// Step 3 : Create a method that prints all elements beginning with C.
		// Without lambda:
		printStartsWithCJava7(peopleJava7);
		// Or:
		printSomeWithCJava7(peopleJava7, new Condition() {
			public boolean test(Person p) {
				if (p.getLastName().startsWith("C")) {
					return true;
				}
				
				return false;
			}
		});
		// With lambda:
		printJava8(peopleJava8, p -> p.getLastName().startsWith("C"));
		// Or:
		/*people.forEach(p -> {
			if (p.lastName.startsWith("C")) {
				System.out.println(p.name + " " + p.lastName);
			}
		});*/
	}
	
	private static void printAllJava7(List<Person> peopleJava7) {
		for (Person p : peopleJava7) {
			System.out.println(p);
		}
	}
	
	private static void printStartsWithCJava7(List<Person> peopleJava7) {
		for (Person p : peopleJava7) {
			if (p.getLastName().startsWith("C")) {
				System.out.println(p);
			}
		}
	}
	
	private static void printSomeWithCJava7(List<Person> peopleJava7, Condition condition) {
		for (Person p : peopleJava7) {
			if (condition.test(p)) {
				System.out.println(p);
			}
		}	
	}
	

	private static void printJava8(List<Person> peopleJava8, Condition condition) {
		for (Person p : peopleJava8) {
			if (condition.test(p)) {
				System.out.println(p);
			}
		}	
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
	
	interface Condition {
		boolean test(Person p);
	}
}