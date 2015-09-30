/**
 *  Util.js
 *  Cesar Albarran
 */


$(document).ready(function() {
	
	
	$('#idAdmonUsuarios').click(function() {		
		$.ajax({
			url : contextvu +  '/admonUsuarios.sct',
			data : {				
			},			
			success : function(response) {
				$("#idHomeSctBody").css("display", "none");
				$("#idMuestraPersona").css("display", "block");
				//('#idHomeSctBody').load(response);
			}
		});
	});
	
	$('#idCerrarSesion').click(function() {		
		$.ajax({
			url : contextvu +  '/cerrarSession.sct',
			data : {				
			},	
			success : function(response) {
				//if(response=='success'){
				window.location.href = contextvu + '/ventanillaU.sct';
				//}else{
					//alert(response);
				//}
			}
		});
	});
	
	
});

