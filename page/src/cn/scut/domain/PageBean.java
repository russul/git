package cn.scut.domain;

import java.util.List;

public class PageBean {
	
	private int pageNum;
	private int pageSize;
	private int totalRecord;
	private int totalPage;

	private List<Student> list;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
	}

	public void setTotalPage() {
		this.totalPage = this.getTotalPage();
	}

	public int getTotalPage() {
		if (totalRecord % pageSize == 0) {
			totalPage = totalRecord / pageSize;

		} else {
			totalPage = totalRecord / pageSize + 1;
		}

		return totalPage;
	}

	public List<Student> getList() {
		return list;
	}

	public void setList(List<Student> list) {
		this.list = list;
	}
}
