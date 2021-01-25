<%-- 
    Document   : modificarContrasenaObligado
    Created on : abr 29, 2019, 4:40:44 p.m.
    Author     : Andres Gonzalez
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<c:set var="pagina" value="encuesta" />
<c:set var="titulo" value="Editar Contraseña" />

<jsp:include page="../layouts/_header.jsp">
    <jsp:param name="pagina" value="${pagina}"/>
    <jsp:param name="titulo" value="${titulo}"/>
    <jsp:param name="cssItems" value="_assets/modules/icheck/skins/all.css" />
    <jsp:param name="cssItems" value="_dist/css/pages/form-icheck.css" />   
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
<div class="col-8 offset-2">
    <div class="card">
        <div class="card-body collapse show justify-content-md-center">
            <h2 class="card-title text-center">Editar Contraseña</h2>
            <hr />
            <p> Usuario: ${usuario}</p>
            <form:form method="post" novalidate="novalidate">
                <div id="valora" class="justify-content-md-center">
                    <div class="form-group col-md-6">
                        <div class="controls">
                            <label  for="password">Contraseña<span class="text-danger">*</span></label>
                            <input type="password" class="form-control mb-2" id="password" name="password" placeholder="Contraseña" required="required" data-validation-required-message="Ingrese Contraseña">
                        </div>
                    </div>
                    <br/>
                    <div class="form-group col-md-6">
                        <div class="controls">
                            <label  for="contrasenaN">Nueva Contraseña<span class="text-danger">*</span></label>
                            <input type="password" class="form-control mb-2" id="contrasenaN" name="contrasenaN" placeholder="Nueva Contraseña" required="required" data-validation-required-message="Ingrese Contraseña Nueva" minlength="8" data-validation-minlength-message="La contraseña debe tener mínimo 8 carácteres">
                        </div>
                    </div>
                    <br/>
                    <div class="form-group col-md-6">
                        <div class="controls">
                            <label  for="contrasenaN2">Confirmar Nueva Contraseña<span class="text-danger">*</span></label>
                            <input type="password" class="form-control mb-2" id="contrasenaN2" name="contrasenaN2" placeholder="Confirmar Nueva Contraseña" required="required" data-validation-match-match="contrasenaN" data-validation-required-message="Ingrese Contraseña Nueva" data-validation-match-message="Las contraseñas no coinciden" >
                        </div>
                    </div>
                </div>
                <br/>
                <div class="form-group col-md-6">
                    <div class="text-center">

                        <button type="button" id="btnModificar" class="btn btn-success">Editar</button>
                    </div>
                </div>
            </form:form>
        </div>
    </div>
</div>
<script>
    username = "${usuario}";
</script>
<jsp:include page="../layouts/_footer.jsp">
    <jsp:param name="pagina" value="${pagina}"/>
    <jsp:param name="jsItems" value="_dist/js/waves.min.js"/> 
    <jsp:param name="jsItems" value="_dist/js/validation.min.js"/>
    <jsp:param name="jsItems" value="_assets/modules/icheck/icheck.min.js"/>
    <jsp:param name="jsItems" value="_assets/modules/icheck/icheck.init.js"/>    
    <jsp:param name="jsItems" value="_dist/js/general.js"/> 
    <jsp:param name="jsItems" value="js/services/modificarContrasenaObligado.js"/>
    <jsp:param name="jsItems" value="_assets/modules/sweetalert/sweetalert.min.js"/>
</jsp:include>