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

@WebServlet("/update")
public class UpdateCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateCompanyServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String vatNumber = request.getParameter("vatNumber");
		String businessName = request.getParameter("businessName");
		String addressLocation = request.getParameter("addressLocation");
		String employeesNumber = request.getParameter("employeesNumber");
		
		
		ArrayList<CompanyVO> companies = new ArrayList<>();
		CompanyVO companyVO = new CompanyVO(vatNumber, businessName, addressLocation,Integer.parseInt(employeesNumber));
		CompanyDAO companyDAO = new CompanyDAOImpl();
		
		int updateRow= 0;
		
		try {
			updateRow = companyDAO.updateCompany(companyVO, SqlScript.updateCompany);
			companies = companyDAO.fienAllCompanies(SqlScript.findAllCompany);
			
		} catch (ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}
		if (updateRow > 0 && !companies.isEmpty()) {
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
