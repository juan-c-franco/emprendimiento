<%-- 
    Document   : moduloCiclo
    Created on : jul 9, 2019, 11:45:22 a.m.
    Author     : Andres Gonzalez
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!-- Contenido de la pagina  -->
<h3>Módulos / Ciclos </h3>
<hr />
<p><i class="mdi mdi-view-headline"></i> Lista de módulos parametrizados en el sistema</p>

<c:if test="${not empty mensaje2}">
    <c:if test="${status2=='1'}">
        <div class="alert alert-success"> <i class="fa fa-check-circle"></i> ${mensaje2}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
    <c:if test="${status2=='0'}">
        <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje2}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
</c:if>
<%--<c:if test="${status=='1'}">--%>
<table id="tableData" class="table table-bordered table-striped">
    <thead>
        <tr>
            <th >Nombre Módulo</th>
            <th >Capacitación Programa</th>
            <th >Intensidad Horaria</th>
            <th >Editar</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${modulos}" var="tempMod">
            <tr>
                <td class="noOverflow">${tempMod.nombremodulociclo}</td>
                <td class="noOverflow"> ${tempMod.capacitacionPrograma.nombrecapacitacionprograma} </td>
                <td> ${tempMod.intensidadhoraria}</td>
                <td align="center"><button type='button' data-index="${tempMod.idmodulociclo}" class='btn btn-sm btn-rounded btn-warning btn-modificar' data-toggle="tooltip" data-placement="top" title="Editar"><i class="fas fa-edit"></i></button></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<div class="text-center">
    <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
    <button class="btn btn-success align-content-center" type="button" id="btn-agregar">Agregar</button>
</div>

<%--</c:if>--%>
<c:if test="${status=='0'}">

    <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
    </div>
</c:if>

<script src="${pageContext.request.contextPath}/resources/js/services/moduloCiclo.js" type="text/javascript"></script>
