<%-- 
    Document   : agendarSesionEvaluacion
    Created on : 30/11/2018, 09:22:36 AM
    Author     : Juan Carlos Franco
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Agendar Sesión de Evaluación</h3>
<hr/>
<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-header">
                <i class="mdi mdi-view-headline"></i> Agendar Sesión Evaluación
            </div>

            <div class="card-body">
                <div id="calendar"></div>
            </div>

        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/_dist/js/services/evaluacion/agendarSesionEvaluacion.js" type="text/javascript"></script>
