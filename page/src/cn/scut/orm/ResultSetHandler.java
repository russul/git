package cn.scut.orm;

import java.sql.ResultSet;

public interface ResultSetHandler<T> {
	public T handler(ResultSet rs) throws Exception;
}
