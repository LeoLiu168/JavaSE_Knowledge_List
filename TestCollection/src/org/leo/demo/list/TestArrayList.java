package org.leo.demo.list;

import java.util.Arrays;
import java.util.List;

public class TestArrayList {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("AA", "BB", "CC");
		//显示类的类型为java.util.Arrays$ArrayList
		System.out.println(list.getClass());
		
		list.forEach(System.out::println);
		//以下会抛出运行时异常java.lang.UnsupportedOperationException
		list.add("DD");

	}

}
