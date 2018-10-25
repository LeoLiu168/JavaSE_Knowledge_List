package org.leo.demo.threadinit;

import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {

	public static void main(String[] args) {
		
		Timer timer = new Timer();
		
		timer.schedule(new TimerTask() {
			
			@Override
			public void run() {
				System.out.println("Timer task is running");
			}
		}, 0, 1000);
				
	}

}
