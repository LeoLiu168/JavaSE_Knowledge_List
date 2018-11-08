package org.leo.demo.threadexception;

import java.util.concurrent.TimeUnit;

public class CaptureThreadException {

	public static void main(String[] args) {
		//设置回调接口
		Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
			System.out.println(t.getName() + " occur exception");
			e.printStackTrace();
		});
		final Thread thread = new Thread(() -> {
			try {
				TimeUnit.SECONDS.sleep(2);
			} catch (InterruptedException e1) {
			}
			//此处会出现unchecked异常
			System.out.println(1 / 0);
		}, "Test-Thread");
		thread.start();
	}

}
