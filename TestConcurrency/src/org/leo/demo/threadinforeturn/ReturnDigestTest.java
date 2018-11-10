package org.leo.demo.threadinforeturn;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/*
 * 设计可以返回运行结果的线程
 * 定义一个线程读取文件内容, 使用字符串存取结果并返回主线程
 */
public class ReturnDigestTest extends Thread{
	//定义文件名
	private String fileName;
	//定义一个字符串对象result, 用于存取线程执行结果
	private String result;
	
	public ReturnDigestTest(String fileName) {
		this.fileName = fileName;
	}
	//run方法中读取本目录下文件, 并存储至result
	@Override
	public void run() {
		try (FileInputStream fis = new FileInputStream(fileName)){
			byte[] buffer = new byte[1024];
			int hasRead = 0;
			while ((hasRead = fis.read(buffer)) > 0) {
				result = new String(buffer, 0, hasRead);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	//定义返回result结果的方法
	public String getResult() {
		return result;
	}
	public static void main(String[] args) throws InterruptedException {
		//测试, 在子线程中执行读取文件, 主线程返回
		ReturnDigestTest returnDigestTest = new ReturnDigestTest("test.txt");
		returnDigestTest.start();
		//以下结果返回null. 因为getResult方法执行的时候, 子线程可能还没结束
		//如果使主线程休眠5秒, 将返回预期的结果
		TimeUnit.SECONDS.sleep(5);
		System.out.println(returnDigestTest.getResult());
	}
}
