package com.soat.happyref.struts.formbeans;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

public class LoginForm extends ActionForm{
	
	private static final long serialVersionUID = 3017063471766281578L;
	
	private String mail;
	private String password;
	/**
	 * @return the login
	 */
	public String getMail() {
		return mail;
	}
	/**
	 * @param login the login to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// gestion des erreurs
		ActionErrors errors = new ActionErrors();
		
		// le nom doit être non vide
		if (this.mail == null || "".equals(this.mail.trim())){
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("errors.mailvide", "<li>L\'adresse e-mail est obligatoire !</li>"));		
		}
		
		if( this.password == null || "".equals(this.password.trim())){
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("errors.passwordvide", "<li>Le mot de passe est obligatoire !</li>"));		
		}
		
		if(this.password != null && !"".equals(this.password.trim()) && this.password.length() < 6){
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("errors.passwordlength", "<li>Le mot de passe comporte au moins 6 caractères !</li>"));		
		}
		
		if(this.mail != null && !"".equals(this.mail.trim()) && !this.mail.matches("^[a-zA-Z0-9\\._-]+@[a-zA-Z0-9\\.-]{2,}[\\.][a-zA-Z]{2,4}$")){
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("errors.mailinvalide", "<li>Le format de l\'adresse e-mail n'est pas valide !</li>"));		

		}
		return errors;
		
	}
	
}
