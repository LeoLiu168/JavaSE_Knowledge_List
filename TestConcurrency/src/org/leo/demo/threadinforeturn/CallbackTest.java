package org.leo.demo.threadinforeturn;

public class CallbackTest implements CallbackUserInterface {
	//实现回调方法
	@Override
	public void receiveResult(String result, String fileName) {
		System.out.println("文件" + fileName + "的内容是: \n" + result);
	}

	public static void main(String[] args) {
		//新建回调接口引用, 指向实现类的对象
		CallbackUserInterface test = new CallbackTest();
		new Thread(new CallbackDigest("test.txt", test)).start();
	}
}
