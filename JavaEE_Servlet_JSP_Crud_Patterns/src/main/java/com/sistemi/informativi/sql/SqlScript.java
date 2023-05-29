package com.sistemi.informativi.sql;

public interface SqlScript {
	final String insertCompany="INSERT INTO company(vat_number, business_name, address_location, employees_number) VALUES (?,?,?,?)";
	final String findAllCompany = "SELECT * FROM company";
	final String deleteCompany= "DELETE FROM company WHERE vat_number=?";
	final String updateCompany="UPDATE company SET business_name=?,address_location=?,employees_number=? WHERE vat_number=?";
	final String sqlOnlyCompanySelect="SELECT * FROM `company` WHERE vat_number=?";
}
