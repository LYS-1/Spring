package com.company.home.util;

public class Pagination {
	private Long startRow;
	private Long endRow;
	
	private Long page;
	private Long perPage;
	
	private Long startNum;
	private Long endNum;
	
	private Long totalPage;
	private Long totalBlock;
	private boolean after = false;
	
	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public Long getTotalBlock() {
		return totalBlock;
	}

	public void setTotalBlock(Long totalBlock) {
		this.totalBlock = totalBlock;
	}
	
	
	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getEndNum() {
		return endNum;
	}

	public void setEndNum(Long endNum) {
		this.endNum = endNum;
	}

	public boolean isAfter() {
		return after;
	}

	public void setAfter(boolean after) {
		this.after = after;
	}

	public Pagination(){
		this.page = 1L;
		this.perPage = 10L;
	}
	
	public void makeRow() {
		this.startRow = (this.page - 1L) * this.perPage + 1L;
		this.endRow = (this.page * this.perPage);
	}
	
	public void makeBlock(Long totalCount) {
		this.totalPage = totalCount / this.perPage;
		if(totalCount % this.perPage != 0) {
			this.totalPage ++;
		}
		
		Long perBlock = 5L;
		
		this.totalBlock = this.totalPage / perBlock;
		if(this.totalPage % perBlock != 0) {
			this.totalBlock ++;
		}
		
		Long curBlock = this.page / perBlock;
		if(this.page % perBlock != 0) {
			curBlock ++;
		}
		
		this.startNum = (curBlock - 1L) * perBlock + 1L;
		this.endNum = (curBlock * perBlock);
		
		if(this.endNum > this.totalPage) {
			this.after = true;
			this.endNum = this.totalPage;
		}
	}
	
	
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getEndRow() {
		return endRow;
	}
	public void setEndRow(Long endRow) {
		this.endRow = endRow;
	}
	public Long getPage() {
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getPerPage() {
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	
	
}
