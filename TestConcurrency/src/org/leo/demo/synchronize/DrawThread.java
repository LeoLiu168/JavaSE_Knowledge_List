package org.leo.demo.synchronize;

import java.util.concurrent.TimeUnit;

public class DrawThread extends Thread {
	
	private Account account;
	private double drawAmount;
	public DrawThread(String name, Account account, double drawAmount) {
		super(name);
		this.account = account;
		this.drawAmount = drawAmount;
	}
	@Override
	public void run() {
		//使用account作为同步代码块的锁对象
		synchronized(account) {
			if (account.getBalance() >= drawAmount) {
				System.out.println(getName() + "取款成功, 取出:" + drawAmount);
				try {
					TimeUnit.MILLISECONDS.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				account.setBalance(account.getBalance() - drawAmount);
				System.out.println("余额为: " + account.getBalance());
			} else {
				System.out.println(getName() + "取款失败!余额不足!");
			}
		}
	}
}
