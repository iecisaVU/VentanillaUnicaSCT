<%-- 
    Document   : footer
    Created on : 31/08/2015, 01:56:42 PM
    Author     : jcalbarran
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <body>
    <hr/>
         <div>
            <div class="row" >
                <div class="col-sm-12 text-center" style="font-size: 12px;"> 
                    <!-- label class="control-label text-info" ><spring:message code="title.footer" /></label-->
                    Dirección General de Autotransporte Federal<br/>
					Calzada de las Bombas #411, Col. Los Girasoles<br/>
					Delegación Coyoacán, México D.F., C.P. 04920                    
                </div>
            </div>
        </div>
        <div class="modal fade" id="idModalMessage">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Administracíon de usuarios</h4>
      </div>
      <div class="modal-body" id="mensaje">
       
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default" data-dismiss="modal">Cerrar</button>
      </div>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
    </body>
</html>
