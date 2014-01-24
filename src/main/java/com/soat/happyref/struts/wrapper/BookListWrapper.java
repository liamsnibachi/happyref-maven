package com.soat.happyref.struts.wrapper;

import java.util.ArrayList;

import com.soat.happyref.beans.Book;

public class BookListWrapper {
	
	private ArrayList<Book> books;
	
	public BookListWrapper(){
		super();
	}
	
	public BookListWrapper(ArrayList<Book> books) {
		super();
		this.books = books;
	}

	/**
	 * @return the books
	 */
	public ArrayList<Book> getBooks() {
		return books;
	}

	/**
	 * @param books the books to set
	 */
	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	
	
	

}
