<%@page import="beans.ComedienPiece"%>
<%@page import="beans.Commentaire"%>
<%@page import="beans.EquipeTechnique"%>
<%@page import="beans.Piece"%>
<%@page import="beans.Representation"%>
<%@page import="beans.Photo"%>

<% 
	java.text.DateFormat df = new java.text.SimpleDateFormat("EEEE dd MMMM YYYY"); 
	java.text.DateFormat hf = new java.text.SimpleDateFormat("k:m"); 
%>

<%@ include file="/pages/shared/Header.jsp" %>

<body>
	<% 
		Piece piece = (Piece) request.getAttribute("piece");
		List<Commentaire> visibleCommentaires = piece.getCommentaires(Commentaire.StatutEnum.VALIDE);
		currentUser = (Utilisateur) session.getAttribute("_UTILISATEUR_COURANT");
	%>
	
	<div class="container-fluid p-0">
		<% if (request.getAttribute("createdComment") != null) { %>
			<div class="row my-2 justify-content-center">
				<div class="col-6">
					<div class="d-flex align-items-center alert alert-dismissible fade show alert-success my-2" role="alert">
					  	Commentaire ajouté, en attente de modération<span>
						<button type="button" class="close" data-dismiss="alert" aria-label="Close">
						    <span aria-hidden="true">&times;</span>
					    </button>
					</div>
				</div>
			</div>
		<% } %>
		
		<div class="d-flex flex-column justify-content-center align-items-center p-5">				
			<h1 class="display-4 text-center font-weight-bold"><%= piece.getNom() %></h1>
			<h3>par <span><%= piece.getAuteur() %></span></h3>
			
			<% if (visibleCommentaires.size() > 0) { %>
				<div class="rating">
					<% for (int i = 1; i <= 10; i++) { %>
					  <input 
					  	id="ratingResult<%= i %>" 
					  	type="radio" 
					  	name="noteResults" 
					  	value="<%= i %>" 
					  	disabled
					  	<%= piece.getMoyenne() == i ? "checked" : "" %>
				  	  >
					  <label for="ratingResult<%= i %>"><%= i %></label>
                    <% } %>	
                   </div>
				<span class="font-italic font-weight-light">
					<%= piece.getMoyenne() %> / 10 sur <%= visibleCommentaires.size() %> avis
				</span>	
			<% } %>
			
			<h4 class="mt-5">Résumé</h4>
			<p class="lead text-justify mx-5 px-5"><%= piece.getDescription() %></p>
		</div>
		
		<div class="row justify-content-center align-items-center">
			<div class="col-6">				
				<div class="owl-carousel owl-theme">
					<% for (Photo photo: piece.getPhotos()) { %>
						<img class="img-fluid" src="<%= photo.getChemin() %>"/>
					<% } %>
				</div>
				
			</div>
		</div>
		
		<div class="row p-5">
			<div class="col">
				<h3 class="text-center font-weight-bold mb-5">Distribution</h3>
				<div>
					<% for (ComedienPiece comedienPiece : piece.getComedienPieces()) { %>
						<div class="d-flex my-2">
							<div class="text-uppercase font-weight-bold mr-2">
								<%= comedienPiece.getComedien().getNom() %>
							</div>
							<div class="font-italic">
							 	(<%= comedienPiece.getRole() %>)
						 	</div>
						</div>
					<% } %>
				</div>
			</div>
			<div class="col">
				<h3 class="text-center font-weight-bold mb-5">Equipe Technique</h3>
				<div>
					<% for (EquipeTechnique personneRole : piece.getEquipeTechniques()) { %>
						<div class="d-flex my-2">
							<div class="font-weight-bold mr-2">
							 	<%= personneRole.getRole().getNom() %> :
							</div>
							<div class="font-italic">
							 	<%= personneRole.getPersonne().getNom() %>
						 	</div>
						</div>
					<% } %>
				</div>
			</div>
			<div class="col">
				<h3 class="text-center font-weight-bold mb-5">Représentations</h3>
				<div>
					<% for (Representation representation : piece.getRepresentations()) { %>
						<div class="row">
							<div class="col d-flex flex-column">
								<div class="font-weight-bold text-capitalize">
									<%= df.format(representation.getDate()) %> 
								</div>
								<div class="font-weight-bold">
									à <%= hf.format(representation.getDate()) %>
								</div>
								<div><%= representation.getLieu().getAdresse() %></div>
								<div class="font-italic font-weight-light">
									<%= representation.getFestival().getNom() %> (<%= representation.getFestival().getVille() %>)
								</div>
							</div>
							<% if (currentUser != null){%>
							<div class="col-4 text-right">
								<a href="/ProjetTheatre/reservation/add?representation=<%= representation.getId() %>">
									<button class="btn btn-primary">Réserver</button>	
								</a>
							</div>
							<% } %>
							<% if (currentUser == null){%>
							<div class="col-4 text-right">
								<a href="/ProjetTheatre/ConnexionAbonneServlet">
									<button class="btn btn-primary">Réserver</button>	
								</a>
							</div>
							<% } %>
						</div>
						<hr/>
					<% } %>
				</div>
			</div>
		</div>
		<div class="row p-5 justify-content-center">
			<div class="col-6">
				<h3 class="text-center font-weight-bold mb-5">
					Avis spectateurs <%= visibleCommentaires.size() > 0 ? "(" + visibleCommentaires.size() + ")" : "" %>					
				</h3>
				
				<%@ include file="/CommentaireForm.jsp" %>
				
				<div>
					<% if (visibleCommentaires.size() > 0) {
							for (Commentaire commentaire : visibleCommentaires) {
					%>
						<div class="d-flex flex-column my-3">
							<div class="font-weight-bold">
								<%= commentaire.getNote() %> / 10
							</div>
							<p><p><%= commentaire.getCommentaire() %></p>
							<div class="font-italic">
								par 
								<%= commentaire.getUtilisateur() != null 
									? commentaire.getUtilisateur().getPrenom() + " " + commentaire.getUtilisateur().getNom()
									: "Anonyme"
								%>
							</div>
						</div>
						<hr/>
					
					<% 	}
					} else {
					%>
						<h6 class="font-italic font-weight-light text-center">Pas encore d'avis reçu</h6>
					<% } %>	
				</div>
			</div>
		</div>
	</div>
</body>
<script>
	$(document).ready(function(){
	  var carousel = function() {
			$('.owl-carousel').owlCarousel({
		    loop:true,
		    autoplay: true,
		    margin:30,
		    animateOut: 'fadeOut',
		    animateIn: 'fadeIn',
		    smartSpeed: 15000,
		    nav:true,
		    dots: true,
		    autoplayHoverPause: false,
		    items: 1,
		    navText : ["<span class='ion-ios-arrow-back'></span>","<span class='ion-ios-arrow-forward'></span>"],
			});

		};
		carousel();
	});
</script>
<%@ include file="/pages/shared/Footer.jsp" %>
