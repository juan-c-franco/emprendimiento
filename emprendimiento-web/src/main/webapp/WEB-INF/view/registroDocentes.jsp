<%-- 
    Document   : registroDocentes
    Created on : jul 16, 2019, 2:06:34 p.m.
    Author     : Andres Gonzalez
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Registrar Docente</h3>
<hr />
<p>Diligencie el siguiente formulario</p>

<div id="valora">
    <div class="form-row">
        <div class="form-group col-md-6">
            <div class="controls">
                <label for="primernombre">Primer Nombre<span class="text-danger">*</span></label>
                <input type="text" class="form-control" id="primernombre" name="primernombre" 
                       tabindex="0" placeholder="Primer Nombre" required="required" data-validation-required-message="Ingrese Primer Nombre" maxlength="200">
            </div>
        </div>
        <div class="form-group col-md-6">
            <div class="controls">
                <label for="segundonombre">Segundo Nombre</label>
                <input type="text" class="form-control" id="segundonombre" name="segundonombre" 
                       tabindex="0" placeholder="Segundo Nombre" maxlength="200">
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <div class="controls">
                <label for="primerapellido">Primer Apellido<span class="text-danger">*</span></label>
                <input type="text" class="form-control" id="primerapellido" name="primerapellido" 
                       tabindex="0" placeholder="Primer Apellido" required="required" data-validation-required-message="Ingrese Primer Apellido" maxlength="200">
            </div>
        </div>
        <div class="form-group col-md-6">
            <label for="segundoapellido">Segundo Apellido</label>
            <input type="text" class="form-control" id="segundoapellido" name="segundoapellido" 
                   tabindex="0" placeholder="Segundo Apellido" maxlength="200">
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <div class="controls">
                <label for="email">Email<span class="text-danger">*</span></label>
                <input type="text" class="form-control" id="email" name="email" placeholder="Email" 
                       tabindex="0" required="required" data-validation-required-message="Ingrese Email"
                       data-validation-regex-regex="([a-zA-Z0-9_\.-]+)@([\da-zA-Z\.-]+)\.([a-zA-Z\.]{2,6})"
                       data-validation-regex-message="Email no v�lido. Ej. docente@emprendimiento.com.co" maxlength="200">
            </div>
        </div>
        <div class="form-group col-md-6">
            <div class="controls">
                <label for="telefono">Tel�fono<span class="text-danger">*</span></label>
                <input type="NumericTextBox" class="form-control only-number" id="telefono" name="telefono" placeholder="Tel�fono" min="0"
                       required="required" data-validation-required-message="Ingrese Tel�fono" tabindex="0"
                       minlength="7" maxlength="18" data-validation-maxlength-message="El n�mero de tel�fono debe tener m�ximo 18 caracteres" data-validation-minlength-message="El n�mero de tel�fono debe tener m�nimo 7 caracteres">
            </div>
        </div>
    </div>

    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="idtipodocumento">Tipo de Documento<span class="text-danger">*</span></label>
            <select id="idtipodocumento" class="selectpicker" data-style="btn-info" name="idtipodocumento">
                <c:forEach items="${tiposDTO}" var="tempTipos">
                    <c:if test="${tempTipos.nombredocumento=='CC'}">
                        <option value="${tempTipos.idtipodocumento}" selected >${tempTipos.nombredocumento}</option>
                    </c:if>
                    <c:if test="${tempTipos.nombredocumento!='CC'}">
                        <option value="${tempTipos.idtipodocumento}">${tempTipos.nombredocumento}</option>
                    </c:if>

                </c:forEach>
            </select>
        </div>
        <div class="form-group col-md-6">
            <div class="controls">
                <label for="numerodocumento">N�mero de Documento<span class="text-danger">*</span></label>
                <input type="text" class="form-control" id="numerodocumento" name="numerodocumento" 
                       tabindex="0" placeholder="N�mero de Documento" data-validation-required-message="Ingrese N�mero de Documento" maxlength="18" data-validation-maxlength-message="El n�mero de documento debe tener m�ximo 18 caracteres">
                <span id="spanNumeroDocumento"></span>
            </div>
        </div>
    </div>
</div>
<div class="text-center">
    <button class="btn btn-danger align-content-center float-center" type="button" id="btn-Cancelar">Atr�s</button>
    <button type="button" id="btnRegistro" class="btn btn-success float-center">Guardar</button>    
</div>




<script src="${pageContext.request.contextPath}/resources/js/services/registroDocentes.js" type="text/javascript"></script>
