<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<div class="container">

	<div id="idConfirmacionBody" class="col-md-12" >
        <div class="row">
           		<h2>Confirmaci&oacute;n de Registro de Ingreso a<br>
           				    Ventanilla &Uacute;nica
           		</h2>
           		<hr class="red">
        </div>
        	
        <div class="alert alert-warning"></div>	
        	
        <div class="row" align="center">
        		<h3>Correo Electr&oacute;nico Confirmado</h3>
        </div>	   
        <br>    

        <div class="row">
			<p>
				Con la finalidad de agilizar sus tr&aacute;mites, la Secretar&iacute;a de Comunicaciones y Transportes
				pone a su disposici&oacute;n la Ventanilla &Uacute;nica de Autotransporte Federal, cuyo requisito
				indispensable es que el solicitante cuente con su Firma Electr&oacute;nica Avanzada (FIEL).
			</p>
			<p>
				Se ha confirmado su correo electr&oacute;nico de manera satisfactoria. A partir de este momento puede realizar
				tr&aacute;mites v&iacute;a Ventanilla &Uacute;nica de la Direccion General de Autotransporte Federal. 
				mediante su FIEL (Firma Electr&oacute;nica Avanzada) para conocer m&aacute;s del proceso de tr&aacute;mites  
				en Ventanilla &Uacute;nica DGAF, puede leer el Manual de Ventanilla &Uacute;nica y/o las condiciones de uso.
			</p>
    	</div> 
    	<br>

		<div class="row" align="right">
    		<button id="goTramites" class="btn btn-primary" type="submit">Ir a Tramites</button>
		</div>
    	
    </div>

</div>

<script>var contextvu = '<%=request.getContextPath()%>';</script>
<script src="<spring:url value='/resources/js/utilConfirm.js'/>" type="text/javascript"></script>