<%-- 
    Document   : registrarAsistencia
    Created on : ene 18, 2019, 3:01:36 p.m.
    Author     : Andres Felipe Gonzalez Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<h3>Registrar Asistencia </h3>
<hr />
<div id="calendar"></div>


<script src="${pageContext.request.contextPath}/resources/js/services/registrarAsistenciaCalendar.js" type="text/javascript"></script>
<script>
    var idfuncionario = null;
    <c:if test="${not empty idFuncionario}">
    idfuncionario = ${idFuncionario};
    </c:if>
</script>