package com.tests.java8.T11ParallelArrays;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This small code snippet uses method parallelSetAll() to fill up arrays with 20000 random values. 
 * After that, the parallelSort() is being applied.
 * The program outputs first 10 elements before and after sorting so to ensure the array is really ordered.
 * The sample program output may look like that (please notice that array elements are randomly generated):
 * 791114 629529 289562 346932 945466 85681 384882 77529 14983 655919 
 * 47 115 211 274 277 303 429 468 471 525 
 */
public class AMain {

	public static void main( String[] args ) {
		
		long[] arrayOfLong = new long [20000];
		
		Arrays.parallelSetAll(arrayOfLong, index -> ThreadLocalRandom.current().nextInt(1000000));
		
		Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
		
		System.out.println();
		
		Arrays.parallelSort(arrayOfLong);
		
		Arrays.stream(arrayOfLong).limit(10).forEach(i -> System.out.print(i + " "));
		
		System.out.println();
	}
}