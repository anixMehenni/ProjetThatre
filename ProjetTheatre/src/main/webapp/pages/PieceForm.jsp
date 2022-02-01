<%@page import="beans.Comedien"%>
<%@page import="beans.Personne"%>
<%@page import="beans.Role"%>

<%@ include file="./shared/Header.jsp" %>
	<h1>Création pièce de théâtre </h1>
	<form method="POST">
		<label for="nom">Nom :</label>
		<br>
  		<input type="text" id="nom" name="nom">
  		<br>
  		
  		<label for="auteur">Auteur :</label>
		<br>
  		<input type="text" id="name" name="auteur">
  		<br>
  		
		<label for="description">Description :</label>
		<br>
		<textarea id="description" name="description" rows="5" cols="33"></textarea>
  		<br>
  		
  		<label for="comediens">Comediens :</label>
		<br>
		<select name="comediens">
			<option value=""></option>
			<% for (Comedien comedien: (ArrayList<Comedien>) request.getAttribute("comediens")) { %>
				<option value="<%= comedien.getId() %>"><%= comedien.getNom() %></option>
			<% } %>
		</select>
		<br>
		<label for="rolesComediens">Role :</label>
		<br>
  		<input type="text" name="rolesComediens">
  		<br>
  		
		<select name="comediens">
			<option value=""></option>
			<% for (Comedien comedien: (ArrayList<Comedien>) request.getAttribute("comediens")) { %>
				<option value="<%= comedien.getId() %>"><%= comedien.getNom() %></option>
			<% } %>
		</select>
		<br>
		<label for="rolesComediens">Role :</label>
		<br>
  		<input type="text" name="rolesComediens">
  		<br>
		
		<label for="personnes">Equipe technique :</label>
		<br>
		<select name="personnes">
			<option value=""></option>
			<% for (Personne personne: (ArrayList<Personne>) request.getAttribute("personnes")) { %>
				<option value="<%= personne.getId() %>"><%= personne.getNom() %></option>
			<% } %>
		</select>
		<br>
		<label for="rolesPersonnes">Role :</label>
		<br>
		<select name="rolesPersonnes">
			<option value=""></option>
			<% for (Role role: (ArrayList<Role>) request.getAttribute("roles")) { %>
				<option value="<%= role.getId() %>"><%= role.getNom() %></option>
			<% } %>
		</select>
		<br>
		<select name="personnes">
			<option value=""></option>
			<% for (Personne personne: (ArrayList<Personne>) request.getAttribute("personnes")) { %>
				<option value="<%= personne.getId() %>"><%= personne.getNom() %></option>
			<% } %>
		</select>
		<br>
		<label for="rolesPersonnes">Role :</label>
		<br>
		<select name="rolesPersonnes">
			<option value=""></option>
			<% for (Role role: (ArrayList<Role>) request.getAttribute("roles")) { %>
				<option value="<%= role.getId() %>"><%= role.getNom() %></option>
			<% } %>
		</select>
		
		<button type="submit">Créer</button>
	</form>
<%@ include file="./shared/Footer.jsp" %>