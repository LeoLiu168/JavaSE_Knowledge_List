package org.leo.demo.threadcom;

import java.util.concurrent.TimeUnit;

/*
 * producer/client pattern
 */
public class EventClient {
	
	public static void main(String[] args) {
		final EventQueue eventQueue = new EventQueue();
		
		new Thread(()->{
			while(true) {
				eventQueue.offer(new EventQueue.Event());
			}
		}, "producer").start();
		
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
