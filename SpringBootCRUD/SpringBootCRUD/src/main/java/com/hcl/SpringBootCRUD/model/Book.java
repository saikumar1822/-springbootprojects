package com.hcl.SpringBootCRUD.model;

import javax.persistence.Entity;

@Entity
public class Book {
	public int bookId;
	public String bookName;
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	

}
