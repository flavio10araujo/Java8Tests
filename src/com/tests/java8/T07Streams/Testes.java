package com.tests.java8.T07Streams;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

public class Testes {

	public static void main(String[] args) {
		/*List<Person> pessoas = List.of(
				new Person(20, "Luana"),
				new Person(19, "Júnior"),
				new Person(11, "Amanda"),
				new Person(9, "Milena")
				);
		
		pessoas.forEach(p -> p.setAge(p.getAge() + 10));
		pessoas.forEach(p -> System.out.println(p));*/
		
		//printlala(pessoas, p -> ((Person) p).getAge() < 18);
		
		/*List<Person> kids = pessoas
				.stream()
				.filter(p -> p.getAge() < 18)
				.collect(Collectors.toList());
		
		System.out.println(kids);*/
		
		/*int sumAgeKids = pessoas
				.stream()
				.filter(p -> p.getAge() < 18)
				.mapToInt(Person::getAge)
				.sum();
		
		System.out.println(sumAgeKids);*/
		
		/*List<String> words = List.of("aaa", "bbb", "ccc");
		
		String concat = words
				.stream()
				.reduce("", (a, b) -> a + ";" + b);
		
		StringJoiner sj = new StringJoiner(";");
		sj.add("aaa");
		sj.add("bbb");
		
		System.out.println(concat);
		System.out.println(sj);*/
		
		Map<Integer, String> myMap = Map.of(
				1, "A",
				2, "B",
				3, "C"
				);
		
		for(Map.Entry<Integer, String> entry : myMap.entrySet()) {
			System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
		}
		
		myMap.forEach((K, V) -> System.out.println("key = " + K + " value = " + V));
	}
	
	public static void printlala(List<Person> pessoas, Predicate<Person> predicate) {
		pessoas
			.stream()
			.filter(predicate)
			.limit(1)
			.forEach(p -> System.out.println(p.getName()));
	}
	
	static class Person {
		int age;
		String name;
		
		Person(int age, String name) {
			this.age = age;
			this.name = name;
		}
		
		public int getAge() {
			return age;
		}
		
		public void setAge(int age) {
			this.age = age;
		}
		
		public String getName() {
			return this.name;
		}
		
		public String toString() {
			return "Name: " + getName() + " Age: " + getAge();
		}
	}
}