package org.leo.spring.demo.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class SadSound implements CompactDisc {
	
	private String title = "Sad Sound";
	private String artist = "Gordon";

	@Override
	public void play() {
		System.out.println("Playing" + title + " by " + artist);
	}

}
