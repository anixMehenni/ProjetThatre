<%@page import="beans.Comedien"%>
<%@page import="beans.Personne"%>
<%@page import="beans.Role"%>

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
		<h3 class="text-center display-4 my-5">Cr�ation pi�ce de th��tre </h3>
		
		
		<form method="POST" enctype="multipart/form-data">
			<div class="row">
				<div class="col">			
					<div class="form-group">
					    <label for="nom">Nom</label>
					    <input type="text" class="form-control" id="nom" name="nom">
				    </div>
				    <div class="form-group">
					    <label for="auteur">Auteur</label>
					    <input type="text" class="form-control" id="auteur" name="auteur">
				    </div>
				    <div class="form-group">
					    <label for="description">D�scription</label>
					    <textarea class="form-control" id="description" rows="5" name="description"></textarea>
					</div>
					<div class="form-group">
					    <label for="photos">Photos</label>
					    <input type="file" class="form-control-file" id="photos" name="photos" multiple="true">
					</div>
				</div>			
				
				<div class="col" id="rightSide">
					<div class="mb-5">
						<h6>Com�diens</h6>
						
						<div class="row">
							<div class="col">
								<label for="comediens">Com�dien</label>						    
							</div>
							<div class="col">							
								<label for="rolesComediens">R�le</label>	
							</div>
							<div class="col-1"></div>
						</div>
						
						<div class="row my-2">
							<div class="col">
								<select name="comediens" class="form-control">
							        <option value=""></option>
									<% for (Comedien comedien: (ArrayList<Comedien>) request.getAttribute("comediens")) { %>
										<option value="<%= comedien.getId() %>"><%= comedien.getNom() %></option>
									<% } %>
							    </select>						    
							</div>
							<div class="col">						
						    	<input type="text" class="form-control" name="rolesComediens">	
							</div>
							<div class="col-1">										
								<button type="button" class="btn btn-outline-danger" data-target="comediens">-</button>
							</div>
						</div>
						
						<div class="row justify-content-center mt-3" id="addComedienBtn">			
							<button type="button" class="btn btn-outline-primary">+</button>
						</div>	
					</div>
					
					<div>					
						<h6>Equipe Technique</h6>
						<div class="row">
							<div class="col">							
								<label for="rolesPersonnes">R�le</label>	
							</div>
							<div class="col">
								<label for="personnes">Personne</label>						    
							</div>
							<div class="col-1"></div>
						</div>
						<div class="row my-2">
							<div class="col">						
								<select name="rolesPersonnes" class="form-control">
							        <option value=""></option>
									<% for (Role role: (ArrayList<Role>) request.getAttribute("roles")) { %>
										<option value="<%= role.getId() %>"><%= role.getNom() %></option>
									<% } %>
							    </select>	
							</div>
							<div class="col">
								<select name="personnes" class="form-control">
							        <option value=""></option>
									<% for (Personne personne: (ArrayList<Personne>) request.getAttribute("personnes")) { %>
										<option value="<%= personne.getId() %>"><%= personne.getNom() %></option>
									<% } %>
							    </select>						    
							</div>							
							<div class="col-1">										
								<button type="button" class="btn btn-outline-danger" data-target="personnes">-</button>
							</div>
						</div>						
						
						<div class="row justify-content-center mt-3" id="addEquipeTechniqueBtn">			
							<button type="button" class="btn btn-outline-primary">+</button>
						</div>	
					</div>
				</div>
			</div>
				  					
			<div class="row justify-content-center my-3">			
				<button type="submit" class="btn btn-primary">Cr�er</button>
			</div>
		</form>
	</div>
	

<script type="text/javascript" src="/ProjetTheatre/js/pieceForm.js"></script>

</body>
<%@ include file="/pages/shared/Footer.jsp" %>