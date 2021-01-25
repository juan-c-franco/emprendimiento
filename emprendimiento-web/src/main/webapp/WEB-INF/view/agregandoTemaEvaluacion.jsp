<%-- 
    Document   : agregandoTemaEvaluacion
    Created on : 13/10/2018, 07:21:59 PM
    Author     : Danny Fernando Guerrero Gelpud
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<h3>Registro Tema de Evaluación</h3>
<hr />
<p>Nombre: ${temaEvaluacionDTO.herramientaValoracionDTO.nombreHerramienta}</p>

<!--<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <h3>Nombre: </h3><h4>${temaEvaluacionDTO.herramientaValoracionDTO.nombreHerramienta}</h4>
    </div>
</nav>
<th/>-->
<input type="hidden" id="idHerramienta" name="idHerramienta" value="${temaEvaluacionDTO.herramientaValoracionDTO.idHerramienta}" />
<input type="hidden" id="idCajaCompensacion" name="idCajaCompensacion" value="${temaEvaluacionDTO.cajaCompensacionDTO.idcajacompensacion}" />
<div id="valora">
    <div class="form-row">
        <div class="form-group col-sm-12">
            <div class="controls">
                <label for="nombretema">Nombre Tema<span class="text-danger">*</span> </label>
                <input type="text" class="form-control" id="nombretema" name="nombretema" 
                       tabindex="0" placeholder="Nombre Tema" required="required" value="${temaEvaluacionDTO.nombretema}" data-validation-required-message="Ingrese el nombre del tema" maxlength="180">
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-sm-12">
            <div class="controls">
                <label for="descripcion">Descripción<span class="text-danger">*</span> </label>
                <textarea type="text" class="form-control" id="descripcion" 
                          name="descripcion" placeholder="Descripción" required="required" 
                          value="${temaEvaluacionDTO.descripcion}" 
                          data-validation-required-message="Ingrese la descripción del tema" 
                          maxlength="450" tabindex="0"
                          data-validation-maxlength-message="Máximo 450 carácteres"></textarea>
                          <span id="chars">450</span> carácteres restantes.
            </div>
        </div>
    </div>
</div>

<br/>
<c:if test="${temaEvaluacionDTO.herramientaValoracionDTO.idHerramienta != '1'}">

    <div class="form-row">
        <div class="form-group col-sm-6">        
            <div class="controls">
                <label for="horasbasico">Cantidad de Horas Nivel Básico<span class="text-danger">*</span> </label>
                <input type="NumericTextBox" min="0" class="form-control only-number" id="horasbasico" 
                       tabindex="0" name="horasbasico" placeholder="Cantidad de Horas Nivel Básico" required="required" value="${temaEvaluacionDTO.horasbasico}" min="0" data-validation-required-message="Ingrese la cantidad de horas" data-toggle="tooltip" data-placement="top" title="Este campo debe ser mayor al nivel intermedio">
            </div>
        </div>
        <div class="form-group col-sm-6">
            <div class="controls">
                <label for="calificacionbasico">Umbral de Calificación Nivel Básico<span class="text-danger">*</span> </label>
                <input type="NumericTextBox" min="0" class="form-control only-number" id="calificacionbasico" 
                       tabindex="0" name="calificacionbasico" placeholder="Umbral de Calificación Nivel Básico" required="required" value="${temaEvaluacionDTO.calificacionbasico}" min="0" data-validation-required-message="Ingrese el umbral de calificación" data-toggle="tooltip" data-placement="top" title="Este campo debe ser menor al nivel intermedio">
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-sm-6">
            <div class="controls">
                <label for="horasintermedio">Cantidad de Horas Nivel Intermedio<span class="text-danger">*</span> </label>
                <input type="NumericTextBox" min="0" class="form-control only-number" id="horasintermedio" 
                       tabindex="0" name="horasintermedio" placeholder="Cantidad de Horas Nivel Intermedio" required="required" value="${temaEvaluacionDTO.horasintermedio}" min="0" data-validation-required-message="Ingrese la cantidad de horas" data-toggle="tooltip" data-placement="top" title="Este campo debe ser mayor al nivel avanzado">
            </div>
        </div>
        <div class="form-group col-sm-6">
            <div class="controls">
                <label for="calificacionintermedio">Umbral de Calificación Nivel Intermedio<span class="text-danger">*</span> </label>
                <input type="NumericTextBox" min="0" class="form-control only-number" id="calificacionintermedio"
                       tabindex="0" name="calificacionintermedio" placeholder="Umbral de Calificación Nivel Intermedio" required="required" value="${temaEvaluacionDTO.calificacionintermedio}" min="0" data-validation-required-message="Ingrese el umbral de calificación" data-toggle="tooltip" data-placement="top" title="Este campo debe ser menor al nivel avanzado">
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-sm-6">
            <div class="controls">
                <label for="horasavanzado">Cantidad de Horas Nivel Avanzado<span class="text-danger">*</span> </label>
                <input type="NumericTextBox" min="0" class="form-control only-number" id="horasavanzado"
                       tabindex="0" name="horasavanzado" placeholder="Cantidad de Horas Nivel Avanzado" required="required" value="${temaEvaluacionDTO.horasavanzado}" min="0" data-validation-required-message="Ingrese la cantidad de horas">
            </div>
        </div>
        <div class="form-group col-sm-6">
            <div class="controls">
                <label for="calificacionavanzado">Umbral de Calificación Nivel Avanzado<span class="text-danger">*</span> </label>
                <input type="NumericTextBox" min="0" class="form-control only-number" id="calificacionavanzado" 
                       tabindex="0" name="calificacionavanzado" placeholder="Umbral de Calificación Nivel Avanzado" required="required" value="${temaEvaluacionDTO.calificacionavanzado}" min="0" data-validation-required-message="Ingrese el umbral de calificación">
            </div>
        </div>
    </div>
</c:if>
<div class="text-center">

    <button type="button" id="btnCancelar"class="btn btn-danger">Atrás</button>





    <input type="hidden" id="tipoHerramienta" name="tipoHerramienta" value="${herramientaValoracion.idHerramienta}" />
    <button type="button" id="btnGuardar"class="btn btn-success">Guardar</button>


</div>


<script src="${pageContext.request.contextPath}/resources/js/services/agregandoTemaEvaluacion.js" type="text/javascript"></script>