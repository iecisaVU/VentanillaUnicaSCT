<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<spring:url value="/verTramites.sct" var="tramproc" />
<div class="container">
	<div class="row">
		<div class="col-sm-10">
			<div class="row" >
				<h6 style="padding-left:10px"><font color="#545454"><spring:message code="sol.tram.act.lab"/></font></h6>
				<hr style="color: #545454; background-color: #545454; height: 5px;" align="left" />
			</div>
			<div class="row">
				<table class="table table-hover table-responsive" style="border-style:solid;border-width: 1px; border-color:#F6F6F6" id="idTramAct">
					<thead style="background-color: #393C3E">
						<tr bordercolor="White">
							<td><font color="White"><spring:message code="sol.tram.act.no" /></font></td>
							<td><font color="White"><spring:message code="sol.tram.act.desc" /></font></td>
							<td><font color="White"><spring:message code="sol.tram.act.est" /></font></td>
							<td><font color="White"></font></td>
						</tr>
					</thead>
					<tbody id="idTabTramAct">
					</tbody>
				</table>
			</div>
			
			<div class="row" >
				<h6 style="padding-left:10px"><font color="#545454"><spring:message code="sol.tram.det.lab"/></font></h6>
				<hr style="color: #545454; background-color: #545454; height: 5px;" align="left" />
			</div>
			
			<div class="row">
				<table class="table table-hover table-responsive" style="border-style:solid;border-width: 1px; border-color:#F6F6F6" id="idTramSel">
					<thead style="background-color: #393C3E">
						<tr bordercolor="White">
							<td><font color="White"><spring:message code="sol.tram.det.fol" /></font></td>
							<td><font color="White"><spring:message code="sol.tram.det.fec" /></font></td>
							<td><font color="White"><spring:message code="sol.tram.det.det" /></font></td>
						</tr>
					</thead>
					<tbody id="idTabTramSel">
					</tbody>
				</table>
			</div>
			
		</div>
	</div>
</div>

<script>var contextvu = '<%=request.getContextPath()%>';</script>
<script src="<spring:url value='/resources/js/utilTramitesAct.js'/>" type="text/javascript"></script>

	