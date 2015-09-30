<%-- 
    Document   : Confirmacion SCT
    Created on : 24/09/2015, 03:49:03 PM
    Author     : huribe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventanilla Unica</title>
        <script src="<spring:url value='/resources/js/jquery-1.9.1.min.js' />" type="text/javascript"></script>
        <jsp:include page="/template/template.jsp"/>
    </head>
    <body>
        <div>
            <br/>
            <div class="row">
                <div id="idHeaderLogin" class="col-sm-12">
                <jsp:include page="/template/header.jsp"/> 
                </div>                
            </div>
            <div class="row">
                <div id="idConfirmSctBody" class="col-sm-12">
                
                </div>    
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <jsp:include page="/template/footer.jsp"/>
                </div>                
            </div>
        </div>
        <script>var contextvu = '<%=request.getContextPath()%>';</script>
        <script src="<spring:url value='/resources/js/confirmacion.js'/>" type="text/javascript"></script>
     </body>
</html>