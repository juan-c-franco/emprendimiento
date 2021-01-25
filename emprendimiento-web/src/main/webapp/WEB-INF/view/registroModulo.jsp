<%-- 
    Document   : registroModulo
    Created on : jul 9, 2019, 2:34:18 p.m.
    Author     : Andres Gonzalez
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Registrar M�dulo / Ciclo</h3>
<hr />
<p>Diligencie el siguiente formulario</p>

<div id="valora">

    <div class="form-row">
        <div class="form-group col-md-6">
            <div class="controls">
                <label for="nombremodulociclo">Nombre M�dulo<span class="text-danger">*</span></label>
                <input type="text" class="form-control" id="nombremodulociclo" name="nombremodulociclo" 
                       tabindex="0" placeholder="Nombre M�dulo..." required="required" data-validation-required-message="Ingrese el nombre del m�dulo" maxlength="200">
            </div>
        </div>
        <div class="form-group col-md-6">
            <label for="idcapacitacionprograma">Capacitaci�n Programa<span class="text-danger">*</span></label>
            <div class="controls">
                <select id="idcapacitacionprograma" class="selectpicker" data-style="btn-info" name="idcapacitacionprograma" required data-validation-required-message="Seleccione Capacitaci�n">
                    <c:if test="${not empty capacitaciones}">
                        <option selected value="">Seleccione...</option>
                        <c:forEach items="${capacitaciones}" var="tempCap">
                            <option value="${tempCap.idcapacitacionprograma}">${tempCap.nombrecapacitacionprograma}</option>
                        </c:forEach> 
                    </c:if>
                    <c:if test="${empty capacitaciones}">
                        <option selected value="" disabled>No hay Capacitaciones parametrizadas</option> 
                    </c:if>
                </select>
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <div class="controls">
                <label for="intensidadhoraria">Intensidad Horaria<span class="text-danger">*</span></label>
                <input type="NumericTextBox" class="form-control only-number" id="intensidadhoraria" 
                       tabindex="0" name="intensidadhoraria" placeholder="Intensidad Horaria..." required="required" data-validation-required-message="Ingrese la intensidad horaria" maxlength="3">
            </div>
        </div>
    </div>
</div>
<div class="text-center">
    <button class="btn btn-danger align-content-center float-center" type="button" id="btn-Cancelar">Atr�s</button>
    <button type="button" id="btnRegistro" class="btn btn-success float-center">Guardar</button>    
</div>

<script src="${pageContext.request.contextPath}/resources/js/services/registroModulo.js" type="text/javascript"></script>


