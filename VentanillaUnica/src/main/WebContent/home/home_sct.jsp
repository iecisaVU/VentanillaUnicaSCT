<%-- 
    Document   : Home SCT
    Created on : 30/08/2015, 03:49:03 PM
    Author     : jcalbarran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html ng-app="SCTApp">
    <head>

<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.6/angular.min.js"></script>
 <link href="http://framework-gb.cdn.gob.mx/assets/styles/main.css" rel="stylesheet">
 <script src="<spring:url value='/resources/js/adminPersonas.js'/>" type="text/javascript"></script>
        <script src="<spring:url value='/resources/general/FileSaver.min.js' />" type="text/javascript"></script>
         <script src="<spring:url value='/resources/js/welcome.js'/>" type="text/javascript"></script>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventanilla Unica</title>
        <jsp:include page="/template/template.jsp"/>
    </head>
    <body>
        <div>
            <br/>
            <div class="row">
                <div class="col-sm-12">
                    <jsp:include page="/template/headerHome.jsp"/>
                </div>                
            </div>
            <div class="row">
                <div id="idHomeSctBody" class="col-sm-12">                    
                	
                </div>  
                <div id="idMuestraPersona" class="col-sm-12" >
                    	<admin-personas></admin-personas>
                   </div>  
            </div>
            <div class="row">
                <div class="col-sm-12">
                    <jsp:include page="/template/footer.jsp"/>
                </div>                
            </div>
        </div>
        <script>var contextvu = '<%=request.getContextPath()%>';</script>
        <script src="<spring:url value='/resources/js/utilHome.js'/>" type="text/javascript"></script>
     </body>
</html>
