<%@page import="beans.Billet"%>
<%@page import="beans.Panier"%>

<%@ include file="/pages/shared/Header.jsp" %>

<% 
	List<Panier> paniers = (List<Panier>) request.getAttribute("paniers");
	java.text.DateFormat df = new java.text.SimpleDateFormat("dd MMMM YYYY"); 
	java.text.DateFormat hf = new java.text.SimpleDateFormat("k:m"); 
%>

<div class="container">
	<h3 class="text-center my-5">Vos paniers</h3>
	
	<% for (Panier panier: paniers) { %>
		<div class="row my-3">
		    <div class="col">
		        <div class="card">
		            <div class="card-header">
						<div class="d-flex justify-content-between align-items-center">
							<div class="d-flex align-items-center">
								<button 
		  							class="btn btn-outline-primary" 
		  							type="button" 
		  							data-toggle="collapse" 
		  							data-target="#panier<%= panier.getId() %>"
		  							 aria-expanded="false" 
		  							 aria-controls="#panier<%= panier.getId() %>"
								>
									+
								</button>
								<div class="h5 my-0 mx-5">
									Panier du <%= df.format(panier.getDateCreation()) %>
								</div>
								<span>(<%= panier.getStatut() %>)</span>
								
							</div>
	  						
							<button class="btn btn-primary text-center">
						    	Payer
			             	</button>
						</div>
		            </div>
	                <div class="collapse" id="panier<%= panier.getId() %>">	            		
	            		<div class="card-body mx-5 my-1">
							<% for (Billet billet: panier.getBillets()) { %>
								<div class="row">
									<div class="col font-weight-bold">
										<%= billet.getRepresentation().getPiece().getNom() %>
									</div>
									<div class="col">
										<%= df.format(billet.getRepresentation().getDate()) %>
										à <%= hf.format(billet.getRepresentation().getDate()) %>
									</div>									
									<div class="col">
										<%= billet.getRepresentation().getLieu().getType() %>
										<br/>
										<span class="font-italic">
											<%= billet.getRepresentation().getLieu().getAdresse() %>
										</span>										
									</div>									
									<div class="col"><%= billet.getPlaces().size() %> places</div>
									<div class="col text-right">
										<button class="btn btn-danger">
											x
										</button>
									</div>
								</div>
								<div class="font-italic font-weight-light mt-2">
									Réservé le <%= df.format(billet.getDateReservation()) %> 
									à <%= hf.format(billet.getDateReservation()) %>
								</div>
								<hr/>
							<% } %>
		                </div>
		            </div>
		        </div>
		    </div>
		</div>
	<% } %>
</div>


<%@ include file="/pages/shared/Footer.jsp" %>