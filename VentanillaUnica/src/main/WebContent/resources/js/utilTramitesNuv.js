$(document).ready(function() {
	
	
	$("#accordion").on("click", "a.btn", function(){
		var idTramSel = $(this).attr('id');
		console.log("----------load nuevo tramite -----" + idTramSel);
		
		$.ajax({
			url :  contextvu +  '/addTramSel.sct',
			type: 'GET',
			data: ({idTramNuv : idTramSel}),
			success : function(data) {
				console.log("----------load nuevo tramite -----" + data);
				var etiqueta = $('#mensajeCnf');
				etiqueta.text("Se agregó nuevo trámite");
			}, 
			 error:function(data){
				 var etiqueta = $('#mensajeCnf');
				 etiqueta.text('Error al agregar nuevo trámite');
				 var btnconfir = $('#btnconfirm');
//				 btnconfir.removeClass();
				 btnconfir.addClass("btn btn-danger btn-s");
		     }
		});
		
	});
	
	$("#accordion").ready(function(){
		console.log("----------loadListTram-----");
		$.ajax({
			url :  contextvu +  '/getListtram.sct',
			success : function(data) {
				var divheader = $('#accordion');
				$.each(data, function(id, depto) {

var idacordeon = 'collapse' + (id+1);
var nomacordeon = '#collapse' + (id+1);

var acordeon = $('<div/>');
acordeon.addClass("panel panel-default");

var acordeonH = $('<div/>');
acordeonH.addClass("panel-heading");

var acordeonL = $('<h4/>');
acordeonL.addClass("panel-title");

var etiqueta = $('<a/>');
etiqueta.attr("href", nomacordeon);
etiqueta.attr("data-toggle", "collapse");
etiqueta.attr("data-parent", "#accordion");
etiqueta.text(depto.descDeptoTram);

var acordeontram = $('<div/>');
acordeontram.attr("id", idacordeon);
acordeontram.addClass("panel-collapse collapse");

var acordeonul = $('<ul/>');
acordeonul.addClass("list-group");

$.each(depto.tramites, function(index, item) {
var tramite = $('<li/>');
tramite.addClass("list-group-item");
tramite.text(item.descTram);

var adDivTram = $('<div/>');
adDivTram.css('text-align', 'right');

var adHrefTram = $('<a/>');
adHrefTram.addClass("btn btn-xs btn-default");
adHrefTram.attr("id", item.idTramite);
adHrefTram.attr("rel", "sendTram");
adHrefTram.attr("data-toggle", "modal");
adHrefTram.attr("data-target", "#confirm-send");

var adSpanTram = $('<span/>');
adSpanTram.addClass("glyphicon glyphicon-plus-sign");
adSpanTram.attr("data-toggle", "tooltip");
adSpanTram.attr("data-placement", "bottom");
adSpanTram.attr("title", "Agrega Solicitud");

adHrefTram.append(adSpanTram);
adDivTram.append(adHrefTram);
tramite.append(adDivTram);

//var adTrambttn = $('<div style="text-align: right;" ><a class="btn btn-xs btn-default" id="'+ item.idTramite + '" rel="sendTram" data-toggle="modal" data-target="#confirm-send" ><span class="glyphicon glyphicon-plus-sign" /></a></div>');
//tramite.append(adTrambttn);

acordeonul.append(tramite);

					});
acordeontram.append(acordeonul);

//var acordeonF = $('<div/>');
//acordeonF.addClass("panel-footer");
//acordeonF.text("Footer");
//acordeontram.append(acordeonF);

acordeonL.append(etiqueta);
acordeonH.append(acordeonL);
acordeon.append(acordeonH);
acordeon.append(acordeontram);
divheader.append(acordeon);
				});        	 

			}
		});

	});
	
});

