<%-- 
    Document   : registroCategoria
    Created on : jul 10, 2019, 1:35:41 p.m.
    Author     : Andres Gonzalez
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Registrar Categoría</h3>
<hr />
<p>Diligencie el siguiente formulario</p>

<div id="valora">

    <div class="form-row">
        <div class="form-group col-md-6">
            <div class="controls">
                <label for="nombrecategoria">Nombre Categoría<span class="text-danger">*</span></label>
                <input type="text" class="form-control" id="nombrecategoria" name="nombrecategoria" 
                       tabindex="0" placeholder="Nombre Categoría..." required="required" data-validation-required-message="Ingrese el nombre de la categoría" maxlength="100">
            </div>
        </div>
        <div class="form-group col-md-6">
            <div class="controls">
                <label for="porcentajeaprobacion">Porcentaje de Aprobación<span class="text-danger">*</span></label>
                <input type="NumericTextBox" class="form-control only-number" id="porcentajeaprobacion" 
                       tabindex="0" name="porcentajeaprobacion" placeholder="Porcentaje de Aprobación..."
                       required="required" 
                       data-validation-required-message="Ingrese el procentaje de aprobación"
                       maxlength="3">
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <div class="controls">
                <label for="calificacionaprobacion">Calificación de Aprobación<span class="text-danger">*</span></label>
                <input type="NumericTextBox" class="form-control only-number" id="calificacionaprobacion"
                       tabindex="0" name="calificacionaprobacion" placeholder="Calificación de Aprobación..." required="required" data-validation-required-message="Ingrese la calificación de aprobación" maxlength="3">
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-11">
            <div class="form-group">
                <label for="descripcion">Descripción <span class="text-danger">*</span></label>
                <div class="controls">
                    <textarea type="text" class="form-control" name="descripcion" id="descripcion" placeholder="Descripción..." 
                              data-validation-required-message="Campo obligatorio" required 
                              maxlength="500" tabindex="0"
                              data-validation-maxlength-message="Máximo 500 caracteres"
                              /></textarea>
                    <span id="chars">500</span> caracteres restantes.
                </div>
            </div>
        </div>
    </div> 
</div>
<div class="text-center">
    <button class="btn btn-danger align-content-center float-center" type="button" id="btn-Cancelar">Atrás</button>
    <button type="button" id="btnRegistro" class="btn btn-success float-center">Guardar</button>    
</div>

<script src="${pageContext.request.contextPath}/resources/js/services/registroCategoria.js" type="text/javascript"></script>


