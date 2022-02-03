<%@ page language="java" contentType="text/html"%>

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

<title>Creation du nouveau compte modérateur</title>

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
	<div class="d-lg-flex half">
		<div class="bg order-1 order-md-2"
			style="background-image: url('/ProjetTheatre/images/bg_1.jpg');"></div>
		<div class="contents order-2 order-md-1">
			<div class="container">
				<div class="row align-items-center justify-content-center">
					<div class="col-md-7 py-5">
						<h3>
							<strong>Nouveau compte modérateur</strong>
						</h3>
						<form action="/ProjetTheatre/CreationCompteModerateurServlet"
							method="post">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group first">
										<label for="name">Nom</label> <input type="text"
											class="form-control" placeholder="Nom" name="nom" id="nom"
											required />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group first">
										<label for="father_name">Prénom</label> <input type="text"
											class="form-control" placeholder="Prénom" name="prenom"
											id="prenom" required />
									</div>
								</div>
							</div>

							<div class="row">
								<div class="col-md-12">
									<div class="form-group first">
										<label for="address">Email</label> <input type="email"
											class="form-control" placeholder="example@email.com"
											name="email" id="email" required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group first">
										<label for="address">Numéro de téléphone</label> <input
											type="tel" class="form-control" name="telephone"
											pattern="[0-9]{10}" placeholder="06XXXXXXXX" id="telephone"
											required />
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group first">
										<label for="address">Adresse</label> <input type="text"
											class="form-control" placeholder="Adresse postale"
											name="adresse" id="adresse" required />
									</div>
								</div>
							</div>

							<div class="form-group fourth">
								<label for="address">Mot de passe</label> <input type="password"
									class="form-control" placeholder="Mot de Passe"
									name="motDePasse" id="motDePasse" required />
							</div>
							<div class="form-group">
								<label for="exampleFormControlSelect2">Sélectionner le type du compte</label> <select multiple class="form-control"
									name="type" id="type" required>
									<option>Abonné</option>
									<option>Modérateur</option>
								</select>
							</div>

							<input type="submit" value="Créer un compte"
								class="btn btn-block btn-primary" name="submit" id="submit" />
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- JS -->
	<script type="text/javascript"
		src="/ProjetTheatre/js/jquery-3.3.1.min.js"></script>
	<script type="text/javascript" src="/ProjetTheatre/js/popper.min.js"></script>
	<script type="text/javascript" src="/ProjetTheatre/js/bootstrap.min.js"></script>
	<script type="text/javascript" src="/ProjetTheatre/js/main.js"></script>

</body>
</html>