package com.tests.java8.T02Interfaces;

@FunctionalInterface
public interface ComAnnotationFunctionalInterface {

	void unicoMetodo();
	
	// Se esse segundo método for descomentado, ocorre um erro.
	// Isso ocorre porque ao utilizar @FunctionalInterface a interface deve possuir um único método.
	// void outroMetodo();
}