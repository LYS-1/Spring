package com.home.spring.util;

public class Pagination {
	private Long startRow;
	private Long endRow;
	
	private Long page;
	private Long perPage;
	
	private Long startNum;
	private Long endNum;
	private Long perBlock;
	private Long totalPage;
	private Long totalBlock;
	private boolean after = false;
	
	//검색 종류(사용할 컬럼)
	private String kind;
	//검색어
	private String search; 
	
	
	
	
	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(search == null) {
			search = "";
		}
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}

	public Long getTotalPage() {
		return totalPage;
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
		this.perPage = 5L;
		this.perBlock = 5L;
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
		
		
		this.totalBlock = this.totalPage / this.getPerBlock();
		if(this.totalPage % this.getPerBlock() != 0) {
			this.totalBlock ++;
		}
		
		Long curBlock = this.page / this.getPerBlock();
		if(this.page % this.getPerBlock() != 0) {
			curBlock ++;
		}
		
		this.startNum = (curBlock - 1L) * this.getPerBlock() + 1L;
		this.endNum = (curBlock * this.getPerBlock());
		
		if(this.page >= this.totalPage) {
			this.after = true;
			this.endNum = this.totalPage;
		}
	}
	
	
	public Long getPerBlock() {
		return perBlock;
	}

	public void setPerBlock(Long perBlock) {
		this.perBlock = perBlock;
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
