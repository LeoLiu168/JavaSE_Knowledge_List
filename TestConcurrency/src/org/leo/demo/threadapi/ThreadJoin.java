package org.leo.demo.threadapi;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreadJoin {
	
	private static void shortSleep() {
		try {
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static Thread create(int seq) {
		return new Thread(() -> {
			for (int i = 0; i < 10; i++) {
				System.out.println(Thread.currentThread().getName() + "#" + i);
				shortSleep();
			}
		}, String.valueOf(seq));
	}

	public static void main(String[] args) throws InterruptedException {
		
		List<Thread> threads = IntStream.range(1, 3).mapToObj(ThreadJoin::create).collect(Collectors.toList());
		
		threads.forEach(Thread::start);
		//在main线程中, 依次调用thread的join方法, main会进入阻塞, 等其它线程完成了再行继续
		for(Thread thread : threads) {
			thread.join();
		}
		
		for(int i = 0; i < 10; i++) {
			System.out.println(Thread.currentThread().getName() + "#" + i);
			shortSleep();
		}

	}

}
