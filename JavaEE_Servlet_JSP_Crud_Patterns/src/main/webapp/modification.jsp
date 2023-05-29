<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.sistemi.informativi.vo.CompanyVO"%>
    <%@ page import="com.sistemi.informativi.key.Key"%>
    <%@ page import="com.sistemi.informativi.pages.Page"%>
<!DOCTYPE html>
<% CompanyVO company = (CompanyVO) session.getAttribute(Key.company); %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modifica</title>
</head>
<body>

<table align="center" border="1">
<%
				String vatNumber = company.getVatNumber();
				String businessName = company.getBusinessName();
				String addressLocation = company.getAddressLocation();
				int employeesNumber = company.getEmployeesNumber();
				%>
<h1 align="center">Update to <%=businessName%></h1>
		


		<form method="post" action="update">

			<tr>

				

				<td><input type="text" name="vatNumber" value="<%=vatNumber%>" readonly/></td>
				<td><input type="text" name="businessName"
					value="<%=businessName%>"/></td>
				<td><input type="text" name="addressLocation"
					value="<%=addressLocation%>"/></td>
				<td><input type="text" name="employeesNumber"
					value="<%=employeesNumber%>"/></td>
				<td><input type="submit" value="update"></td>

			</tr>

		</form>


		

	</table>

	<table align="center">

		<tr>

			<td><a href=<%=Page.home%>>Home</a></td>

		</tr>

	</table>

</body>
<style>
.bold {
font-weight: bold;
}
td,input,a {
text-align: center;
}
</style>
</html>