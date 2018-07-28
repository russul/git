package cn.scut.dao.impl;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import cn.scut.dao.StudentDao;
import cn.scut.domain.Student;
import cn.scut.orm.BeanListHandler;
import cn.scut.orm.ResultSetHandler;
import cn.scut.orm.SclarHandler;

public class StudentDaoImpl implements StudentDao {

	@Override
	public void add(Student student) {

		// 将这部分配置在文件中
		// // TODO Auto-generated method stub
		// // 1、和数据库建立链接，得到连接池对象
		// ComboPooledDataSource dataSource = new ComboPooledDataSource();
		// try {
		// dataSource.setDriverClass("com.mysql.jdbc.Driver");
		// } catch (PropertyVetoException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/company");
		// dataSource.setUser("root");
		// dataSource.setPassword("1234");

		ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");
		// 得到连接对象
		Connection connection = null;
		PreparedStatement statement = null;
		try {
			connection = dataSource.getConnection();

			statement = connection
					.prepareStatement("insert into student (age,name,gender) values(?,?,?)");

			// 向里面插入1000条测试记录
			// for(int i=0;i<1000;i++){
			// statement.setInt(1, i);
			// statement.setString(2, "stu_"+i);
			// if(i%2==0){
			// statement.setString(3, "男");
			//
			// }else{
			// statement.setString(3, "女");
			// }
			//
			//
			// statement.executeUpdate();
			// }
			//

			statement.setInt(1, student.getAge());
			statement.setString(2, student.getName());
			statement.setString(3, student.getGender());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	@Override
	public int getTotalRecord() {
		// TODO Auto-generated method stub
		// // 1、和数据库建立链接，得到连接池对象
		// ComboPooledDataSource dataSource = new ComboPooledDataSource();
		// try {
		// dataSource.setDriverClass("com.mysql.jdbc.Driver");
		// } catch (PropertyVetoException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/company");
		// dataSource.setUser("root");
		// dataSource.setPassword("1234");

		ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");

		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;
		int totalRecord = 0;
		try {
			connection = dataSource.getConnection();
			String sql = "select count(*) from student";
			statement = connection.prepareStatement(sql);
			rs = statement.executeQuery();

			// ORM

			ResultSetHandler<Long> handler = new SclarHandler<Long>(1);

			totalRecord = (handler.handler(rs)).intValue();
			// if (rs.next()) {
			// totalRecord = rs.getInt(1);
			//
			// }

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				statement.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}

		}

		return totalRecord;
	}

	public List<Student> findAll(int pageNum, int pageSize) {

		List<Student> results = null;
		// // 1、和数据库建立链接，得到连接池对象
		// ComboPooledDataSource dataSource = new ComboPooledDataSource();
		// try {
		// dataSource.setDriverClass("com.mysql.jdbc.Driver");
		// } catch (PropertyVetoException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/company");
		// dataSource.setUser("root");
		// dataSource.setPassword("1234");

		ComboPooledDataSource dataSource = new ComboPooledDataSource("mysql");
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet rs = null;

		try {
			connection = dataSource.getConnection();
			String sql = "select * from student limit ?,?";
			statement = connection.prepareStatement(sql);
			int start = (pageNum - 1) * pageSize;
			int end = pageSize;
			statement.setInt(1, start);
			statement.setInt(2, end);
			rs = statement.executeQuery();

			// ORM

			ResultSetHandler<List<Student>> handler = new BeanListHandler<Student>(
					Student.class);
			results = handler.handler(rs);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			try {
				rs.close();
				statement.close();
				connection.close();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
		return results;

	}

}
