package org.leo.demo.threadapi;

import java.util.concurrent.TimeUnit;

/*
 * 通过volatile修饰符, 设置开关来控制线程关闭
 */
public class FlagThreadExit {
	
	static class MyTask extends Thread{
		//使用volatile修饰一个boolean开关变量
		private volatile boolean closed = false;
		public void run() {
			System.out.println("I will start to work");
			//通过开变量和中断标识, 以便控制while循环实现控制线程关闭的目的
			while(!closed && !interrupted()) {
				//working
			}
			System.out.println("I will exit");
		}
		//定义用于关闭的close方法, 设置开关变量和调用中断方法
		public void close() {
			closed = true;
			interrupt();
		}
	}

	public static void main(String[] args) throws InterruptedException {
		MyTask t = new MyTask();
		t.start();
		TimeUnit.SECONDS.sleep(2);
		System.out.println("use close method");
		t.close();
	}
}
