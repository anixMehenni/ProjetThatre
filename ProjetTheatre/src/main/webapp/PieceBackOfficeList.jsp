<%@page import="beans.Piece"%>
<%@page import="beans.Commentaire"%>

<%
	java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/YYYY"); 
%>
	
<%@ include file="/pages/shared/Header.jsp" %>

<div class="container">
	<div class="d-flex flex-column align-items-center my-5">
		<h1>Liste des pieces</h1>
		<a href="/ProjetTheatre/piece/create">
			<button class="btn btn-primary">
				+ Créer
			</button>
		</a>
	</div>
	
	
	<div class="d-flex justify-content center align-items-center">
		<table class="table table-striped">
			<thead>
			    <tr>
			      <th class="text-center" scope="col">Nom</th>
			      <th class="text-center" scope="col">Auteur</th>			      
			      <th class="text-center" scope="col">Représentations</th>			          
			      <th class="text-center" scope="col">Commentaires validés</th>				          
			      <th class="text-center" scope="col">Commentaires à valider</th>			          
			      <th class="text-center" scope="col">Commentaires rejetés</th>				          
			      <th class="text-center" scope="col">Note</th>
			      <th class="text-center" scope="col">Date de création</th>
			      <th class="text-right" scope="col">Actions</th>
			    </tr>
		    </thead>
		    <tbody>
				<% for (Piece piece : (List<Piece>) request.getAttribute("pieces")) { %>
					<tr scope="row">
						<td><%= piece.getNom() %></td>
						<td><%= piece.getAuteur() %></td>
						<td class="text-center"><%= piece.getRepresentations().size() %></td>
						
						<% 
							int commentairesAValider = piece.getCommentaires(Commentaire.StatutEnum.CREE).size();
							int commentairesValides = piece.getCommentaires(Commentaire.StatutEnum.VALIDE).size();
							int commentairesRejetes = piece.getCommentaires(Commentaire.StatutEnum.REJETE).size();
						%>
						<td class="text-center text-success">
							<%= commentairesValides %>
						</td>
						<td class="text-center text-warning">
							<%= commentairesAValider %>
						</td>	
						
						<td class="text-center text-danger">
							<%= commentairesRejetes %>
						</td>					
						<td class="text-center"><%= piece.getMoyenne()%></td>
						<td class="text-center"><%= df.format(piece.getDateCreation()) %></td>						
						<td class="text-right">							
							<a href="/ProjetTheatre/representation/add?piece=<%= piece.getId() %>">
								<button class="btn btn-outline-primary my-1">
									+ Représentation
								</button>
							</a>
							<a class="my-1" href="/ProjetTheatre/piece/view?id=<%= piece.getId() %>">
								<button class="btn btn-outline-info my-1">
									Voir
								</button>
							</a>
						</td>
					</tr>
				<% } %>
		    </tbody>
		</table>
	</div>
</div>

<%@ include file="/pages/shared/Footer.jsp" %>