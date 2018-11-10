package org.leo.demo.reflection;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/*
 * 基于反射构造一个简单的对象池
 */
public class ObjectPoolFactory {
	
	private Map<String, Object> objectPool = new HashMap<>();
	
	private Object createObject(String clazzName) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class<?> clazz = Class.forName(clazzName);
		return clazz.newInstance();
	}
	public void initPool(String fileName) {
		try (FileInputStream fis = new FileInputStream(fileName)){
			Properties props = new Properties();
			props.load(fis);
			for (String name : props.stringPropertyNames()) {
				objectPool.put(name, createObject(props.getProperty(name)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Object getObject(String name) {
		return objectPool.get(name);
	}
	public static void main(String[] args) {
		ObjectPoolFactory pf = new ObjectPoolFactory();
		pf.initPool("obj.txt");
		System.out.println(pf.getObject("a"));
		System.out.println(pf.getObject("b"));
	}

}
