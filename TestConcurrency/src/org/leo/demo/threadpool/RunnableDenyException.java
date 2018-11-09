package org.leo.demo.threadpool;

public class RunnableDenyException extends RuntimeException {
	
	private static final long serialVersionUID = 112311231231412L;

	public RunnableDenyException(String message) {
		super(message);
	}
}
