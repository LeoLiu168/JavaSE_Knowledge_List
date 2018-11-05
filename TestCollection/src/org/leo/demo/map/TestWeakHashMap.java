package org.leo.demo.map;

import java.util.WeakHashMap;

public class TestWeakHashMap {

	public static void main(String[] args) {
		WeakHashMap<String, String> whm = new WeakHashMap<>();
		//添加的三个Key对象都是弱引用的匿名类对象
		whm.put(new String("Python"), new String("pass"));
		whm.put(new String("R"), new String("good"));
		whm.put(new String("Scala"), new String("great"));
		//添加一个系统缓存的字符串直接量, 为强引用对象,作为Key
		whm.put("Java", new String("Number One"));
		System.out.println(whm);
		//通知系统进行垃圾回收
		System.gc();
		System.runFinalization();
		//此时whm仅保留一个强引用的Java键值对
		System.out.println(whm);
	}
}
