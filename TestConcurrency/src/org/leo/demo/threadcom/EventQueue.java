package org.leo.demo.threadcom;

import java.util.LinkedList;
/*
 * 通过一个生产者-消费者队列来说明线程通信的基本使用方法
 */
public class EventQueue {
	//定义一个队列元素数量, 一旦赋值则不可更改
	private final int max;
	//定义一个空的内部类, 代表存储元素
	static class Event{		}
	//定义一个不可改的链表集合, 作为队列载体
	private final LinkedList<Event> eventQueue = new LinkedList<>();
	//如果不指定初始容量, 则容量默认为10
	private final static int DEFAULT_MAX_EVENT = 10;
	//使用自定义容量初始化队列
	public EventQueue(int max) {
		this.max = max;
	}
	//如果不指定初始容量, 则容量默认为10
	public EventQueue() {
		this(DEFAULT_MAX_EVENT);
	}
	//封装一个输出到控制台的方法
	private void console(String message) {
		System.out.printf("%s:%s\n",Thread.currentThread().getName(), message);
	}
	//定义入队方法
	public void offer(Event event) {
		//使用链表对象作为锁, 通过synchronized代码块实现同步
		synchronized(eventQueue) {
			//在循环中判断如果队列已满, 则调用锁的wait方法, 使生产者线程阻塞
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
			//唤醒所有等待中的消费者;注意如果此处使用notify(),可能导致线程不安全
			this.eventQueue.notifyAll();
		}
	}
	//定义出队方法
	public Event take() {
		//使用链表对象作为锁
		synchronized(eventQueue) {
			//在循环中判断如果队列已空, 则调用锁的wait方法, 使消费者线程阻塞
			while(eventQueue.isEmpty()) {
				try {
					console(" the queue is empty.");
					eventQueue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Event event = eventQueue.removeFirst();
			//唤醒所有等待中的生产者;注意如果此处使用notify(),可能导致线程不安全
			this.eventQueue.notifyAll();
			console(" the event " + event + " is handled/taked.");
			return event;
		}
	}
}
