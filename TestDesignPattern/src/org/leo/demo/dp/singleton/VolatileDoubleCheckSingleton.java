package org.leo.demo.dp.singleton;

import java.net.Socket;
import java.sql.Connection;

/*
 * 优点: 实现了懒加载+数据同步+getInstance方法性能提升+避免空指针
 */
//不允许被继承
public final class VolatileDoubleCheckSingleton {
	//实例变量, 由于单例对象是静态的, 在类的加载阶段, 就会初始化实例变量
	@SuppressWarnings("unused")
	private byte[] data = new byte[1024];
	//定义静态实例对象, 不直接初始化
	//通过volatile, 避免指令重排序导致的空指针异常
	private static volatile VolatileDoubleCheckSingleton instance = null;
	Connection conn;
	Socket socket;
	//私有化构造函数, 不允许直接new对象
	//由于指令重排序, 实例化顺序可能重排, 从而导致空指针,使用volatile关键字修饰单例解决
	private VolatileDoubleCheckSingleton() {
		//this.conn;
		//this.socket;
	}
	//提供公共的方法获取实例对象
	public static VolatileDoubleCheckSingleton getInstance() {
		//
		if(null == instance) {
			synchronized(VolatileDoubleCheckSingleton.class) {
				if(null == instance) {
					instance = new VolatileDoubleCheckSingleton();					
				}
			}
		}
		return instance;
	}
}
