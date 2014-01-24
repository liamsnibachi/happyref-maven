package com.soat.happyref.services.imp;

import com.soat.happyref.beans.User;
import com.soat.happyref.dao.UserDAO;
import com.soat.happyref.dao.UserDAOImp;
import com.soat.happyref.exceptions.FonctionnelleException;
import com.soat.happyref.services.UserService;

/**
 * @author formation
 *
 */
public class UserServiceImp implements UserService {
	private UserDAO userDAO= new UserDAOImp();

	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Override
	public void insertUser(String mail, String nom, String prenom,
			String password) throws FonctionnelleException {
		User user = this.getUserDAO().getUserById(mail);
		if(user!=null){
			throw new FonctionnelleException("Cette adresse e-mail est déjà utilisée!");
		}
		this.getUserDAO().insertUser(mail, nom, prenom, password);
	}

	@Override
	public User getUserById(String mail) {
		User user = this.getUserDAO().getUserById(mail);
		return user;
	}
	
	@Override
	public User login(String mail, String password){
		User user = this.getUserDAO().getUserById(mail);
		if(user!=null && password!=null && password.equals(user.getPassword())){
			return user;
		}
		return null;
	}
}
