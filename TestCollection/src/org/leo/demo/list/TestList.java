package org.leo.demo.list;

import java.util.ArrayList;
import java.util.List;

public class TestList {

	@SuppressWarnings("unlikely-arg-type")
	public static void main(String[] args) {
		
		List<String> books = new ArrayList<>();
		//List集合添加元素的顺序是有序的
		books.add(new String("资本论"));
		books.add(new String("共产党宣言"));
		books.add(new String("家庭私有制和国家的起源"));
		System.out.println(books);
		//add和addAll分别在指定索引处添加元素或另一个集合
		books.add(1, "德意志意识形态");
		books.forEach(str -> System.out.println(str));
		//使用Lambda表达式对List进行排序
		books.sort((o1, o2) -> (o1.length() - o2.length()));
		System.out.println(books);
		//删除指定索引的元素
		books.remove(2);
		System.out.println(books);
		//通过指定索引返回元素(==根据HashCode来判断,此处返回false)
		System.out.println(books.get(0) ==new String("资本论"));
		//通过indexOf来返回指定元素所在的索引位置
		//indexOf通过元素的equals方法来判断, 只要是true就返回对应的索引
		System.out.println(books.indexOf(new String("德意志意识形态")));
		//通过索引改变元素
		books.set(1, new String("神圣家族"));
		//返回子集合[1,3), 不改变原集合
		System.out.println(books.subList(1, 3));
		
		//使用Lambda表达式使用每个字符的长度替代原集合的元素
		books.replaceAll(ele -> ele.length() + "");
		//因为A对象equals方法恒返回true,所以集合会在第一次比较中直接删除第一个元素
		books.remove(new A());
		System.out.println(books);
		//同样的,继续删除第一个元素
		books.remove(new A());
		System.out.println(books.size());
		
	}

}

class A{
	//定义A类对象的equals方法恒返回true
	public boolean equals(Object obj) {
		return true;
	}
}
