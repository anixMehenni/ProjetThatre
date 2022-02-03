<%@page import="beans.Piece"%>


<%
	java.text.DateFormat df = new java.text.SimpleDateFormat("dd/M/YYYY"); 
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
			      <th scope="col">Nom</th>
			      <th scope="col">Auteur</th>			      
			      <th scope="col">Représentations</th>			          
			      <th scope="col">Commentaires</th>			          
			      <th scope="col">Note</th>
			      <th scope="col">Date de création</th>
			      <th class="text-right" scope="col">Actions</th>
			    </tr>
		    </thead>
		    <tbody>
				<% for (Piece piece : (List<Piece>) request.getAttribute("pieces")) { %>
					<tr scope="row">
						<td><%= piece.getNom() %></td>
						<td><%= piece.getAuteur() %></td>
						<td class="text-center"><%= piece.getRepresentations().size() %></td>
						<td class="text-center"><%= piece.getCommentaires().size() %></td>						
						<td class="text-center">
							<%= piece.getCommentaires()
								.stream()
								.mapToDouble(c -> c.getNote())
								.average()
								.orElse(0)
							%>
						</td>
						<td class="text-center"><%= df.format(piece.getDateCreation()) %></td>						
						<td class="text-right">							
							<a href="/ProjetTheatre/representation/add?piece=<%= piece.getId() %>">
								<button class="btn btn-outline-primary">
									+ Représentation
								</button>
							</a>
							<a href="/ProjetTheatre/piece/view?id=<%= piece.getId() %>">
								<button class="btn btn-outline-info">
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