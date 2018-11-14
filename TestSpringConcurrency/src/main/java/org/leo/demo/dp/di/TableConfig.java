package org.leo.demo.dp.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TableConfig {
	
	@Bean
	public Table table() {
		return new TableDemo(column());
	}
	
	@Bean
	public Column column() {
		return new AgeColumn(System.out);
	}
}
