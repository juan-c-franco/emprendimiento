<%-- 
    Document   : revisionYCalificacionAdmin
    Created on : dic 6, 2018, 4:05:54 p.m.
    Author     : Andres Felipe Gonzalez M Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<div class="form-row">

    <c:if test ="${buscador == '1'}">

        <div class="row">
            <div class="input-group">
                <select class="custom-select" id="buscarPor" aria-label="Example select with button addon">
                    <option selected value="0">Buscar por...</option>
                    <option value="1">Documento</option>
                    <option value="2">Nombre Emprendimiento</option>
                    <!--                    <option value="3">Id Emprendimiento</option>-->
                </select>
                <div class="input-group-append">

                    <button class="btn btn-outline-secondary" type="button" id ="btnDoc">Buscar</button>

                </div>
            </div>
        </div>
    </c:if>
    <div class="row">
        <div class="form-group mx-sm-3 col-4" >
            <label for="documento" class="sr-only">Documento</label>
            <input type="text" min="0" class="form-control" id="documento" placeholder="Documento" hidden="true">
        </div>

    </div>
    <div class="row">
        <div class="form-group mx-sm-3 col-4">
            <label for="nombreEmprendimiento" class="sr-only">Nombre Emprendimiento</label>
            <input type="text" min="0" class="form-control " id="nombreEmprendimiento" placeholder="Nombre Emprendimiento" hidden="true" >
        </div>

    </div>

    <c:if test="${not empty mensaje}">
        <h4>${mensaje}</h4>
    </c:if>
    <table id="resultBeneficiarios" class="table table-striped">
        <thead>
            <tr>
                <th >Emprendimiento</th>
                <th >Estado Emprendimiento</th>
                <th >Tipo de Emprendimiento</th>
                <th >Accion</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${emprendimientos}" var="tempEmprendimientos">
                <tr>
                    <td >${tempEmprendimientos.nombreemprendimiento}</td>
                    <td >${tempEmprendimientos.estadoemprendimiento.nombreestadoemprendimiento}</td>
                    <td >${tempEmprendimientos.tipoemprendimiento.nombretipoemprendimiento}</td>
                    <td ><a onclick="loadView('Adjuntar Plan de Accion', '${pageContext.request.contextPath}/adjuntarPlanAccion2?emprendimientoId=${tempEmprendimientos.idemprendimiento}')">Adjuntar Plan</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>

<script src="${pageContext.request.contextPath}/resources/js/services/adjuntarPlanAccion1.js" type="text/javascript"></script>