package com.soat.happyref.dao;

import com.soat.happyref.beans.User;

public interface UserDAO {
	
	public User getUserById(String mail);
	
	public void insertUser(String mail, String nom, String prenom, String password);

}
