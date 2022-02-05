<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.io.*,java.util.*, javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/pages/shared/Header.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
    
     <link href="https://fonts.googleapis.com/css?family=Poppins:300,400,500,600,700,800,900" rel="stylesheet">
		
		<link rel="stylesheet" href="/ProjetTheatre/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/ProjetTheatre/css/owl.theme.default.min.css">
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/4.5.6/css/ionicons.min.css">
		<link rel="stylesheet" href="/ProjetTheatre/css/style.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="background-color:#8B0000 " >
	<h1 style="color:#FFFFFF "><%
	String nomFestival = (String) request.getAttribute("nomFestival");
	out.println(nomFestival);
	%></h1>
	<h4 style="color:#FFFFFF ">Dates</h4>
	<p style="color:#FFFFFF ">Du 
	<%
	Date date = (Date) request.getAttribute("DateDebutFestival");
	   out.print(date.toString());
	%> au 
	<%
	Date dateFin = (Date) request.getAttribute("DateFinFestival");
	   out.print(dateFin.toString());
	%>
	</p>
	<h3 style="color:#FFFFFF ">Lieu</h3>
	<p style="color:#FFFFFF "><%
	String ville = (String) request.getAttribute("villeFestival");
	   out.print(ville);
	%> </p>
	
<h3 style="color:#FFFFFF ">A l'affiche !</h3>

<% List<String> photos = (List<String>) request.getAttribute("photos"); %>
<% List<String> Ids = (List<String>) request.getAttribute("Ids"); %>

<div class="container">
  <div class="row">
    <div class="col">
    </div>
    <div class="col" style="max-height:70rem;min-width:45rem" >
      <section class="ftco-section">
			<div class="container">
				<div class="row">
					<div class="col-md-12">
						<div class="hero featured-carousel owl-carousel">
							<div class="item">
								<div class="work">
								<a href="/ProjetTheatre/VisualiserPiece?id=<%= Ids.get(0) %>&pic=<%= photos.get(0) %>">
								<div class="img d-flex align-items-center justify-content-center" style="background-image: url(<%= photos.get(0) %>);">
										
									</div>
								</a>
									
								</div>
							</div>
							<div class="item">
								<div class="work">
									<a href="/ProjetTheatre/VisualiserPiece?id=<%= Ids.get(0) %>&pic=<%= photos.get(1) %>">
								<div class="img d-flex align-items-center justify-content-center" style="background-image: url(<%= photos.get(1) %>);">
										
									</div>
								</a>
								</div>
							</div>
							<div class="item">
								<div class="work">
									<a href="/ProjetTheatre/VisualiserPiece?id=<%= Ids.get(0) %>&pic=<%= photos.get(2) %>">
								<div class="img d-flex align-items-center justify-content-center" style="background-image: url(<%= photos.get(2) %>);">
										
									</div>
								</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>


    </div>
    <div class="col">
    </div>
  </div>
</div>

<h3 style="color:#FFFFFF ">Historique du festival</h3>
<p style="text-align: justify;color:#FFFFFF" >
<%
	String descriptif = (String) request.getAttribute("descriptionFestival");
	   out.print(descriptif);
	%>
</p>
<h3 style="color:#FFFFFF ">Sponsors</h3>
<p style="color:#FFFFFF ">
<%
	String response3 = (String) request.getAttribute("sponsor");
	out.println(response3);
	%>
</p>
<ul>

	
</ul>
    <script src="/ProjetTheatre/js/jquery.min.js"></script>
    <script src="/ProjetTheatre/js/popper.js"></script>
    <script src="/ProjetTheatre/js/bootstrap.min.js"></script>
    <script src="/ProjetTheatre/js/owl.carousel.min.js"></script>
    <script src="/ProjetTheatre/js/main_carousel.js"></script>
</body>
</html>