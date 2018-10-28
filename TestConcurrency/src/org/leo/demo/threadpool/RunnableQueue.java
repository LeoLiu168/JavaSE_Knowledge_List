package org.leo.demo.threadpool;
/**
 * A cache queue for submited tasks
 * @author leoliu
 *
 */
public interface RunnableQueue {
	
	void offer(Runnable runnable);
	
	Runnable take() throws InterruptedException;
	
	int size();

}
