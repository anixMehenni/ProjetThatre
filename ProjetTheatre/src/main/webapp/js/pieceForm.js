$(document).ready(function(){
	$("#addComedienBtn").on("click", function() {
		form = $(this).prev().clone();
		form.find("input").val("");
		form.insertBefore(this);
	});
	
	$("#addEquipeTechniqueBtn").on("click", function() {
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