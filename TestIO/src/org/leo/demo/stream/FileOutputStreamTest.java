package org.leo.demo.stream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamTest {

	public static void main(String[] args) {
		FileInputStream fis = null;
		FileOutputStream fos = null;
		try {
			fis = new FileInputStream("test.txt");
			fos = new FileOutputStream("testCopy.txt");
			byte[] bbuf = new byte[32];
			int hasRead = 0;
			while ((hasRead = fis.read(bbuf)) > 0) {
				fos.write(bbuf, 0, hasRead);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		
	}

}
