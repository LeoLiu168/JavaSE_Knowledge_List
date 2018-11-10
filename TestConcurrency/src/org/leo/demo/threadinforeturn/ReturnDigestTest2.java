package org.leo.demo.threadinforeturn;

import java.io.FileInputStream;
import java.io.IOException;

/*
 * 使用轮询对代码进行优化
 */
public class ReturnDigestTest2 extends Thread{
	//定义文件名
	private String fileName;
	//定义一个字符串对象result, 用于存取线程执行结果
	private String result;
	
	public ReturnDigestTest2(String fileName) {
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
		ReturnDigestTest2 returnDigestTest = new ReturnDigestTest2("test.txt");
		returnDigestTest.start();
		//使用轮询, 判断线程返回结果是否为null
		while (true) {
			if (returnDigestTest.getResult() != null) {
				System.out.println(returnDigestTest.getResult());
				break;
			}
		}
	}

}
