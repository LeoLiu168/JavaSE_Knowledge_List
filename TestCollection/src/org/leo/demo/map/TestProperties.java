package org.leo.demo.map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties props = new Properties();
		//为Properties对象添加元素
		props.setProperty("username", "admin");
		props.setProperty("password", "123456");
		//写入文件
		props.store(new FileOutputStream("test.properties"), "comment line");
		Properties props2 = new Properties();
		props2.setProperty("gender", "male");
		//将文件中的内容追加到Props2的元素中
		props2.load(new FileInputStream("test.properties"));
		System.out.println(props2);
	}

}
