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
<body>
	<% Piece piece = (Piece) request.getAttribute("piece"); %>
	
	
	
	<div class="container-fluid p-0">
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
				
				<h4 class="mt-5">R�sum�</h4>
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
				<h3 class="text-center font-weight-bold mb-5">Repr�sentations</h3>
				<div>
					<% for (Representation representation : piece.getRepresentations()) { %>
						<div class="row">
							<div class="col d-flex flex-column">
								<div class="font-weight-bold text-capitalize">
									<%= df.format(representation.getDate()) %> 
								</div>
								<div class="font-weight-bold">
									� <%= hf.format(representation.getDate()) %>
								</div>
								<div><%= representation.getLieu().getAdresse() %></div>
								<div class="font-italic font-weight-light">
									<%= representation.getFestival().getNom() %> (<%= representation.getFestival().getVille() %>)
								</div>
							</div>
							
							<div class="col-4 text-right">
								<button class="btn btn-primary">R�server</button>	
							</div>
						</div>
						<hr/>
					<% } %>
				</div>
			</div>
		</div>
		<div class="row p-5 justify-content-center">
			<div class="col-6">
				<h3 class="text-center font-weight-bold mb-5">Avis spectateurs</h3>
				<div>
					<% 
						List<Commentaire> visibleCommentaires = piece.getCommentaires()
							.stream()
							.filter(commentaire -> Commentaire.StatutEnum.valueOf(commentaire.getStatut()) == Commentaire.StatutEnum.VALIDE)
							.collect(Collectors.toList());
						for (Commentaire commentaire : visibleCommentaires) {
					%>
						<div class="d-flex flex-column my-3">
							<div class="font-weight-bold">
								<%= commentaire.getNote() %> / 10
							</div>
							<p><p><%= commentaire.getCommentaire() %></p>
							<div class="font-italic">
								par 
								<%= commentaire.getUtilisateur().getNom() %>
								<%= commentaire.getUtilisateur().getPrenom() %>
							</div>
						</div>
						<hr/>
					<% } %>
				</div>
			</div>
		</div>
	</div>
</body>
<%@ include file="/pages/shared/Footer.jsp" %>
