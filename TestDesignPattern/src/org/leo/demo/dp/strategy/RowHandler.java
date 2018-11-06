package org.leo.demo.dp.strategy;

import java.sql.ResultSet;
/*
 * RowHandler定义了对数据库查询返回结果操作的方法, 具体实现需要
 * 实现类完成, 类似于Runnable接口
 */
public interface RowHandler<T> {
	T handle(ResultSet rs);
}
