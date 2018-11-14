package org.leo.demo.db.aop;

import java.io.PrintStream;

public class EmployeeTableLog {
	
	private PrintStream stream;
	
	public EmployeeTableLog(PrintStream stream) {
		this.stream = stream;
	}

	public void logBeforeSum() {
		stream.println("start to sum...");
	}
	
	public void logAfterSum() {
		stream.println("finish summing...");
	}

}
