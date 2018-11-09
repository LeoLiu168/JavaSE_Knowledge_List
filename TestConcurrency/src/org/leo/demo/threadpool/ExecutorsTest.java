package org.leo.demo.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {

	public static void main(String[] args) {
		//通过工厂方法Executors创建一个6个线程容量的固定线程池
		ExecutorService pool = Executors.newFixedThreadPool(6);
		//使用Lambda表达式创建Runnable对象
		Runnable target = () -> {
			for (int i = 0; i < 100; i++) {
				System.out.println(Thread.currentThread().getName() + "的i值为: " + i);
			}
		};
		//提交两个任务
		pool.submit(target);
		pool.submit(target);
		//关闭线程池
		pool.shutdown();
	}

}
