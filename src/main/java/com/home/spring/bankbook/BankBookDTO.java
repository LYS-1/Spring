package com.home.spring.bankbook;

public class BankBookDTO {
	private Long bookNumber;
	private String bookName;
	private Double bookRate;
	private Integer bookSale;
	private String bookDetail;
	
	
	public Long getBookNumber() {
		return bookNumber;
	}
	public void setBookNumber(Long bookNumber) {
		this.bookNumber = bookNumber;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public Double getBookRate() {
		return bookRate;
	}
	public void setBookRate(Double bookRate) {
		this.bookRate = bookRate;
	}
	public Integer getBookSale() {
		return bookSale;
	}
	public void setBookSale(Integer bookSale) {
		this.bookSale = bookSale;
	}
	public String getBookDetail() {
		return bookDetail;
	}
	public void setBookDetail(String bookDetail) {
		this.bookDetail = bookDetail;
	}
}
