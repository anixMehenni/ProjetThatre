<%@page import="beans.Organisateur"%>
<%@page import="beans.Sponsor"%>

<%@ include file="/pages/shared/Header.jsp" %>

<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<meta charset="ISO-8859-1">


<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">
<!-- Header styling --> 
<link href="/ProjetTheatre/css/headerStyle.css" rel="stylesheet" type="text/css" />

<link
      rel="stylesheet"
      href="/ProjetTheatre/css/A.style.css.pagespeed.cf.2hpsIU3gX-.css"
    />
</head>

<body>
	<div class="container">	
		<h3 class="text-center my-5">Création festival</h3>
	
		<form method="POST" enctype="multipart/form-data">
			<div class="row">
				<div class="col">
					<div class="form-group">
					    <label for="nom">Nom</label>
					    <input type="text" class="form-control" id="nom" name="nom">
				    </div>
				    
				    <div class="form-group">
					    <label for="ville">Ville</label>
					    <input type="text" class="form-control" id="ville" name="ville">
				    </div>
				    
				    <div class="form-group">
					    <label for="description">Déscription</label>
					    <textarea class="form-control" id="description" rows="5" name="description"></textarea>
					</div>
					
					<div class="row">
						<div class="col">
							<div class="form-group">
							    <label for="dateDebut">Début</label>
							    <input type="date" class="form-control" id="dateDebut" name="dateDebut">
						    </div>
						</div>
						<div class="col">
							<div class="form-group">
							    <label for="dateFin">Fin</label>
							    <input type="date" class="form-control" id="dateFin" name="dateFin">
						    </div>
						</div>			
					</div>
					
					<div class="form-group">
					    <label for="photos">Photos</label>
					    <input type="file" class="form-control-file" id="photos" name="photos" multiple="true">
					</div>
				</div>
				
				<div class="col" id="rightSide">
						<div class="mb-5">			
							<label for="organisateurs">Organisateurs</label>	
							
							<div class="row my-2">
								<div class="col">
									<select name="organisateurs" class="form-control">
								        <option value=""></option>
										<% for (Organisateur organisateur: (ArrayList<Organisateur>) request.getAttribute("organisateurs")) { %>
											<option value="<%= organisateur.getId() %>"><%= organisateur.getNom() %></option>
										<% } %>
								    </select>						    
								</div>
								<div class="col-1">										
									<button type="button" class="btn btn-outline-danger" data-target="organisateurs">-</button>
								</div>
							</div>
							
							<div class="row justify-content-center mt-3" id="addOrganisateurBtn">			
								<button type="button" class="btn btn-outline-primary">+</button>
							</div>	
						</div>
						
						<div>					
							<label for="sponsors">Sponsors</label>	
							
							<div class="row my-2">
								<div class="col">
									<select name="sponsors" class="form-control">
								        <option value=""></option>
										<% for (Sponsor sponsor: (ArrayList<Sponsor>) request.getAttribute("sponsors")) { %>
											<option value="<%= sponsor.getId() %>"><%= sponsor.getNom() %></option>
										<% } %>
								    </select>						    
								</div>
								<div class="col-1">										
									<button type="button" class="btn btn-outline-danger" data-target="sponsors">-</button>
								</div>
							</div>
							
							<div class="row justify-content-center mt-3" id="addSponsorBtn">			
								<button type="button" class="btn btn-outline-primary">+</button>
							</div>
						</div>
					</div>			
			</div>
			
			<div class="row justify-content-center my-3">			
				<button type="submit" class="btn btn-primary">Créer</button>
			</div>
		</form>
	</div>
<script type="text/javascript" src="/ProjetTheatre/js/festivalForm.js"></script>
</body>
<%@ include file="/pages/shared/Footer.jsp" %>