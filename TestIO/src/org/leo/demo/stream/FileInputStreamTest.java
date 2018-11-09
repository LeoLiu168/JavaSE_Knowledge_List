package org.leo.demo.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamTest {

	public static void main(String[] args) {
		//创建字节输入流
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("test.txt");
			//创建一个长度为1024的Buffer
			byte[] bbuf = new byte[1024];
			//用于保存实际读取的字节数
			int hasRead = 0;
			while ((hasRead = fis.read(bbuf)) > 0) {
				//将字节数组转换为字符串
				System.out.println(new String(bbuf, 0, hasRead));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			//关闭文件流, 1.7之后的NIO都实现了自动关闭接口, 在编码上有所改进
			if (fis != null) {				
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
