package org.leo.demo.set;

import java.util.EnumSet;

enum Season{
	SPRING, SUMMER, FALL, WINTER
}

public class TestEnumSet {

	public static void main(String[] args) {
		//创建一个指定枚举类Season的枚举集合
		EnumSet<Season> es1 = EnumSet.allOf(Season.class);
		System.out.println(es1);
		//创建一个指定枚举类Season的空集合
		EnumSet<Season> es2 = EnumSet.noneOf(Season.class);
		System.out.println(es2);
		//手动添加枚举值
		es2.add(Season.WINTER);
		es2.add(Season.SUMMER);
		System.out.println(es2);
		//创建一个指定枚举值的枚举集合
		EnumSet<Season> es3 = EnumSet.of(Season.SPRING, Season.FALL);
		System.out.println(es3);
		//创建一个指定枚举值及顺序的枚举集合
		EnumSet<Season> es4 = EnumSet.range(Season.SUMMER, Season.WINTER);
		System.out.println(es4);
		//创建一个es4集合的其余集合es5, 其中es4+es5=es1
		EnumSet<Season> es5 = EnumSet.complementOf(es4);
		System.out.println(es5);		
	}

}
