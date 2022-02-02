$(document).ready(function(){
	$("#addOrganisateurBtn").on("click", function() {
		form = $(this).prev().clone();
		form.insertBefore(this);
	});
	
	$("#addSponsorBtn").on("click", function() {
	  	form = $(this).prev().clone();
		form.insertBefore(this);
	});
	
	$("#rightSide").on("click", ".btn-outline-danger", function() {
		rootElement = $(this).parent().parent().parent();
		target = $(this).data("target");
		count = rootElement.find("select[name='" + target + "']").length;
		if (count > 1) {	
			$(this).parent().parent().remove();
		}
	});
});