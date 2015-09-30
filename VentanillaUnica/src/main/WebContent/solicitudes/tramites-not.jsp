<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<spring:url value="/verTramites.sct" var="tramproc" />
<div class="container">
	<div class="row">
		<div class="col-sm-10">
			
			<div class="row" >
				<h6 style="padding-left:10px"><font color="#545454"><spring:message code="sol.tram.not.lab"/></font></h6>
				<hr style="color: #545454; background-color: #545454; height: 5px;" align="left" />
			</div>
			<div class="row">
				<table class="table table-hover table-responsive" style="border-style:solid;border-width: 1px; border-color:#F6F6F6" id="idTramNot">
					<thead style="background-color: #393C3E">
						<tr bordercolor="White">
							<td><font color="White"></font></td>
							<td><font color="White"><spring:message code="sol.tram.not.fol" /></font></td>
							<td><font color="White"><spring:message code="sol.tram.not.rfc" /></font></td>
							<td><font color="White"><spring:message code="sol.tram.not.nom" /></font></td>
							<td><font color="White"><spring:message code="sol.tram.not.fec" /></font></td>
							<td><font color="White"><spring:message code="sol.tram.not.not" /></font></td>
							
						</tr>
					</thead>
					<tbody id="idTabTramNot">
					</tbody>
				</table>
			</div>
			
			
		</div>
	</div>
</div>

<script>var contextvu = '<%=request.getContextPath()%>';</script>
<script src="<spring:url value='/resources/js/utilTramitesNot.js'/>" type="text/javascript"></script>

	