package org.leo.demo.queue;

import java.util.LinkedList;

public class TestLinkedList {

	public static void main(String[] args) {
		LinkedList<String> ll = new LinkedList<>();
		//入队
		ll.offer("AAA");
		//压栈
		ll.push("BBB");
		//双端的另一端入队
		ll.addFirst("NNN");
		ll.forEach(str -> System.out.println("遍历中:" + str));
		//获取队头
		System.out.println(ll.peekFirst());
		//获取队尾
		System.out.println(ll.peekLast());
		//弹栈
		System.out.println(ll.pop());
		System.out.println(ll);
		//双端的后端出列
		System.out.println(ll.pollLast());
		System.out.println(ll);
	}
}
