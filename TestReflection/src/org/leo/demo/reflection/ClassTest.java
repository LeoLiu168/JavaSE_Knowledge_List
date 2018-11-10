package org.leo.demo.reflection;

import java.lang.annotation.Annotation;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

@Repeatable(Annos.class)
@interface Anno {}
@Retention(value=RetentionPolicy.RUNTIME)
@interface Annos {
	Anno[] value();
}
@SuppressWarnings(value="unused")
@Deprecated
@Anno
@Anno
public class ClassTest {
	
	private int aInt;
	
	private ClassTest() {
		
	}
	public ClassTest(String name) {
		System.out.println("执行有参数的构造器");
	}
	public void info() {
		System.out.println("执行无参数的info方法");
	}
	public void info(String str) {
		System.out.println("执行有参数的info方法, 参数值为: " + str);
	}
	class Inner{
		
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, ClassNotFoundException {
		Class<ClassTest> clazz = ClassTest.class;
		//获取Class对象的全部构造器
		Constructor<?>[] ctors = clazz.getDeclaredConstructors();
		System.out.println("ClassTest的全部构造器如下:");
		for (Constructor<?> c : ctors) {
			System.out.println(c);
		}
		//获取Class对象的全部public构造器
		Constructor<?>[] publicCtors = clazz.getConstructors();
		System.out.println("ClassTest的全部public构造器如下:");
		for (Constructor<?> c : publicCtors) {
			System.out.println(c);
		}
		//获取Class对象的全部public方法
		Method[] methods = clazz.getMethods();
		System.out.println("ClassTest的全部public方法如下:");
		for (Method method : methods) {
			System.out.println(method);
		}
		System.out.println("带一个字符串参数的info方法为: " + clazz.getMethod("info", String.class));
		Annotation[] anns = clazz.getAnnotations();
		System.out.println("ClassTest的全部annotation如下:");
		for (Annotation ann : anns) {
			System.out.println(ann);
		}
		//SuppressWarning只保存在SOURCE阶段, 因此运行时将无法取得
		System.out.println("该Class元素上的@SuppressWarning注解为:" 
				+ Arrays.toString(clazz.getAnnotationsByType(SuppressWarnings.class)));
		System.out.println("该Class元素上的@Anno注解为:"
			+ Arrays.toString(clazz.getAnnotationsByType(Anno.class)));
		Class<?>[] inners = clazz.getDeclaredClasses();
		System.out.println("全部内部类如下:");
		for (Class<?> inner : inners) {
			System.out.println(inner);
		}
		Class<?> inClazz = Class.forName("org.leo.demo.reflection.ClassTest$Inner");
		System.out.println("inClazz对应类的外部类为: " + inClazz.getDeclaringClass());
		System.out.println("ClassTest的包为: " + clazz.getPackage());
		System.out.println("ClassTest的父类为: " + clazz.getSuperclass());
	}

}
