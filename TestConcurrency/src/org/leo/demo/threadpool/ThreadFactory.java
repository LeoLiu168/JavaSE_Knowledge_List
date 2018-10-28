package org.leo.demo.threadpool;

@FunctionalInterface
public interface ThreadFactory {
	
	Thread createThread(Runnable runnable);

}
