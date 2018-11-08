package org.leo.demo.threadapi;

import java.util.concurrent.TimeUnit;

public class InterruptThreadExit {

	public static void main(String[] args) throws InterruptedException {
		
		Thread t = new Thread() {
			@Override
			public void run() {
				System.out.println("I will start to work");
				//此处通过IsInterrupt或interrupted方法来判断中断状态, 以便控制while循环实现控制线程关闭的目的
				while(!interrupted()) {
					//System.out.println(isInterrupted());
				}
				System.out.println(isInterrupted());
				System.out.println("I will exit");
			}
		};
		t.start();
		TimeUnit.SECONDS.sleep(3);
		System.out.println("ready to send interrupt signal");
		t.interrupt();
	}
}
