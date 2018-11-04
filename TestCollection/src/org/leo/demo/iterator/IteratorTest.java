package org.leo.demo.iterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class IteratorTest {

	public static void main(String[] args) {
		
		Set<String> books = new HashSet<String>();
		books.add("1844年经济学哲学手稿");
		books.add("德谟克利特的自然哲学和伊壁鸠鲁的自然哲学的差别");
		books.add("资本论");
		books.add("自然辩证法");
		books.add("1");
		books.removeIf(ele -> ele.length() < 3);
		
		Iterator<String> it = books.iterator();
		//使用Lambda表达式遍历集合(Iterator对象)
		//it.forEachRemaining(obj -> System.out.println("Iterator遍历对象:" + obj));
		
		while(it.hasNext()) {
			String book = it.next();
			System.out.println(book);
			if(book.equals("资本论")) {
				it.remove();
			}
			book = "通往奴役之路";//Iterator不能改变集合元素,赋值失败
		}
		
		System.out.println(books);

		
		//使用Lambda表达式遍历集合(集合对象)
		books.forEach(obj -> System.out.println("集合遍历对象:" + obj));
	}

}
