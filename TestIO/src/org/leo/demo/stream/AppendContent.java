package org.leo.demo.stream;

import java.io.IOException;
import java.io.RandomAccessFile;

public class AppendContent {

	public static void main(String[] args) {
		//使用try(...){}来集中定义流引用, try块会安全的将它们关闭
		try (RandomAccessFile raf = new RandomAccessFile("out.txt", "rw")){
			raf.seek(raf.length());
			raf.write("追加的内容!\n".getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
