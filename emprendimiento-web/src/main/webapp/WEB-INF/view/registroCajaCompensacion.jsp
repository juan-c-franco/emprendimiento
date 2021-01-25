<%-- 
    Document   : homepage
    Created on : 12/09/2018, 09:27:32 AM
    Author     : Andrés Felipe González Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<h3>Registrar Caja de Compensacion</h3>
<hr />
<p>Diligencie el siguiente formulario</p>

<div id="valora">
    <div class="form-row">
        <div class="form-group col-md-6">
            <div class ="controls">
                <label for="nombrecajacompensacion">Nombre Caja de Compensación<span class="text-danger">*</span></label>
                <input type="text" class="form-control" id="nombrecajacompensacion" name="nombrecajacompensacion" 
                       placeholder="Nombre Caja Compensación" required="required" 
                       data-validation-required-message="Ingrese Nombre Caja de Compensación" maxlength="90" tabindex="0">
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <div class ="controls">
                <label for="codigoccf">Código Caja de Compensación<span class="text-danger">*</span></label>
                <input type="text" class="form-control" id="codigoccf" name="codigoccf" 
                       placeholder="Código Caja de Compensación" required="required" 
                       tabindex="0" data-validation-required-message="Ingrese Código Caja de Compensación" maxlength="20">
            </div>
        </div>
    </div>
</div>


<div class="form-row">
    <!--                                        <div class="form-group col-md-6">
                                                <label for="departamento">Departamento</label>
                                                <input type="text" class="form-control" id="departamento" name="departamento" placeholder="Departamento" required="required">
                                            </div>-->

    <div class="form-group col-md-2">
        <label for="idestadocajacompensacion">Estado</label>
        <select id="idestadocajacompensacion" class="selectpicker" data-style="btn-info"required="required" name="idestadocajacompensacion">
            <option value="1" selected>Activa</option>
            <option value="0">Inactiva</option>
        </select>
    </div>
</div>
<br/>
<div class="text-center">
    <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
    <button type="button" id="btnRegistro" class="btn btn-success">Guardar</button>
</div>

<script src="${pageContext.request.contextPath}/resources/js/services/registroCajaCompensacion.js" type="text/javascript"></script>