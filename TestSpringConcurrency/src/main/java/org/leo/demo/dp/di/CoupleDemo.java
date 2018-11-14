package org.leo.demo.dp.di;
/*
 * 定义一个紧耦合的类(表示一张表),成员变量为一个列的对象.
 * 通过在构造函数中new对象, 造成紧耦合
 */
public class CoupleDemo {
	
	Column1 column;
	
	public CoupleDemo() {
		this.column = new Column1();
	}
	
	public void sumOnColumn() {
		column.sumField();
	}

}

class Column1 {
	public void sumField() {
		
	}
}