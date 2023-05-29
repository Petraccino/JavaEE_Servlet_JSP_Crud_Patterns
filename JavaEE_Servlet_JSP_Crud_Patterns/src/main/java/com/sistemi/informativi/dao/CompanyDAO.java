package com.sistemi.informativi.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.sistemi.informativi.dto.CompanyDTO;
import com.sistemi.informativi.vo.CompanyVO;

public interface CompanyDAO {
	public int addCompany(CompanyDTO companyDTO, String sqlCompanyInsert) throws SQLException, ClassNotFoundException;

	public ArrayList<CompanyVO> fienAllCompanies(String sql) throws SQLException, ClassNotFoundException;
	
	public int deleteCompany(String sql,String vatNumber)throws SQLException, ClassNotFoundException;
	
	public int updateCompany(CompanyVO companyVO,String sql)throws SQLException, ClassNotFoundException;
	
	public CompanyVO selectCompany(String sqlSelectCompany, String vatNumber)throws ClassNotFoundException,SQLException;
}
