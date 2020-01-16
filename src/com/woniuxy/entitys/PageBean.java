package com.woniuxy.entitys;

import java.util.List;

public class PageBean<T> {
	private int totalCount;//������
	private int pageSize;//ÿҳ��ʾ����Ŀ��
	private int currentPage;//��ǰҳ��
	private int pages;//��ҳ��
	private List<T> data;//ÿҳ��ʾ������
	
	public PageBean() {
		super();
	}

	public PageBean(int totalCount, int pageSize, int currentPage, int pages, List<T> data) {
		super();
		this.totalCount = totalCount;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.pages = pages;
		this.data = data;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public List<T> getData() {
		return data;
	}

	public void setData(List<T> data) {
		this.data = data;
	}

	public int getPages() {
		return pages=totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
	}

	@Override
	public String toString() {
		return "PageBean [totalCount=" + totalCount + ", pageSiza=" + pageSize + ", currentPage=" + currentPage
				+ ", pages=" + pages + ", data=" + data + "]";
	}
	

}
