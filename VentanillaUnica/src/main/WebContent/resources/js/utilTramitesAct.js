$(document).ready(function() {
	
	$("#tramNomF").ready(function(){
		console.log("----------load nom tram-----");
		$.ajax({
			url :  contextvu +  '/loadTramNom.sct',
			type: 'GET',
			success : function(data) {
				console.log(data);
				var table = $('#tramNomF');
				table.text(data);
			}
		});
	});
	
	$('#idTabTramAct').on('click','.btn', function() {
		var idSolSel = $(this).attr('id');
		console.log("----------load detalle-----");
		
		$.ajax({
			url :  contextvu +  '/viewSelTramAct.sct',
			type: 'GET',
			data: ({idSolSel : idSolSel}),
			success : function(data) {
				$("#idTabTramSel tr").remove();
				var table = $('#idTabTramSel');
				var numReg = data.length;
				var regFolio = false;
				console.log(data.length);
				
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
	
	$("#idTabTramAct").ready(function(){
		console.log("----------loadTramAct-----");
		$.ajax({
			url :  contextvu +  '/loadTramAct.sct',
			success : function(data) {
				var table = $('#idTabTramAct');
				$.each(data, function(i, item) {
					var renglon = $('<tr/>');
					renglon.append($('<td/>').text(item.tramite.cveTram))
					.append($('<td/>').text(item.tramite.descTram))
					.append($('<td/>').text(item.estSol.descEst));
					
					var seccion = $('<td/>');
					var acusebttn = $('<a/>');
					acusebttn.addClass("btn btn-default pull-right  btn-xs");
					acusebttn.attr("id", item.idSolicitud);
					var acusegly = $('<span/>');
					acusegly.addClass("glyphicon glyphicon-ok-sign");
					acusegly.attr("data-toggle", "tooltip");
					acusegly.attr("data-placement", "bottom");
					acusegly.attr("title", "Ver Detalles");
					acusebttn.append(acusegly);
//					var acusebttn = $('<a class="btn btn-default pull-right  btn-xs" id="'+
//							item.idSolicitud + '"><span class="glyphicon glyphicon-ok-sign"></span></a>');
					seccion.append(acusebttn);
			        renglon.append(seccion);
			        table.append(renglon);
				});        	 

			}
		});

	});
	
});

