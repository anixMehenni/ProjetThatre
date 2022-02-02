<%@page import="beans.Comedien"%>
<%@page import="beans.Personne"%>
<%@page import="beans.Role"%>

<%@ include file="./shared/Header.jsp" %>
	<div class="container">
		<h3 class="text-center my-5">Création pièce de théâtre </h3>
		
		
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
					    <label for="description">Déscription</label>
					    <textarea class="form-control" id="description" rows="5" name="description"></textarea>
					</div>
					<div class="form-group">
					    <label for="photos">Photos</label>
					    <input type="file" class="form-control-file" id="photos" name="photos" multiple="true">
					</div>
				</div>			
				
				<div class="col" id="rightSide">
					<div class="mb-5">
						<h6>Comédiens</h6>
						
						<div class="row">
							<div class="col">
								<label for="comediens">Comédien</label>						    
							</div>
							<div class="col">							
								<label for="rolesComediens">Rôle</label>	
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
								<label for="rolesPersonnes">Rôle</label>	
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
				<button type="submit" class="btn btn-primary">Créer</button>
			</div>
		</form>
	</div>
	

<script type="text/javascript" src="/ProjetTheatre/js/pieceForm.js"></script>
<%@ include file="./shared/Footer.jsp" %>