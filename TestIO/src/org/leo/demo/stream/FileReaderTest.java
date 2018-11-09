package org.leo.demo.stream;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderTest {

	public static void main(String[] args) {
		FileReader fr = null;
		try {
			fr = new FileReader("test.txt");
			char[] cbuf = new char[64];
			int hasRead = 0;
			while ((hasRead = fr.read(cbuf)) > 0) {
				System.out.println(new String(cbuf, 0, hasRead));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fr != null) {
				try {
					fr.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
