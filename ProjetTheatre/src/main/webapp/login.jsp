<%@ page language="java" contentType="text/html"%>

<%@ include file="/pages/shared/Header.jsp" %>

<!DOCTYPE html>
<html>
<head>

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<meta charset="ISO-8859-1">


<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<link href="https://fonts.googleapis.com/css?family=Roboto:300,400&display=swap" rel="stylesheet">

<!-- Bootstrap Style 
<link rel="stylesheet" href="/ProjetTheatre/src/main/webapp/css/bootstrap.min.css">-->

<!-- Header styling --> 
<link href="/ProjetTheatre/css/headerStyle.css" rel="stylesheet" type="text/css" />

<link
      rel="stylesheet"
      href="/ProjetTheatre/css/A.style.css.pagespeed.cf.2hpsIU3gX-.css"
    />
<!-- Style -->
<link rel="stylesheet" href="/ProjetTheatre/css/loginStyle.css">

<!-- Style -->
<link rel="stylesheet" href="/ProjetTheatre/css/owl.carousel.min.css">

<!-- Style -->
<link rel="stylesheet" href="/ProjetTheatre/css/icomoonstyle.css">

<div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('/ProjetTheatre/images/bg_1.jpg');"></div>
    	<div class="contents order-2 order-md-1">
    	<div class="container">
        	<div class="row align-items-center justify-content-center">
          		<div class="col-md-7 align-items-center">
    			 <h3><strong>Se Connecter</strong></h3>
    			 
    			 <form action="/ProjetTheatre/ConnexionAbonneServlet" method="post">
    				<div class="form-group first">
                		<label for="email">Adresse email</label>
               			<input type="email" class="form-control" placeholder="email@gmail.com" id="email" name="email">
              		</div>
              		<div class="form-group last mb-3">
                		<label for="motDePasse">Mot de passe</label>
               			<input type="password" class="form-control" placeholder="********" id="password" name="motDePasse">
              		</div>
					<div class="d-flex mb-5 align-items-center">
                		<!--<label class="control control--checkbox mb-0"><span class="caption">Se souvenir de moi</span>
                  		<input type="checkbox" checked="checked"/>
                  		<div class="control__indicator"></div>
                		</label> -->
                		<span class="ml-auto"><a href="/ProjetTheatre/CreationCompteAbonneServlet" class="forgot-pass">S'inscrire</a></span> 
              		</div>
              		<input type="submit" value="Se connecter" class="btn btn-block btn-primary">
                 </form>
     			</div>
    		</div>
  		</div>
     </div> 
</div>

    
  </div>                 
	<script type="text/javascript" src="/ProjetTheatre/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="/ProjetTheatre/js/popper.min.js"></script>
    <script type="text/javascript" src="/ProjetTheatre/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="/ProjetTheatre/js/main.js"></script>
</body>
</html>