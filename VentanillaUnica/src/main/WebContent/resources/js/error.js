$(document).ready(function() {
	
	$('#idcargaPagBtn').click(function() {		
		$.ajax({
			url :  contextvu +  '/cargaPag.sct',
			data : {
			},
			success : function(response) {				
				$('#idHomeSctBody').load(response);
			}
		});
	});	
		
});