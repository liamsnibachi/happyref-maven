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

public class LogoutAction extends Action{
	
	private final String SUCCES = "succes";
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException {
		
		String forward = SUCCES;
		
		//récupération de la session HTTP de l'utilisateur
		HttpSession session = request.getSession();
		session.invalidate();
		//retourne un objet de classe ActionForward
		return mapping.findForward(forward);
	}

}
