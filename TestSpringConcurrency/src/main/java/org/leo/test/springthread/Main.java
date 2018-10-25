package org.leo.test.springthread;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);
		
		TestService bean = ac.getBean(TestService.class);
		
		bean.a();
		bean.b();
		
	}

}
