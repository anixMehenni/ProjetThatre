<%@page import="beans.Organisateur"%>
<%@page import="beans.Sponsor"%>

<%@ include file="./shared/Header.jsp" %>
	<h1>Création Festival </h1>
	<img src="/assets/ccf-dedup.PNG"/>
	<form method="POST" enctype="multipart/form-data">
		<label for="nom">Photos :</label>
		<br>
		<input type="file" name="photos" multiple="true" />
		<br>
		
		<label for="nom">Nom :</label>
		<br>
  		<input type="text" id="nom" name="nom">
  		<br>
  		
  		<label for="ville">Ville :</label>
		<br>
  		<input type="text" id="ville" name="ville">
  		<br>
  		
		<label for="description">Description :</label>
		<br>
		<textarea id="description" name="description" rows="5" cols="33"></textarea>
  		<br>
  		
  		<label for="dateDebut">Date Debut :</label>
		<br>
		<input type="date" id="dateDebut" name="dateDebut"/>
  		<br>
  		
  		<label for="dateFin">Date Fin :</label>
		<br>
		<input type="date" id="dateFin" name="dateFin"/>
  		<br>
  		
  		<label for="organisateurs">Organisateurs :</label>
		<br>
		<select name="organisateurs">
			<option value=""></option>
			<% for (Organisateur organisateur: (ArrayList<Organisateur>) request.getAttribute("organisateurs")) { %>
				<option value="<%= organisateur.getId() %>"><%= organisateur.getNom() %></option>
			<% } %>
		</select>
		<br>
		<select name="organisateurs">
			<option value=""></option>
			<% for (Organisateur organisateur: (ArrayList<Organisateur>) request.getAttribute("organisateurs")) { %>
				<option value="<%= organisateur.getId() %>"><%= organisateur.getNom() %></option>
			<% } %>
		</select>
		<br>
  				
		<label for="sponsors">Sponsors :</label>
		<br>
		<select name="sponsors">
			<option value=""></option>
			<% for (Sponsor sponsor: (ArrayList<Sponsor>) request.getAttribute("sponsors")) { %>
				<option value="<%= sponsor.getId() %>"><%= sponsor.getNom() %></option>
			<% } %>
		</select>
		<br>
		<select name="sponsors">
			<option value=""></option>
			<% for (Sponsor sponsor: (ArrayList<Sponsor>) request.getAttribute("sponsors")) { %>
				<option value="<%= sponsor.getId() %>"><%= sponsor.getNom() %></option>
			<% } %>
		</select>
		
		
		<button type="submit">Créer</button>
	</form>
<%@ include file="./shared/Footer.jsp" %>