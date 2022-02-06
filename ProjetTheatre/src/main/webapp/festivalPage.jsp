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
<body style="background-color:#f8f9fa;" >
<div class="container">
  <div class="row my-3 justify-content-center">
  	<div class="col-6">
			<p class="display-4 text-center font-weight-bold"><%
	String nomFestival = (String) request.getAttribute("nomFestival");
	out.println(nomFestival);
	%></p>
    </div>
  </div>
</div>
<div class="container">
  <div class="row">
  	<div class="col-6">
			<p class="h4 text-center font-weight-bold">Dates</p>
	<p class="h6 text-center">Du 
	<%
	Date date = (Date) request.getAttribute("DateDebutFestival");
	   out.print(date.toString());
	%> au 
	<%
	Date dateFin = (Date) request.getAttribute("DateFinFestival");
	   out.print(dateFin.toString());
	%>
	</p>
    </div>
    <div class="col-6">
  		<p class="h3 text-center font-weight-bold">Lieu</p>
	<p class="h6 text-center"><%
	String ville = (String) request.getAttribute("villeFestival");
	   out.print(ville);
	%> </p>
    </div>
  </div>
</div>
	
<div class="container">
  <div class="row">
  <div class="col"></div>
  	<div class="col-10">
	<p class="h3 font-weight-bold">A l'affiche !</p>
    </div>
    <div class="col"></div>
  </div>
</div>
	
	
	


<% List<String> photos = (List<String>) request.getAttribute("photos"); %>
<% List<String> Ids = (List<String>) request.getAttribute("Ids"); %>
<% List<String> organisateurs = (List<String>) request.getAttribute("organisateurs"); %>

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
								<a href="/ProjetTheatre/piece/view?id=<%= Ids.get(0) %>">
								<div class="img d-flex align-items-center justify-content-center" style="background-image: url(<%= photos.get(0) %>);">
										
									</div>
								</a>
									
								</div>
							</div>
							<div class="item">
								<div class="work">
									<a href="/ProjetTheatre/piece/view?id=<%= Ids.get(0) %>">
								<div class="img d-flex align-items-center justify-content-center" style="background-image: url(<%= photos.get(0) %>);">
										
									</div>
								</a>
								</div>
							</div>
							<div class="item">
								<div class="work">
									<a href="/ProjetTheatre/piece/view?id=<%= Ids.get(0) %>">
								<div class="img d-flex align-items-center justify-content-center" style="background-image: url(<%= photos.get(0) %>);">
										
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

<div class="container">
  <div class="row">
  	<div class="col-8">
  		<p class="h3">Historique du festival</p>
		<p style="text-align:justify" >
			<%
				String descriptif = (String) request.getAttribute("descriptionFestival");
	   			out.print(descriptif);
			%>
		</p>
    </div>
  </div>
</div>

<div class="container">
  <div class="row">
  	<div class="col-6">
  		<p class="h3">Organisateurs</p>
			<p >
				<% for(int i = 0; i < organisateurs.size(); i+=1) { %>
				<p>
            <% out.println(organisateurs.get(i)); %>;
            </p>
        <% } %>
			</p>
    </div>
  </div>
</div>


<div class="container">
  <div class="row">
  	<div class="col-6">
  		<p class="h3">Sponsors</p>
			<p >
				<%
					String response3 = (String) request.getAttribute("sponsor");
					out.println(response3);
				%>
			</p>
    </div>
  </div>
</div>


<ul>

	
</ul>
    <script src="/ProjetTheatre/js/jquery.min.js"></script>
    <script src="/ProjetTheatre/js/popper.js"></script>
    <script src="/ProjetTheatre/js/bootstrap.min.js"></script>
    <script src="/ProjetTheatre/js/owl.carousel.min.js"></script>
    <script src="/ProjetTheatre/js/main_carousel.js"></script>
</body>
</html>