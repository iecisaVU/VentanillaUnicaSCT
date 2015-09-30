<%-- 
    Document   : SCT
    Created on : 30/08/2015, 03:49:03 PM
    Author     : jcalbarran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ventanilla Unica</title>
        <jsp:include page="/template/template.jsp"/>            
    </head>
    <body>
        <div>
            <div class="row">
                <div id="idHeaderLogin" class="col-sm-12">
                <jsp:include page="/template/header.jsp"/> 
                </div>                
            </div>
            <div class="row">
                <div id="idAccesoLogin" class="col-sm-12">
                <jsp:include page="/access/acceso.jsp"/>
                 </div>    
            </div>
            <div class="row">
                <div id="idFooterLogin" class="col-sm-12">  
                <jsp:include page="/template/footer.jsp"/>                   
                </div>                
            </div>
        </div>
	   
    </body>
</html>
