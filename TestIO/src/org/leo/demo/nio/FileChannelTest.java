package org.leo.demo.nio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

public class FileChannelTest {

	public static void main(String[] args) {
		File file = new File("out.txt");
		try (FileChannel inChannel = new FileInputStream(file).getChannel();
				FileChannel outChannel = new FileOutputStream("outCopy.txt").getChannel()){
			//将FileChannel里所有数据转为ByteBuffer
			MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
			//使用UTF-8字符集来创建解码器
			Charset charset = Charset.forName("UTF-8");
			//直接将Buffer里的数据全部输出
			outChannel.write(buffer);
			//调用clear方法, 重置limit, position的位置
			buffer.clear();
			//创建解码器对象
			CharsetDecoder decoder = charset.newDecoder();
			//使用解码器将ByteBuffer转换成CharBuffer
			CharBuffer charBuffer = decoder.decode(buffer);
			//CharBuffer的toString方法获取字符串
			System.out.println(charBuffer.toString());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
