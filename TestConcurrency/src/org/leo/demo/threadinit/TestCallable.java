package org.leo.demo.threadinit;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable implements Callable<Integer>{

	@Override
	public Integer call() throws Exception {
		System.out.println("Thread is running...");
		Thread.sleep(3000);
		return 1;
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		TestCallable tc = new TestCallable();
		FutureTask<Integer> task = new FutureTask<>(tc);
		
		new Thread(task).start();
		
		System.out.println("do something else...");
		
		Integer integer = task.get();
		
		System.out.println("The thread running result is :" + integer);
		
	}

}
