package com.tests.java8.T06Optional;

import java.util.Optional;

public class AMain {

	public static void main(String[] args) {
		
		// ### Example 1
		
		Optional<String> fullName = Optional.ofNullable(null);
		
		// The isPresent() method returns true if this instance of Optional has non-null value and false otherwise.
		System.out.println("Full Name is set? " + fullName.isPresent()); // Full Name is set? false
		
		// The orElseGet() method provides the fallback mechanism in case Optional has null value 
		// by accepting the function to generate the default one.
		System.out.println("Full Name: " + fullName.orElseGet(() -> "[none]")); // Full Name: [none]
		
		// The map() method transforms the current Optional's value and returns the new Optional instance.
		// The orElse() method is similar to orElseGet() but instead of function it accepts the default value.
		System.out.println(fullName.map(name -> "Hey " + name + "!").orElse("Hey Stranger!")); // Hey Stranger!
		

		// ### Example 2
		Optional<String> firstName = Optional.of("Tom");
		
		System.out.println("First Name is set? " + firstName.isPresent()); // First Name is set? true
		
		System.out.println("First Name: " + firstName.orElseGet(() -> "[none]")); // First Name: Tom
		
		System.out.println(firstName.map(name -> "Hey " + name + "!").orElse("Hey Stranger!")); // Hey Tom!
	}
}