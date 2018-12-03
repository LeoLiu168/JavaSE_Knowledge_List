package org.leo.spring.demo.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class HappySound implements CompactDisc {
	
	private String title = "Happy Sound";
	private String artist = "Burt";

	@Override
	public void play() {
		System.out.println("Playing" + title + " by " + artist);
	}

}
