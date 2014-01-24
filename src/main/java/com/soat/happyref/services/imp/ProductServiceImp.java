package com.soat.happyref.services.imp;

import org.apache.log4j.Logger;

import com.soat.happyref.beans.Book;
import com.soat.happyref.dao.BookDAO;
import com.soat.happyref.dao.BookDAOHibernateImp;
import com.soat.happyref.exceptions.FonctionnelleException;
import com.soat.happyref.services.ProductService;

/**
 * @author formation
 *
 */
public class ProductServiceImp implements ProductService {
	
	private BookDAO bookDAO = new BookDAOHibernateImp();
	public BookDAO getBookDAO() {
		return bookDAO;
	}

	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	private final static Logger logger = Logger.getLogger(ProductServiceImp.class);

	public Book getBookById(String idBook) throws FonctionnelleException {
		Book book = new Book();
		
			if((idBook!=null) && (!"".equals(idBook))){
				book = this.getBookDAO().getBookById(idBook);
				if(book==null){
					logger.warn("Ce livre est introuvable : " + idBook);
					throw new FonctionnelleException("Une erreur fonctionnelle s'est produite : aucun livre référencé avec l'isbn (" + idBook+").");
				}
			}
		
		return book;
	}

}
