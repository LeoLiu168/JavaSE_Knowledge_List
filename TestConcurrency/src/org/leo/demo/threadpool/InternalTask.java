package org.leo.demo.threadpool;

public class InternalTask implements Runnable {
	//组合一个RunnableQueue的引用
	private final RunnableQueue runnableQueue;
	//使用volatile关键字修饰开关变量
	private volatile boolean running = true;
	
	public InternalTask(RunnableQueue runnableQueue) {
		this.runnableQueue = runnableQueue;
	}
	@Override
	public void run() {
		// if current task match "both running and isInterrupt" are true
		// continue to take runnable from queue and run
		while(running && !Thread.currentThread().isInterrupted()) {
			try {
				Runnable task = runnableQueue.take();
				task.run();
			} catch (Exception e) {
				running = false;
				break;
			}
		}

	}
	//停止线程的开关方法
	public void stop() {
		this.running = false;
	}
}
