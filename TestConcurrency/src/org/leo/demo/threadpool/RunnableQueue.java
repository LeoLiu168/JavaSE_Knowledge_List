package org.leo.demo.threadpool;
/**
 * A blocking queue for submited tasks
 * @author leoliu
 *
 */
public interface RunnableQueue {
	//提交任务到队列
	void offer(Runnable runnable);
	//从队列中获取任务
	Runnable take() throws InterruptedException;
	//返回队列中任务数
	int size();
}
