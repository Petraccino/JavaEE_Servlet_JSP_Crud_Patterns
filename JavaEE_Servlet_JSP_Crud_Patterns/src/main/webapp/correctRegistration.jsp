<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@ page import="com.sistemi.informativi.dto.CompanyDTO" %>
    <%@ page import="com.sistemi.informativi.key.Key"%>
    <%@ page import="com.sistemi.informativi.pages.Page"%>
        <!DOCTYPE html>
        <% String businessName= (String) session.getAttribute(Key.bussinessName); %>
            <html>

            <head>
                <meta charset="ISO-8859-1">
                <title>Correct Registration</title>
            </head>

            <body>
                <%="Registrazione evvenuta correttamente della company " + businessName %>
                
                <a href=<%=Page.home%>>Home</a>
</body>

</html>