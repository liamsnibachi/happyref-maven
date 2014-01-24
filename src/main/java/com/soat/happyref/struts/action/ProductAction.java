package com.soat.happyref.struts.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.soat.happyref.beans.Book;
import com.soat.happyref.exceptions.FonctionnelleException;
import com.soat.happyref.services.ProductService;
import com.soat.happyref.services.imp.ProductServiceImp;

public class ProductAction extends Action{
	
	private ProductService productService = new ProductServiceImp();
	private final String SUCCES = "succes";
	private final String ERROR = "error";
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException {
		
		String forward = SUCCES;
		ActionErrors errors = new ActionErrors();
		String idBook = request.getParameter("id");
		try{
			
			Book book = productService.getBookById(idBook);
			if(book==null){
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("errors.isbn.inconnu",idBook));
				forward = ERROR;
			}else{
				request.setAttribute("book", book);
				forward = SUCCES;
			}
		}catch(FonctionnelleException fe){
			errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("errors.isbn.inconnu",idBook));
			forward = ERROR;
		}
		
		saveErrors(request,errors);
		//retourne un objet de classe ActionForward
		return mapping.findForward(forward);
	}

}

