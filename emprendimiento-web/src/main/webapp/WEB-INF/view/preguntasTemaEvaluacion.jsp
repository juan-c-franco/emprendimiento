<%-- 
    Document   : preguntasTemaEvaluacion
    Created on : 14/10/2018, 11:11:01 PM
    Author     : Danny Fernando Guerrero Gelpud
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Preguntas</h3>
<hr />
<p><i class="mdi mdi-view-headline"></i> Lista de preguntas para ${tema.nombretema} que están parametrizadas en el sistema</p>

<div class="form-group row">
    <label for="descripcion" class="col-sm-2 col-form-label">Caja de Compensación: </label>
    <div class="col-sm-10">
        <input type="text" readonly class="form-control-plaintext" id="descripcion" name="descripcion" value="${caja.nombrecajacompensacion}">
    </div>
</div>
<div class="form-group row">
    <label for="descripcion" class="col-sm-2 col-form-label">Tema:  </label>
    <div class="col-sm-10">
        <input type="text" readonly class="form-control-plaintext" id="descripcion" name="descripcion" value="${tema.nombretema}">
    </div>
</div>
<div class="form-group row">
    <label for="descripcion" class="col-sm-2 col-form-label">Herramienta: </label>
    <div class="col-sm-10">
        <input type="text" readonly class="form-control-plaintext" id="descripcion" name="descripcion" value="${herramienta.nombreHerramienta}">
    </div>
</div>

<!--<label for="caja" class="control-label">Caja de Compensación: </label>
<input id="caja" name="caja" disabled="true" value="${caja.nombrecajacompensacion}" type="text"/>
<br/>
<label for="tema" class="control-label">Tema: </label>
<input id="tema" name="tema" disabled="true" value="${tema.nombretema}" type="text"/>
<br/>
<label for="herramienta" class="control-label">Herramienta: </label>
<input id="herramienta" name="herramienta" disabled="true" value="${herramienta.nombreHerramienta}" type="text"/>
<br/>-->
<!--<h5>${mensaje}</h5>-->
<c:if test="${not empty mensaje}">
    <c:if test="${status=='1'}">
        <div class="alert alert-success"> <i class="fa fa-check-circle"></i> ${mensaje}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
    <c:if test="${status=='0'}">
        <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
</c:if>
<table id="tableData" class="table table-bordered table-striped">
    <thead>
        <tr>
            <th>No Pregunta</th>
            <th>Texto Pregunta</th>
            <th>Fecha Registro</th>
            <th></th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="pregunta" items="${preguntas}" varStatus="loop"> 
            <tr>
                <td>${loop.index + 1}</td>
                <td  class="noOverflow">${pregunta.textopregunta} </td>
                <td>${pregunta.fecharegistro} </td>
                <td align="center">
                    <button type="button" onclick="editarPregunta(${pregunta.idpregunta})" class="btn btn-sm btn-rounded btn-warning" data-toggle="tooltip" data-placement="top" title="Editar"><i class="fas fa-edit"></i></button>
                    <button type="button" onclick="borrarPregunta(${pregunta.idpregunta})" class="btn btn-sm btn-rounded btn-danger" data-toggle="tooltip" data-placement="top" title="Borrar"><i class="fas fa-trash-alt"></i></button>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

<div class="row">
    <div class="col-md-12">
        <div class="text-center">

            <input type="hidden" id="idTema" name="idTema" value="${tema.idtema}" />
            <input type="hidden" id="idHerramienta" name="idHerramienta" value="${herramienta.idHerramienta}" />
            <input type="hidden" id="idCajaCompensacion" name="idCajaCompensacion" value="${caja.idcajacompensacion}" />
            <input type="hidden" id="tipoHerramienta" name="tipoHerramienta" value="${herramienta.idHerramienta}" />

            <button type="button" id="btnCancelar" class="btn waves-effect waves-light btn-danger">Atrás</button>  
            <button type="button" id="btnAgregar" class="btn waves-effect waves-light btn-success">Agregar Pregunta</button>

        </div>
    </div>
</div>

<div class="form-row">
    <div class="form-group col-sm-6" style="text-align: right">


    </div>
    <div class="form-group col-sm-6">  


    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/services/preguntasTemaEvaluacion.js" type="text/javascript"></script>