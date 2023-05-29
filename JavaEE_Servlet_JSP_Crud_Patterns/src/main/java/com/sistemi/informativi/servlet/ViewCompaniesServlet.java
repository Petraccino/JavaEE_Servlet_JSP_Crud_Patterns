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

import com.sistemi.informativi.sql.SqlScript;
import com.sistemi.informativi.vo.CompanyVO;
import com.sistemi.informativi.dao.CompanyDAO;
import com.sistemi.informativi.dao.CompanyDAOImpl;
import com.sistemi.informativi.key.Key;
import com.sistemi.informativi.pages.Page;

@WebServlet("/companies")
public class ViewCompaniesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ViewCompaniesServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		CompanyDAO companyDAO = new CompanyDAOImpl();
		ArrayList<CompanyVO> companies = null;
		try {
			companies = companyDAO.fienAllCompanies(SqlScript.findAllCompany);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		if (!companies.isEmpty()) {
			HttpSession session = request.getSession();
			session.setAttribute(Key.companies, companies);
			response.sendRedirect(Page.companies);
		} else {
			response.sendRedirect(Page.error);
		}
	}

}
