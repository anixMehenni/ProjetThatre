
<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
    
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>    
<%@ page import="java.util.stream.Collectors"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


<title>${ !empty pageName ? pageName : 'Theatre JAVA' }</title>
</head>
<body>
<script type="text/javascript" src="/ProjetTheatre/js/jquery-3.3.1.min.js"></script>
<nav class="navbar navbar-expand-lg navbar-light justify-content-between" style="background-color: #e3f2fd;">
<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  
   <div class="collapse navbar-collapse float-right" id="navbarNavAltMarkup">
    <div class="navbar-nav float-right">
      <a class="nav-item nav-link" href="#">Accueil <span class="sr-only">(current)</span></a>
      <a class="nav-item nav-link" href="#">Pièces populaires</a>
      <a class="nav-item nav-link" href="/ProjetTheatre/ConnexionAbonneServlet">Se connecter</a>
    </div>
  </div>
</nav>
</body>
