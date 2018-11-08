package org.leo.demo.threadcom;

import java.util.concurrent.TimeUnit;

/*
 * producer/client pattern
 */
public class EventClient {
	
	public static void main(String[] args) {
		//定义不可变队列实例
		final EventQueue eventQueue = new EventQueue();
		//新建生产者线程, 可以设置多个
		new Thread(()->{
			while(true) {
				eventQueue.offer(new EventQueue.Event());
			}
		}, "producer").start();
		//新建消费者线程, 可以设置多个
		new Thread(()->{
			while(true) {
				eventQueue.take();
				try {
					TimeUnit.MILLISECONDS.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "consumer").start();
	}
}
