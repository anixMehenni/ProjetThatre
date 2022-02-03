$(document).ready(function(){
	$("#addRepresentationBtn").on("click", function() {
		console.log("hello");
		form = $(this).prev().clone();		
		form.find("input").val("");
		form.insertBefore(this);
	});
	
	
	$("form").on("click", ".btn-outline-danger", function() {
		count = $("form").find("select[name='festivals']").length;
		console.log({count});
		if (count > 1) {	
			$(this).parent().parent().remove();
		}
	});
});