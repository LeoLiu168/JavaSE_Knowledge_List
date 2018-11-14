package org.leo.demo.dp.di;

import org.junit.Test;
import org.mockito.Mockito;

public class TableDemoTest {
	
	@Test
	public void tableDemotest() {
		Column mockColumn = Mockito.mock(Column.class);
		TableDemo demo = new TableDemo(mockColumn);
		demo.sumOnColumn();
		Mockito.verify(mockColumn).sumField();
	}

}
