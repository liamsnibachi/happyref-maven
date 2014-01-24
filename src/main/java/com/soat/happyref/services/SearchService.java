package com.soat.happyref.services;

import java.util.ArrayList;

import com.soat.happyref.beans.Book;
import com.soat.happyref.exceptions.TechniqueException;

public interface SearchService {
	
	public ArrayList<Book> getBookList(String categoryId, String word) throws TechniqueException;

}
