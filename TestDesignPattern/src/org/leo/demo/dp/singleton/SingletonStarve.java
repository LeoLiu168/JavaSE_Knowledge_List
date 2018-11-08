package org.leo.demo.dp.singleton;
/*
 * 优点: instance作为类变量在类初始化过程会被收进<clinit>()方法, 该方法是线程安全的.
 * 缺点: 如果一个类中成员都是比较重的资源, 会带来较多的内存开销和浪费
 */
//不允许被继承
public final class SingletonStarve {
	//实例变量, 由于单例对象是静态的, 在类的加载阶段, 就会初始化实例变量
	@SuppressWarnings("unused")
	private byte[] data = new byte[1024];
	//定义静态实例对象的时候直接初始化
	private static SingletonStarve instance = new SingletonStarve();
	//私有化构造函数, 不允许直接new对象
	private SingletonStarve() {}
	//提供公共的方法获取实例对象
	public static SingletonStarve getInstance() {
		return instance;
	}
}
