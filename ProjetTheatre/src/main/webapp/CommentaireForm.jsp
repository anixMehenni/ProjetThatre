<%@page import="beans.Piece"%>

<div class="d-flex justify-content-center">
	<button class="btn btn-link mb-5" data-toggle="modal" data-target="#commentaireForm">
	    Laisser un avis
	</button>
</div>

<div class="modal fade" id="commentaireForm" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Laisser un avis</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <form method="POST" action="/ProjetTheatre/commentaire/add">
                    <input type="hidden" name="piece" value="<%= ((Piece) request.getAttribute("piece")).getId() %>"/>
                    <div class="form-group">
                        <label for="note">Note</label>                        
                        <input type="range" class="form-control-range" min="0" max="10" name="note" />
                    </div>
                    <div class="form-group">
                        <label for="commentaire">Commentaire</label>
                        <textarea class="form-control" id="description" rows="5" name="commentaire"></textarea>
                    </div>
					
					<div class="d-flex justify-content-center">
	                    <button type="submit" class="btn btn-primary text-center">Ajouter</button>
					</div>
                </form>
            </div>
        </div>
    </div>
</div>
