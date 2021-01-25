<%-- 
    Document   : visorLogAuditoria
    Created on : mar 4, 2019, 11:32:32 a.m.
    Author     : Andres Gonzalez
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<h3>Log de Auditoría</h3>
<hr/>
<p>Seleccione el rango de fechas para realizar la consulta.</p>
<br>
<c:if test="${not empty mensaje}">
    <c:if test="${status=='1'}">
        <div class="alert alert-success"> <i class="fa fa-check-circle"></i> ${mensaje}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
    <c:if test="${status=='0'}">
        <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
</c:if>
<div id="valora">
    <div class="form-group">
        <div class="form-row m-b-20">

            <div class="col">
                <label for="fechaI">Fecha Inicio</label>
                <div class="controls">
                    <input  id="fechaI" type="text" class="form-control setDay" placeholder="Fecha Inicial" required data-validation-required-message="Seleccione una fecha">
                </div>
            </div>
            <div class="col">
                <label for="fechaF">Fecha Fin</label>
                <div class="controls">
                    <input  id="fechaF" type="text" class="form-control setDay" placeholder="Fecha Final" required data-validation-required-message="Seleccione una fecha">
                </div>
            </div>
        </div>
    </div>
</div>
<div class="col-md-12 text-center m-b-30">
    <button type="submit" class="btn btn-primary" id="btnFiltro"> <i class="mdi mdi-magnify"></i> Consultar</button>
</div>


<table id="tableData" class="table table-bordered table-striped">
    <thead>
        <tr>
            <th >Usuario</th>
            <th >Módulo</th>
            <th >Acción</th>
            <!--            <th>Id Elemento</th>-->
            <th>Fecha Registro</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${not empty registrosLog}">
            <c:forEach items="${registrosLog}" var="log">
                <tr>
                    <td>${log.users.username}</td>
                    <td>${log.modulo}</td>
                    <td>${log.accion}</td>
<!--                    <td>${log.idelemento}</td>-->
                    <td>${log.fecharegistro}</td>
                </tr>

            </c:forEach>
        </c:if>
    </tbody>
</table>

<script src="${pageContext.request.contextPath}/resources/js/services/visorLogAuditoria.js" type="text/javascript"></script>