	package com.sistemi.informativi.servlet;

import java.io.IOException;
import java.sql.SQLException;

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

@WebServlet("/toUpdate")
public class UpdateCompanyAlternativeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateCompanyAlternativeServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String vatNumber = request.getParameter("vatNumber");
		CompanyVO company = null;
		
		CompanyDAO companyDAO = new CompanyDAOImpl();
		try {
			company = companyDAO.selectCompany(SqlScript.sqlOnlyCompanySelect, vatNumber);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if  (company!= null) {
			HttpSession session = request.getSession();
			session.setAttribute(Key.company, company );
			response.sendRedirect(Page.modification);
		} else {
			response.sendRedirect(Page.error);
		}
	}

}
