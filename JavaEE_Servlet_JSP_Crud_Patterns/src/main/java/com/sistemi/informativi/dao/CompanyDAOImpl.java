package com.sistemi.informativi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sistemi.informativi.connection.ConnectionManager;
import com.sistemi.informativi.dto.CompanyDTO;
import com.sistemi.informativi.sql.SqlScript;
import com.sistemi.informativi.vo.CompanyVO;

public class CompanyDAOImpl implements CompanyDAO {
	public int addCompany(CompanyDTO companyDTO, String sqlCompanyInsert) throws SQLException, ClassNotFoundException {
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sqlCompanyInsert);
		ps.setString(1, companyDTO.getVatNumber());
		ps.setString(2, companyDTO.getBusinessName());
		ps.setString(3, companyDTO.getAddressLocation());
		ps.setInt(4, companyDTO.getEmployeesNumber());
		return ps.executeUpdate();
	}

	public ArrayList<CompanyVO> fienAllCompanies(String sql) throws SQLException, ClassNotFoundException {
		CompanyVO companyVO;
		ArrayList<CompanyVO> companies = new ArrayList<>();
		ResultSet rs = ConnectionManager.getResultSet(sql);
		while (rs.next()) {
			companyVO = new CompanyVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
			companies.add(companyVO);
		}
		return companies;

	}

	@Override
	public int deleteCompany(String sql, String vatNumber) throws SQLException, ClassNotFoundException {
		PreparedStatement ps = ConnectionManager.getPreparedStatement(sql);
		ps.setString(1, vatNumber);
		return ps.executeUpdate();
	}

	@Override
	public int updateCompany(CompanyVO companyVO, String sql) throws SQLException, ClassNotFoundException {
		PreparedStatement ps= ConnectionManager.getPreparedStatement(SqlScript.updateCompany);
		ps.setString(1, companyVO.getBusinessName());
		ps.setString(2, companyVO.getAddressLocation());
		ps.setInt(3, companyVO.getEmployeesNumber());
		ps.setString(4, companyVO.getVatNumber());
		return ps.executeUpdate();
	}
	@Override
	public CompanyVO selectCompany(String sqlSelectCompany, String vatNumber) throws ClassNotFoundException, SQLException {
	 CompanyVO companyVO = null;
		PreparedStatement ps = ConnectionManager.getPreparedStatement(SqlScript.sqlOnlyCompanySelect);
		ps.setString(1, vatNumber);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			companyVO = new CompanyVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
		}
		return companyVO;
	}
	

}
