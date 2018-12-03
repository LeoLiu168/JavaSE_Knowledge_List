package org.leo.spring.demo.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
/*
 * @ComponentScan
 * 1. basePackages可以为多个String元素的数组,如basePackages={"package_a","package_b"}
 * 2. 或者指定基础包中的类或接口, 如basePackageClasses={CDPlayer.class, DVDPlayer.class}
 */
@Configuration
@Import(CDConfig.class)
public class CDPlayerConfig {
	
	@Bean
	public CompactDisc randomCD() {
		int choice = (int)Math.floor(Math.random() * 4);
		if (choice == 0) {
			return new SgtPeppers();
		} else if (choice == 1) {
			return new LittleApple();
		} else if (choice == 2) {
			return new HappySound();
		} else {
			return new SadSound();
		}
	}
	
	//装配一个依赖于其它Bean的Bean
//	@Bean
//	public CDPlayer cdPlayer() {
//		return new CDPlayer(sgtPeppers());
//	}
}
