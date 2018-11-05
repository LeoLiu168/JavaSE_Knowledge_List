package org.leo.demo.queue;

import java.util.ArrayDeque;

public class ArrayDequeStack {

	public static void main(String[] args) {
		ArrayDeque<String> stack = new ArrayDeque<>();
		//压栈,此时AAA在最下,CCC在最外
		stack.push("AAA");
		stack.push("BBB");
		stack.push("CCC");
		System.out.println(stack);
		//获取最后添加的元素,但不删除
		System.out.println(stack.peek());
		System.out.println(stack);
		//弹出最后添加的元素
		System.out.println(stack.pop());
		System.out.println(stack);
	}

}
