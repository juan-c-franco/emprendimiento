<%-- 
    Document   : herramientasEvaluacion
    Created on : 10/10/2018, 08:58:48 PM
    Author     : Danny Fernando Guerrero Gelpud    
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Herramientas de Evaluación</h3>
<hr />
<div class="form-row" id="valora">
    <div class="form-group col-sm-6">
        <div class="controls">
            <label>Herramienta de Evaluación</label>
            <select  class="selectpicker m-b-20 m-r-10" data-style="btn-info" name="tipoHerramienta" id="tipoHerramienta" data-validation-required-message="Seleccione una herramienta de valoración" required="required">  
                <option value="" label="Seleccione ..." selected="selected">Seleccione ...</option>
                <c:forEach items="${herramientasValoracion}" var="herramientaValoracion">
                    <c:if test="${tipoHerramienta == herramientaValoracion.idHerramienta}">
                        <option style=" heigth : 1px" value="${herramientaValoracion.idHerramienta}" selected>${herramientaValoracion.nombreHerramienta}</option>
                    </c:if>
                    <c:if test="${tipoHerramienta != herramientaValoracion.idHerramienta}">
                        <option style=" heigth : 1px" value="${herramientaValoracion.idHerramienta}"> ${herramientaValoracion.nombreHerramienta} </option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
    </div>
    <c:if test="${status !='adm'}">
        <div class="form-group col-sm-6">
            <div class="controls">
                <label>Caja de Compensación</label>
                <select  class="selectpicker m-b-20 m-r-10" data-style="btn-info" name="cajaId" id="cajaId" disabled data-validation-required-message="Seleccione una Caja de Compensación" required="required"> 
                    <option value="" label="Seleccione ..." selected="selected">Seleccione ...</option>
                    <c:forEach items="${cajas}" var="caja">
                        <option style=" heigth : 1px" name="cajaId" value="${caja.idcajacompensacion}"> ${caja.nombrecajacompensacion} </option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </c:if>
    <c:if test="${status=='adm'}">
        <div class="form-group col-sm-6">
            <div class="controls">
                <label>Caja de Compensación</label>
                <select  class="selectpicker m-b-20 m-r-10" data-style="btn-info" name="cajaId" id="cajaId" data-validation-required-message="Seleccione una Caja de Compensación" required="required"> 
                    <option value="" label="Seleccione ..." selected="selected">Seleccione ...</option>
                    <c:forEach items="${cajas}" var="caja">
                        <option style=" heigth : 1px" name="cajaId" value="${caja.idcajacompensacion}"> ${caja.nombrecajacompensacion} </option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </c:if>
</div>
<div class="text-center">

    <a href="${pageContext.request.contextPath}/" class="btn btn-danger" role="button">Atrás</a>
    <button type="button" id="btnParametrizar"class="btn btn-success">Parametrizar</button>

</div>

<script src="${pageContext.request.contextPath}/resources/js/services/herramientasEvaluacionParametrizar.js" type="text/javascript"></script>