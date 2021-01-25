<%-- 
    Document   : respuesta olvido contraseña
    Created on : 12/12/2018, 07:40:32 AM
    Author     : Juan C Pulido
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="pagina" value="login" />
<c:set var="titulo" value="Recordación password - Emprendimiento" />

<jsp:include page="../layouts/_header.jsp">
    <jsp:param name="pagina" value="${pagina}"/>
    <jsp:param name="titulo" value="${titulo}"/>
    <jsp:param name="cssItems" value="_dist/css/pages/login-register-lock.css" />
</jsp:include>

<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-body collapse show">
                <h2 class="card-title text-center"><img src="${pageContext.request.contextPath}/resources/_assets/images/gobierno-logos.png" alt="Gobierno Colombia - Mintrabajo - MPC" class="img-fluid"></h2>
            </div>
        </div>
    </div>
</div>

<div class="login-register">
    <div class="login-box card">
        <div class="card-body"> 

            <h6>Recuperar contraseña</h6>
            <hr />

            <div class="alert alert-info">
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">×</span> </button>
                <h3 class="text-info"><i class="fas fa-exclamation-circle"></i> Información</h3>
                ${mensaje}
            </div>

            <div class="ml-auto">
                <a href="./" class="text-muted"><i class="fas fa-user m-r-5"></i> Volver</a> 
            </div>
        </div>
    </div>
</div>

<jsp:include page="../layouts/_footer.jsp">
    <jsp:param name="pagina" value="${pagina}"/>
    <jsp:param name="jsItems" value="_dist/js/login.js"/>
</jsp:include>