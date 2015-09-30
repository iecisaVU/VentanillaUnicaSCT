<%-- 
    Document   : Registo de personas
    Created on : 
    Author     : 
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Ventanilla Unica</title>
<jsp:include page="/template/template.jsp" />
</head>

<body ng-app="regPersonasApp">


	<div>
		<div class="row">
			<div class="col-md-12">
				<jsp:include page="/template/headerHome.jsp" />
			</div>
		</div>
		<br>

		<div class="container">

			<div id="idHomeSctBody" class="col-md-12" >

				<div class="row">
					<div id="idHomeSctBody" class="col-sm-12 ">
						<h3>Registro de persona física</h3>
					</div>
				</div>

				</br>
				
				<div class="row">
					<div class="col-xs-12 col-md-12 columna ">

						<div class="row" style="background-color: #DDDDDD">
								<font color="Black">Se ha detectado que usted no
									tiene un usuario para la realización de trámites en la SCT.
									Introduzca un correo electrónico que pueda verificar para
									proceder a registrarlo y poder realizar trámites en la
									institución</font> </br>
							<font color="Black">Cualquier duda respecto al proceso de trámites sirvase leer las </font>
							<a href=>Condiciones de uso</a>
						</div>

					</div>
				</div>
				
				</br>
				
				<div class="row">

					<div class="col-xs-12 col-md-2  "></div>
					<div class="col-xs-12 col-md-8 columna ">

						<div class="row" style="background-color: #393C3E">
							<div class="col-xs-12 columna ">
								<font color="White">Registro de persona física</font>
							</div>
						</div>

					</div>
				</div>

				<form role="form" class="form-inline" ng-submit="personaCtrl.guardarPersonas()" ng-controller="regPersonasController as personaCtrl"> 

						<div class="row">
							<div class="col-xs-0 col-md-2  "></div>
							<div class="col-xs-12 col-md-8 columna " ng-repeat="persona in personaCtrl.lstPersonas">

								<div class="row" style="background-color: #393C3E">
									<div class="col-xs-12 col-md-4 columna ">
										<font color="White">Nombre</font>
									</div>
									<div class="col-xs-12 col-md-8 columna ">
										<input type="text" class=" form-control input-sm"   maxlength="70"
											required ng-model="persona.nombre"
											>
									</div>
								</div>
								
								
								<div class="row" style="background-color: #393C3E">
									<div class="col-xs-12 col-md-4 columna ">
										<font color="White">Apellido Materno</font>
									</div>
									<div class="col-xs-12 col-md-8 columna ">
										<input type="text" class="form-control input-sm" maxlength="70"
											required ng-model="persona.apMaterno"
											>
									</div>
								</div>
								<div class="row" style="background-color: #393C3E">
									<div class="col-xs-12 col-md-4 columna ">
										<font color="White">Apellido Paterno</font>
									</div>
									<div class="col-xs-12 col-md-8 columna">
										<input type="text" class="form-control input-sm" maxlength="70"
											required ng-model="persona.apPaterno"
											>
									</div>
								</div>
																
								<div class="row" style="background-color: #393C3E">
									<div class="col-xs-12 col-md-4 columna ">
										<font color="White">Email</font>
									</div>
									<div class="col-xs-12 col-md-8 columna ">
										<input type="email" class="form-control input-sm" maxlength="70"
											required ng-model="persona.email"
											>
									</div>
								</div>
								<div class="row" style="background-color: #393C3E">
									<div class="col-xs-12 col-md-4 columna ">
										<font color="White">Confirma Email</font>
									</div>
									<div class="col-xs-12 col-md-8 columna ">
										<input type="cemail" class="form-control input-sm">
									</div>
								</div>
		

								<div class="row" style="background-color: #393C3E">
									<div class="col-xs-12 col-md-4 columna ">
									</div>
									<div class="col-xs-12 col-md-8 columna ">								
										<font color="White">Firma Electrónica avanzada</font>
									</div>
								</div>
								
								
							</div>
							
		
							<div class="row">
								<div class="col-xs-12 col-md-4"> </div>
								<div class="col-xs-12 col-md-8" style="background-color: #393C3E">
									<input type="checkbox"><font color="White">He
										leído y aceptado las condiciones de uso </font>
									<button type="submit" class="btn btn-primary pull-right  btn-xs"
										id="btnSiguiente" />
									<span class="glyphicon glyphicon-ok"></span>Siguiente
								</div>
							</div>
							
							
							
							
						</div>
				</form> 

			</div>

		</div>
		--------------------- -
	</div>
	<div class="row">
		<div class="col-sm-12">
			<jsp:include page="/template/footer.jsp" />
		</div>
	</div>
	<script>var contextvu = '<%=request.getContextPath()%>';</script>



</body>
</html>
