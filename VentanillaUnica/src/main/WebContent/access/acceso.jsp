<%-- 
    Document   : acceso
    Created on : 31/08/2015, 02:06:22 PM
    Author     : jcalbarran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">       
        <title></title>        
        <script src="<spring:url value='/resources/js/jquery-1.9.1.min.js' />" type="text/javascript"></script>
        <script>var isConfirm =  '<%=request.getAttribute("userconfirm")%>'</script>
        <script>var rfcConfirm =  '<%=request.getAttribute("ConfirmaRFC")%>'</script>
        <script>var contextvu = '<%=request.getContextPath()%>';</script>
        <script src="<spring:url value='/resources/js/util.js' />" type="text/javascript"></script>
    </head>    
    <body>
    		<div class="row" >            
                 <div class="col-sm-4">
                 </div>
                 <div class="col-sm-4">
                 <h3 id="sistema-de-reticula">Ingresar a Ventanilla Única</h3>
    	         <hr class="red"></hr>
                       <jsp:include page="/applet/applet.jsp"/>
                 </div>
                 <div class="col-sm-4">
                 </div>
           </div> 
	</body>
</html>
