package com.sistemi.informativi.vo;

import java.io.Serializable;

public class CompanyVO implements Serializable{
	private String vatNumber;
	private String businessName;
	private String ddressLocation;
	private int employeesNumber;
	
	
	
	protected CompanyVO() {
		super();
	}

	@Override
	public String toString() {
		return "CompanyVO [vatNumber=" + vatNumber + ", businessName=" + businessName + ", ddressLocation="
				+ ddressLocation + ", employeesNumber=" + employeesNumber + "]";
	}

	public CompanyVO(String vatNumber, String businessName, String ddressLocation, int employeesNumber) {
		super();
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
