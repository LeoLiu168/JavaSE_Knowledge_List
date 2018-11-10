package org.leo.demo.reflection;

import java.lang.reflect.Array;

public class ArrayTest {

	public static void main(String[] args) {
		Object arr = Array.newInstance(String.class, 10);
		Array.set(arr, 5, "Hello");
		Array.set(arr, 6, "world");
		Object str1 = Array.get(arr, 5);
		Object str2 = Array.get(arr, 6);
		System.out.println(str1);
		System.out.println(str2);
	}

}
