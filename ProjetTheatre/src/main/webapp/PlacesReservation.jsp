<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ include file="/pages/shared/Header.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
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
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="justify-content:center;align-content:center;width:100%">
<input type="button" name="1" value="1" id="select" onclick="colorchange('select')" style="background:rgb(255,145,0);width:35px;height:35px"/>
<input type="button" name="2" value="2" id="select1" onclick="colorchange('select1');" style="background:rgb(255,145,0);width:35px;height:35px"/>
<input type="button" name="3" value="3" id="select2" onclick="colorchange('select2');" style="background:rgb(255,145,0);width:35px;height:35px"/>
<input type="button" name="4" value="4" id="select3" onclick="colorchange('select3');" style="background:rgb(255,145,0);width:35px;height:35px"/>
<input type="button" name="5" value="5" id="select4" onclick="colorchange('select4');" style="background:rgb(255,145,0);width:35px;height:35px"/>
<input type="button" name="6" value="6" id="select5" onclick="colorchange('select5');" style="background:rgb(255,145,0);width:35px;height:35px"/>
<input type="button" name="7" value="7" id="select6" onclick="colorchange('select6')" style="background:rgb(255,145,0);width:35px;height:35px"/>
<input type="button" name="8" value="8" id="select7" onclick="colorchange('select7');" style="background:rgb(255,145,0);width:35px;height:35px"/>
<input type="button" name="9" value="9" id="select8" onclick="colorchange('select8');" style="background:rgb(255,145,0);width:35px;height:35px"/>
<input type="button" name="10" value="10" id="select9" onclick="colorchange('select9');" style="background:rgb(255,145,0);width:35px;height:35px"/>
<input type="button" name="11" value="11" id="select10" onclick="colorchange('select10');" style="background:rgb(255,145,0);width:35px;height:35px"/>
</div>
<div style="justify-content:center;align-content:center;width:100%">
<input type="button" name="12" value="12" id="select11" onclick="colorchange('select11');" style="background:rgb(255,145,0);width:35px;height:35px"/>
<input type="button" name="13" value="13" id="select12" onclick="colorchange('select12');" style="background:rgb(255,145,0);width:35px;height:35px"/>
<input type="button" name="14" value="14" id="select13" onclick="colorchange('select13');" style="background:rgb(255,145,0);width:35px;height:35px"/>
<input type="button" name="16" value="16" id="select14" onclick="colorchange('select14');" style="background:rgb(255,145,0);width:35px;height:35px"/>
<input type="button" name="17" value="17" id="select15" onclick="colorchange('select15')" style="background:rgb(255,145,0);width:35px;height:35px"/>
<input type="button" name="18" value="18" id="select16" onclick="colorchange('select16');" style="background:rgb(255,145,0);width:35px;height:35px"/>
<input type="button" name="19" value="19" id="select17" onclick="colorchange('select17');" style="background:rgb(255,145,0);width:35px;height:35px"/>
<input type="button" name="20" value="20" id="select18" onclick="colorchange('select18');" style="background:rgb(255,145,0);width:35px;height:35px"/>
<input type="button" name="21" value="21" id="select19" onclick="colorchange('select19');" style="background:rgb(255,145,0);width:35px;height:35px"/>
</div>
</body>
<script>
function colorchange(id) {

    var background = document.getElementById(id).style.backgroundColor;
    if (background == "rgb(255, 145, 0)") {
        document.getElementById(id).style.background = "rgb(26,255,0)";
    } else {
        document.getElementById(id).style.background = "rgb(255,145,0)";
    }

}
</script>
</html>

