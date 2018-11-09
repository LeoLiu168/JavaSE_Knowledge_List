package org.leo.demo.threadpool;

import java.util.LinkedList;

public class LinkedRunnableQueue implements RunnableQueue {
	//设置队列上限
	private final int limit;
	//设置拒绝策略的引用
	private final DenyPolicy denyPolicy;
	//使用LinkedList作为队列的具体实现类
	private final LinkedList<Runnable> runnableList = new LinkedList<>();
	//设置线程池的引用
	private final ThreadPool threadPool;
	//构造方法时赋初始值
	public LinkedRunnableQueue(int limit, DenyPolicy denyPolicy, ThreadPool threadPool) {
		this.limit = limit;
		this.denyPolicy = denyPolicy;
		this.threadPool = threadPool;
	}

	@Override
	public void offer(Runnable runnable) {
		//使用同步锁, 确保入队的线程安全
		synchronized (runnableList) {
			//当达到队列上限, 调用拒绝策略;否则加入队尾, 并唤醒阻塞中的线程.
			if(runnableList.size() >= limit) {
				denyPolicy.reject(runnable, threadPool);
			}else {
				runnableList.addLast(runnable);
				runnableList.notifyAll();
			}
		}
	}

	@Override
	public Runnable take() throws InterruptedException {
		synchronized (runnableList) {
			
			while(runnableList.isEmpty()) {
				try {
					//如果队列中没有可执行任务, 线程挂起, 进入runnableList关联的monitor waitset中等待被唤醒
					runnableList.wait();
				} catch (InterruptedException e) {
					//如果被中断, 需要抛出异常
					throw e;
				}
			}
			return runnableList.removeFirst();
		}
	}

	@Override
	public int size() {
		synchronized (runnableList) {
			//返回队列中的任务数量
			return runnableList.size();
		}
	}
}
