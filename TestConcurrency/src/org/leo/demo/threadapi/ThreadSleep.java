package org.leo.demo.threadapi;

import java.util.concurrent.TimeUnit;

public class ThreadSleep {
	
	private static void sleep(int ms) {
		try {
			TimeUnit.SECONDS.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {

		new Thread(() -> 
		{
			long startTime = System.currentTimeMillis();
			sleep(2);
			long endTime = System.currentTimeMillis();
			System.out.println(String.format("Total spend %d second", (endTime - startTime)));
		}).start();
		
		/*
		 * Thread sleep times depends on your system
		 */
		long startTime = System.currentTimeMillis();
		sleep(3);
		long endTime = System.currentTimeMillis();
		System.out.println(String.format("Main thread total spend %d second", (endTime - startTime)));
		
	}
}
