package org.leo.demo.dp.di;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TableMain {

	public static void main(String[] args) {
		//载入xml的配置文件, 使用Spring管理Beans
		ClassPathXmlApplicationContext context = 
		new ClassPathXmlApplicationContext("Table.xml");
		Table table = context.getBean(Table.class);
		table.sumOnColumn();
		context.close();
	}

}
