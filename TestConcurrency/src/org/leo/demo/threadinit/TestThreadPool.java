package org.leo.demo.threadinit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {

	public static void main(String[] args) {
		
		@SuppressWarnings("unused")
		ExecutorService threadPool = Executors.newFixedThreadPool(10);
		
		ExecutorService threadPool2 = Executors.newCachedThreadPool();
		
		
		for (int i = 0; i < 1000; i++) {
			threadPool2.execute(new Runnable() {

				@Override
				public void run() {
					System.out.println(Thread.currentThread().getName());
				}
			});
		}
		
		threadPool2.shutdown();

	}

}
