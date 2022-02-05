<%@page import="beans.Festival"%>

<%
	java.text.DateFormat df = new java.text.SimpleDateFormat("dd/MM/YYYY"); 
%>
	
<%@ include file="/pages/shared/Header.jsp" %>

<div class="container">
	<div class="d-flex flex-column align-items-center my-5">
		<h1>Liste des festivals</h1>
		<a href="/ProjetTheatre/festival/create">
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
			      <th class="text-center" scope="col">Ville</th>	
			      <th class="text-center" scope="col">Organisateurs</th>
			      <th class="text-center" scope="col">Sponsors</th>				      
			      <th class="text-center" scope="col">Représentations</th>	
			      <th class="text-center" scope="col">Date de début</th>			      
			      <th class="text-center" scope="col">Date de fin</th>
			      <th class="text-center" scope="col">Date de création</th>
			      <th class="text-right" scope="col">Actions</th>
			    </tr>
		    </thead>
		    <tbody>
				<% for (Festival festival : (List<Festival>) request.getAttribute("festivals")) { %>
					<tr scope="row">
						<td><%= festival.getNom() %></td>
						<td><%= festival.getVille() %></td>						
						<td>
							<%= festival.getOrganisateurs()
								.stream().map(o -> o.getNom())
								.collect(Collectors.joining(", "))
							%>
						</td>
						<td>
							<%= festival.getSponsors()
								.stream().map(o -> o.getNom())
								.collect(Collectors.joining(", "))
							%>
						</td>						
						<td class="text-center"><%= festival.getRepresentations().size() %></td>						
						<td class="text-center"><%= df.format(festival.getDateDebut()) %></td>
						<td class="text-center"><%= df.format(festival.getDateFin()) %></td>
						<td class="text-center"><%= df.format(festival.getDateCreation()) %></td>						
						<td class="text-right">	
							<a href="/ProjetTheatre/bo/piece">
								<button class="btn btn-outline-primary my-1">
									+ Représentation
								</button>
							</a>
							<a class="my-1" href="/ProjetTheatre/festival/view?id=<%= festival.getId() %>">
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