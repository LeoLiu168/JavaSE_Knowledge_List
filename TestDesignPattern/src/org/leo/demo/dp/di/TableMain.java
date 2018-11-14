package org.leo.demo.dp.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TableMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
		new ClassPathXmlApplicationContext("/resources/Table.xml");
		Table table = context.getBean(Table.class);
		table.sumOnColumn();
		context.close();
	}

}
