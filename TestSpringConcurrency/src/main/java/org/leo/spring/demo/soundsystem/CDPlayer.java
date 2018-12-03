package org.leo.spring.demo.soundsystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 * 
 */
@Component
public class CDPlayer implements MediaPlayer {
	
	private CompactDisc cd;
	
	//使用Autowired修饰构造器实现自动装配
	@Autowired
	public CDPlayer(CompactDisc cd) {
		this.cd = cd;
	}
	
	//使用Autowired修饰Setter实现自动装配
//	@Autowired
//	public void setCd(CompactDisc cd) {
//		this.cd = cd;
//	}
	//使用Autowired修饰更一般的方法实现自动装配
	//使用required属性, 表示如果Spring找不到bean装配, 将保持未装配状态, 但要避免可能的空指针异常
	//如果有多个Bean符合条件, 将产生歧义
	@Autowired(required=false)
	public void insertDisc(CompactDisc cd) {
		this.cd = cd;
	}

	@Override
	public void play() {
		cd.play();
	}

}
