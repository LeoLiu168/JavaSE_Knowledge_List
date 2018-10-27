package org.leo.demo.threadapi;

import java.util.concurrent.TimeUnit;

public class ThreadClose extends Thread{
	
	private volatile boolean closed = false;
	
	@Override
	public void run() {
		System.out.println("Thread will start to work");
		while(!closed && !isInterrupted()) {
			System.out.println("Thread is running");
		}
		System.out.println("Thread will be exited");
	}
	
	public void close() {
		this.closed = true;
		this.interrupt();
	}

	public static void main(String[] args) throws InterruptedException {
		
		ThreadClose tc = new ThreadClose();
		tc.start();
		TimeUnit.MILLISECONDS.sleep(10);
		System.out.println("System will be shutdown");
		tc.close();
		

	}

}
