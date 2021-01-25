<%-- 
    Document   : homepage
    Created on : 12/09/2018, 09:27:32 AM
    Author     : Andrés Felipe González Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Editar Entidad Financiera</h3>
<hr />
<p>Diligencie el siguiente formulario</p>

<c:if test="${status=='1'}">

    <div id="valora">
        <div class="form-row">

            <div class="form-group col-md-6">
                <div class="controls">
                    <label for="nombreentidad">Nombre Entidad Financiera<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="nombreentidad" name="nombreentidad" 
                           tabindex="0" placeholder="Nombre Entidad Financiera" required="required" value="${entidadDTO.nombreentidad}" data-validation-required-message="Ingrese Nombre Entidad Financiera" maxlength="180">
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <div class="controls">
                    <label for="descripcion">Descripción<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="descripcion" name="descripcion" tabindex="0"
                           placeholder="Descripción" required="required" value="${entidadDTO.descripcion}" data-validation-required-message="Ingrese Descripción" maxlength="450">
                </div>
            </div>
        </div>
    </div>
    <div class="form-row">

        <div class="form-group col-md-2">
            <label for="estado">Estado</label>
            <c:if test="${entidadDTO.estado=='1'}">
                <select id="estado" class="selectpicker" data-style="btn-info" required="required" name="estado">
                    <option value="1" selected>Activa</option>
                    <option value="0">Inactiva</option>
                </select>
            </c:if>
            <c:if test="${entidadDTO.estado=='0'}">
                <select id="estado" class="selectpicker" data-style="btn-info" required="required" name="estado">
                    <option value="1" >Activa</option>
                    <option value="0"selected>Inactiva</option>
                </select>
            </c:if>
        </div>
    </div>
    <input type="hidden" name="identidadesfinanciera" id="identidadesfinanciera"value="${entidadDTO.identidadfinanciera}">
    <div class="form-group col-md-6">
        <div class="text-center">
            <button type="button" id="btn-Cancelar" class="btn btn-danger">Atrás</button>
            <button type="button" id="btnModificar" class="btn btn-success">Guardar</button>
        </div>
    </div>

</c:if>
<c:if test="${status=='0'}">
    <h5>${mensaje}</h5>
</c:if>      
<script src="${pageContext.request.contextPath}/resources/js/services/modificarEntidadFinanciera.js" type="text/javascript"></script>