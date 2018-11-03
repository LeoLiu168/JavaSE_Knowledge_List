package org.leo.demo.arrays;

import java.util.Arrays;

public class TestArrays {

	public static void main(String[] args) {
		
		int[] a = new int[] {3,4,5,6};
		int[] a2 = {3,4,5,6};
		
		System.out.println("a equals a2? " + Arrays.equals(a, a2));
		
		int[] b = Arrays.copyOf(a, 6);
		System.out.println("a equals b? " + Arrays.equals(a, b));
		System.out.println("b array is: " + Arrays.toString(b));
		
		Arrays.fill(b, 2, 4, 1);
		System.out.println("b array is: " + Arrays.toString(b));
		
		Arrays.sort(b);
		System.out.println("b array is: " + Arrays.toString(b));
		
		System.out.println("the index of number 1 in b is:" + Arrays.binarySearch(b, 1));

	}

}
