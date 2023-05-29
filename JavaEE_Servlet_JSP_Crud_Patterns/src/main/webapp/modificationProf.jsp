<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.sistemi.informativi.dto.CompanyDTO"%>
    <%@ page import="com.sistemi.informativi.key.Key"%>
<!DOCTYPE html>
<% CompanyDTO company = (CompanyDTO) session.getAttribute(Key.company); %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modification Prof</title>
</head>
<body>
<h1 align="center">Company Registration</h1>
	<form align="center" method="post" action="update"> <!-- Questo serve per registrare  -->
		<label for="vatNumber">Vat Number</label> <input type="text" name="vatNumber" value="<%=company.getVatNumber()%>" readonly>
		<br></br>
		<label for="businessName">Business Name</label> <input type="text" name="businessName" value="<%=company.getBusinessName() %>">
		<br></br>
		<label for="addressLocation">Address Location</label> <input type="text" name="addressLocation" value="<%=company.getAddressLocation()%>">
		<br></br>
		<label for="employeesNumber">Employees Number</label> <input type="text" name="employeesNumber" value="<%=company.getEmployeesNumber() %>">
		<br></br>
		<input type="submit" value="Update">
	</form>
</body>
</html>