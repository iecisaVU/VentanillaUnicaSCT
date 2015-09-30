$(document).ready(function() {
	
	
	$("#idTramNot").ready(function(){
		console.log("----------loadTramNot-----");
		$.ajax({
			url :  contextvu +  '/loadNotSol.sct',
			success : function(data) {
				var table = $('#idTabTramNot');
				$.each(data, function(index, persona) {
					$.each(persona.listNot, function(i, item) {
						var renglon = $('<tr/>');
						
//						var checkbox = '<input type="checkbox" class="checkboxes">';
//						var casilla = $('<checkbox/>');
//						casilla.attr("id", item.idNotSol);
//						renglon.append(checkbox)
						renglon.append($('<td/>').text(""))
						.append($('<td/>').text(item.folio))
						.append($('<td/>').text(persona.rfc))
						.append($('<td/>').text(persona.nomComple))
						.append($('<td/>').text(item.fecView))
						.append($('<td/>').text(item.notificacion));
				        
						table.append(renglon);
					}); 
				});
			}
		});

	});
	
	$('input[type="checkbox"]').click(function(){
        if($(this).is(":checked")){
            alert("Checkbox is checked.");
        }
        else if($(this).is(":not(:checked)")){
            alert("Checkbox is unchecked.");
        }
    });
	
});

