package org.leo.demo.threadcom;

import java.util.List;
import java.util.concurrent.TimeoutException;

public interface Lock {
	//An interruptible synchronized method 
	void lock() throws InterruptedException;
	
	//An overloaded lock method, add timeout function
	void lock(long mills) throws InterruptedException, TimeoutException;
	//able to release lock
	void unlock();
	//A list for threads which are under blocked
	List<Thread> getBlockedThreads();

}
