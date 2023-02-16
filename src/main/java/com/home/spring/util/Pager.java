package com.home.spring.util;

public class Pager {
	private Long startRow;
	private Long lastRow;
	
	//클라이언트가 보고싶은 페이지 번호
	private Long page;
	
	//한 페이지에 출력할 ROW 개수 
	private Long perPage;
	
	//전체 row의 갯수를 담을 변수
	//private Long totalCount;
	
	private Long startNum;
	private Long lastNum;
	private Long totalBlock;
	private Long totalPage;
	private boolean after = false;
	
	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}
	
	

	public boolean isAfter() {
		return after;
	}

	public void setAfter(boolean after) {
		this.after = after;
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

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

//	public Long getTotalCount() {
//		return totalCount;
//	}
//
//	public void setTotalCount(Long totalCount) {
//		this.totalCount = totalCount;
//	}

	public Pager() {
		this.perPage = 10L;
		this.page = 1L;
	}
	
	//startRow, lastRow 계산하는 메서드
	public void makeRow() {
		this.startRow = (this.page - 1L) * this.perPage + 1L;
		this.lastRow = this.page * this.perPage;
	}
	//startNum, lastNum
	public void makeNum(Long totalCount) {
		//1. 전체 로우의 갯수를 알아야함
		
		//2. 총 페이지의 갯수를 구해야함
		this.totalPage = totalCount/this.getPerPage();
		if(totalCount % this.getPerPage() != 0) {
			this.totalPage ++;
		}
		
		//3. 한 블럭에 출력할 번호의 갯수 = 5개
		Long perBlock = 5L;
		
		//4. 총 블럭의 수
		this.totalBlock = this.totalPage / perBlock;
		if(this.totalPage % perBlock != 0) {
			this.totalBlock ++;
		}
		
		//5. page 번호로 현재 블럭 번호 구하기
		// page 1~5 cur 1,  page 6~10 cur2
		Long curBlock = this.page / perBlock;
		if(this.page % perBlock != 0) {
			curBlock ++;
		}
		
		//6.현재 블럭 번호에 블럭의 시작번호와 끝번호를 계산
		// curBlock = 1 시작 번호 = 1 마지막 번호 = 5
		// curBlock = 2 시작 번호 = 6 마지막 번호 = 10
		this.startNum = (curBlock - 1L) * perBlock + 1L;
		this.lastNum = curBlock * perBlock;
		
		if(this.lastNum > this.totalPage) {
			this.after = true;
			this.lastNum = this.totalPage;
		}
	}
	
	public Long getPerPage() {
		if(this.perPage==null || this.perPage==0) {
			this.perPage=10L;
		}
		return perPage;
	}
	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}
	public Long getPage() {
		if(this.page == null || this.page < 1) {
			this.page = 1L;
		}
		return page;
	}
	public void setPage(Long page) {
		this.page = page;
	}
	public Long getStartRow() {
		return startRow;
	}
	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}
	public Long getLastRow() {
		return lastRow;
	}
	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}
	
	
}
