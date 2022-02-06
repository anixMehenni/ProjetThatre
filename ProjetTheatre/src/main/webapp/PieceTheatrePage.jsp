<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/pages/shared/Header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

<!-- Bootstrap Style 
<link rel="stylesheet" href="/ProjetTheatre/src/main/webapp/css/bootstrap.min.css">-->

<!-- Header styling --> 
<link href="/ProjetTheatre/css/headerStyle.css" rel="stylesheet" type="text/css" />

<link
      rel="stylesheet"
      href="/ProjetTheatre/css/A.style.css.pagespeed.cf.2hpsIU3gX-.css"
    />
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="/ProjetTheatre/css/festivalStyle.css" type="text/css">
<title><%
String nom = (String) request.getAttribute("nom");
out.print(nom);
%></title>
</head>
<body style="background-color:#8B0000 " >
	<h1 style="color:#FFFFFF "><%
out.print(nom);
%></h1>
	
	<h3 style="color:#FFFFFF ">Par</h3>
	<p style="color:#FFFFFF "><%
String auteur = (String) request.getAttribute("auteurPiece");
out.print(auteur);
%>
 </p>
	


       
      <div >
      	<img src="<%= request.getParameter("pic") %>"  alt="" />
      </div>
      
      <button>Reserver ma place</button>
      
<h3 style="color:#FFFFFF ">Description</h3>
<p style="text-align: justify; color:#FFFFFF" >
<%
String description = (String) request.getAttribute("description");
out.print(description);
%>
</p>
</ul>
</body>
</html>