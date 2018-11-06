package org.leo.demo.map;

import java.util.IdentityHashMap;

public class TestIdentityHashMap {

	public static void main(String[] args) {
		IdentityHashMap<String, Integer> ihm = new IdentityHashMap<>();
		//两个new String对象,会被认为是不同的Key,一起添加到集合中
		ihm.put(new String("Python"), 100);
		ihm.put(new String("Python"), 98);
		//字符串直接量Java的内存地址相同,会被认为是同一个对象, 因此只会添加一个(覆盖前值)
		ihm.put("Java", 100);
		ihm.put("Java", 11);
		System.out.println(ihm);
	}
}
