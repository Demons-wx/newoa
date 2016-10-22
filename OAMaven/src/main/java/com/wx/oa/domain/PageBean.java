package com.wx.oa.domain;

import java.util.List;

/**
 * 分页中的一页信息
 * @author Demons
 *
 */
public class PageBean {

	// 页面参数
	private int currentPage; // 当前页
	private int pageSize; // 每页显示多少条
	
	// 查询数据库
	private int recordCount; // 总记录数
	private List recordList; // 本页的数据列表
	
	// 计算得到的信息
	private int pageCount; // 总页数
	private int beginPageIndex; // 页码列表的开始索引
	private int endPageIndex; // 页码列表的结束索引
	
	public PageBean(int currentPage, int pageSize, int recordCount, List recordList){
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.recordCount = recordCount;
		this.recordList = recordList;
		
		// 计算总页码
		pageCount = (recordCount + pageSize - 1) / pageSize;
		
		// 计算开始索引和结束索引
		if(pageCount <= 10){
			beginPageIndex = 1;
			endPageIndex = pageCount;
		}else{
			// 显示当前页附近的10页
			beginPageIndex = currentPage - 4;
			endPageIndex = currentPage + 5;
			// 当前面页码不足4个时，则显示前10个页码
			if(beginPageIndex < 1){
				beginPageIndex = 1;
				endPageIndex = 10;
			}
			// 当后面页码不足5个时，则显示后面10个页码
			if(endPageIndex > pageCount){
				endPageIndex = pageCount;
				beginPageIndex = pageCount - 10 + 1;
			}
		}
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public List getRecordList() {
		return recordList;
	}
	public int getPageCount() {
		return pageCount;
	}
	public int getBeginPageIndex() {
		return beginPageIndex;
	}
	public int getEndPageIndex() {
		return endPageIndex;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public void setBeginPageIndex(int beginPageIndex) {
		this.beginPageIndex = beginPageIndex;
	}
	public void setEndPageIndex(int endPageIndex) {
		this.endPageIndex = endPageIndex;
	}
	
	
}
