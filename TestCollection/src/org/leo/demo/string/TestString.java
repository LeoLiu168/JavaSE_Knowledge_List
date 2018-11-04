package org.leo.demo.string;

import java.io.UnsupportedEncodingException;

public class TestString {

	public static void main(String[] args) throws UnsupportedEncodingException {
		//字符串初始化
		String s1 = "Hello World!";
		System.out.println(s1);
		//通过byte[]和码表来构造字符串
		byte[] b = {21, 97, 12, 100};
		String s3 = new String(b, "utf-8");//有UnsupportedEncodingException异常抛出
		System.out.println(s3);

		//返回字符串长度
		String s2 = new String("aeiou");
		System.out.println(s2.replace('a', '$'));
		System.out.println("s2.length()" + s2.length());
		//通过索引查找字符
		System.out.println("s2.charAt(2):" + s2.charAt(2));
		//查找索引
		System.out.println("s2.indexOf('o')" + s2.indexOf('o'));
		System.out.println("s2.indexOf(\"io\")" + s2.indexOf("io"));
		//查找前缀/后缀
		System.out.println("s2.endsWith(\"ih\")"+s2.endsWith("ih"));
		System.out.println("s2.startsWith(\"ae\")" + s2.startsWith("ae"));
		//字符串的比较
		String s21 = new String("aeiouwww");
		String s22 = new String("aewou");
		System.out.println("s2.compareTo(s21):"+s2.compareTo(s21));
		System.out.println("s2.compareTo(s22):"+s2.compareTo(s22));
		StringBuffer sb1 = new StringBuffer("aeiousss");
		System.out.println("s2.contentEquals(sb1):"+s2.contentEquals(sb1));
		System.out.println("s2.equals(s22)"+s2.equals(s22));
		//连接
		System.out.println(s1.concat(s2));//相当于"+"
		char[] c = new char[] {'a','e','i','h','h','j'};
		String s4 = String.copyValueOf(c, 1, 3);
		System.out.println(s4);
		//数组化
		byte[] b1 = s4.getBytes();
		System.out.println(b1.toString());
		s4.getChars(1, 2, c, 2);
		System.out.println(c.toString());
		System.out.println(s4.toCharArray());
		
		for(byte cc:b1) {
			System.out.print(cc + " ");
		}
	}

}
