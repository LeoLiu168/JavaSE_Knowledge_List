package org.leo.demo.dp.di;

import java.io.PrintStream;

public class AgeColumn implements Column {
	
	private PrintStream stream;

	public AgeColumn(PrintStream stream) {
		this.stream = stream;
	}

	@Override
	public void sumField() {
		stream.println("计算年龄列的总和");
	}

}
