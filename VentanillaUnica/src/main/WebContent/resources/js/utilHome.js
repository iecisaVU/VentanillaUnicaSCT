$(document).ready(function() {
	
	$(function() {
		$.ajax({
			url : contextvu +  '/home.sct',
			data : {
				
			},			
			success : function(response) {
				$("#idHomeSctBody").css("display", "block");
				$("#idMuestraPersona").css("display", "none");
				$("#imgIdHeaderHome").html("<img src='" + contextvu + "/resources/img/sct_img.jpg' alt='' />");
				$('#idHomeSctBody').load(response);
			}
		});
		
	});	
		
});
