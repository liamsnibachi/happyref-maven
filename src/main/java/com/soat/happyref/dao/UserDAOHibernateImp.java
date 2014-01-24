package com.soat.happyref.dao;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.soat.happyref.beans.User;
import com.soat.happyref.hibernate.util.HibernateUtil;

/**
 * @author formation
 *
 */
public class UserDAOHibernateImp implements UserDAO{

	@SuppressWarnings("unchecked")
	@Override
	public User getUserById(String mail) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		ArrayList<User> resultList = (ArrayList<User>) session.createQuery("from User where mail = ?").setString(0, mail).list();
		tx.commit();

        if (resultList.isEmpty()) {
        	return null;
		}
        return resultList.get(0);
	}

	@Override
	public void insertUser(String mail, String nom, String prenom, String password) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		User theUser = new User(mail, nom, prenom, password);
		
		HibernateUtil.getSessionFactory().getCurrentSession().save(theUser);
		
		tx.commit();
	}

		
}
