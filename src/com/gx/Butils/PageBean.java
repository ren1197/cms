package com.gx.Butils;

import java.io.Serializable;

public class PageBean implements Serializable {
	private int pageNo=1;//当前页
	private int pageSize=9;//每一页显示的条数
	private int totalCount;//总条数
	 
	private int nextPage;//下一页
	private int prevPage;//上一页
	private int totalPage;//总页数
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getNextPage() {
		if(this.getPageNo()==this.getTotalPage()){
			return this.getPageNo();
		}else{
		return this.getPageNo()+1;
		}
	}
	
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public int getPrevPage() {
		if(this.getPageNo()==1){
			return this.getPageNo();
		}else{
		return this.getPageNo()-1;
		}
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getTotalPage() {
		if(this.getTotalCount()%this.getPageSize()==0){
			return this.getTotalCount()/this.getPageSize();
		}else{
			return this.getTotalCount()/this.getPageSize()+1;
		}
		
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}
