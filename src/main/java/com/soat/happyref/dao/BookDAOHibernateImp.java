package com.soat.happyref.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.soat.happyref.beans.Book;
import com.soat.happyref.beans.Category;
import com.soat.happyref.exceptions.TechniqueException;
import com.soat.happyref.hibernate.util.HibernateUtil;

/**
 * @author formation
 * 
 */
public class BookDAOHibernateImp implements BookDAO {

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Book> getAllBooks() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		ArrayList<Book> result = (ArrayList<Book>) session.createQuery("from Book").list();
		tx.commit();
        return result;
	}

	@Override
	public ArrayList<Book> getBooksByCategory(String categoryId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		Integer categoryIdInt = Integer.parseInt(categoryId);
		
        Category category = (Category) session.load(Category.class, categoryIdInt);
       
		ArrayList<Book> resultList = new ArrayList<Book>();
		resultList.addAll(category.getBookSet());
		tx.commit();
		
        return resultList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Book getBookById(String isbn) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		ArrayList<Book> resultList = (ArrayList<Book>) session.createQuery("from Book where isbn = ?").setString(0, isbn).list();
		tx.commit();

        if (resultList.isEmpty()) {
        	return null;
		}
        return resultList.get(0);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Book> getBooksByKeyWord(String word) throws TechniqueException {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        ArrayList<Book> result = (ArrayList<Book>) session.createQuery("from Book where " +
        		"isbn like ? or " +
        		"author like ? or " +
        		"title like ? or " +
        		"long_description like ?")
        		.setString(0, "%" + word + "%")
        		.setString(1, "%" + word + "%")
        		.setString(2, "%" + word + "%")
        		.setString(3, "%" + word + "%")
        		.list();
        session.getTransaction().commit();
        return result;
	}

}
