package org.leo.demo.threadcom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeoutException;

public class BooleanLock implements Lock {
	
	private Thread currentThread;
	
	private boolean locked = false;
	
	private final List<Thread> blockedList = new ArrayList<>();

	public void lock() throws InterruptedException {

		synchronized(this) {
			while(locked) {
				final Thread tempThread = Thread.currentThread();
				try {
					if(!blockedList.contains(tempThread)) {
						blockedList.add(tempThread);						
						this.wait();
					}
				} catch (InterruptedException e) {
					blockedList.remove(tempThread);
					throw e;
				}
			}
			blockedList.remove(Thread.currentThread());
			this.locked = true;
			this.currentThread = Thread.currentThread();
		}
	}

	public void lock(long mills) throws InterruptedException, TimeoutException {
		synchronized (this) {
			if(mills <= 0) {
				this.lock();
			}else {
				long remainingMills = mills;
				long endMills = System.currentTimeMillis() + remainingMills;
				while(locked) {
					final Thread tempThread = Thread.currentThread();
					if(remainingMills <= 0)
						throw new TimeoutException("can not get the lock during " + mills);
					try {
						if(!blockedList.contains(tempThread)) {
							blockedList.add(tempThread);						
						}
						this.wait(remainingMills);
					} catch (InterruptedException e) {
						blockedList.remove(tempThread);
						throw e;
					}
					remainingMills = endMills - System.currentTimeMillis();					
				}
				blockedList.remove(Thread.currentThread());
				this.locked = true;
				this.currentThread = Thread.currentThread();
			}
			
		}
	}

	public void unlock() {
		synchronized(this) {
			if(currentThread == Thread.currentThread()) {
				this.locked = false;
				Optional.of(Thread.currentThread().getName() + " release the lock.").ifPresent(System.out::println);
				this.notifyAll();
			}
		}
	}

	public List<Thread> getBlockedThreads() {
		return Collections.unmodifiableList(blockedList);
	}
	
	public void tryLock() {
		synchronized(this) {
			if(!locked) {
				locked = true;
				currentThread = Thread.currentThread();			
			}
		}
	}

}
