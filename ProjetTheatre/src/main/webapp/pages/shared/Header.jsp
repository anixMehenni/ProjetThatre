
<%@ page language="java"%>

<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="java.util.stream.Collectors"%>

<%@page import="beans.Utilisateur"%>
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="ISO-8859-1">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />

<link href="/ProjetTheatre/css/headerStyle.css" rel="stylesheet"
	type="text/css" />
<link href="/ProjetTheatre/css/rating.css" rel="stylesheet"
	type="text/css" />

<link rel="stylesheet"
	href="/ProjetTheatre/css/A.style.css.pagespeed.cf.2hpsIU3gX-.css" />
<link rel="stylesheet" href="/ProjetTheatre/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="/ProjetTheatre/css/owl.theme.default.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap"
	rel="stylesheet">

<!--  <title>${ !empty pageName ? pageName : 'Theatre JAVA' }</title>  -->

<script defer="" src="../../ProjetTheatre/js/s.js"></script>

<script>
      ;(function (w, d) {
        !(function (a, e, t, r, z) {
          ;(a.zarazData = a.zarazData || {}),
            (a.zarazData.executed = []),
            (a.zarazData.tracks = []),
            (a.zaraz = { deferred: [] })
          var s = e.getElementsByTagName('title')[0]
          ;(a.zarazData.c = e.cookie),
            s && (a.zarazData.t = e.getElementsByTagName('title')[0].text),
            (a.zarazData.w = a.screen.width),
            (a.zarazData.h = a.screen.height),
            (a.zarazData.j = a.innerHeight),
            (a.zarazData.e = a.innerWidth),
            (a.zarazData.l = a.location.href),
            (a.zarazData.r = e.referrer),
            (a.zarazData.k = a.screen.colorDepth),
            (a.zarazData.n = e.characterSet),
            (a.zarazData.o = new Date().getTimezoneOffset()), //
            (a.dataLayer = a.dataLayer || []),
            (a.zaraz.track = (e, t) => {
              for (key in (a.zarazData.tracks.push(e), t))
                a.zarazData['z_' + key] = t[key]
            }),
            (a.zaraz._preSet = []),
            (a.zaraz.set = (e, t, r) => {
              ;(a.zarazData['z_' + e] = t), a.zaraz._preSet.push([e, t, r])
            }),
            a.dataLayer.push({ 'zaraz.start': new Date().getTime() }),
            a.addEventListener('DOMContentLoaded', () => {
              var t = e.getElementsByTagName(r)[0],
                z = e.createElement(r)
              ;(z.defer = !0),
                (z.src =
                  '/cdn-cgi/zaraz/s.js?z=' +
                  btoa(encodeURIComponent(JSON.stringify(a.zarazData)))),
                t.parentNode.insertBefore(z, t)
            })
        })(w, d, 0, 'script')
      })(window, document)
    </script>
</head>
</head>
<body>
	<%
				Utilisateur currentUser = (Utilisateur) session.getAttribute("_UTILISATEUR_COURANT");
				%>
	<script type="text/javascript"
		src="../../ProjetTheatre/js/jquery-3.3.1.min.js"></script>
	<div class="container">
		<nav class="navbar navbar-expand-lg ftco_navbar ftco-navbar-light"
			id="ftco-navbar">
			<div class="container">
				<a class="navbar-brand"
					href="../../ProjetTheatre/VisualiserFestival">Festival</a>

				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#ftco-nav" aria-controls="ftco-nav"
					aria-expanded="false" aria-label="Toggle navigation">
					<span class="fa fa-bars"></span> Menu
				</button>

				<div class="collapse navbar-collapse" id="ftco-nav">
					<ul class="navbar-nav ml-auto mr-md-3">
						<li class="nav-item active"><a
							href="../../ProjetTheatre/VisualiserFestival" class="nav-link">Accueil</a>
						</li>
						
						
						<%if (currentUser == null) { %>
						<li class="nav-item"><a
							href="../../ProjetTheatre/ConnexionAbonneServlet"
							class="nav-link">Se connecter</a></li>
						<% } %>
						
						<%if (currentUser != null) { %>
						<li class="nav-item"><a 
						href="../../ProjetTheatre/paniers" 
						class="nav-link">Panier</a></li>
						<li class="nav-item"><a
							href="../../ProjetTheatre/GestionCompteServlet"
							class="nav-link">Mon compte</a></li>
						
						<li class="nav-item"><a
							href="../../ProjetTheatre/DeconnexionServlet"
							class="nav-link">Se d?connecter</a></li>
						
						<% if(currentUser.getRole().equals("MODERATEUR") || currentUser.getRole().equals("ADMINISTRATEUR")) { %>
						<li class="dropdown nav-item d-md-flex align-items-center"><a
							href="#"
							class="dropdown-toggle nav-link d-flex align-items-center justify-content-center icon-cart p-0"
							id="dropdown04" data-toggle="dropdown" aria-expanded="false">
								<i class="fa fa-shopping-cart"></i> <b class="caret"></b>
						</a>
							<div class="dropdown-menu dropdown-menu-right"
								aria-labelledby="dropdown04">
								<% if (currentUser.getRole().equals("MODERATEUR")) { %>
								<a href="../../ProjetTheatre/commentaire/validation" class="dropdown-item">Gestion des commentaires</a> 
								<% }%>
								<% if (currentUser.getRole().equals("ADMINISTRATEUR")) { %>
								<a href="../../ProjetTheatre/CreationCompteModerateurServlet"
									class="dropdown-item">Ajouter un mod?rateur</a>
									<a href="../../ProjetTheatre/bo/piece"
									class="dropdown-item">Pi?ces de th?atre</a>
								<% }%>
							</div></li>
							<% } %>
							<% } %>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	<script type="text/javascript"
		src="../../ProjetTheatre/js/jquery-3.3.1.min.js"></script>
	<script
		src="../../ProjetTheatre/js/popper.js+bootstrap.min.js+main.js.pagespeed.jc.5x6Uz2igdj.js"></script>
	<script>
      eval(mod_pagespeed_0UPnXzZwRD)
    </script>
	<script>
      eval(mod_pagespeed_W64Hd3v$EA)
    </script>
	<script>
      eval(mod_pagespeed_YC9jOPNpKZ)
    </script>
	<script defer=""
		src="./Website menu 05_files/v652eace1692a40cfa3763df669d7439c1639079717194"
		integrity="sha512-Gi7xpJR8tSkrpF7aordPZQlW2DLtzUlZcumS8dMQjwDHEnw9I7ZLyiOj/6tZStRBGtGgN6ceN6cMH8z7etPGlw=="
		data-cf-beacon='{"rayId":"6d76ef5e681cedcf","token":"cd0b4b3a733644fc843ef0b185f98241","version":"2021.12.0","si":100}'
		crossorigin="anonymous"></script>
</body>