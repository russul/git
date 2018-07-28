package cn.scut.test;

import cn.scut.dao.StudentDao;
import cn.scut.dao.impl.StudentDaoImpl;
import cn.scut.domain.Student;

public class testAdd {
	public static void main(String[] args) {
		StudentDao studentDao = new StudentDaoImpl();
		studentDao.add(new Student());
	}
}
