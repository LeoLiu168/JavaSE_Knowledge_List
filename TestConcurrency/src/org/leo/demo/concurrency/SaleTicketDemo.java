package org.leo.demo.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Typical sample to introduce java multiple thread
 * @author leoliu
 * 多线程编写要点:
 * 1.线程
 * 2.实例方法
 * 3.资源类
 * ----高内聚 低耦合
 *
 */
public class SaleTicketDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Ticket ticket = new Ticket();
		//使用Lambda表达式进行重构
		new Thread(() -> {for (int i = 0; i<40;i++) ticket.sale();}, "AA").start();
		new Thread(() -> {for (int i = 0; i<40;i++) ticket.sale();}, "BB").start();
		new Thread(() -> {for (int i = 0; i<40;i++) ticket.sale();}, "CC").start();
		
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				for (int i = 0; i < 400; i++) {
//					ticket.sale();
//				}
//			}
//		}, "AA").start();
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				for (int i = 0; i < 400; i++) {
//					ticket.sale();
//				}
//			}
//		}, "BB").start();
//		new Thread(new Runnable() {
//	
//			@Override
//			public void run() {
//				for (int i = 0; i < 400; i++) {
//					ticket.sale();
//				}
//			}
//		}, "CC").start();
//
	}

}

class Ticket{
	
	private int ticket = 300;
	
	private Lock lock = new ReentrantLock();
	
	public void sale() {
		lock.lock();
		try {
			if (ticket > 0) {
				System.out.println(Thread.currentThread().getName()+"\t卖出第:" + (ticket--) + "\t还剩下:" + ticket);
			}
		} finally {
			lock.unlock();
		}
		
	}
}
