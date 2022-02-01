<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<h3> Se Connecter </h3>
<form action="user_login" method="post">
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
                 <input type="submit" value="Login" /></form>
                 <a href="/ProjetTheatre/CreationCompteAbonneServlet"><b>S'inscrire</b></a>
</body>
</html>