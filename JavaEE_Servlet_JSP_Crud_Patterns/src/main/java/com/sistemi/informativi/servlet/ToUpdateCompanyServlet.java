package com.sistemi.informativi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sistemi.informativi.dto.CompanyDTO;
import com.sistemi.informativi.key.Key;
import com.sistemi.informativi.pages.Page;

/**
 * SERVLET FATTA IN CLASSE. IL PROF HA FATTO L'ESERCIZIO IN MANIERA DIVERSA DA
 * COME L'AVEVO IMPLEMENTATO IO
 */
@WebServlet("/toupdate")
public class ToUpdateCompanyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ToUpdateCompanyServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String vatNumber = request.getParameter("vatNumber");
		String businessName = request.getParameter("businessName");
		String addressLocation = request.getParameter("addressLocation");
		int employessNumber = Integer.parseInt(request.getParameter("employeesNumber"));

		CompanyDTO company = new CompanyDTO(vatNumber, businessName, addressLocation, employessNumber);

		if (company != null) {
			HttpSession session = request.getSession();
			session.setAttribute(Key.company, company);
			response.sendRedirect(Page.modificationProf);
		} else {
			response.sendRedirect(Page.error);
		}

	}

}
