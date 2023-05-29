package com.sistemi.informativi.dto;

import java.io.Serializable;

public class CompanyDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String vatNumber;
	private String businessName;
	private String ddressLocation;
	private int employeesNumber;

	public CompanyDTO() {
	}

	public CompanyDTO(String vatNumber, String businessName, String ddressLocation, int employeesNumber) {
		this.vatNumber = vatNumber;
		this.businessName = businessName;
		this.ddressLocation = ddressLocation;
		this.employeesNumber = employeesNumber;
	}

	public String getVatNumber() {
		return vatNumber;
	}

	public void setVatNumber(String vatNumber) {
		this.vatNumber = vatNumber;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}

	public String getAddressLocation() {
		return ddressLocation;
	}

	public void setAddressLocation(String ddressLocation) {
		this.ddressLocation = ddressLocation;
	}

	public int getEmployeesNumber() {
		return employeesNumber;
	}

	public void setEmployeesNumber(int employeesNumber) {
		this.employeesNumber = employeesNumber;
	}

}
