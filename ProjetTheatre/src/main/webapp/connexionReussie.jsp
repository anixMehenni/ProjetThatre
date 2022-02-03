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
<!-- Header styling --> 
<link href="/ProjetTheatre/css/headerStyle.css" rel="stylesheet" type="text/css" />

<link
      rel="stylesheet"
      href="/ProjetTheatre/css/A.style.css.pagespeed.cf.2hpsIU3gX-.css"
    />
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
<tr><td><%=currentUser.getPrenom()%></td></tr>


				
<tr></tr><tr><td></td><td><a href="login.jsp"><b>Logout</b></a></td></tr>
</table>
</body>
</html>