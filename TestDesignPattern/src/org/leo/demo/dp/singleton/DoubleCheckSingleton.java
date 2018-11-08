package org.leo.demo.dp.singleton;

import java.net.Socket;
import java.sql.Connection;

/*
 * 优点: 实现了懒加载+数据同步+getInstance方法性能提升
 * 缺点: 多线程下可能会出现空指针异常
 */
//不允许被继承
public final class DoubleCheckSingleton {
	//实例变量, 由于单例对象是静态的, 在类的加载阶段, 就会初始化实例变量
	@SuppressWarnings("unused")
	private byte[] data = new byte[1024];
	//定义静态实例对象, 不直接初始化
	private static DoubleCheckSingleton instance = null;
	Connection conn;
	Socket socket;
	//私有化构造函数, 不允许直接new对象
	//由于指令重排序, 实例化顺序可能重排, 从而导致空指针
	private DoubleCheckSingleton() {
		//this.conn;
		//this.socket;
	}
	//提供公共的方法获取实例对象
	public static DoubleCheckSingleton getInstance() {
		//
		if(null == instance) {
			synchronized(DoubleCheckSingleton.class) {
				if(null == instance) {
					instance = new DoubleCheckSingleton();					
				}
			}
		}
		return instance;
	}
}
