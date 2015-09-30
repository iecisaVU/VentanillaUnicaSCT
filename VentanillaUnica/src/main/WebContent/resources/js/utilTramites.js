$(document).ready(function() {
	
	$(".nav a").ready(function(){
		console.log("----------functionA-----");
		$.ajax({
			url : contextvu +  '/viewTramAct.sct',
			data : {
				
			},			
			success : function(response) {
				$('#tab-02').load(response);
			}
		});
	});
	
	$('.nav a[href="#tab-01"]').on("click", function(){
		console.log("----------functionB-----");
		$.ajax({
			url : contextvu +  '/viewTramNuv.sct',
			data : {
				
			},			
			success : function(response) {
				$('#tab-01').load(response);
			}
		});
	});
		
	
	$('.nav a[href="#tab-02"]').on("click", function(){
		console.log("----------functionC-----");
		$.ajax({
			url : contextvu +  '/viewTramAct.sct',
			data : {
				
			},			
			success : function(response) {
				$('#tab-02').load(response);
			}
		});
	});
	
	$('.nav a[href="#tab-03"]').on("click", function(){
		console.log("----------functionD-----");
		$.ajax({
			url : contextvu +  '/viewTramFin.sct',
			data : {
				
			},			
			success : function(response) {
				$('#tab-03').load(response);
			}
		});
	});
	
	$('.nav a[href="#tab-04"]').on("click", function(){
		console.log("----------functionE-----");
		$.ajax({
			url : contextvu +  '/viewTramNot.sct',
			data : {
				
			},			
			success : function(response) {
				$('#tab-04').load(response);
			}
		});
	});
	
	$("#idNumNot").ready(function(){
		console.log("----------idNumNot-----");
		$.ajax({
			url :  contextvu +  '/loadNotNum.sct',
			success : function(data) {
				console.log(data);
				var etiqueta = $('#idNumNot');
				etiqueta.text('Notificaciones (' + data + ')');
			}
		});
	});

	
});

