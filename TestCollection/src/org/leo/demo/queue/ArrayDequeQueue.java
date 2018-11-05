package org.leo.demo.queue;

import java.util.ArrayDeque;

public class ArrayDequeQueue {

	public static void main(String[] args) {
		ArrayDeque<String> queue = new ArrayDeque<>();
		//入队
		queue.offer("AAA");
		queue.offer("BBB");
		queue.offer("CCC");
		System.out.println(queue);
		//获取但不出队
		System.out.println(queue.peek());
		System.out.println(queue);
		//出队
		System.out.println(queue.poll());
		System.out.println(queue);
	}

}
