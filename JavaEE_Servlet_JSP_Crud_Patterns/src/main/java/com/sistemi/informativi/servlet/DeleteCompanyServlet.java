package com.sistemi.informativi.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sistemi.informativi.dao.CompanyDAO;
import com.sistemi.informativi.dao.CompanyDAOImpl;
import com.sistemi.informativi.key.Key;
import com.sistemi.informativi.pages.Page;
import com.sistemi.informativi.sql.SqlScript;
import com.sistemi.informativi.vo.CompanyVO;

@WebServlet("/delete")
public class DeleteCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeleteCompanyServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String vatNumber = request.getParameter("vatNumber");
		/*
		 * corrisponde al nome della variabile inviata nell'url composto
		 */
		ArrayList<CompanyVO> companies = new ArrayList<>();
		int numbDelete = 0;
		CompanyDAO companyDAO = new CompanyDAOImpl();
		try {
			numbDelete = companyDAO.deleteCompany(SqlScript.deleteCompany, vatNumber);
			companies = companyDAO.fienAllCompanies(SqlScript.findAllCompany);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if (numbDelete > 0 && !companies.isEmpty()) {
			/*
			 * nel caso positivo viene salvata la lista companies che contien le nuova
			 * companies esistendi adesso dopo l'operazione di cancellazione
			 * in tal mod ola companies.jsp lanciata succesivamente potrà recuperare 
			 */
			HttpSession session = request.getSession();
			session.setAttribute(Key.companies, companies);
			response.sendRedirect(Page.companies);
		} else {
			response.sendRedirect(Page.error);
		}
	}

}
