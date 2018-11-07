package org.leo.demo.synchronize;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class RLAccount {
	//定义锁对象
	private final ReentrantLock lock = new ReentrantLock();
	private String accountNo;
	private double balance;
	public RLAccount() {
		
	}
	public RLAccount(String accountNo, double balance) {
		this.accountNo = accountNo;
		this.balance = balance;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public double getBalance() {
		return balance;
	}
	public void draw(double drawAmount) {
		//加锁
		lock.lock();
		try {
			if (balance >= drawAmount) {
				System.out.println(Thread.currentThread().getName() + "取款成功, 取出:" + drawAmount);
				try {
					TimeUnit.MILLISECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				balance -= drawAmount;
				System.out.println("余额为: " + balance);
			} else {
				System.out.println(Thread.currentThread().getName() + "取款失败!余额不足!");
			} 
		} finally {
			//通过finally块保证释放锁
			lock.unlock();
		}
	}
}
