<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>


<div class="container" ng-controller="personasController as personaCtrl">
	<div class="col-sm-12">
		<h3>Administración de usuarios</h3>
		<h3>Persona Física</h3>
		<hr class="red" />
		<div class="col-sm-12">
			<div align="left">
				<font size="2">{{personaCtrl.personaSession.rfc}}</font>
			</div>
			<div align="left">
				<font size="2">{{personaCtrl.personaSession.nombre}}
					{{personaCtrl.personaSession.apPaterno}}
					{{personaCtrl.personaSession.apMaterno}}</font>
			</div>
			<div class="col-sm-3">				
			</div>
			<div class="col-sm-9" align="right">
				<form class="form-inline" role="form"
					ng-submit="personaCtrl.buscaPersonas()">
					<div class="form-group">
						<label class="col-sm-3 control-label">C.U.R.P.</label>
						<div class="col-sm-2">
							<input type="text" class="form-control input-sm" maxlength="18"
								placeholder="Ej. MART800721456HDFRSS04" required
								ng-model="personaCtrl.filtroCurp" />
						</div>
						<button type="submit" class="btn btn-primary pull-right btn-sm ">Buscar</button>
					</div>
				</form>
			</div>
			<hr>
		</div>
		<div class="col-sm-1"></div>
		<div class="col-sm-10">
			<font size="2"> Usuarios (Apoderado Legal, Personas par ver y
				escuchar notificaciones)</font>
			<form role="form" class="form-inline" name="formPersona"
				ng-submit="personaCtrl.guardarPersonas()">
				<div class="row" style="background-color: #393C3E">
					<div class="col-sm-3" align="center">
						<label><font color="White" size="2">Nombre Completo</font></label>
					</div>
					<div class="col-sm-2" align="center">
						<label><font color="White" size="2">R.F.C.</font></label>
					</div>
					<div class="col-sm-4" align="center">
						<label><font color="White" size="2">Correo
								electrónico</font></label>
					</div>
					<div class="col-sm-2" align="center">
						<label><font color="White" size="2">Tipo</font></label>
					</div>

				</div>

				<div class="row" ng-repeat="persona in personaCtrl.lstPersonas">
					<div class="col-sm-3 input-group">

						<input type="text" class="form-control input-sm" maxlength="70"
							placeholder="Ej. Juan Perez Leon" required
							ng-model="persona.nombre" name="{{persona.nombre}}"
							disabled="disabled" />
					</div>
					<div class="col-sm-2 input-group">

						<input type="text" class="form-control input-sm" maxlength="13"
							placeholder="Ej. MART800721456" required ng-model="persona.rfc"
							disabled="disabled" />

					</div>
					<div class="col-sm-4 input-group">
						<input type="email" class="form-control input-sm" maxlength="40"
							placeholder="Ej. jleon@server.com" required
							ng-model="persona.email" ng-disabled="persona.idPersona != null" />

					</div>
					<div class="col-sm-2 input-group">

						<select class="form-control input-sm" required
							ng-model="persona.tipoPersona.idCatTipoPersona"
							ng-options="tipoPersona.idCatTipoPersona as tipoPersona.descripcion for tipoPersona in personaCtrl.lstTipoPersona">
							<option value="">Seleccione...</option>
						</select>
					</div>
					<div class="checkbox input-group" align="left">
						<input type="checkbox" ng-model="persona.activo" />
					</div>

				</div>
				<br>
				<div class="row">
					<div class="col-sm-4">
						<div class="col-sm-2 col-sm-offset-2">
							<button type="submit" class="btn btn-primary btn-sm">Registrar</button>
						</div>
					</div>
					<jsp:include page="/applet/applet.jsp" />
				</div>
			</form>
		</div>
	</div>


	<script>var contextvu ='<%=request.getContextPath()%>';
	</script>

	<div class="modal fade" id="idModalMessage">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h4 class="modal-title">Administracíon de usuarios</h4>
				</div>
				<div class="modal-body" id="mensajes"></div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
</div>


