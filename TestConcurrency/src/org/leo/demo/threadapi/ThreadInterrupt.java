package org.leo.demo.threadapi;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupt {

	public static void main(String[] args) throws InterruptedException {
		Thread thread = new Thread() {
			public void run() {
				while(true) {
					try {
						/*
						 * sleep为可中断方法, 因此会擦除interrupt标志;
						 * 如果注释掉sleep方法, thread收到中断信号后,interrupt标志不会被移除
						 */
						TimeUnit.MINUTES.sleep(2);
					} catch (InterruptedException e) {
						System.out.printf("I am be interrupted? %s\n", isInterrupted());
					}
				}
			}
		};
		thread.setDaemon(true);
		thread.start();
		TimeUnit.SECONDS.sleep(2);
		System.out.printf("I am be interrupted? %s\n", thread.isInterrupted());
		thread.interrupt();
		TimeUnit.SECONDS.sleep(2);
		System.out.printf("I am be interrupted? %s\n", thread.isInterrupted());

	}

}
