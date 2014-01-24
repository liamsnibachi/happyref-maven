package com.soat.happyref.struts.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.validator.DynaValidatorForm;

import com.soat.happyref.beans.User;
import com.soat.happyref.exceptions.FonctionnelleException;
import com.soat.happyref.services.UserService;
import com.soat.happyref.services.imp.UserServiceImp;

public class SubscribeAction extends Action{
	
	private UserService userService = new UserServiceImp();
	private final String SUCCES = "succes";
	private final String ERROR = "error";
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException {
		
		HttpSession session = request.getSession();
		String forward = ERROR;
		
		DynaValidatorForm  dynaForm = (DynaValidatorForm)form;
		
		String mail = dynaForm.getString("mail");
		String nom = dynaForm.getString("nom");
		String prenom = dynaForm.getString("prenom");
		String password = dynaForm.getString("password");
		
		// les précondition sont valides on peut executer le corps de la méthode
		try {
			userService.insertUser(mail, nom, prenom, password);
			User user = userService.getUserById(mail);
			session.setAttribute("user", user);
			forward = SUCCES;
		} catch (FonctionnelleException e) {
			//String insertReturn = e.getMessage();
			session.invalidate();
			//request.setAttribute("error", insertReturn);
			forward = ERROR;
		}
		//retourne un objet de classe ActionForward
		return mapping.findForward(forward);
	}

}
