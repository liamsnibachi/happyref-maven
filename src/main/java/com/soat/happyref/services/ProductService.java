package com.soat.happyref.services;

import com.soat.happyref.beans.Book;
import com.soat.happyref.exceptions.FonctionnelleException;

public interface ProductService {
	
	public Book getBookById(String id) throws FonctionnelleException;

}
