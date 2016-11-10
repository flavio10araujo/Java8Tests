package com.tests.java8.T10Base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class AMain {

	public static void main(String[] args) {
		
		final String text = "Base64 finally in Java 8!";
		final String encoded = Base64
				.getEncoder()
				.encodeToString(text.getBytes(StandardCharsets.UTF_8));
		
		System.out.println(encoded); // QmFzZTY0IGZpbmFsbHkgaW4gSmF2YSA4IQ==
		
		final String decoded = new String(Base64.getDecoder().decode(encoded), StandardCharsets.UTF_8);
		
		System.out.println(decoded); // Base64 finally in Java 8!
	}
}