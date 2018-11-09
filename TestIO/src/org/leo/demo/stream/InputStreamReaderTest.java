package org.leo.demo.stream;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamReaderTest {

	public static void main(String[] args) {
		InputStreamReader reader = null;
		BufferedReader br = null;
		try {
			//将System.in的InputStream对象转换为Reader对象
			reader = new InputStreamReader(System.in);
			//包装成BufferReader
			br = new BufferedReader(reader);
			String line = null;
			while ((line = br.readLine()) != null) {
				if(line.equals("exit")) {
					System.exit(1);
				}
				System.out.println("输入内容为: " + line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

}
