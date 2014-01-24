package com.soat.happyref.services;

import com.soat.happyref.beans.User;
import com.soat.happyref.exceptions.FonctionnelleException;

public interface UserService {
	public void insertUser(String mail, String nom, String prenom, String password) throws FonctionnelleException;
	public User getUserById(String mail);
	public User login(String mail, String password);
}
