package org.leo.demo.map;

import java.util.HashMap;
import java.util.Map;

public class TestMapAdvance {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		//添加键值对,value可重复
		map.put("AAA", 110);
		map.put("BBB", 120);
		map.put("CCC", 20);
		map.put("DDD", 120);
		//因为map中无ZZZ,因此替换失败
		map.replace("ZZZ", 122);
		System.out.println(map);
		//使用原value与参入参数重新计算value
		map.merge("CCC", 20, (oldVal, param) -> (oldVal+param)*2);
		System.out.println(map);
		//当key为Java,对应的value不存在或null, 计算结果为新value
		map.computeIfAbsent("Java", (key) -> key.length());
		System.out.println(map);
		//当key为Java存在, 则用新结果替换
		map.computeIfPresent("Java", (key, value) -> value * 100);
		System.out.println(map);
	}
}
