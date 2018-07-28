package cn.scut.dao;

import java.util.List;

import cn.scut.domain.Student;

public interface StudentDao {
	void add(Student student);
	int getTotalRecord();
	public List<Student> findAll(int pageNum,int pageSize);
	
}
