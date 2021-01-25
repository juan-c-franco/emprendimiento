<%-- 
    Document   : registroCategoria
    Created on : jul 10, 2019, 1:35:41 p.m.
    Author     : Andres Gonzalez
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Registrar Categor�a</h3>
<hr />
<p>Diligencie el siguiente formulario</p>

<div id="valora">

    <div class="form-row">
        <div class="form-group col-md-6">
            <div class="controls">
                <label for="nombrecategoria">Nombre Categor�a<span class="text-danger">*</span></label>
                <input type="text" class="form-control" id="nombrecategoria" name="nombrecategoria" 
                       tabindex="0" placeholder="Nombre Categor�a..." required="required" data-validation-required-message="Ingrese el nombre de la categor�a" maxlength="100">
            </div>
        </div>
        <div class="form-group col-md-6">
            <div class="controls">
                <label for="porcentajeaprobacion">Porcentaje de Aprobaci�n<span class="text-danger">*</span></label>
                <input type="NumericTextBox" class="form-control only-number" id="porcentajeaprobacion" 
                       tabindex="0" name="porcentajeaprobacion" placeholder="Porcentaje de Aprobaci�n..."
                       required="required" 
                       data-validation-required-message="Ingrese el procentaje de aprobaci�n"
                       maxlength="3">
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <div class="controls">
                <label for="calificacionaprobacion">Calificaci�n de Aprobaci�n<span class="text-danger">*</span></label>
                <input type="NumericTextBox" class="form-control only-number" id="calificacionaprobacion"
                       tabindex="0" name="calificacionaprobacion" placeholder="Calificaci�n de Aprobaci�n..." required="required" data-validation-required-message="Ingrese la calificaci�n de aprobaci�n" maxlength="3">
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-11">
            <div class="form-group">
                <label for="descripcion">Descripci�n <span class="text-danger">*</span></label>
                <div class="controls">
                    <textarea type="text" class="form-control" name="descripcion" id="descripcion" placeholder="Descripci�n..." 
                              data-validation-required-message="Campo obligatorio" required 
                              maxlength="500" tabindex="0"
                              data-validation-maxlength-message="M�ximo 500 caracteres"
                              /></textarea>
                    <span id="chars">500</span> caracteres restantes.
                </div>
            </div>
        </div>
    </div> 
</div>
<div class="text-center">
    <button class="btn btn-danger align-content-center float-center" type="button" id="btn-Cancelar">Atr�s</button>
    <button type="button" id="btnRegistro" class="btn btn-success float-center">Guardar</button>    
</div>

<script src="${pageContext.request.contextPath}/resources/js/services/registroCategoria.js" type="text/javascript"></script>


