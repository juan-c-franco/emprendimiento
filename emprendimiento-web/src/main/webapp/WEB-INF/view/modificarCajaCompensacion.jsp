<%-- 
    Document   : homepage
    Created on : 12/09/2018, 09:27:32 AM
    Author     : Andrés Felipe González Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Editar Caja de Compensacion</h3>
<hr />
<p>Diligencie el siguiente formulario</p>

<c:if test="${status=='1'}">
    <div id="valora">
        <div class="form-row">

            <div class="form-group col-md-6">
                <div class ="controls">
                    <label for="nombrecajacompensacion">Nombre Caja de Compensación<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="nombrecajacompensacion"
                           tabindex="0" name="nombrecajacompensacion" placeholder="Nombre Caja de Compensación"  required="required" value="${cajaDTO.nombrecajacompensacion}" data-validation-required-message="Ingrese Nombre Caja de Compensación" maxlength="90">
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <div class ="controls">
                    <label for="codigoccf">Código Caja de Compensación<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="codigoccf" name="codigoccf" 
                           tabindex="0" placeholder="Código Caja de Compensación"  required="required" value="${cajaDTO.codigoccf}" data-validation-required-message="Ingrese Código Caja de Compensación" maxlength="20">
                </div>
            </div>
        </div>
    </div>

    <div class="form-row">
        <!--        <div class="form-group col-md-6">
                    <label for="departamento">Departamento</label>
                    <input type="text" class="form-control" id="departamento" name="departamento" placeholder="Departamento" required="required" value="${cajaDTO.departamento}">
                </div>-->

        <div class="form-group col-md-2">
            <label for="idestadocajacompensacion">Estado</label>
            <select id="idestadocajacompensacion" class="selectpicker" data-style="btn-info" required="required" name="idestadocajacompensacion">
                <c:if test="${cajaDTO.estadocajacompensacion.idestadocajacompensacion=='1'}">
                    <option value=1 selected>Activa</option>
                    <option value=0>Inactiva</option>
                </c:if>
                <c:if test="${cajaDTO.estadocajacompensacion.idestadocajacompensacion=='0'}">
                    <option value=1 >Activa</option>
                    <option value=0 selected>Inactiva</option>
                </c:if>
            </select>
        </div>
    </div>
    <br/>
    <input type="hidden" name="idcajacompensacion" id="idcajacompensacion" value="${cajaDTO.idcajacompensacion}">
    <div class="text-center">
        <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
        <button type="button" id="btnModificar" class="btn btn-success">Guardar</button>
    </div>
</c:if>
<c:if test="${status=='0'}">
    <h5>${mensaje}</h5>
</c:if> 
<script src="${pageContext.request.contextPath}/resources/js/services/modificarCajaCompensacion2.js" type="text/javascript"></script>