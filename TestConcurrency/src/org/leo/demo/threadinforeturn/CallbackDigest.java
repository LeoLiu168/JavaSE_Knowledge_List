package org.leo.demo.threadinforeturn;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * 使用接口回调, 实现线程执行结果的返回
 */
public class CallbackDigest implements Runnable{
	private String fileName;
	private String result;
	//定义回调方法接口的引用
	private CallbackUserInterface cui;
	public CallbackDigest(String fileName, CallbackUserInterface cui) {
		this.fileName = fileName;
		this.cui = cui;
	}
	@Override
	public void run() {
		try (FileInputStream fis = new FileInputStream(fileName)){
			byte[] buffer = new byte[1024];
			int hasRead = 0;
			while((hasRead = fis.read(buffer)) > 0) {
				result = new String(buffer, 0, hasRead);
			}
			//通过回调接口引用, 调用了receiveResult方法, 可以在主线程中返回结果.
			//此处利用了多态
			cui.receiveResult(result, fileName);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
