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

<!-- Style -->
<link rel="stylesheet" href="/ProjetTheatre/src/main/webapp/css/loginStyle.css">

<!-- Style -->
<link rel="stylesheet" href="/ProjetTheatre/src/main/webapp/css/owl.carousel.min.css">

<!-- Style -->
<link rel="stylesheet" href="/ProjetTheatre/src/main/webapp/css/icomoonstyle.css">

<div class="d-lg-flex half">
    <div class="bg order-1 order-md-2" style="background-image: url('https://img-4.linternaute.com/CRjbQ1RCVbD16f9U-lRPqhyZhZA=/1080x/smart/47b0d9e9b807480f9af424d6b1ff3af0/ccmcms-linternaute/12369448.jpg');"></div>
    	<div class="contents order-2 order-md-1">
    	<div class="container">
        	<div class="row align-items-center justify-content-center">
          		<div class="col-md align-items-center">
    			 <h3><strong>Se Connecter</strong></h3>
    			 <img alt="" src="/ProjetTheatre/src/main/webapp/images/bg_1.jpg"/>
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
	<script type="text/javascript" src="${jakarta.servlet.jsp.PageContext}/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="${jakarta.servlet.jsp.PageContext}/js/popper.min.js"></script>
    <script type="text/javascript" src="${jakarta.servlet.jsp.PageContext}/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="${jakarta.servlet.jsp.PageContext}/js/main.js"></script>
</body>
</html>