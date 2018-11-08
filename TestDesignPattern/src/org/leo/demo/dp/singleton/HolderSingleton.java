package org.leo.demo.dp.singleton;
/*
 * 最好的单例模式之一:
 * Holder直到方法调用时才进行初始化并赋值, 并且可以实现同步线程安全
 */
//不允许被继承
public final class HolderSingleton {
	//实例变量
	@SuppressWarnings("unused")
	private byte[] data = new byte[1024];
	//私有化构造器
	private HolderSingleton() {}
	//定义静态内部类Holder, 及内部实例成员, 并直接初始化
	private static class Holder{
		private static HolderSingleton instance = new HolderSingleton();
	}
	//通过Holder.instance获得单例
	public static HolderSingleton getInstance() {
		return Holder.instance;
	}
}
