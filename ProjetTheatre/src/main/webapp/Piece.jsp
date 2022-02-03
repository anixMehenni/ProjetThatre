<%@page import="beans.ComedienPiece"%>
<%@page import="beans.Commentaire"%>
<%@page import="beans.EquipeTechnique"%>
<%@page import="beans.Piece"%>
<%@page import="beans.Representation"%>
<%@page import="beans.Photo"%>

<% 
	java.text.DateFormat df = new java.text.SimpleDateFormat("EEEE dd MM YYYY"); 
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
	
	<% for (Photo photo: piece.getPhotos()) { %>
		<img src="<%= photo.getChemin() %>" alt="photos"/>
	<% } %>
	
	<h1><%= piece.getNom() %></h1>
	<h5>Ecrit par <%= piece.getAuteur() %></h5>		
	<p><%= piece.getDescription() %></p>
	
	<div>
		<h4>Comediens :</h4>
		<ul>
			<% for (ComedienPiece comedienPiece : piece.getComedienPieces()) { %>
				<li><%= comedienPiece.getComedien().getNom() %> (<%= comedienPiece.getRole() %>)</li>
			<% } %>
		</ul>
	</div>
	
	<div>
		<h4>Equipe Technique :</h4>
		<ul>
			<% for (EquipeTechnique personneRole : piece.getEquipeTechniques()) { %>
				<li><%= personneRole.getRole().getNom() %> : <%= personneRole.getPersonne().getNom() %></li>
			<% } %>
		</ul>
	</div>
	
	<div>
		<h4>Representations :</h4>
		<ul>
			<% for (Representation representation : piece.getRepresentations()) { %>
				<li>
					<%= representation.getFestival().getNom() %>
					<%= representation.getLieu().getType() %>
					<%= df.format(representation.getDate()) %> à 
					<%= hf.format(representation.getDate()) %>
				</li>
			<% } %>
		</ul>
	</div>
	
	<div>
		<h4>Commentaires :</h4>
		<ul>
			<% 
				List<Commentaire> visibleCommentaires = piece.getCommentaires()
					.stream()
					.filter(commentaire -> Commentaire.StatutEnum.valueOf(commentaire.getStatut()) == Commentaire.StatutEnum.VALIDE)
					.collect(Collectors.toList());
				for (Commentaire commentaire : visibleCommentaires) {
			%>
				<li>
					<%= commentaire.getUtilisateur().getNom() %>
					<%= commentaire.getUtilisateur().getPrenom() %>
					<%= commentaire.getNote() %> / 10
					<p><%= commentaire.getCommentaire() %></p>
				</li>
			<% } %>
		</ul>
	</div>
</body>
<%@ include file="/pages/shared/Footer.jsp" %>