<%@page import="beans.Utilisateur"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="_UTILISATEUR_COURANT"
	class="beans.Utilisateur" scope="session"></jsp:useBean>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Connexion r�ussie </title>
</head>
<body>
	<table style="width: 20%">
		<%
		Utilisateur currentUser = (Utilisateur) session.getAttribute("_UTILISATEUR_COURANT");
		if (currentUser == null) {
			System.out.println("Liste operations est a null");
		}
		%>

        
        <tr><td>
<tr><td><%=currentUser.getPrenom()%></td></tr>


				
<tr></tr><tr><td></td><td><a href="login.jsp"><b>Logout</b></a></td></tr>
</table>
</body>
</html>