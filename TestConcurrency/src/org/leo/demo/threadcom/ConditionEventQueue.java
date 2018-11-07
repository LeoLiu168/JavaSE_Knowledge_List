package org.leo.demo.threadcom;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/*
 * 使用Lock接口和Condition来实现生产者-消费者队列的通信
 */
public class ConditionEventQueue {
	//显示定义Lock对象
	private final Lock lock = new ReentrantLock();
	//通过newCondition方法获取指定Lock对象的Condition实例
	private final Condition cond = lock.newCondition();
	private final int max;
	static class Event{
		
	}
	//定义一个不可改的链表集合, 作为队列载体
	private final LinkedList<Event> eventQueue = new LinkedList<>();
	
	private final static int DEFAULT_MAX_EVENT = 10;
	
	public ConditionEventQueue(int max) {
		this.max = max;
	}
	
	public ConditionEventQueue() {
		this(DEFAULT_MAX_EVENT);
	}
	
	private void console(String message) {
		System.out.printf("%s:%s\n",Thread.currentThread().getName(), message);
	}
	//定义入队方法
	public void offer(Event event) {
			lock.lock();
			try {
				//在循环中判断如果队列已满, 则调用cond的wait方法, 使线程阻塞
				while (eventQueue.size() >= max) {
					try {
						console(" the queue is full");
						cond.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				console(" the new event is submitted");
				eventQueue.addLast(event);
				cond.signalAll();;
			} finally {
				lock.unlock();
			}
		
	}
	//定义出队方法
	public Event take() {
			lock.lock();
			try {
				//在循环中判断如果队列已空, 则调用cond的wait方法, 使线程阻塞
				while (eventQueue.isEmpty()) {
					try {
						console(" the queue is empty.");
						cond.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				Event event = eventQueue.removeFirst();
				cond.signalAll();
				console(" the event " + event + " is handled/taked.");
				return event;
			} finally {
				lock.unlock();
			}
	}
}
