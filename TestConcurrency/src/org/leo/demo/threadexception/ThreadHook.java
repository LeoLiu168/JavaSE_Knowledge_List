package org.leo.demo.threadexception;

import java.util.concurrent.TimeUnit;

public class ThreadHook {

	public static void main(String[] args) {
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				try {
					System.out.println("The hook thread 1 is running.");
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("The hook thread 1 will exit");
			}
		});
		Runtime.getRuntime().addShutdownHook(new Thread(){
			@Override
			public void run() {
				try {
					System.out.println("The hook thread 2 is running.");
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("The hook thread 2 will exit");
			}
		});
		System.out.println("the program will be stopped");
	}

}
