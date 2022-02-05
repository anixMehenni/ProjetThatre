<%@page import="beans.Festival"%>
<%@page import="beans.Lieu"%>
<%@page import="beans.Piece"%>

<%
	Piece piece = (Piece) request.getAttribute("piece");
	List<Festival> festivals = (List<Festival>) request.getAttribute("festivals");
	List<Lieu> lieux = (List<Lieu>) request.getAttribute("lieux");
%>
<%@ include file="/pages/shared/Header.jsp" %>

	<div class="container">	
		<h3 class="text-center display-4 my-5">Ajout Représentation pour : <%= piece.getNom() %></h3>
	
		<form method="POST">
			<input type="hidden" name="piece" value="<%= piece.getId() %>"/>
			<div class="row align-items-center">
				<%-- 
				<div class="col">
					<div class="form-group">
					    <label for="festivals">Festival</label>
						<select name="festivals" class="form-control">
					        <option value=""></option>
							<% for (Festival festival: festivals) { %>
								<option value="<%= festival.getId() %>"><%= festival.getNom() %></option>
							<% } %>
					    </select>						    
					</div>
				</div>
				--%>
				<div class="col">
					<div class="form-group">
					    <label for="lieux">Lieu</label>
						<select name="lieux" class="form-control">
					        <option value=""></option>
							<% for (Lieu lieu: lieux) { %>
								<option value="<%= lieu.getId() %>">
									<%= lieu.getAdresse() %> - <%= lieu.getType() %>
								</option>
							<% } %>
					    </select>						    
					</div>
				</div>
				<div class="col">
					<div class="form-group">
					    <label for="dates">Date</label>
					    <input type="date" class="form-control" name="dates">
				    </div>
				</div>
				<div class="col">
					<div class="form-group">
					    <label for="heures">Heure</label>
					    <input type="time" class="form-control" name="heures">
				    </div>
				</div>	
				<div class="col-1">										
					<button type="button" class="btn btn-outline-danger">-</button>
				</div>		
			</div>
			<div class="row justify-content-center mt-3" id="addRepresentationBtn">			
				<button type="button" class="btn btn-outline-primary">+</button>
			</div>

			
			<div class="row justify-content-center my-3">			
				<button type="submit" class="btn btn-primary">Ajouter</button>
			</div>
		</form>
	</div>
	
<script type="text/javascript" src="/ProjetTheatre/js/representationForm.js"></script>

<%@ include file="/pages/shared/Footer.jsp" %>