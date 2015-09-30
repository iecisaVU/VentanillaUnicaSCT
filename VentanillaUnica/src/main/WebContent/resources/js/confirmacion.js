//alert("Entra a js")

$(document).ready(function() {

	//alert("Entra a js")
	/*
	$(function() {
		$.ajax({
			type:'GET',
			url :  contextvu +  '/confirmar.sct',
			dataType:"json",
			data:{'rfcTxt':$('#rfcTxt').val()},			
			success : function(data){
				console.log("persona "+data);
			}
		});
		
	});	*/
	
	$(function() {
		//alert("confirmar.sct")
		$.ajax({
			url : contextvu +  '/confirmar.sct',
			data : {
				
			},			
			success : function(response) {
				//$("#imgIdHeaderHome").html("<img src='" + contextvu + "/resources/img/sct_img.jpg' alt='' />");
				$('#idConfirmSctBody').load(response);
			}
		});
		
	});	
	
		
});
		
