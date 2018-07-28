package cn.scut.service;

import cn.scut.domain.PageBean;

public interface StudentService {
	PageBean getPageBean(int pageNum,int pageSize);
}
