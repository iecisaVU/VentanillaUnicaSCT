<%-- 
Document   : header
Created on : 31/08/2015, 01:47:34 PM
Author     : jcalbarran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page import="mx.gob.sct.dgaf.model.TPersona" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="<spring:url value='/resources/js/jquery-1.9.1.min.js' />" type="text/javascript"></script>
        <title></title>              
    </head>
    <body>
    		
    	<div class="row">
            <div class="col-md-1">

            </div> 
            <div class="col-md-4">
                <div class="row" id="imgIdHeaderHome">
                    
                </div>
            </div>    
            <div class="col-md-7">
                <div class="row">
                    <div class="col-md-11">
                        <div class="row" > 
                            <div class="col-sm-4">
                                <label class="control-label ">
                                <%= ((TPersona)request.getSession().getAttribute("TPersona")).getRfc() %>
                                </label>
                            </div>
                            <div class="col-sm-3">
                                <button type="button" class="btn btn-primary" style="background-color: #393C3E;">                   
                                    <span class="glyphicon glyphicon-user"> Mi perfil</span>
                                </button>
                            </div>
                            <div class="col-sm-4">
                                <button id="idAdmonUsuarios" type="button" class="btn btn-primary" style="background-color: #393C3E;"> 
                                    Admon. Usuarios 
                                </button>
                            </div>
                            <div class="col-sm-1">
                                <button id="idCerrarSesion" type="button" class="btn btn-danger" style="background-color: #393C3E;">                   
                                    <span class="glyphicon glyphicon-off"  ></span>
                                </button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <h3 id="sistema-de-reticula">Dirección General de Autotransporte Federal</h3>
                        <hr class="red"></hr>
                    </div>
                </div>
            </div>
        </div>
		
	<script>var contextvu = '<%=request.getContextPath()%>';</script>
    <script src="<spring:url value='/resources/js/util.js'/>" type="text/javascript"></script>
    </body>
</html>
