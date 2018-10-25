package org.leo.demo.threadinit;
/**
 * 实现Runnable接口的类,是作为线程任务存在,而不是线程类
 * @author leoliu
 *
 */
public class TestRunnable implements Runnable{

	@Override
	public void run() {
		while(true) {
			System.out.println("thread running...");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Thread t = new Thread(new TestRunnable());
		t.start();
		
		new Thread() {
			@Override
			public void run() {
				System.out.println("Thread的匿名内部类");
			}
		}.start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("父类的线程");
			}
		}) {
			@Override
			public void run() {
				System.out.println("子类的线程");
			}
		}.start();
		
	}

}
