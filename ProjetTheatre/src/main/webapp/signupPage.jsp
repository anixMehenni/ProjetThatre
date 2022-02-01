<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<meta charset="ISO-8859-1">
<title>Inscription | Nouveau compte abonné</title>
</head>
<body>
<h1>Nouveau compte abonné</h1>
<form action="/ProjetTheatre/CreationCompteAbonneServlet" method="post">
                           <table style="with: 20%">
                                    <tr>
                                              <td>Nom</td>
                                              <td><input type="text" placeholder="Nom" name="nom" required/></td>
                                    </tr>
                                    <tr>
                                              <td>Prénom</td>
                                              <td><input type="text" placeholder="Prénom" name="prenom" required/></td>
                                    </tr>
                                    <tr>
                                              <td>Adresse email</td>
                                              <td><input type="email" placeholder="example@email.com" name="email" required/></td>
                                    </tr>
                                    <tr>
                                              <td>Mot de passe</td>
                                              <td><input type="password" placeholder="Mot de Passe" name="motDePasse" required/></td>
                                    </tr>
                                    <tr>
                                              <td>Numéro de téléphone</td>
                                              <td><input type="tel" name="telephone" pattern="[0-9]{10}" required/></td>
                                    </tr>
                                    <tr>
                                    	<td>Adresse postale</td>
                                    	<td><input type="text" placeholder="Adresse postale" name="adresse" required/></td>
                                    </tr>
                           </table>
                           <input type="submit" value="Submit" /></form>
</body>
</html>