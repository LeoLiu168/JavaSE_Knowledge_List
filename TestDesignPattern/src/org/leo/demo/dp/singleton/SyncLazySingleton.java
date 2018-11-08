package org.leo.demo.dp.singleton;
/*
 * 优点: 实现了懒加载+数据同步, 确保实例的唯一性
 * 缺点: getInstance方法同一时刻只能被一个线程访问, 性能较低
 */
//不允许被继承
public final class SyncLazySingleton {
	//实例变量, 由于单例对象是静态的, 在类的加载阶段, 就会初始化实例变量
	@SuppressWarnings("unused")
	private byte[] data = new byte[1024];
	//定义静态实例对象, 不直接初始化
	private static SyncLazySingleton instance = null;
	//私有化构造函数, 不允许直接new对象
	private SyncLazySingleton() {}
	//提供公共的方法获取实例对象, 通过synchronized修饰为同步方法
	public static synchronized SyncLazySingleton getInstance() {
		if(null == instance) {
			instance = new SyncLazySingleton();
		}
		return instance;
	}
}
