<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<div class="container">
	<div class="col-sm-12" >
	<h3>
		<spring:message code="sol.label.tramite" />
	</h3>
	<div class="col-sm-12" style="background-color: #272829">
		<h2><%=""%></h2>
	</div>
	<div class="col-sm-12" style="background-color: #F6F6F6" >
		<ul class="nav nav-tabs" >
			<li><a data-toggle="tab" href="#tab-01"><spring:message code="sol.nav.lab.nu" /></a></li>
			<li class="active"><a data-toggle="tab" href="#tab-02"><spring:message code="sol.nav.lab.pro" /></a></li>
			<li><a data-toggle="tab" href="#tab-03"><spring:message
						code="sol.nav.lab.fin" /></a></li>
			<li><a data-toggle="tab" href="#tab-04" id="idNumNot"></a></li>
		</ul>
		<div class="tab-content">
			<div class="tab-pane" id="tab-01"></div>
			<div class="tab-pane active" id="tab-02"></div>
			<div class="tab-pane" id="tab-03"></div>
			<div class="tab-pane" id="tab-04"></div>
		</div>
	</div>
	</div>
</div>
<script>var contextvu = '<%=request.getContextPath()%>';</script>
<script src="<spring:url value='/resources/js/utilTramites.js'/>" type="text/javascript"></script>
