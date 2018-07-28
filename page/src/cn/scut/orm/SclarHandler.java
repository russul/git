package cn.scut.orm;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.persistence.Column;

public class SclarHandler<T> implements ResultSetHandler<T> {
	// 根据列名或者列的索引获取单行单列的值

	private int columnIndex;
	private String columnName;

	public SclarHandler(int columnIndex) {
		this(columnIndex, null);
	}

	public SclarHandler(String columnName) {
		this(1, columnName);
	}

	public SclarHandler(int columnIndex, String columnName) {
		this.columnIndex = columnIndex;
		this.columnName = columnName;
	}

	@Override
	public T handler(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub
		if (rs.next()) {
			if (this.columnName == null) {
				return (T) rs.getObject(columnIndex);
			}
			return (T) rs.getObject(columnName);
		}
		return null;
	}

	// private Class clazz;
	//
	// public SclarHandler(Class clazz) {
	// this.clazz = clazz;
	// }
	//
	// @Override
	// public Object handler(ResultSet rs) throws Exception {
	// // TODO Auto-generated method stub
	// return this.toSclar(rs, clazz);
	// }
	//
	// public Object toSclar(ResultSet rs, Class type) {
	// Object result=null;
	// try {
	// result = type.newInstance();
	// } catch (InstantiationException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// } catch (IllegalAccessException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	// if (rs == null) {
	// return null;
	// }
	//
	// try {
	// ResultSetMetaData meta = rs.getMetaData();
	// int column = meta.getColumnCount();
	// String name = meta.getColumnName(1);
	//
	// if (column == 1 && rs.next()) {
	// PropertyDescriptor pd = new PropertyDescriptor(name, type);
	// Method method = pd.getReadMethod();
	// method.invoke(result, rs.getObject(name));
	// }
	// } catch (Exception e) {
	// // TODO: handle exception
	// e.printStackTrace();
	// }
	//
	// return result;
	//
	// }

}
