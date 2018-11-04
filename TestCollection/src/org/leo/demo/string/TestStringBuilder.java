package org.leo.demo.string;

public class TestStringBuilder {

	public static void main(String[] args) {

		StringBuilder sb = new StringBuilder();
		System.out.println(sb.hashCode());
		//增(追加)
		sb.append("Java");
		//增(插入)
		sb.insert(0, "Hello ");
		//改
		sb.replace(5, 6, ",");
		//删
		sb.delete(5, 6);
		System.out.println(sb);
		//查
		char c = sb.charAt(5);
		System.out.println(c);
		//反转
		sb.reverse();
		System.out.println(sb);
		//长度及容量
		System.out.println("sb.length():" + sb.length());
		System.out.println("sb.capacity():" + sb.capacity());
		//取子串
		String string = sb.substring(2, 6);
		System.out.println(string);
		//改变长度,将保留前n的StringBuilder对象
		sb.setLength(4);
		System.out.println(sb);
		System.out.println(sb.hashCode());
	}

}
