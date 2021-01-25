<%-- 
    Document   : homepage
    Created on : 12/09/2018, 09:27:32 AM
    Author     : Andrés Felipe González Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<c:if test="${not empty update}">
    <c:if test="${update==1}" >

        <i>Asistencia Registrada Correctamente</i>
    </c:if> 

    <c:if test="${update!=1}">

        <i>Hubo un error al registrar la asistencia</i>

    </c:if>
</c:if> 
<c:if test="${not empty respuesta}">
    <c:if test="${respuesta==1}" >

        <i>Encuesta Registrada Correctamente</i>
    </c:if> 

    <c:if test="${respuesta==0}">

        <i>Hubo un error al registrar la encuesta</i>

    </c:if>
</c:if>        