package org.leo.demo.threadcom;

import java.util.LinkedList;
/*
 * 通过一个生产者-消费者队列来说明线程通信的基本使用方法
 * 注意: 该队列仅适用于单线程进行入队和出队操作, 如果分别有多个线程操作入队\出队, 会导致线程不安全.
 */
public class EventQueue {
	
	private final int max;
	
	static class Event{
		
	}
	//定义一个不可改的链表集合, 作为队列载体
	private final LinkedList<Event> eventQueue = new LinkedList<>();
	
	private final static int DEFAULT_MAX_EVENT = 10;
	
	public EventQueue(int max) {
		this.max = max;
	}
	
	public EventQueue() {
		this(DEFAULT_MAX_EVENT);
	}
	
	private void console(String message) {
		System.out.printf("%s:%s\n",Thread.currentThread().getName(), message);
	}
	//定义入队方法
	public void offer(Event event) {
		//使用链表对象作为锁
		synchronized(eventQueue) {
			//在循环中判断如果队列已满, 则调用锁的wait方法, 使线程阻塞
			while(eventQueue.size() >= max) {
				try {
					console(" the queue is full");
					eventQueue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			console(" the new event is submitted");
			eventQueue.addLast(event);
			this.eventQueue.notifyAll();
		}
	}
	//定义出队方法
	public Event take() {
		//使用链表对象作为锁
		synchronized(eventQueue) {
			//在循环中判断如果队列已空, 则调用锁的wait方法, 使线程阻塞
			while(eventQueue.isEmpty()) {
				try {
					console(" the queue is empty.");
					eventQueue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Event event = eventQueue.removeFirst();
			this.eventQueue.notifyAll();
			console(" the event " + event + " is handled/taked.");
			return event;
		}
	}

}
