package org.leo.demo.dp.di;
/*
 * 通过传入接口实现对象的引用来解耦
 * 通过接口来表达依赖关系
 */
public class TableDemo implements Table{
	
	Column column;
	
	//依赖注入的方式之一:构造器注入
	public TableDemo(Column column) {
		this.column = column;
	}
	
	public void sumOnColumn() {
		column.sumField();
	}

}
