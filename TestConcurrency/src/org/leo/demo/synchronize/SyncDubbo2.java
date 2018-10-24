package org.leo.demo.synchronize;

import java.util.concurrent.CountDownLatch;

/**
 * 在父子类继承关系中, 都通过synchronized修饰方法可以实现线程安全
 * @author leoliu
 *
 */
public class SyncDubbo2 {
	
	final CountDownLatch countDownLatch = new CountDownLatch(1);
	
	static class Main{
		public int i = 10;
		public synchronized void operationSup() {
			try {
				i--;
				System.out.println("Main print i = " + i);
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	static class Sub extends Main{
		@Override
		public synchronized void operationSup() {
			try {
				while(i>0) {
					i--;
					System.out.println("Sub print i = " + i);
					Thread.sleep(100);
					super.operationSup();
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Sub sub = new Sub();
				sub.operationSup();
			}
		}).start();

	}

}
