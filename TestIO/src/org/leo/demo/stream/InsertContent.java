package org.leo.demo.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
 * 使用RandomAccessFile实现对文件插入内容.
 * RandomAccessFile不能直接在文件中部插入内容, 需把指针后面的内容暂存至某临时文件中, 在插入完成后, 补回临时文件
 * 的内容
 */
public class InsertContent {
	
	public static void insert(String fileName, long pos, String insertContent) throws IOException {
		File temp = File.createTempFile("tmp", null);
		temp.deleteOnExit();
		try (
			RandomAccessFile raf = new RandomAccessFile(fileName, "rw");
			//建立临时文件的输出流和输入流, 用于写入和读取临时保存内容
			FileOutputStream tmpOut = new FileOutputStream(temp);
			FileInputStream tempIn = new FileInputStream(temp);
				){
			raf.seek(pos);
			//---下面代码将插入点后的内容暂存到临时文件
			byte[] bbuf = new byte[1024];
			int hasRead = 0;
			while ((hasRead = raf.read(bbuf)) > 0) {
				tmpOut.write(bbuf, 0, hasRead);
			}
			//---下面代码用于插入内容-----
			raf.seek(pos);
			raf.write(insertContent.getBytes());
			while ((hasRead = tempIn.read(bbuf)) > 0) {
				raf.write(bbuf, 0, hasRead);
			}
		}
	}

	public static void main(String[] args) {
		try {
			insert("test.txt", 5, "Java is the best!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
