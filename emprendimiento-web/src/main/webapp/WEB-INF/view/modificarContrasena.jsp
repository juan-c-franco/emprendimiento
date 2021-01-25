<%-- 
    Document   : homepage
    Created on : 12/09/2018, 09:27:32 AM
    Author     : Andrés Felipe González Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>



<h3>Editar Contraseña</h3>
<hr />
<p><security:authorize access="isAuthenticated()">
        Usuario: <security:authentication property="principal.username" /> 
    </security:authorize></p>


<!--                                    <div class="form-row align-items-center">-->
<div id="valora">
    <div class="form-group col-md-6">
        <div class="controls">
            <label  for="password">Contraseña actual<span class="text-danger">*</span></label>
            <input type="password" class="form-control mb-2" id="password" name="password" placeholder="Contraseña" required="required" data-validation-required-message="Ingrese la Contraseña">
        </div>
    </div>
    <br/>
    <div class="form-group col-md-6">
        <div class="controls">
            <label  for="contrasenaN">Nueva Contraseña<span class="text-danger">*</span></label>
            <input type="password" class="form-control mb-2" id="contrasenaN" name="contrasenaN" placeholder="Nueva Contraseña" required="required" data-validation-required-message="Ingrese la Contraseña Nueva" minlength="8" data-validation-minlength-message="La contraseña debe tener mínimo 8 carácteres, una mayúscula, una minúscula, un número y un carácter especial">
            <span id="reggex1"></span>
        </div>
    </div>
    <br/>
    <div class="form-group col-md-6">
        <div class="controls">
            <label  for="contrasenaN2">Confirmar Nueva Contraseña<span class="text-danger">*</span></label>
            <input type="password" class="form-control mb-2" id="contrasenaN2" name="contrasenaN2" placeholder="Confirmar Nueva Contraseña" required="required" data-validation-match-match="contrasenaN" data-validation-required-message="Ingrese la Contraseña Nueva" data-validation-match-message="Las contraseñas no coinciden" >
            <span id="reggex2"></span>
        </div>
    </div>
</div>
<br/>
<div class="form-group col-md-6">
    <div class="text-center">
        <button class="btn btn-danger" type="button" id="btn-Cancelar">Atrás</button>
        <button type="button" id="btnModificar" class="btn btn-success">Guardar</button>
    </div>
</div>
<!--                                    </div>-->




<script src="${pageContext.request.contextPath}/resources/js/services/modificarContrasena.js" type="text/javascript"></script>
