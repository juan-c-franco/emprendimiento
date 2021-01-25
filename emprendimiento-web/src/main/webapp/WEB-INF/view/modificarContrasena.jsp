<%-- 
    Document   : homepage
    Created on : 12/09/2018, 09:27:32 AM
    Author     : Andr�s Felipe Gonz�lez Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>



<h3>Editar Contrase�a</h3>
<hr />
<p><security:authorize access="isAuthenticated()">
        Usuario: <security:authentication property="principal.username" /> 
    </security:authorize></p>


<!--                                    <div class="form-row align-items-center">-->
<div id="valora">
    <div class="form-group col-md-6">
        <div class="controls">
            <label  for="password">Contrase�a actual<span class="text-danger">*</span></label>
            <input type="password" class="form-control mb-2" id="password" name="password" placeholder="Contrase�a" required="required" data-validation-required-message="Ingrese la Contrase�a">
        </div>
    </div>
    <br/>
    <div class="form-group col-md-6">
        <div class="controls">
            <label  for="contrasenaN">Nueva Contrase�a<span class="text-danger">*</span></label>
            <input type="password" class="form-control mb-2" id="contrasenaN" name="contrasenaN" placeholder="Nueva Contrase�a" required="required" data-validation-required-message="Ingrese la Contrase�a Nueva" minlength="8" data-validation-minlength-message="La contrase�a debe tener m�nimo 8 car�cteres, una may�scula, una min�scula, un n�mero y un car�cter especial">
            <span id="reggex1"></span>
        </div>
    </div>
    <br/>
    <div class="form-group col-md-6">
        <div class="controls">
            <label  for="contrasenaN2">Confirmar Nueva Contrase�a<span class="text-danger">*</span></label>
            <input type="password" class="form-control mb-2" id="contrasenaN2" name="contrasenaN2" placeholder="Confirmar Nueva Contrase�a" required="required" data-validation-match-match="contrasenaN" data-validation-required-message="Ingrese la Contrase�a Nueva" data-validation-match-message="Las contrase�as no coinciden" >
            <span id="reggex2"></span>
        </div>
    </div>
</div>
<br/>
<div class="form-group col-md-6">
    <div class="text-center">
        <button class="btn btn-danger" type="button" id="btn-Cancelar">Atr�s</button>
        <button type="button" id="btnModificar" class="btn btn-success">Guardar</button>
    </div>
</div>
<!--                                    </div>-->




<script src="${pageContext.request.contextPath}/resources/js/services/modificarContrasena.js" type="text/javascript"></script>
