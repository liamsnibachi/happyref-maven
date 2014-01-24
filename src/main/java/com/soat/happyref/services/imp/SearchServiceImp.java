package com.soat.happyref.services.imp;

import java.util.ArrayList;

import com.soat.happyref.beans.Book;
import com.soat.happyref.dao.BookDAO;
import com.soat.happyref.dao.BookDAOHibernateImp;
import com.soat.happyref.exceptions.TechniqueException;
import com.soat.happyref.services.SearchService;

/**
 * @author formation
 *
 */
public class SearchServiceImp implements SearchService {
	
	/**
	 * Book DAO
	 */
	private BookDAO bookDAO = new BookDAOHibernateImp();
	
	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	public ArrayList<Book> getBookList(String categoryId, String word) throws TechniqueException {
		ArrayList<Book> books = new ArrayList<Book>();
		
		if(categoryId!=null && !"".equals(categoryId)){
			books = this.getBookDAO().getBooksByCategory(categoryId);
		}else if(word!=null && !"".equals(word)){
			books = this.getBookDAO().getBooksByKeyWord(word);
		}else{
			books = this.getBookDAO().getAllBooks();
		}
		return books;
	}

}
