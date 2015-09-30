<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<div class="row">
	<div class="col-sm-12">
		<div class="panel-group" id="accordion"></div>
	</div>
	<div class="modal fade" id="confirm-send" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
               <spring:message code="sol.nav.lab.nu" />
            </div>
            <div class="modal-body" id="mensajeCnf" ></div>
            <div class="modal-footer" id="mensajeCnfF">
                <button type="button" class="btn btn-default btn-s" data-dismiss="modal" id="btnconfirm">OK</button>
            </div>
        </div>
    </div>
</div>
</div><script>var contextvu = '<%=request.getContextPath()%>';</script>
<script src="<spring:url value='/resources/js/utilTramitesNuv.js'/>"
	type="text/javascript"></script>