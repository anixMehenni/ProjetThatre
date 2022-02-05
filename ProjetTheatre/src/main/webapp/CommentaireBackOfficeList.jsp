<%@page import="beans.Piece"%>
<%@page import="beans.Commentaire"%>
	
<%@ include file="/pages/shared/Header.jsp" %>

<div class="container">
	<h1 class="text-center my-5">Gestion des commentaires</h1>	
	
	<form class="my-5" method="GET" id="searchForm">
		<div class="row justify-content-between align-items-center">
			<div class="col">
				<label for="piece">Pièce</label>
				<select name="piece" class="form-control">
			        <option value=""></option>
					<% for (Piece piece: (List<Piece>) request.getAttribute("pieces")) { %>
						<option value="<%= piece.getId() %>"
							<%= 
								request.getParameter("piece") != null 
								&& Integer.parseInt(request.getParameter("piece")) == piece.getId() 
								? "selected" 
								: "" 
							%>
						><%= piece.getNom() %></option>
					<% } %>
			    </select>						
			</div>
			<div class="col">
				<label for="statut">Statut</label>
				<select name="statut" class="form-control">
			        <option value=""></option>
					<% for (Commentaire.StatutEnum statut: (Commentaire.StatutEnum[]) request.getAttribute("statuts")) { %>
						<option value="<%= statut %>"
							<%= 
								request.getParameter("statut") != null 
								&& !request.getParameter("statut").isEmpty()
								&&  Commentaire.StatutEnum.valueOf(request.getParameter("statut")) == statut 
								? "selected" 
								: "" 
							%>
						><%= statut %></option>
					<% } %>
			    </select>						
			</div>
		</div>
	</form>
	
	<div class="d-flex justify-content center align-items-center">
		<table class="table table-striped">
			<thead>
			    <tr>
			      <th scope="col">Piece</th>
			      <th scope="col">Auteur</th>			          
			      <th scope="col">Statut</th>
			      <th scope="col">Note</th>
			      <th scope="col">Commentaire</th>			          
			      <th class="text -right" scope="col">Actions</th>
			    </tr>
		    </thead>
		    <tbody>
				<% for (Commentaire commentaire : (List<Commentaire>) request.getAttribute("commentaires")) { %>
					<tr scope="row">					
						<td><%= commentaire.getPiece().getNom() %></td>
						<td>
							<%= commentaire.getUtilisateur() != null
								? commentaire.getUtilisateur().getNom() + " " + commentaire.getUtilisateur().getNom() 
								: "Anonyme"
							%>
						</td>
						<td class="<%= Commentaire.StatutEnum.valueOf(commentaire.getStatut()) == Commentaire.StatutEnum.VALIDE 
							? "text-success" : Commentaire.StatutEnum.valueOf(commentaire.getStatut()) == Commentaire.StatutEnum.REJETE
							? "text-danger"
							: "text-warning"
						%>">
							<%= commentaire.getStatut() %>
						</td>
						<td><%= commentaire.getNote() %></td>						
						<td>
							<p><%= commentaire.getCommentaire() %><p>
						</td>					
						<td class="text-right">							
							<form method="POST">
								<input type="hidden" name="commentaire" value="<%= commentaire.getId() %>" />
								<input type="hidden" name="newStatut" />
								
								<% if (Commentaire.StatutEnum.valueOf(commentaire.getStatut()) != Commentaire.StatutEnum.VALIDE) { %>
									<button type="submit" class="btn btn-outline-success" data-statut="<%= Commentaire.StatutEnum.VALIDE %>">
										Valider
									</button>
								<% } %>
								
								<% if (Commentaire.StatutEnum.valueOf(commentaire.getStatut()) != Commentaire.StatutEnum.REJETE) { %>
									<button type="submit" class="btn btn-outline-danger" data-statut="<%= Commentaire.StatutEnum.REJETE %>">
										Refuser
									</button>
								<% } %>
							</form>
						</td>
					</tr>
				<% } %>
		    </tbody>
		</table>
	</div>
</div>

<script>
	$(function() {
		$("button[type='submit']").on('click', function(event) {
			event.preventDefault();
			newStatut = $(this).data("statut");
			$(this).siblings("input[name='newStatut']").val(newStatut);
			$(this).parent("form").submit();
		});
		
		$("select").on("change",  function() {
			$("#searchForm").submit();
		})
	});
</script>

<%@ include file="/pages/shared/Footer.jsp" %>