<%-- 
    Document   : consultarSesionesComiteIndividual
    Created on : feb 28, 2019, 12:54:14 p.m.
    Author     : Andres Gonzalez
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Consultar Sesiónes Comité de Evaluación</h3>
<hr/>
<p>Sesiones de Comité</p>
<div id="calendar"></div>
<script src="${pageContext.request.contextPath}/resources/_dist/js/services/evaluacion/consultarSesionesComiteIndividual.js" type="text/javascript"></script>
<script>
    <c:if test="${not empty idFuncionario}">
    idfuncionario = ${idFuncionario};
    </c:if>
    <c:if test="${not empty idcajacompensacion }">
    idcajacompensacion = ${idcajacompensacion };
    </c:if>
</script>