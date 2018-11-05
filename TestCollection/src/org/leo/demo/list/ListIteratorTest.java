package org.leo.demo.list;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
/*
 * 与Collection集合的Iterator接口不同, List额外提供一个ListIterator接口(继承了Iterator接口), 增加了如下三个方法:
 * 1. hasPrevious():是否还有上一个元素
 * 2. previous():返回上一个元素
 * 3. add():增加一个元素
 */
public class ListIteratorTest {

	public static void main(String[] args) {
		
		String[] books = {
				"资本论","德意志意识形态","共产党宣言"
		};
		List<String> booksList = new ArrayList<>();
		for(int i=0; i<books.length;i++) {
			booksList.add(books[i]);
		}
		ListIterator<String> lit = booksList.listIterator();
		System.out.println("====下面开始正向迭代====");
		while(lit.hasNext()) {
			System.out.println(lit.next());
			lit.add("----分隔符----");
		}
		System.out.println("====下面开始反向迭代====");
		while(lit.hasPrevious()) {
			System.out.println(lit.previous());
		}
		
		List<Object> bookList = new ArrayList<>();
		bookList.add(null);
		bookList.add(new ListIteratorTest());
		bookList.forEach(obj -> System.out.println(obj));
	}

}
