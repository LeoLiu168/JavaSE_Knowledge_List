package org.leo.spring.demo.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class LittleApple implements CompactDisc {
	
	private String title = "Little Apple";
	private String artist = "Tony";

	@Override
	public void play() {
		System.out.println("Playing" + title + " by " + artist);
	}

}
