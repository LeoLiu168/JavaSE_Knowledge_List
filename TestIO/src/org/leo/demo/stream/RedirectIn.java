package org.leo.demo.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class RedirectIn {

	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream("out.txt");
			//标准输出重定向到ps输出流
			System.setIn(fis);
			@SuppressWarnings("resource")
			Scanner sc = new Scanner(System.in);
			sc.useDelimiter("\n");
			while (sc.hasNext()) {
				System.out.println("键盘输入的内容是: " + sc.next());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
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
