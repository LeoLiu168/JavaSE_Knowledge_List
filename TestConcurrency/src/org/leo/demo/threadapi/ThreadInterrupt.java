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
						 * 程序运行结果为:
						 * I am be interrupted? false
						 * I am be interrupted? true
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
		//确保thread线程启动完毕
		TimeUnit.SECONDS.sleep(2);
		System.out.printf("I am be interrupted? %s\n", thread.isInterrupted());
		//在main线程中, 调用线程对象thread的interrupt()方法, 中断thread线程的sleep阻塞状态.
		thread.interrupt();
		//确保thread线程进入Runnable并被线程调度器调动
		TimeUnit.SECONDS.sleep(2);
		System.out.printf("I am be interrupted? %s\n", thread.isInterrupted());
	}
}
