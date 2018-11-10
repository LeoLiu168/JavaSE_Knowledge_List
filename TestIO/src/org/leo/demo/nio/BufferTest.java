package org.leo.demo.nio;

import java.nio.CharBuffer;

public class BufferTest {

	public static void main(String[] args) {
		//创建Buffer
		CharBuffer buffer = CharBuffer.allocate(8);
		System.out.println("capacity: " + buffer.capacity());
		System.out.println("limit: " + buffer.limit());
		System.out.println("position: " + buffer.position());
		//放入元素
		buffer.put('a');
		buffer.put('b');
		buffer.put('c');
		System.out.println("加入3个元素后, position= " + buffer.position());
		System.out.println("加入3个元素后, limit= " + buffer.limit());
		//调用flip方法
		buffer.flip();
		System.out.println("调用flip方法后, position= " + buffer.position());
		System.out.println("调用flip方法后, limit= " + buffer.limit());
		//取出第一个元素
		System.out.println("第一个元素(position=0): " + buffer.get());
		System.out.println("取出第一个元素后, position= " + buffer.position());
		System.out.println("取出第一个元素后, limit= " + buffer.limit());
		//调用clear方法
		buffer.clear();
		System.out.println("执行clear后, position= " + buffer.position());
		System.out.println("执行clear后, limit= " + buffer.limit());
		//clear后, 缓存区内容并没有删除, 仍然可以读第三个元素
		System.out.println("第三个元素为:" + buffer.get(2));
		System.out.println("执行绝对读取后, position= " + buffer.position());
		System.out.println("执行绝对读取后, limit= " + buffer.limit());
		buffer.put('z');
		buffer.put('w');
		System.out.println("加入2个元素后, position= " + buffer.position());
		System.out.println("加入2个元素后, limit= " + buffer.limit());
		System.out.println(buffer.get(0));
		System.out.println(buffer.get(1));
		System.out.println(buffer.get(2));
	}

}
