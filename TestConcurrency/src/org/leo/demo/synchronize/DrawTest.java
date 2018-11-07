package org.leo.demo.synchronize;

public class DrawTest {

	public static void main(String[] args) {
		//创建同一个账户
		final Account acct = new Account("1234567", 1000);
		new DrawThread("甲", acct, 800).start();
		new DrawThread("乙", acct, 800).start();
	}

}
