<%@ page language="java" contentType="text/html"%>

<%@page import="beans.Utilisateur"%>

<%@ include file="/pages/shared/Header.jsp"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<meta charset="ISO-8859-1">


<meta http-equiv="X-UA-Compatible" content="ie=edge">

<title>Profil utilisateur | Modifer vos informations</title>

<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap"
	rel="stylesheet">
<!-- Header styling -->
<link href="/ProjetTheatre/css/headerStyle.css" rel="stylesheet"
	type="text/css" />

<link rel="stylesheet"
	href="/ProjetTheatre/css/A.style.css.pagespeed.cf.2hpsIU3gX-.css" />
<!-- Style -->
<link rel="stylesheet" href="/ProjetTheatre/css/loginStyle.css">

<!-- Style -->
<link rel="stylesheet" href="/ProjetTheatre/css/owl.carousel.min.css">

<!-- Style -->
<link rel="stylesheet" href="/ProjetTheatre/css/icomoonstyle.css">


</head>
<body>
	<div class="container">
		<div class="row align-items-center">
			<div class="col">
				<%
				currentUser = (Utilisateur) session.getAttribute("_UTILISATEUR_COURANT");
				if (currentUser != null) {
				%>

				<div class="row align-items-center justify-content-center">

					<form action="/ProjetTheatre/GestionCompteServlet" method="post">
						<div class="row align-items-center justify-content-center">
							<h3>
								<strong>Modifer mes informations</strong>
							</h3>
						</div>
						<div class="row align-items-center justify-content-center">
							<div class="col">
								<div class="form-group first">
									<label for="name">Nom</label> <input type="text"
										class="form-control" placeholder="Nom" name="nom" id="nom"
										value="<%=currentUser.getNom()%>" required />
								</div>
							</div>
						</div>

						<div class="row align-items-center justify-content-center">
							<div class="col">
								<div class="form-group first">
									<label for="name">Prénom</label> <input type="text"
										class="form-control" placeholder="Prénom" name="prenom"
										id="prenom" value="<%=currentUser.getPrenom()%>" required />
								</div>
							</div>
						</div>

						<div class="row align-items-center justify-content-center">
							<div class="col">
								<div class="form-group first">
									<label for="address">Email</label> <input type="email"
										class="form-control" placeholder="example@email.com"
										name="email" id="email" value="<%=currentUser.getEmail()%>"
										required />
								</div>
							</div>
						</div>

						<div class="row align-items-center justify-content-center">
							<div class="col">
								<div class="form-group first">
									<label for="address">Numéro de téléphone</label> <input
										type="tel" class="form-control" name="telephone"
										pattern="[0-9]{10}" placeholder="06XXXXXXXX" id="telephone"
										value="<%=currentUser.getTelephone()%>" required />
								</div>
							</div>
						</div>

						<div class="row align-items-center justify-content-center">
							<div class="col">
								<div class="form-group first">
									<label for="address">Adresse</label> <input type="text"
										class="form-control" placeholder="Adresse postale"
										name="adresse" id="adresse"
										value="<%=currentUser.getAdresse()%>" required />
								</div>
							</div>
						</div>

						<div class="row align-items-center justify-content-center">
							<div class="col">
								<div class="form-group first">
									<label for="password">Mot de passe</label> <input
										type="password" class="form-control"
										placeholder="Mot de
											Passe" name="motDePasse"
										id="motDePasse" required
										value="<%=currentUser.getMotDePasse()%>" required />
								</div>
							</div>
						</div>

						<div class="row align-items-center justify-content-center">
							<div class="col-md-12">
								<input type="submit" value="Enregistrer"
									class="btn btn-block btn-primary" name="submit" id="submit" />
							</div>
						</div>
					</form>
				</div>

				<% } %>

			</div>
		</div>
	</div>
</body>
</html>