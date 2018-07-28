package cn.scut.orm;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler<T> implements ResultSetHandler<List<T>> {

	private Class clazz;

	public BeanListHandler(Class clazz) {
		this.clazz = clazz;
	}

	@Override
	public List<T> handler(ResultSet rs) throws Exception {
		// TODO Auto-generated method stub

		return this.toBeanList(rs, clazz);
	}

	// 必须定义一个泛型方法，通过用统配符的方式让编译器知道传入的具体类必须是T的子类,这样编译就能顺利通过，执行也不会出错
	public <T> List<T> toBeanList(ResultSet rs, Class<? extends T> type) {

		// 创建list
		List<T> list = new ArrayList<T>();

		// rs的元数据，可以得到当前行的列数，列明等信息
		// ResultSetMetaData meta=rs.getMetaData();

		if (rs == null)

		{
			list = null;
			return null;
		}

		// 获取当前行的某列的值
		try {
			if (!rs.next()) {
				return list;
			}
			do {
				
				T t = type.newInstance();
				Field[] fields = type.getDeclaredFields();
				for (Field field : fields) {
					field.setAccessible(true);
					// 要求调用者的数据表中的列名和对象的属性名一致，这里就不进行两者的校验了
					String name = field.getName();
					PropertyDescriptor pd = new PropertyDescriptor(name, type);
					Method set = pd.getWriteMethod();
					
					if (set != null) {
						set.invoke(t, rs.getObject(name));

					}

				}
				list.add(t);

			} while (rs.next());

		} catch (IntrospectionException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			// TODO: handle exception
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;
	}

}
