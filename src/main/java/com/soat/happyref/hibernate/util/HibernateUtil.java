package com.soat.happyref.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static final SessionFactory sessionFactory = buildSessionFactory();

	private static SessionFactory buildSessionFactory() {
		try {
			// lecture de hibernate.cfg.xml et création de la configuration
			return new Configuration().configure().buildSessionFactory();
		} catch (Throwable ex) {
			// log les exceptions
			System.err.println("L'initialisation de Hibernate à échouée." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
}
