package cn.scut.test;

import java.beans.PropertyVetoException;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import cn.scut.dao.StudentDao;
import cn.scut.dao.impl.StudentDaoImpl;
import cn.scut.domain.Student;
import cn.scut.orm.BeanHandler;
import cn.scut.orm.BeanListHandler;
import cn.scut.orm.ResultSetHandler;
import cn.scut.orm.SclarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class test {

//	@Test
//	public void testBeanHandler() {
//		// 1、和数据库建立链接，得到连接池对象
//		ComboPooledDataSource dataSource = new ComboPooledDataSource();
//		try {
//			dataSource.setDriverClass("com.mysql.jdbc.Driver");
//		} catch (PropertyVetoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/company");
//		dataSource.setUser("root");
//		dataSource.setPassword("1234");
//
//		Connection connection = null;
//		PreparedStatement statement = null;
//		ResultSet rs = null;
//
//		try {
//			connection = dataSource.getConnection();
//			String sql = "select * from student where id=?";
//			statement = connection.prepareStatement(sql);
//			statement.setInt(1, 1);
//			rs = statement.executeQuery();
//
//		} catch (Exception e) {
//			throw new RuntimeException();
//		}
//
//		// ORM
//		ResultSetHandler<Student> beanhandler = new BeanHandler<Student>(
//				Student.class);
//
//		Student student = null;
//		try {
//			student = (Student) beanhandler.handler(rs);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println(student);
//	}

//	@Test
//	public void testBeanListHandler() {
//		// 1、和数据库建立链接，得到连接池对象
//		ComboPooledDataSource dataSource = new ComboPooledDataSource();
//		try {
//			dataSource.setDriverClass("com.mysql.jdbc.Driver");
//		} catch (PropertyVetoException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/company");
//		dataSource.setUser("root");
//		dataSource.setPassword("1234");
//
//		Connection connection = null;
//		PreparedStatement statement = null;
//		ResultSet rs = null;
//
//		try {
//			connection = dataSource.getConnection();
//			String sql = "select * from student where gender=?";
//			statement = connection.prepareStatement(sql);
//			statement.setString(1, "男");
//			rs = statement.executeQuery();
//
//		} catch (Exception e) {
//			throw new RuntimeException();
//		}
//
//		// ORM
//		ResultSetHandler<List<Student>> beanhandler = new BeanListHandler<Student>(
//				Student.class);
//		
//		List<Student> list=null;
//		try {
//			list=beanhandler.handler(rs);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		for(int i=0;i<list.size();i++){
//			Student student=list.get(i);
//			System.out.println(student);
//		}
//	}
//	
//	@Test
//	public void testStudent() {
//		Student student= new Student();
//		student.setAge(5);
//		student.setId(5);
//		Student s1=student;
//		student.setAge(10);
//		student.setId(10);
//		Student s2=student;
//		//只通过set方法改变student的属性值，而没有改变引用，所以S1和S2是同一个对象，都是student
//		System.out.println(s1==s2);
//	}
	
	@Test
	public void testgetTotalRecord() {
		StudentDao studentDao=new StudentDaoImpl();
		int record=studentDao.getTotalRecord();
		System.out.println(record);
		

	}
	
//	@Test
//	public void testfindAll() {
//		StudentDao studentDao=new StudentDaoImpl();
//		List<Student> list=studentDao.findAll(6,10);
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i));
//		}
//	}

}
