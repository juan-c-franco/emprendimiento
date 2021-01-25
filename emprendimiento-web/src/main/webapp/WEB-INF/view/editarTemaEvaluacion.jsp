<%-- 
    Document   : editarTemaEvaluacion
    Created on : 14/10/2018, 12:18:14 PM
    Author     : Danny Fernando Guerrero Gelpud
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<h3>Editar Tema de Evaluación</h3>
<hr />
<p>Nombre: ${temaEvaluacionDTO.herramientaValoracionDTO.nombreHerramienta}</p>

<input type="hidden" id="idtema" name="idtema" value="${temaEvaluacionDTO.idtema}" />
<input type="hidden" id="idHerramienta" name="idHerramienta" value="${temaEvaluacionDTO.herramientaValoracionDTO.idHerramienta}" />
<input type="hidden" id="idCajaCompensacion" name="idCajaCompensacion" value="${temaEvaluacionDTO.cajaCompensacionDTO.idcajacompensacion}" />
<div id="valora">
    <div class="form-row">
        <div class="form-group col-sm-12">
            <div class='controls'>
                <label for="nombretema">Nombre Tema<span class="text-danger">*</span> </label>
                <input type="text" class="form-control" id="nombretema" name="nombretema" placeholder="Nombre Tema" required="required" value="${temaEvaluacionDTO.nombretema}" data-validation-required-message="Ingrese el nombre del tema" maxlength="180">
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-sm-12">
            <div class='controls'>
                <label for="descripcion">Descripción<span class="text-danger">*</span> </label>
                <textarea type="text" class="form-control" id="descripcion" 
                          name="descripcion" placeholder="Descripción" required="required"  
                          data-validation-required-message="Ingrese la descripción del tema" 
                          maxlength="450"
                          data-validation-maxlength-message="Máximo 450 carácteres">${temaEvaluacionDTO.descripcion}</textarea>
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
                <input type="NumericTextBox" min="0" class="form-control only-number" id="horasbasico" name="horasbasico" placeholder="Cantidad de Horas Nivel Básico" required="required" value="${temaEvaluacionDTO.horasbasico}" min="0" data-validation-required-message="Ingrese la cantidad de horas" data-toggle="tooltip" data-placement="top" title="Este campo debe ser mayor al nivel intermedio">
            </div>
        </div>
        <div class="form-group col-sm-6">
            <div class="controls">
                <label for="calificacionbasico">Umbral de Calificación Nivel Básico<span class="text-danger">*</span> </label>
                <input type="NumericTextBox" min="0" class="form-control only-number" id="calificacionbasico" name="calificacionbasico" placeholder="Umbral de Calificación Nivel Básico" required="required" value="${temaEvaluacionDTO.calificacionbasico}" min="0" data-validation-required-message="Ingrese el umbral de calificación" data-toggle="tooltip" data-placement="top" title="Este campo debe ser menor al nivel intermedio">
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-sm-6">
            <div class="controls">
                <label for="horasintermedio">Cantidad de Horas Nivel Intermedio<span class="text-danger">*</span> </label>
                <input type="NumericTextBox" min="0" class="form-control only-number" id="horasintermedio" name="horasintermedio" placeholder="Cantidad de Horas Nivel Intermedio" required="required" value="${temaEvaluacionDTO.horasintermedio}" min="0" data-validation-required-message="Ingrese la cantidad de horas" data-toggle="tooltip" data-placement="top" title="Este campo debe ser mayor al nivel avanzado">
            </div>
        </div>
        <div class="form-group col-sm-6">
            <div class="controls">
                <label for="calificacionintermedio">Umbral de Calificación Nivel Intermedio<span class="text-danger">*</span> </label>
                <input type="NumericTextBox" min="0" class="form-control only-number" id="calificacionintermedio" name="calificacionintermedio" placeholder="Umbral de Calificación Nivel Intermedio" required="required" value="${temaEvaluacionDTO.calificacionintermedio}" min="0" data-validation-required-message="Ingrese el umbral de calificación" data-toggle="tooltip" data-placement="top" title="Este campo debe ser menor al nivel avanzado">
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-sm-6">
            <div class="controls">
                <label for="horasavanzado">Cantidad de Horas Nivel Avanzado<span class="text-danger">*</span> </label>
                <input type="NumericTextBox" min="0" class="form-control only-number" id="horasavanzado" name="horasavanzado" placeholder="Cantidad de Horas Nivel Avanzado" required="required" value="${temaEvaluacionDTO.horasavanzado}" min="0" data-validation-required-message="Ingrese la cantidad de horas">
            </div>
        </div>
        <div class="form-group col-sm-6">
            <div class="controls">
                <label for="calificacionavanzado">Umbral de Calificación Nivel Avanzado<span class="text-danger">*</span> </label>
                <input type="NumericTextBox" min="0" class="form-control only-number" id="calificacionavanzado" name="calificacionavanzado" placeholder="Umbral de Calificación Nivel Avanzado" required="required" value="${temaEvaluacionDTO.calificacionavanzado}" min="0" data-validation-required-message="Ingrese el umbral de calificación">
            </div>
        </div>
    </div>
</c:if>
<div class="form-group col-md-2">
    <label for="estado">Estado</label>

    <select id="estado" class="selectpicker" data-style="btn-info" name="estado">
        <c:if test="${temaEvaluacionDTO.estado == '1'}">
            <option value="1" selected>Activo</option>
            <option value="0">Inactivo</option>
        </c:if>
        <c:if test="${temaEvaluacionDTO.estado == '0'}">
            <option value="1">Activo</option>
            <option value="0" selected>Inactivo</option>
        </c:if>
    </select>
</div>
<div class="text-center">
    <button type="button" id="btnCancelar"class="btn btn-danger">Atrás</button>
    <button type="button" id="btnGuardar"class="btn btn-success">Guardar</button>
    <input type="hidden" id="tipoHerramienta" name="tipoHerramienta" value="${herramientaValoracion.idHerramienta}" />
</div>
<script src="${pageContext.request.contextPath}/resources/js/services/editarTemaEvaluacion.js" type="text/javascript"></script>
