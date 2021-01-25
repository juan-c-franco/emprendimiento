<%-- 
    Document   : encuestaValoracion
    Created on : ene 21, 2019, 12:09:01 p.m.
    Author     : Andres Gonzalez Grow Data PC
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="pagina" value="encuesta" />
<c:set var="titulo" value="Encuesta Valoraci&oacute;n" />

<jsp:include page="../layouts/_header.jsp">
    <jsp:param name="pagina" value="${pagina}"/>
    <jsp:param name="titulo" value="${titulo}"/>
    <jsp:param name="cssItems" value="_assets/modules/icheck/skins/all.css" />
    <jsp:param name="cssItems" value="_dist/css/pages/form-icheck.css" />   
    <jsp:param name="cssItems" value="_assets/modules/sweetalert/sweetalert.css" /> 
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

<div class="row">
    <div class="col-8 offset-2">
        <div class="card">
            <div class="card-body collapse show">
                <h2 class="card-title text-center">Error Cargando Encuesta</h2>
                <hr />

                <div class="row">
                    <div class="col-12 offset-2">
                        <h4><strong>${mensaje}</strong></h4>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>                             
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<jsp:include page="../layouts/_footer.jsp">
    <jsp:param name="pagina" value="${pagina}"/>
    <jsp:param name="jsItems" value="_dist/js/waves.min.js"/> 
    <jsp:param name="jsItems" value="_dist/js/validation.min.js"/>
    <jsp:param name="jsItems" value="_assets/modules/icheck/icheck.min.js"/>
    <jsp:param name="jsItems" value="_assets/modules/icheck/icheck.init.js"/>    
    <jsp:param name="jsItems" value="_dist/js/general.js"/>    
    <jsp:param name="jsItems" value="js/services/encuestaValoracion.js"/>
    <jsp:param name="jsItems" value="_assets/modules/sweetalert/sweetalert.min.js"/>
</jsp:include> 