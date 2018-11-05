package org.leo.demo.set;

import java.util.TreeSet;

class M{
	int age;

	public M(int age) {
		super();
		this.age = age;
	}

	@Override
	public String toString() {
		return "M [age=" + age + "]";
	}
	
}

public class TestTreeSetComparator {

	public static void main(String[] args) {
		TreeSet<M> ts = new TreeSet<>((o1, o2) -> {
			M m1 = (M)o1;
			M m2 = (M)o2;
			//自定义排序:M对象的age属性越大,对比结果反而越小
			return m1.age > m2.age ? -1 : m1.age < m2.age ? 1 : 0;
		});
		ts.add(new M(5));
		ts.add(new M(-3));
		ts.add(new M(9));
		System.out.println(ts);
	}

}
