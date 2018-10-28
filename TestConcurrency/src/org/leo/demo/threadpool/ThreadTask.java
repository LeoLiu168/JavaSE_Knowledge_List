package org.leo.demo.threadpool;

public class ThreadTask {
	
	public final Thread thread;
	
	public final InternalTask internalTask;

	public ThreadTask(Thread thread, InternalTask internalTask) {
		this.thread = thread;
		this.internalTask = internalTask;
	}
	
	

}
