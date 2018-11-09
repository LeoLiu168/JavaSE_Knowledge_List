package org.leo.demo.file;

import java.io.File;
import java.io.IOException;

public class TestFile {

	public static void main(String[] args) throws IOException {
		//使用当前路径创建一个File对象, 注意File对象是个抽象概念, 表示平台无关的文件或目录, 并且与路径紧密关联
		File file = new File(".");
		//输出文件名称, 为"."
		System.out.println(file.getName());
		//获取相对路径的父路径, 为null. 因为getParent是删除File对象名最后的子目录子文件名得出父路径的,
		//因此相对路径"."的父路径将为null
		System.out.println(file.getParent());
		//获取绝对路径
		System.out.println(file.getAbsoluteFile());
		//获取绝对路径的上一级路径
		System.out.println(file.getAbsoluteFile().getParent());
		//创建一个临时文件对象
		File tempFile = File.createTempFile("temp", ".txt", file);
		//JVM退出时删除临时文件
		tempFile.deleteOnExit();
		//使用当前日期创建一个临时文件对象, 调用exists方法此时返回false
		File newFile = new File(System.currentTimeMillis() + "");
		System.out.println("newFile对象是否存在: " + newFile.exists());
		//以newFile文件对象创建一个文件, 调用exists方法返回true
		newFile.createNewFile();
		System.out.println("newFile对象是否存在: " + newFile.exists());
		//因为已经创建了一个文件了, 所以调用目录创建方法将失败, 返回false
		System.out.println(newFile.mkdir());
		//获取当前路径下所有文件和路径并遍历
		String[] fileList = file.list();
		System.out.println("当前目录下所有文件和路径:");
		for (String fileName : fileList) {
			System.out.println(fileName);
		}
		//使用Lambda表达式, 目标类FilenameFilter, 实现文件过滤器
		//如果是java文件或目录, 则返回true
		String[] nameList = file.list((dir, name) -> 
			name.endsWith(".java") || new File(name).isDirectory()
		);
		for (String name : nameList) {
			System.out.println(name);
		}
		//列出所有磁盘根路径并遍历
		File[] roots = File.listRoots();
		System.out.println("系统所有根路径如下:");
		for (File root : roots) {
			System.out.println(root);
		}
	}

}
