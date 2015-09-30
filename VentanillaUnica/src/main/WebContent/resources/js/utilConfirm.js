

$(document).ready(function() {
	
$('#goTramites').click(function() {		
		$.ajax({
			url : contextvu +  '/goToTramites.sct',
			data : {				
			},			
			success : function(response) {
				$('#idAccesoConfirmacion').load(response);
			}
		});
	});
});
