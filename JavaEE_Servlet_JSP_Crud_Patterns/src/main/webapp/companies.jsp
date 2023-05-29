<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.sistemi.informativi.vo.CompanyVO"%>
<%@ page import="com.sistemi.informativi.key.Key"%>
<%@ page import="com.sistemi.informativi.pages.Page"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<CompanyVO> companies = (ArrayList<CompanyVO>) session.getAttribute(Key.companies);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Companies</title>
</head>
<body>
	<table align="center" border="1">
		<tr class="bold">
			<td>Vat Number</td>
			<td>Business Name</td>
			<td>Address Location</td>
			<td>Employees Number</td>
			<td>Action D</td>
			<td>Action UA</td>
			<td>Action U</td>
		</tr>
		<%
		for (int i = 0; i < companies.size(); i++) {
			;
		%>
		<form method="post" action="toUpdate">
			<!-- l'action può essere toUpdate o toupdate  -->
			<tr>
				<%
				String vatNumber = companies.get(i).getVatNumber();
				String businessName = companies.get(i).getBusinessName();
				String addressLocation = companies.get(i).getAddressLocation();
				int employeesNumber = companies.get(i).getEmployeesNumber();
				%>
				<td><input type="text" name="vatNumber" value="<%=vatNumber%>"
					readonly /></td>
				<td><input type="text" name="businessName"
					value="<%=businessName%>" readonly /></td>
				<td><input type="text" name="addressLocation"
					value="<%=addressLocation%>" readonly /></td>
				<td><input type="text" name="employeesNumber"
					value="<%=employeesNumber%>" readonly /></td>
				<td><a style="color: red; text-decoration: none;" href="delete?vatNumber=<%=vatNumber%>">delete</a></td>
				<td><a style="color: green; text-decoration: none;"
					href="toupdate?vatNumber=<%=vatNumber%>&businessName=<%=businessName%>&addressLocation=<%=addressLocation%>&employeesNumber=<%=employeesNumber%>">UpdateA</a></td>
				<td><input type="submit" value="update"></td>
			</tr>
		</form>
		<%
		}
		;
		%>
	</table>
	<table align="center">
		<tr>
			<td><a href="<%=Page.home%>">Home</a></td>
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