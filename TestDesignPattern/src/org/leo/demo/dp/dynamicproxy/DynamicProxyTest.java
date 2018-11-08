package org.leo.demo.dp.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

//测试类
public class DynamicProxyTest {

	public static void main(String[] args) {
		//创建被代理类A的代理类对象
		Invoker invoker1 = new Invoker(new ClassA());
		//通过反射, 获得被代理类A的代理对象
		AbstractInterface ac1 = (AbstractInterface) Proxy.newProxyInstance(AbstractInterface.class.getClassLoader(), 
				new Class[] {
						AbstractInterface.class
				}, invoker1);
		//调用被代理类A的方法
		ac1.show();
		
		//创建被代理类B的代理类对象
		Invoker invoker2 = new Invoker(new ClassB());
		//通过反射, 获得被代理类B的代理对象
		AbstractInterface ac2 = (AbstractInterface) Proxy.newProxyInstance(AbstractInterface.class.getClassLoader(), 
				new Class[] {
						AbstractInterface.class
				}, invoker2);
		//调用被代理类A的方法
		ac2.show();
	}

}
//1. 定义被代理类的接口
interface AbstractInterface {
	public void show();
}
//2. 实现被代理类A
class ClassA implements AbstractInterface{
	@Override
	public void show() {
		System.out.println("Here`s A!");
	}
}
//3. 实现被代理类B
class ClassB implements AbstractInterface{
	@Override
	public void show() {
		System.out.println("Here`s B!");
	}
}
//4. 定义动态代理类, 实现InvocationHandler接口
class Invoker implements InvocationHandler{
	//5. 使用被代理类接口作为成员变量
	AbstractInterface ai;
	//6. 带参数的构造方法
	public Invoker(AbstractInterface ai) {
		this.ai = ai;
	}
	//7. 重写invoke方法
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("DynamicProxy Satrt...");
		//8. 调用方法参数的invoke方法, 执行被代理类的方法
		method.invoke(ai, args);
		System.out.println("DynamicProxy finish...");
		return null;
	}
	
}