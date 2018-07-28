package cn.scut.orm;

import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class BeanHandler<T> implements ResultSetHandler<T> {
	private Class<T> clazz;

	public BeanHandler(Class<T> clazz) {
		this.clazz = clazz;

	}

	@Override
	public T handler(ResultSet rs) {

		// TODO Auto-generated method stub
		T t = null;

		try {
			t = (T) clazz.newInstance();
			if (rs == null) {
				t = null;
			}
			if (rs.next()) {

				Field[] fields = clazz.getDeclaredFields();

				for (Field f : fields) {
					f.setAccessible(true);
//					System.out.println(f.getName());
					PropertyDescriptor pd = new PropertyDescriptor(f.getName(),
							clazz);
					Method method = pd.getWriteMethod();
					if (method != null) {
						method.invoke(t, rs.getObject(f.getName()));
					}
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return t;
	}

}
