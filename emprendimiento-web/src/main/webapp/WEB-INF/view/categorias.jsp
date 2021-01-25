<%-- 
    Document   : categorias
    Created on : jul 10, 2019, 1:22:23 p.m.
    Author     : Andres Gonzalez
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!-- Contenido de la pagina  -->
<h3>Categorías </h3>
<hr />
<p><i class="mdi mdi-view-headline"></i> Lista de categorías parametrizadas en el sistema</p>

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
            <th class="noOverflow">Nombre Categoría</th>
            <th >Porcentaje de Aprobación</th>
            <th >Calificación de Aprobación</th>
            <th class="noOverflow">Descripción</th>
            <th >Editar</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${categorias}" var="tempCat">
            <tr>
                <td >${tempCat.nombrecategoria}</td>
                <td >${tempCat.porcentajeaprobacion}</td>
                <td >${tempCat.calificacionaprobacion}</td>
                <td >${tempCat.descripcion}</td>
                <td align="center"><button type='button' data-index="${tempCat.idcategoria}" class='btn btn-sm btn-rounded btn-warning btn-modificar' data-toggle="tooltip" data-placement="top" title="Editar"><i class="fas fa-edit"></i></button></td>
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

<script src="${pageContext.request.contextPath}/resources/js/services/categorias.js" type="text/javascript"></script>


