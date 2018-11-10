package org.leo.demo.threadinforeturn;

public interface CallbackUserInterface {
	//只定义了回调方法, 传入一个待读取的文件名参数, 和返回结果
	public void receiveResult(String result, String fileName);
}
