package org.leo.demo.dp.singleton;
/*
 * 优点: 实现了懒加载, 当要用的时候才创建实例, 节省了前期的内存空间占用
 * 缺点: getInstance方法多线程中有可能会创建多于1个的实例, 破坏了单例性
 */
//不允许被继承
public final class LazySingleton {
	//实例变量, 由于单例对象是静态的, 在类的加载阶段, 就会初始化实例变量
	@SuppressWarnings("unused")
	private byte[] data = new byte[1024];
	//定义静态实例对象, 不直接初始化
	private static LazySingleton instance = null;
	//私有化构造函数, 不允许直接new对象
	private LazySingleton() {}
	//提供公共的方法获取实例对象
	public static LazySingleton getInstance() {
		if(null == instance) {
			instance = new LazySingleton();
		}
		return instance;
	}
}
