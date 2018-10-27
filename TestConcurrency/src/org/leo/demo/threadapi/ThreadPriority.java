package org.leo.demo.threadapi;

public class ThreadPriority {

	public static void main(String[] args) {
		Thread t1 = new Thread(()->
		{
			while(true) {
				System.out.println("t11111");
			}
		}, "t1");
		t1.setPriority(3);
		
		Thread t2 = new Thread(()->{
			while (true) {
				System.out.println("t22222");
			}
		});
		t2.setPriority(10);

		t1.start();
		t2.start();
	}

}
