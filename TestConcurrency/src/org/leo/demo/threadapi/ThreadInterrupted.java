package org.leo.demo.threadapi;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupted {

	public static void main(String[] args) throws InterruptedException {
		
		Thread thread = new Thread(() -> {
			while (true) {
				if(Thread.interrupted()) {
					System.out.println("Yes my interrupt flag has been removed!");
				}else {
					System.out.println("I am running");
				}
			}
		});
		
		thread.setDaemon(true);
		thread.start();
		
		//Main sleep to make sure thread start
		TimeUnit.MILLISECONDS.sleep(2);
		thread.interrupt();
		//以下显示false
		System.out.println("Main thread is interrupted? " + Thread.interrupted());
		
		Thread.currentThread().interrupt();
		//以下显示true
		System.out.println("Main thread is interrupted? " + Thread.currentThread().isInterrupted());
		
		try {
			TimeUnit.MINUTES.sleep(2);
		} catch (Exception e) {
			System.out.println("I am be interrupted!!!!!!");
		}
	}
}
