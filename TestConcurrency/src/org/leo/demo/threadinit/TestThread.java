package org.leo.demo.threadinit;

public class TestThread extends Thread{
	
	public TestThread(String name) {
		setName(name);
	}
	
	@Override
	public void run() {
		while(!interrupted())
			System.out.println(getName() + "线程执行了");
	}
	
	public static void main(String[] args) {
		
		TestThread t1 = new TestThread("first");
		TestThread t2 = new TestThread("second");
		
//		t1.setDaemon(true);
//		t2.setDaemon(true);
		
		t1.start();
		t2.start();
		
		t1.interrupt();
	}

}
