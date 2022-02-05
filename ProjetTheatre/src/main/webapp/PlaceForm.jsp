
<%@page import="beans.Representation"%>
<%@page import="beans.CategoriePlace"%>
<%@page import="beans.Place"%>

<%@ include file="/pages/shared/Header.jsp" %>

<% 
	java.text.DateFormat df = new java.text.SimpleDateFormat("EEEE dd MMMM YYYY"); 
	java.text.DateFormat hf = new java.text.SimpleDateFormat("k:m"); 
%>

<div class="container p-5">
	<% 
		List<CategoriePlace> categories = (List<CategoriePlace>) request.getAttribute("categories");
		List<Integer> reservations = (List<Integer>) request.getAttribute("reservations");
		Representation representation = (Representation) request.getAttribute("representation");
	%>

<h5 class="text-center">
	Réservation de vous places pour : 
	<br/>
	<%= representation.getPiece().getNom() %> 
</h5>
<h6 class="text-center">
	du <span class="text-capitalize"><%= df.format(representation.getDate()) %></span>
	<br/>
	à <%= hf.format(representation.getDate()) %>
</h6>

<form class="m-5" method="POST">
	<input type="hidden" name="representationId" value="<%= representation.getId() %>"/>
	
	<% for (CategoriePlace categorie: categories) { %>
		<h6 class="text-center">Categorie <%= categorie.getNom() %></h6>	
		<div class="d-flex justify-content-center m-2" id="buttonsContainer">
			<% for (Place place : categorie.getPlaces()) {
				boolean isReserved = reservations.contains(place.getId());
			%>
				<button 
					type="button" 
					class="btn m-1 <%= isReserved ? "btn-secondary" : "btn-outline-primary" %>"
					<%= isReserved ? "disabled" : "" %>
					data-place="<%= place.getId() %>"
					style="width: 50px; height: 50px;"
				>
					<%= place.getNumero() %>
				</button>
			<% } %>
		</div>
	<% } %>
	
	<div class="d-flex justify-content-center mt-5">
		<button type="submit" class="btn btn-primary">Ajouter au panier</button>
	</div>
</form>
</div>

<script>
    $(function() {
    	$("#buttonsContainer button").on('click', function() {
    		clickedId = $(this).data("place");
			correspondingInput = $("form").find("input[name='places'][value='" + clickedId + "']")
    		
			if (correspondingInput.length) {
    			correspondingInput.remove();
    			$(this).removeClass("btn-success");
    			$(this).addClass("btn-outline-primary");
    		} else {
    			$("<input />").attr("type", "hidden")
		            .attr("name", "places")
		            .attr("value", clickedId)
		            .appendTo("form");
    			$(this).removeClass("btn-outline-primary");
    			$(this).addClass("btn-success");
    		}
			
    	});
    });
</script>

<%@ include file="/pages/shared/Footer.jsp" %>
