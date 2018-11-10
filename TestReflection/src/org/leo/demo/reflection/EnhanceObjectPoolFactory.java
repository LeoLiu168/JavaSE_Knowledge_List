package org.leo.demo.reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
 * 构造一个增强的对象池, 可以在配置文件中增加配置对象的成员变量的值, 并利用对象的setter方法设置成员变量值
 */
public class EnhanceObjectPoolFactory {
	//定义一个对象池, 键是对象名, 值是对象
	private Map<String, Object> objectPool = new HashMap<>();
	private Properties config = new Properties();
	//从指定配置文件中初始化Properties对象
	public void init(String fileName) {
		try (FileInputStream fis = new FileInputStream(fileName)){
			config.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
	//定义一个创建对象的方法, 参数为类名
	private Object createObject(String clazzName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clazz = Class.forName(clazzName);
		return clazz.newInstance();
	}
	//提供根据指定文件初始化对象池的方法
	public void initPool() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		for (String name : config.stringPropertyNames()) {
			if(!name.contains("%")) {
				objectPool.put(name, createObject(config.getProperty(name)));
			}
		}
	}
	//根据属性文件调用指定对象的setter方法
	public void initProperty() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		for (String name : config.stringPropertyNames()) {
			if(name.contains("%")) {
				//按%分割
				String[] objAndProp = name.split("%");
				Object target = getObject(objAndProp[0]);
				//获取Setter方法名
				String mtdName = "set" +
				objAndProp[1].substring(0, 1).toUpperCase() + 
				objAndProp[1].substring(1);
				Class<? extends Object> targetClass = target.getClass();
				Method method = targetClass.getMethod(mtdName, String.class);
				method.invoke(target, config.getProperty(name));
			}
		}
	}
	//从ObjectPool中取出指定name对应的对象
	public Object getObject(String name) {
		return objectPool.get(name);
	}
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		EnhanceObjectPoolFactory epf = new EnhanceObjectPoolFactory();
		epf.init("extObj.txt");
		epf.initPool();
		epf.initProperty();
		System.out.println(epf.getObject("a"));
		System.out.println(epf.getObject("b"));
	}

}
