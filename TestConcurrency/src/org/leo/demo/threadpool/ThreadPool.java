package org.leo.demo.threadpool;

public interface ThreadPool {
	
	//submit tasks to thread pool
	void execute(Runnable runnable);
	//close pool
	void shutdown();
	//get the initial size of pool
	int getInitSize();
	//get the max size of pool
	int getMaxSize();
	//get the core size of pool
	int getCoreSize();
	//get the cache tasks queue of pool
	int getQueueSize();
	//get the active thread volume of pool
	int getActiveCount();
	//check if pool has been shutdown
	boolean isShutdown();

}
