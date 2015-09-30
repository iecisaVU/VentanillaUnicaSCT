$(document).ready(function() {
	
	$('#idTramFin').on('click','.btn', function() {
		var idSolSel = $(this).attr('id');
		console.log("----------load detalle-----");
		
		$.ajax({
			url :  contextvu +  '/viewSelTramAct.sct',
			type: 'GET',
			data: ({idSolSel : idSolSel}),
			success : function(data) {
				$("#idTabTramFinSel tr").remove();
				var table = $('#idTabTramFinSel');
				var numReg = data.length;
				var regFolio = false;
				
				$.each(data, function(i, item) {
					var renglon = $('<tr/>');
					var tdfolio = $('<td style="vertical-align:middle;" />');
					if(false == regFolio){
						tdfolio.attr('rowspan',numReg).addClass("critical").text(item.folio);
						regFolio = true;
						renglon.append(tdfolio);
					} 
					
					renglon
					.append($('<td/>').text(item.fecView))
					.append($('<td/>').text(item.detalle));
			         table.append(renglon);
				});
			}
		});
	});
	
	
	$("#idTramFin").ready(function(){
		console.log("----------loadTramFin-----");
		$.ajax({
			url :  contextvu +  '/loadTramFin.sct',
			success : function(data) {
				var table = $('#idTabFinAct');
				$.each(data, function(i, item) {
					var renglon = $('<tr/>');
//					renglon.addClass("clickable-row");
//					renglon.attr("id", "krypton");
					
					renglon.append($('<td/>').text(item.folio))
					.append($('<td/>').text(item.tramite.descDeptoTram))
					.append($('<td/>').text(item.tramite.descTram))
					.append($('<td/>').text(item.fecView))
					.append($('<td/>').text(item.estSol.descEst));
					
					var seccion = $('<td/>');
//					var acusebttn = $('<a class="btn btn-default pull-right  btn-xs" id="'+
//					item.idSolicitud + '"><span class="glyphicon glyphicon-ok-sign"></span></a>');
					var acusebttn = $('<a/>');
					acusebttn.addClass("btn btn-default pull-right  btn-xs");
					acusebttn.attr("id", item.idSolicitud);
					var acusegly = $('<span/>');
					acusegly.addClass("glyphicon glyphicon-ok-sign");
					acusegly.attr("data-toggle", "tooltip");
					acusegly.attr("data-placement", "bottom");
					acusegly.attr("title", "Ver Detalles");
					acusebttn.append(acusegly);
					
					seccion.append(acusebttn);
					renglon.append(seccion);
			        table.append(renglon);
				});        	 

			}
		});

	});
	
});

