package org.leo.demo.synchronize;

import java.util.concurrent.TimeUnit;

public class SyncAccount {
	private String accountNo;
	private double balance;
	public SyncAccount() {
		
	}
	public SyncAccount(String accountNo, double balance) {
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
	//在一个简单的账户取款例子中, 通过添加synchronized的draw方法, 把Account类变为一个线程安全类
	public synchronized void draw(double drawAmount) {
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
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNo == null) ? 0 : accountNo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SyncAccount other = (SyncAccount) obj;
		if (accountNo == null) {
			if (other.accountNo != null)
				return false;
		} else if (!accountNo.equals(other.accountNo))
			return false;
		return true;
	}
}
