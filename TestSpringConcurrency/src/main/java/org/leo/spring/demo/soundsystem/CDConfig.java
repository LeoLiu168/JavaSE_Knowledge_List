package org.leo.spring.demo.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDConfig {
	
	@Bean(name="lonelyHeartsClubBand")
	public CompactDisc compactDisc() {
		return new SgtPeppers();
	}

}
