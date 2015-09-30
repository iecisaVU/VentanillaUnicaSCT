(function() {

	var adminPersonasApp = angular.module('adminPersonasApp',[]);
	console.log(".....................................Entras angular app adminPersonasApp..............................");
	adminPersonasApp.directive('adminPersonas', function(){
		console.log(".....................................Entras angular app Directiva..............................");
		return{			
			restrict: 'E',
			templateUrl: contextvu +'/adminPersonas/adminPersonas.jsp'
		}
	});


	adminPersonasApp.controller('personasController', ['$http','$scope', function($http,$scope) {
		console.log(".....................................Entras angular controllers personasController..............................");
		var adminPersonas = this;
		adminPersonas.reportes=[];		
		adminPersonas.lstPersonas=[];
		adminPersonas.persona;
		adminPersonas.personaMedPreven;
		adminPersonas.personaSession;
		adminPersonas.parametroNotificacion;
		adminPersonas.parametroApoderado;		
		adminPersonas.viewacuseRecibo=false;
		adminPersonas.viewPersonaInsertar=true;
		adminPersonas.mensajeAdmin;
		//Recupera al usuario que se logueo
		$http.get(contextvu +'/adminPersonas/personaSession.sct').success(function(data) {
			adminPersonas.personaSession = data;			
			console.log("cvVars.personaSession "+adminPersonas.personaSession.rfc);
		});		

		//Recupera las personas asociadas al usuario que se logueo
		$http.get(contextvu +'/adminPersonas/verPersonasAdmin.sct').success(function(data) {
			angular.forEach(data, function(value, key) {
				adminPersonas.persona = value;
				var tipoPersona = {idCatTipoPersona:adminPersonas.persona.idTipoPersona};
				adminPersonas.persona.nombre+= " "+adminPersonas.persona.apPaterno +"  "+adminPersonas.persona.apMaterno;
				adminPersonas.persona.tipoPersona = tipoPersona;
				adminPersonas.persona.activo= adminPersonas.persona.estatusTramite==4?true:adminPersonas.persona.estatusTramite==5?false:false;
				adminPersonas.lstPersonas.push(adminPersonas.persona);
			});
		});
		//Recupera el parametro de maximo de notificaciones activas
		$http.get(contextvu +'/adminPersonas/parametroNotificaciones.sct').success(function(data) {
			adminPersonas.parametroNotificacion = data;			
			console.log("cvVars.parametroNotificacion "+adminPersonas.parametroNotificacion.valor);
		});
		//Recupera el parametro de maximo de apoderados activao
		$http.get(contextvu +'/adminPersonas/parametroApoderado.sct').success(function(data) {
			adminPersonas.parametroApoderado = data;			
			console.log("cvVars.parametroApoderado "+adminPersonas.parametroApoderado.valor);
		});
		//Recupera el catalogo de tipo de persona Apoderado, notificaciones
		$http.get(contextvu +'/adminPersonas/catTipoPersona.sct').success(function(data) {
			adminPersonas.lstTipoPersona = data;			
		});

		/////Agrega una persona/////////
		this.addPersona= function(){
			console.log("Entra a addPersona");
			adminPersonas.persona={personaAsociada :adminPersonas.personaSession.idPersona ,nombre: '',rfc: '', curp: '', email:'' , activo: false,  tipoPersona: { descripcion: ''}};
			if(adminPersonas.persona===undefined){				
				adminPersonas.lstPersonas = [adminPersonas.persona];
			}else{				
				adminPersonas.lstPersonas.push(adminPersonas.persona);
			}
		}
		//////////////Metodo para eliminar una Persona de lista////////////////////
//		this.removePersona = function(persona){
//		console.log(persona.idPersona);
////		if(persona.idPersona != undefined && familia.idFamiliar != null){
////		$http.delete('./solicitudes/eliminaFamiliarSolicitud/' + familia.idFamiliar)
////		.success(function(data) {
////		console.log("El familiar se elimino correctamente :"+data);
////		});				
////		}
//		var posicion = adminPersonas.lstPersonas.indexOf(persona);
//		console.log("posicion " + posicion);
//		adminPersonas.lstPersonas.splice(posicion, 1);
//		}

		this.buscaPersonas= function(){
			console.log("curp a consultar: " + adminPersonas.filtroCurp);	
			$http({url:contextvu +'/adminPersonas/buscaPersonasCurp.sct',method: "GET",params:{curp:adminPersonas.filtroCurp}}).success(function(data) {
				console.log("data de curp :"+data);
				adminPersonas.personaMedPreven = data;
				if(adminPersonas.personaMedPreven===null ||adminPersonas.personaMedPreven==="" ||adminPersonas.personaMedPreven===undefined){
					$("#mensajes").html("");
					$("#mensajes").html("Sus datos no se encontraron en medicina preventiva <br> No puede agregar esta persona.");
					$("#idModalMessage").modal();
				}else{
					var nombreMedPreven = adminPersonas.personaMedPreven.cNombre + " "+adminPersonas.personaMedPreven.capPaterno+" "+adminPersonas.personaMedPreven.capMaterno;
					
					adminPersonas.persona={personaAsociada :adminPersonas.personaSession.idPersona ,nombre: nombreMedPreven,
							rfc: adminPersonas.personaMedPreven.cRfc, curp: adminPersonas.filtroCurp, email:'' , activo: false,  tipoPersona: { descripcion: ''}};
					if(adminPersonas.persona===undefined){				
						adminPersonas.lstPersonas = [adminPersonas.persona];
					}else{				
						adminPersonas.lstPersonas.push(adminPersonas.persona);
					}
				}

			}).error(function(data, status, headers, config) {
				console.info("Error");
				adminPersonas.viewacuseRecibo=false;
				adminPersonas.viewPersonaInsertar=true;
				$("#mensajes").html("");
				$("#mensajes").html("Conection refused.");
				$("#idModalMessage").modal();
			});	

		}

		this.guardarPersonas = function(){
			console.log("Personas a guardar: " + angular.toJson(adminPersonas.lstPersonas));	
			var countapoderado=0;
			var countNotificaciones=0;
			adminPersonas.mensajeAdmin=" ";
			angular.forEach(adminPersonas.lstPersonas, function(value, key) {
				adminPersonas.persona = value;
				if(adminPersonas.persona.tipoPersona.idCatTipoPersona==1 && adminPersonas.persona.activo ){						
					countNotificaciones++;
				}
				if(adminPersonas.persona.tipoPersona.idCatTipoPersona==2 && adminPersonas.persona.activo){					
					countapoderado++;
				}				
			});
			console.log("adminPersonas.parametroNotificacion :"+adminPersonas.parametroNotificacion.valor);
			if(countNotificaciones > adminPersonas.parametroNotificacion.valor ){
				adminPersonas.mensajeAdmin+="Solo puede haber 5 Persona Activas para escuchar Notificaciones";	
			}
			console.log("adminPersonas.parametroApoderado :"+adminPersonas.parametroApoderado.valor);
			if(countapoderado > adminPersonas.parametroApoderado.valor){
				adminPersonas.mensajeAdmin+="<br> Solo puede haber 1 Persona Activa Como Apoderado Legal";	
			}
			if(countapoderado > adminPersonas.parametroApoderado.valor || countNotificaciones > adminPersonas.parametroNotificacion.valor){
				console.log(adminPersonas.mensajeAdmin);
				$("#mensajes").html("");
				$("#mensajes").html(adminPersonas.mensajeAdmin);
				//$("#idModalMessage").modal("show");				
				return false;
			}			
			$http.post(contextvu +  '/adminPersonas/agregarPersonaAdmin.sct', angular.toJson(adminPersonas.lstPersonas)).success(
					function(data, status, headers, config) {
						console.info("guarda------------------>>>>>>"+headers("SCTResponse"));						
						$("#mensajes").html("");
						$("#mensajes").html(headers("SCTResponse"));
						//$("#idModalMessage").modal("show");						

						console.info("guardas _________>>>>>>>");
						$http.get(contextvu +  '/adminPersonas/verPersonasAdmin.sct').success(function(data) {
							adminPersonas.lstPersonas=[];
							angular.forEach(data, function(value, key) {
								adminPersonas.persona = value;
								console.log("adminPersonas.persona.tipoPersona "+adminPersonas.persona.tipoPersona);
								var tipoPersona = {idCatTipoPersona:	adminPersonas.persona.idTipoPersona};
								adminPersonas.persona.nombre+= " "+adminPersonas.persona.apPaterno +" "+adminPersonas.persona.apMaterno;
								adminPersonas.persona.tipoPersona = tipoPersona;
								adminPersonas.persona.activo= adminPersonas.persona.estatusTramite==4?true:adminPersonas.persona.estatusTramite==5?false:false;
								adminPersonas.lstPersonas.push(adminPersonas.persona);
							});
							$http({ method:"POST",url:contextvu +'/adminPersonas/acuseActividad.sct',data:angular.toJson(adminPersonas.lstPersonas),
								headers:{'Content-type': 'application/json'},responseType: 'arraybuffer'}).success(function(data, status, headers, config) {							
									var filePDF = new Blob([data], {type: "application/pdf"});
									saveAs(filePDF, headers("SCTResponse") );
								});

						}).error(function(data, status, headers, config) {
							console.info("Error");
							adminPersonas.viewacuseRecibo=false;
							adminPersonas.viewPersonaInsertar=true;
							$("#mensajes").html("");
							$("#mensajes").html("Conection refused.");
							//$("#idModalMessage").modal();
						});	

					}).error(function(data, status, headers, config) {
						console.info("Error");
						adminPersonas.viewacuseRecibo=false;
						adminPersonas.viewPersonaInsertar=true;
						$("#mensajes").html("");
						$("#mensajes").html(headers("SCTResponse"));
						//$("#idModalMessage").modal();
					});	
		}

	} ]);
})();
