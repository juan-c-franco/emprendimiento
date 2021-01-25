<%-- 
    Document   : editarPreguntaTema
    Created on : 15/10/2018, 10:12:12 AM
    Author     : Danny Fernando Guerrero Gelpud
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<h3>Editar Pregunta</h3>

<hr />
<input type="hidden" id="idPregunta" name="idPregunta" value="${pregunta.idpregunta}" />
<input type="hidden" id="idTema" name="idTema" value="${pregunta.temaEvaluacionDTO.idtema}" />
<input type="hidden" id="idHerramienta" name="idHerramienta" value="${pregunta.herramientaValoracionDTO.idHerramienta}" />
<input type="hidden" id="idCajaCompensacion" name="idCajaCompensacion" value="${pregunta.cajaCompensacionDTO.idcajacompensacion}" />

<div class="form-group row">
    <label for="descripcion" class="col-sm-2 col-form-label">Caja de Compensación: </label>
    <div class="col-sm-10">
        <input type="text" readonly class="form-control-plaintext" id="descripcion" name="descripcion" value="${pregunta.cajaCompensacionDTO.nombrecajacompensacion}">
    </div>
</div>
<div class="form-group row">
    <label for="descripcion" class="col-sm-2 col-form-label">Tema:  </label>
    <div class="col-sm-10">
        <input type="text" readonly class="form-control-plaintext" id="descripcion" name="descripcion" value="${pregunta.temaEvaluacionDTO.nombretema}">
    </div>
</div>
<div class="form-group row">
    <label for="descripcion" class="col-sm-2 col-form-label">Herramienta: </label>
    <div class="col-sm-10">
        <input type="text" readonly class="form-control-plaintext" id="descripcion" name="descripcion" value="${pregunta.herramientaValoracionDTO.nombreHerramienta}">
    </div>
</div>
<!--<label for="caja" class="control-label">Caja de Compensación: </label>
<input id="caja" name="caja" disabled="true" value="${pregunta.cajaCompensacionDTO.nombrecajacompensacion}" type="text"/>
<br/>
<label for="tema" class="control-label">Tema: </label>
<input id="tema" name="tema" disabled="true" value="${pregunta.temaEvaluacionDTO.nombretema}" type="text"/>
<br/>
<label for="herramienta" class="control-label">Herramienta: </label>
<input id="herramienta" name="herramienta" disabled="true" value="${pregunta.herramientaValoracionDTO.nombreHerramienta}" type="text"/>
<br/>-->
<div class="form-row">
    <div class="form-group col-sm-12">
        <div class='controls'>
            <label for="textopregunta">Texto de la Pregunta<span class="text-danger">*</span> </label>
            <input type="text" class="form-control" id="textopregunta" name="textopregunta" placeholder="Texto de la Pregunta" required="required" value="${pregunta.textopregunta}" data-validation-required-message='Ingrese la pregunta' maxlength="450">
        </div>
    </div>
</div>
<input type="hidden" id="idTema" name="idTema" value="${idTema}" />
<input type="hidden" id="idHerramienta" name="idHerramienta" value="${idHerramienta}" />
<input type="hidden" id="idCaja" name="idCaja" value="${idCaja}" />
<div class="text-center">
    <button type="button" id="btnCancelar" class="btn btn-danger">Atrás</button>
    <button type="button" id="btnGuardar"class="btn btn-success">Guardar</button>
</div>
<script src="${pageContext.request.contextPath}/resources/js/services/editarPreguntaTema.js" type="text/javascript"></script>