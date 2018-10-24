package org.leo.demo.synchronize;

/**
 * 理解Java多线程中同步和异步的概念
 * @author leoliu
 *
 */
public class MyObject {
	
	public synchronized void method1() {
		try {
			System.out.println(Thread.currentThread().getName());
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * 情形1-method1使用synchronized修饰,method2没有:
	 * 对于t1和t2两个线程来说,在t1执行method1的方法期间,并不影响t2执行method2的方法
	 * 情形2-两个方法都加synchronized修饰
	 * 此时对象被Lock,t1在执行method1期间,t2也需要等待线程执行完毕,才能执行method2
	 */
	public synchronized void method2() {
		System.out.println(Thread.currentThread().getName());
	}

	public static void main(String[] args) {
		final MyObject mo = new MyObject();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				mo.method1();
			}
		},"t1").start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				mo.method2();
			}
		},"t2").start();
	}

}
