/**
 * Action de recherche des livres
 * @author Atef TALBI
 */
package com.soat.happyref.struts.action;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;

import com.soat.happyref.beans.Book;
import com.soat.happyref.services.SearchService;
import com.soat.happyref.services.imp.SearchServiceImp;

public class SearchAction extends Action{
	
	private final static Logger logger = Logger.getLogger(SearchAction.class);
	
	private final String SUCCESS = "succes";
	private final String ERROR = "error";
	private SearchService searchService = new SearchServiceImp();
	
	public ActionForward execute(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException,ServletException {
		String forward = SUCCESS;
		String categoryId = request.getParameter("categoryId");
		String word = request.getParameter("word");
		ActionErrors errors = new ActionErrors();
		try{
			ArrayList<Book> books = searchService.getBookList(categoryId, word);
			if((books==null) || (books.size()==0)){
				forward = ERROR;
				errors.add(ActionErrors.GLOBAL_MESSAGE, new ActionMessage("errors.aucun.resultat"));
			}else{
				forward = SUCCESS;
				request.setAttribute("resultset", books);
			}
		}catch(Exception e){
			logger.error("Une erreur s'est produite lors de la récupération de la liste des livres : " + e.getMessage());
			forward = ERROR;
		}
		saveErrors(request, errors);
		//retourne un objet de classe ActionForward
		return mapping.findForward(forward);
	}

}
