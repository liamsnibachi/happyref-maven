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

import com.soat.happyref.beans.User;
import com.soat.happyref.services.UserService;
import com.soat.happyref.services.imp.UserServiceImp;
import com.soat.happyref.struts.formbeans.LoginForm;

public class LoginAction extends Action{
	
	private UserService userService = new UserServiceImp();
	private final String SUCCES = "succes";
	private final String ERROR = "globalLogin";
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException {
		
		String forward = SUCCES;
		
		if(form != null){
			//récupération de la session HTTP de l'utilisateur
			HttpSession session = request.getSession();
			
			//récupération des identifiants à partir du Bean
			String mail = ((LoginForm) form).getMail();
			String password = ((LoginForm) form).getPassword();
			
			User user = userService.login(mail, password);
			if(user!=null){
				session.setAttribute("user", user);
				forward = SUCCES;
			}else{
				forward = ERROR;
			}
		}
		//retourne un objet de classe ActionForward
		return mapping.findForward(forward);
	}

}
