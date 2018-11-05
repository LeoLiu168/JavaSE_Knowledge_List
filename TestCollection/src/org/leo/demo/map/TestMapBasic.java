package org.leo.demo.map;

import java.util.HashMap;
import java.util.Map;

public class TestMapBasic {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		//添加键值对,value可重复
		map.put("AAA", 110);
		map.put("BBB", 120);
		map.put("CCC", 20);
		map.put("DDD", 120);
		//添加重复key的时候,value会覆盖旧值,方法返回旧值
		System.out.println(map.put("CCC", 111));
		System.out.println(map);
		//通过key和value查找是否存在对应的键\值
		System.out.println("map.containsKey(\"BBB\")?: " + map.containsKey("BBB"));
		System.out.println("map.containsValue(110)?: " + map.containsValue(110));
		//遍历Map的增强for循环
		for(String key:map.keySet()) {
			System.out.println(key + "-->" + map.get(key));
		}
		//根据key删除value
		map.remove("AAA");
		System.out.println(map);
	}
}
