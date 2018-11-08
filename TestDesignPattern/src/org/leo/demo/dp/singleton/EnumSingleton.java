package org.leo.demo.dp.singleton;
//枚举本身是final的, 不允许被继承
public enum EnumSingleton {
	INSTANCE;
	//实例变量
	@SuppressWarnings("unused")
	private byte[] data = new byte[1024];
	
	EnumSingleton() {
		System.out.println("INSTANCE will be initialized immediately");
	}
	public static void method() {
		//调用该方法会主动使用EnumSingleton, INSTANCE将会实例化
	}
	public static EnumSingleton getInstance() {
		return INSTANCE;
	}
}
