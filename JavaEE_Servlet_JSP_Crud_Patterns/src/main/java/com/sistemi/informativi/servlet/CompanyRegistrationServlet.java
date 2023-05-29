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
import com.sistemi.informativi.dto.CompanyDTO;
import com.sistemi.informativi.key.Key;
import com.sistemi.informativi.sql.SqlScript;
import com.sistemi.informativi.pages.Page;

@WebServlet("/registration")
public class CompanyRegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CompanyRegistrationServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/*
		 * così andiamo a recuperare una ad una l'informazioni ( cioè il body ) dentro
		 * ogni input che ha come attributo d'appartenenza il parametro inserito nel
		 * metodo getParameters
		 */
		String vatNumber = request.getParameter("vatNumber");
		String businessName = request.getParameter("businessName");
		String addressLocation = request.getParameter("addressLocation");
		String employessNumber = request.getParameter("employessNumber");
		/*
		 * valorizzazione di un oggetto DTO con le informazioni recuperato dal client
		 * 
		 */
		CompanyDAO companyDAO = new CompanyDAOImpl();
		CompanyDTO companyDTO = new CompanyDTO(vatNumber, businessName, addressLocation,
				Integer.parseInt(employessNumber));
		/*
		 * gestione obbligata dell'eccezioni dato che non possiamo dichiararle nella
		 * firm adle metodo poichè violerebbe la firma del metodo doPost padre
		 */
		int numbAddCompany = 0;
		/*
		 * tramite il ritorno di addCompany che torna un int valorizziamo la variabile
		 * così da
		 */
		try {
			numbAddCompany = companyDAO.addCompany(companyDTO, SqlScript.insertCompany);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		if (numbAddCompany > 0) {
			HttpSession session = request.getSession();
			session.setAttribute(Key.bussinessName, companyDTO.getBusinessName());
			/*
			 * Storage di una reference DTO all'interno di un'istanza 
			 * Httpsession
			 */
			response.sendRedirect(Page.correctRegistration);
		} else {
			response.sendRedirect(Page.error);
		}

	}

}
