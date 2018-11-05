package org.leo.demo.set;

import java.util.HashSet;
import java.util.Set;

/*
 * 测试HashSet的对象添加规则
 */
class A{
	//重写类A的equals方法,恒返回true
	public boolean equals(Object obj) {
		return true;
	}
}
class B{
	//重写类B的HashCode方法,恒返回1
	public int hashCode() {
		return 1;
	}
}
class C{
	//重写类C的HashCode方法,恒返回2
	public int hashCode() {
		return 2;
	}
	//重写类C的equals方法,恒返回true
	public boolean equals(Object obj) {
		return true;
	}
}
public class TestHashSet {

	public static void main(String[] args) {
		
		Set<Object> set = new HashSet<>();
		//equals相同,HashCode不相同:
		//两个对象添加到hash表的不同位置
		set.add(new A());
		set.add(new A());
		//HashCode相同, equals不同
		//此时Hash表会在该HashCode位置,使用链式结构保存这些对象,导致性能下降.
		set.add(new B());
		set.add(new B());
		//C类对象只被添加了一次.
		set.add(new C());
		set.add(new C());
		
		System.out.println(set);

	}

}
