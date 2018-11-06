package org.leo.demo.dp.strategy;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecordQuery  {
	
	private final Connection connection;

	public RecordQuery(Connection connection) {
		this.connection = connection;
	}
	//方法中传入RowHandler的实现类
	public <T> T query(RowHandler<T> handler, String sql, Object... params) throws SQLException {
			PreparedStatement stmt;
			ResultSet resultSet;
			stmt = connection.prepareStatement(sql);
			int index = 1;
			for (Object param : params) {
				stmt.setObject(index++, param);
			}
			resultSet = stmt.executeQuery();
			//调用实现类的handle方法来处理数据
			return handler.handle(resultSet);
	}
}
