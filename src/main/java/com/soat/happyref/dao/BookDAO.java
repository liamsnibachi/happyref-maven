package com.soat.happyref.dao;

import java.util.ArrayList;

import com.soat.happyref.beans.Book;
import com.soat.happyref.exceptions.TechniqueException;

/**
 * @author formation
 *
 */
public interface BookDAO {
	
	public ArrayList<Book> getAllBooks();
	public ArrayList<Book> getBooksByCategory(String categoryId);
	public Book getBookById(String id);
	public ArrayList<Book> getBooksByKeyWord(String id) throws TechniqueException;

}
