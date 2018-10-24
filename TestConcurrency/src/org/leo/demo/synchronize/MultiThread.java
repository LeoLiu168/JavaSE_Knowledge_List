package org.leo.demo.synchronize;

public class MultiThread{
	
	private static int num = 0;
	/**
	 * synchronized所修饰方法的所在对象会成为对象锁(Lock);
	 * 所声明的对象之间, 锁是互不相干的. 因此对象实例之间会互不影响地产生行为.
	 * 如果需要形成"锁"的效果,可以把方法和变量声明为静态, 表示"锁住"类本身, 从而实现同步.
	 * 线程安全需要满足两个条件:
	 * 1. 原子性
	 * 2. 可见性
	 * 
	 * @param tag
	 */
	public static synchronized void printNum(String tag) {
		try {
			if ("a".equals(tag)) {
				num = 100;
				System.out.println("tag a, set number over!");
				Thread.sleep(1000);
			}else {
				num = 200;
				System.out.println("tag b, set num over!");
			}
			System.out.println("tag " + tag + ", num = " + num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
//		final MultiThread m1 = new MultiThread();
//		final MultiThread m2 = new MultiThread();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				printNum("a");
			}
		}).start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				printNum("b");
			}
		}).start();
		
	}
	

}
