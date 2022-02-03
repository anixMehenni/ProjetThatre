<%@page import="beans.Commentaire"%>
	
<%@ include file="/pages/shared/Header.jsp" %>

<div class="container">
	<h1 class="text-center my-5">Gestion des commentaires</h1>	
	
	<div class="d-flex justify-content center align-items-center">
		<table class="table table-striped">
			<thead>
			    <tr>
			      <th scope="col">Piece</th>
			      <th scope="col">Auteur</th>			          
			      <th scope="col">Statut</th>
			      <th scope="col">Note</th>
			      <th scope="col">Commentaire</th>			          
			      <th class="text-right" scope="col">Actions</th>
			    </tr>
		    </thead>
		    <tbody>
				<% for (Commentaire commentaire : (List<Commentaire>) request.getAttribute("commentaires")) { %>
					<tr scope="row">					
						<td><%= commentaire.getPiece().getNom() %></td>
						<td><%= commentaire.getUtilisateur().getNom() %></td>
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
								<input type="hidden" name="statut" />
								
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
			$(this).siblings("input[name='statut']").val(newStatut);
			$(this).parent("form").submit();
		});
	});
</script>

<%@ include file="/pages/shared/Footer.jsp" %>