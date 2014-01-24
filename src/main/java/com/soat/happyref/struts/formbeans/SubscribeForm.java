package com.soat.happyref.struts.formbeans;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.DynaActionForm;

public class SubscribeForm extends DynaActionForm{

	private static final long serialVersionUID = -428115730935191113L;
	
	public ActionErrors validate(ActionMapping mapping, HttpServletRequest request) {
		// gestion des erreurs
		ActionErrors errors = new ActionErrors();
		String nom = this.getString("nom");
		String prenom = this.getString("prenom");
		String mail = this.getString("mail");
		String password = this.getString("password");
		String password2 = this.getString("password2");
		
		//Vérifier les champs obligatoires
		if (mail == null || "".equals(mail.trim())){
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("errors.mailvide", "<li>L\'adresse e-mail est obligatoire !</li>"));		
		}
		if (nom == null || "".equals(nom.trim())){
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("errors.nomvide", "<li>Le nom est obligatoire !</li>"));		
		}
		if (prenom == null || "".equals(prenom.trim())){
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("errors.prenomvide", "<li>Le prénom est obligatoire !</li>"));		
		}
		if( password == null || "".equals(password.trim())){
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("errors.passwordvide", "<li>Le mot de passe est obligatoire !</li>"));		
		}
		//vérifier la validité de l'adresse e-mail
		if(mail != null && !"".equals(mail.trim()) && !mail.matches("^[a-zA-Z0-9\\._-]+@[a-zA-Z0-9\\.-]{2,}[\\.][a-zA-Z]{2,4}$")){
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("errors.mailinvalide", "<li>Le format de l\'adresse e-mail n'est pas valide !</li>"));		
		}
		//vérifier que le mot de passe est confirmé
		if((password!=null) && !(password.equals(password2)) ){
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("errors.password2", "<li>Veuillez confirmez votre mot de passe !</li>"));		
		}
		//vérifier que le mot de passe comprends au moins 6 caractères
		if(password != null && !"".equals(password.trim()) && password.length() < 6){
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("errors.passwordlength", "<li>Le mot de passe comporte au moins 6 caractères !</li>"));		
		}
		
		return errors;
	}
}
