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

<head>
<link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">
<!-- Header styling --> 
<link href="/ProjetTheatre/css/headerStyle.css" rel="stylesheet" type="text/css" />

<link
      rel="stylesheet"
      href="/ProjetTheatre/css/A.style.css.pagespeed.cf.2hpsIU3gX-.css"
    />
</head>
<style>
.rating{
  display : flex;
}

.rating input{
  position : absolute;
  left     : -100vw;
}

.rating label{
  width      : 48px;
  height     : 48px;
  padding    : 48px 0 0;
  overflow   : hidden;
  background : url('/ProjetTheatre/images/stars.svg') no-repeat top left;
}

.rating:not(:hover) input:indeterminate + label,
.rating:not(:hover) input:checked ~ input + label,
.rating input:hover ~ input + label{
  background-position : -48px 0;
}

.rating:not(:hover) input:focus-visible + label{
  background-position : -96px 0;
}</style>
<body>
	<% 
		Piece piece = (Piece) request.getAttribute("piece");
		List<Commentaire> visibleCommentaires = piece.getCommentaires(Commentaire.StatutEnum.VALIDE);
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
		
		<div class="row no-gutters align-items-center min-vh-80">
			<div class="col-7">
				<%-- for (Photo photo: piece.getPhotos()) { --%>
					<%-- <img src="<%= photo.getChemin() %>" alt="photos"/> --%>
				<%-- } --%>
				<%-- TODO Replace with carousel --%>
				<h1>TODO : Remplacer par un caroussel</h1>
				<img src="/ProjetTheatre/images/bg_1.jpg" class="img-fluid" alt="Responsive image">
			</div>
			<div class="col d-flex flex-column justify-content-center align-items-center p-5">				
				<h1 class="display-4 text-center font-weight-bold"><%= piece.getNom() %></h1>
				<h3>par <span><%= piece.getAuteur() %></span></h3>
				<% if (visibleCommentaires.size() > 0) { %>
					<h6 class="font-italic font-weight-light">
						<%= piece.getMoyenne() %> / 10 sur <%= visibleCommentaires.size() %> avis
					</h6>	
				<% } %>
				
				<h4 class="mt-5">Résumé</h4>
				<p class="lead text-justify"><%= piece.getDescription() %></p>
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
							
							<div class="col-4 text-right">
								<button class="btn btn-primary">Réserver</button>	
							</div>
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
<%@ include file="/pages/shared/Footer.jsp" %>
