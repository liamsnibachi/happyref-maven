package com.soat.happyref.beans;

import java.util.HashSet;
import java.util.Set;

public class Category {
	private Integer id;
	private String name;
	private Set<Book> bookSet = new HashSet<Book>();

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setBookSet(Set<Book> bookSet) {
		this.bookSet = bookSet;
	}

	public Set<Book> getBookSet() {
		return bookSet;
	}

}
