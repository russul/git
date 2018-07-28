package cn.scut.service.impl;

import java.util.List;

import cn.scut.dao.StudentDao;
import cn.scut.dao.impl.StudentDaoImpl;
import cn.scut.domain.PageBean;
import cn.scut.domain.Student;
import cn.scut.service.StudentService;

public class StudentServiceImpl implements StudentService{
	
	private StudentDao studentDao=new StudentDaoImpl();
	@Override
	public PageBean getPageBean(int pageNum, int pageSize) {
		int totalRecord = studentDao.getTotalRecord();
		List<Student> results= studentDao.findAll(pageNum,pageSize);
		PageBean pageBean = new PageBean();
		pageBean.setList(results);
		pageBean.setPageNum(pageNum);
		pageBean.setPageSize(pageSize);
		pageBean.setTotalRecord(totalRecord);
		pageBean.setTotalPage();
		
		
		return pageBean;
	}

}
