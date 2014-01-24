package com.soat.happyref.beans;

import java.util.HashSet;
import java.util.Set;

/**
 * @author formation
 *
 */
public class Book {
	private Integer id;
	private String isbn;
	private String title;
	private String author;
	private String imageName;
	private String shortDescription;
	private String longDescription;
	private Set<Category> categorySet = new HashSet<Category>();
	private Set<Rent> rentSet = new HashSet<Rent>();
	
	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public Book(){
		super();
	}
	
	public Book(String isbn, String title, String author, String imageName,
			String shortDescription, String longDescription) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.author = author;
		this.imageName = imageName;
		this.shortDescription = shortDescription;
		this.longDescription = longDescription;
	}

	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public void setCategorySet(Set<Category> categorySet) {
		this.categorySet = categorySet;
	}

	public Set<Category> getCategorySet() {
		return categorySet;
	}

	public void setRentSet(Set<Rent> rentSet) {
		this.rentSet = rentSet;
	}

	public Set<Rent> getRentSet() {
		return rentSet;
	}
}
