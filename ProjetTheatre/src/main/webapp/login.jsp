<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<h3> Se Connecter </h3>
<form action="/ProjetTheatre/ConnexionAbonneServlet" method="post">
<table style="width: 20%">
                 <tr>
                 <td>Email</td>
                                    <td><input type="email" name="email" /></td>
                         </tr>
                                    <tr>
                                    <td>Mot de passe</td>
                                    <td><input type="password" name="motDePasse" /></td>
                           </tr>
                 </table>
                 <button type="submit" class="btn btn-primary">Login</button></form>
                 <a href="/ProjetTheatre/CreationCompteAbonneServlet"><b>S'inscrire</b></a>
</body>
</html>