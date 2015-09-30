<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<div class="container">
	<div class="row">
		<div class="col-sm-10">
			<div class="row">
				<div class="col-md-10">
					<h6 style="padding-left:10px"><font color="#545454"><spring:message code="sol.tram.fin.lab"/></font></h6>
				</div>
				<div class="col-md-1" align="center">
					<a href='<spring:url value="/downRepFin.sct" />' >
					<button type="button" class="btn btn-xs btn-danger" id="descargaPDF" >
						<span class="glyphicon glyphicon-download-alt" 
						title="<spring:message code="sol.tram.fin.dow" />" 
						data-placement="bottom" data-toggle="tooltip"
						>
						</span><spring:message code="sol.tram.fin.pdf" />
					</button></a>
				</div>
				<div class="col-md-1" align="center">
					<a href='<spring:url value="/downRepFinXLS.sct" />' >
					<button type="button" class="btn btn-xs btn-success" id="descargaXLSX" >
						<span class="glyphicon glyphicon-download-alt" 
						title="<spring:message code="sol.tram.fin.dow" />" 
						data-placement="bottom" data-toggle="tooltip"
						>
						</span><spring:message code="sol.tram.fin.xls" />
					</button></a>
				</div>
			</div>
			<div class="row">
				<hr style="color: #545454; background-color: #545454; height: 5px;" align="left" />
			</div>
			<div class="row">
				<table class="table table-hover table-responsive" style="border-style:solid;border-width: 1px; border-color:#F6F6F6" id="idTramFin">
					<thead style="background-color: #393C3E">
						<tr bordercolor="White">
							<td><font color="White"><spring:message code="sol.tram.fin.fol" /></font></td>
							<td><font color="White"><spring:message code="sol.tram.fin.dep" /></font></td>
							<td><font color="White"><spring:message code="sol.tram.fin.des" /></font></td>
							<td><font color="White"><spring:message code="sol.tram.fin.fec" /></font></td>
							<td><font color="White"><spring:message code="sol.tram.fin.est" /></font></td>
							<td><font color="White"></font></td>
						</tr>
					</thead>
					<tbody id="idTabFinAct">
					</tbody>
				</table>
			</div>
			
			
			<div class="row" >
				<h6 style="padding-left:10px"><font color="#545454"><spring:message code="sol.tram.det.lab"/></font></h6>
				<hr style="color: #545454; background-color: #545454; height: 5px;" align="left" />
			</div>
			
			<div class="row">
				<table class="table table-hover table-responsive" style="border-style:solid;border-width: 1px; border-color:#F6F6F6" id="idTramFinSel">
					<thead style="background-color: #393C3E">
						<tr bordercolor="White">
							<td><font color="White"><spring:message code="sol.tram.det.fol" /></font></td>
							<td><font color="White"><spring:message code="sol.tram.det.fec" /></font></td>
							<td><font color="White"><spring:message code="sol.tram.det.det" /></font></td>
						</tr>
					</thead>
					<tbody id="idTabTramFinSel">
					</tbody>
				</table>
			</div>
			
		</div>
	</div>
</div>

<script>var contextvu = '<%=request.getContextPath()%>';</script>
<script src="<spring:url value='/resources/js/utilTramitesFin.js'/>" type="text/javascript"></script>

	