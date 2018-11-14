package org.leo.demo.db.aop;

import org.leo.demo.dp.di.Column;
import org.leo.demo.dp.di.Table;

public class EmployeeTable implements Table {
	
	private Column column;

	public EmployeeTable(Column column) {
		this.column = column;
	}

	@Override
	public void sumOnColumn() {
		column.sumField();
	}

}
