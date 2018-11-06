package org.leo.demo.dp.template;
/*
 * 一个简单的模板模式示例
 */
public class TemplateMethod {
	//相当于Thread类的start方法, 用final修饰避免被更改
	public final void print(String message) {
		System.out.println("-------------");
		wrapPrint(message);
		System.out.println("-------------");
	}
	//相当于Thread的run方法, 用protected修饰限于子类重写
	protected void wrapPrint(String message) {
		
	}
	
	public static void main(String[] args) {
		//通过匿名内部子类, 重写父类的wrapPrint方法, 从而实现不同的输出模板
		TemplateMethod t1 = new TemplateMethod() {
			@Override
			protected void wrapPrint(String message) {
				System.out.println("111" + message + "111");
			}
		};
		t1.print("Hello World!");
		
		TemplateMethod t2 = new TemplateMethod() {
			@Override
			protected void wrapPrint(String message) {
				System.out.println("222" + message + "222");
			}
		};
		t2.print("Hello World!");
	}

}


