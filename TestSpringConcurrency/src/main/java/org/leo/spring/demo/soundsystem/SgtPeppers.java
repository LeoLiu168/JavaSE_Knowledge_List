package org.leo.spring.demo.soundsystem;
/*
 * 使用Spring的隐式Bean发现和装配机制:使用@Component修饰接口实现类
 * 1. Spring的ApplicationContext会默认为每个Bean命名, 规则为类名的第一个字母小写
 */
import org.springframework.stereotype.Component;

@Component("lonelyHeartsClub")//2. 使用Component为bean命名
//@Named("lonelyHeartsClub") 3.可以使用javax.inject包中的@Named为Bean命名
public class SgtPeppers implements CompactDisc {
	
	private String title = "Sgt Peppers";
	private String artist = "Leo";

	@Override
	public void play() {
		System.out.println("Playing" + title + " by " + artist);
	}

}
