package org.leo.demo.threadsafe;

public class Sequence {
	
	private int value;
	
	public synchronized int getNext() {
		return value++;
	}

	public static void main(String[] args) {
		
		Sequence s = new Sequence();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("t1 start");
				s.getNext();
			}
		}, "t1").start();
		
		new Thread(new Runnable() {
					
					@Override
					public void run() {
						System.out.println("t2 start");
						s.getNext();
					}
				}, "t2").start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("t3 start");
				s.getNext();
			}
		}, "t3").start();
		
		System.out.println(s.value);

	}

}
