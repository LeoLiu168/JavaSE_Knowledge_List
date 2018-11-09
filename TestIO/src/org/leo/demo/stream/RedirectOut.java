package org.leo.demo.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class RedirectOut {

	public static void main(String[] args) {
		PrintStream ps = null;
		try {
			ps = new PrintStream(new FileOutputStream("out.txt"));
			//标准输出重定向到ps输出流
			System.setOut(ps);
			System.out.println("普通字符串");
			System.out.println(new RedirectOut());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				ps.close();
			}
		}
	}

}
