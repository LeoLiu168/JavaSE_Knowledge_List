package org.leo.demo.nio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
/*
 * 通过RandomAccessFile获取Channel对象, 赋值文件内容至文档末尾
 */
public class RandomFileChannelTest {

	public static void main(String[] args) {
		File file = new File("out.txt");
		try (
			//创建一个RandomAccessFile对象
			RandomAccessFile raf = new RandomAccessFile(file, "rw");
			//通过RandomAccessFile对象获取对应的Channel	
				FileChannel randomChannel = raf.getChannel()){
			//将Channel中所有数据映射到Buffer
			MappedByteBuffer buffer = randomChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			//将Channel的指针移到最后
			randomChannel.position(file.length());
			//将Buffer中的数据输出
			randomChannel.write(buffer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
