package org.leo.demo.stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamTest {

	public static void main(String[] args) {
		FileOutputStream fos = null;
		PrintStream ps = null;
		try {
			fos = new FileOutputStream("PrintStreamTest.txt");
			ps = new PrintStream(fos);
			ps.println("普通字符串");
			ps.println(new PrintStreamTest());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
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
