package org.leo.demo.threadinit;

import java.util.Arrays;
import java.util.List;

public class TestLambdaThread {
	
	public int add(List<Integer> values) {
		return values.parallelStream().mapToInt(a -> a).sum();
		
	}
	
	public int add2(List<Integer> values) {
		values.parallelStream().forEach(System.out :: println);
		return values.parallelStream().mapToInt(a -> a * a).sum();
		
	}
	
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(10,20,30,40);
		int res = new TestLambdaThread().add2(list);
		System.out.println("The result is:" + res);
	}

}
