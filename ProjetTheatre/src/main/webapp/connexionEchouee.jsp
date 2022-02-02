<%@page import="beans.Utilisateur"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:useBean id="_UTILISATEUR_COURANT"
	class="beans.Utilisateur" scope="session"></jsp:useBean>
	
	
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Connexion réussie </title>
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
<tr><td>Email et/ou mot de passe erroné</td></tr>

				
<tr><td><a href="login.jsp"><b>Veuillez réessayer</b></a></td></tr>
</table>
</body>
</html>