<%-- 
    Document   : registroCapacitacion
    Created on : jul 3, 2019, 2:59:34 p.m.
    Author     : Andres Gonzalez
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Registrar Capacitación / Programa</h3>
<hr />
<p>Diligencie el siguiente formulario</p>

<div id="valora">

    <div class="form-row">
        <div class="form-group col-md-6">
            <div class="controls">
                <label for="nombreCapacitacion">Nombre Capacitación<span class="text-danger">*</span></label>
                <input type="text" class="form-control" id="nombreCapacitacion" name="nombreCapacitacion"
                      tabindex="0" placeholder="Nombre Capacitación..." required="required" 
                      data-validation-required-message="Ingrese el nombre de la institución" 
                      maxlength="200">
            </div>
        </div>
        <div class="form-group col-md-6">
            <label for="idOferenteInstitucion">Institución / Oferente<span class="text-danger">*</span></label>
            <div class="controls">
                <select id="idOferenteInstitucion" class="selectpicker" data-style="btn-info" name="idOferenteInstitucion" required data-validation-required-message="Seleccione Institución/Oferente">
                    <c:if test="${not empty instituciones}">
                        <option selected value="">Seleccione...</option>
                        <c:forEach items="${instituciones}" var="tempInst">
                            <option value="${tempInst.id}">${tempInst.nombreInstitucion}</option>
                        </c:forEach> 
                    </c:if>
                    <c:if test="${empty instituciones}">
                        <option selected value="" disabled>No hay instituciones parametrizadas</option> 
                    </c:if>
                </select>
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="categorias">Categoría<span class="text-danger">*</span></label>
            <div class="controls">
                <c:if test="${not empty categorias}">
                    <select id="categorias" class="selectpicker" data-style="btn-info" name="categorias" required data-validation-required-message="Seleccione Categoría">

                        <option selected value="">Seleccione...</option>
                        <c:forEach items="${categorias}" var="tempCat">
                            <option value="${tempCat.idcategoria}">${tempCat.nombrecategoria}</option>
                        </c:forEach> 
                    </select>
                </c:if>
                <c:if test="${empty categorias}">
                    <select id="categorias" class="selectpicker" data-style="btn-info" name="categorias" required data-validation-required-message="Seleccione Categoría" disabled>
                        <option selected value="">No hay categorias parametrizadas</option> 
                    </select>
                </c:if>


            </div>
        </div>
    </div>
</div>
<div class="text-center">
    <button class="btn btn-danger align-content-center float-center" type="button" id="btn-Cancelar">Atrás</button>
    <button type="button" id="btnRegistro" class="btn btn-success float-center">Guardar</button>    
</div>

<script src="${pageContext.request.contextPath}/resources/js/services/registroCapacitacion.js" type="text/javascript"></script>

