package org.leo.demo.threadpool;

public class InternalTask implements Runnable {
	
	private final RunnableQueue runnableQueue;
	
	private volatile boolean running = true;

	public InternalTask(RunnableQueue runnableQueue) {
		this.runnableQueue = runnableQueue;
	}

	@Override
	public void run() {
		// if current task match "both running and isInterrupt" are ture
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
	
	//stop current task
	public void stop() {
		this.running = false;
	}

}
