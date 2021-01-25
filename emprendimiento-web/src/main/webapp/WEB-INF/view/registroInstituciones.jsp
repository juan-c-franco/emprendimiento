<%-- 
    Document   : registroInstituciones
    Created on : jun 26, 2019, 4:18:50 p.m.
    Author     : Andres Gonzalez
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Registrar Instituci�n / Oferente</h3>
<hr />
<p>Diligencie el siguiente formulario</p>

<div id="valora">

    <div class="form-row">
        <div class="form-group col-md-6">
            <div class="controls">
                <label for="nombreInstitucion">Nombre Instituci�n<span class="text-danger">*</span></label>
                <input type="text" class="form-control" id="nombreInstitucion" name="nombreInstitucion" placeholder="Nombre Instituci�n..." required="required" data-validation-required-message="Ingrese el nombre de la instituci�n" maxlength="50">
            </div>
        </div>
        <div class="form-group col-md-6">
            <div class="controls">
                <label for="nit">NIT<span class="text-danger">*</span></label>
                <input type="text" class="form-control" id="nit" name="nit" placeholder="NIT..." required="required" data-validation-required-message="Ingrese el NIT" maxlength="15">
            </div>
        </div>
    </div>
    <div class="form-row">
        <div class="form-group col-md-6">
            <div class="controls">
                <label for="email">Email<span class="text-danger">*</span></label>
                <input type="text" class="form-control" id="email" name="email" placeholder="Email" required="required" data-validation-required-message="Ingrese Email" data-validation-regex-regex="([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})" data-validation-regex-message="Email no Valido" maxlength="180">
            </div>
        </div>
        <div class="form-group col-md-6">
            <label for="naturalezaJuridica">Naturaleza Jur�dica<span class="text-danger">*</span></label>
            <div class="controls">
                <select id="naturalezaJuridica" class="selectpicker" data-style="btn-info" name="naturalezaJuridica" required data-validation-required-message="Seleccione Naturaleza Jur�dica">
                    <option selected value="">Seleccione...</option>
                    <option value="0">Persona Natural</option>
                    <option value="1">Persona Jur�dica</option>  
                </select>
            </div>
        </div>
    </div>
    <div class="form-row">

        <div class="form-group col-md-6">
            <div class="controls">
                <label for="telefono">Tel�fono</label>
                <input type="NumericTextBox" class="form-control only-number" id="telefono" name="telefono" placeholder="Tel�fono" min="0"
                       minlength="7" maxlength="15" data-validation-maxlength-message="El n�mero de tel�fono debe tener m�ximo 15 caracteres" data-validation-minlength-message="El n�mero de tel�fono debe tener m�nimo 7 caracteres">
            </div>
        </div>
        <div class="form-group col-md-6">
            <label for="origen">Origen<span class="text-danger">*</span></label>
            <div class="controls">
                <select id="origen" class="selectpicker" data-style="btn-info" name="origen" required data-validation-required-message="Seleccione Origen">
                    <option selected value="">Seleccione...</option>
                    <option value="1">P�blico</option>
                    <option value="2">Privado</option>  
                    <option value="3">Mixto</option>  
                </select>
            </div>
        </div>
    </div>

    <div class="form-row">
        <div class="form-group col-md-6">
            <label for="tipoInstitucion">Tipo de Instituci�n<span class="text-danger">*</span></label>
            <div class="controls">
                <select id="tipoInstitucion" class="selectpicker" data-style="btn-info" name="tipoInstitucion" required data-validation-required-message="Seleccione Tipo de Instituci�n">
                    <option selected value="">Seleccione...</option>
                    <option value="1">CCF</option>
                    <option value="2">IETDH</option>
                    <option value="3">UVAES</option>
                    <option value="4">SENA</option>
                    <option value="5">OTRA</option>
                </select>
            </div>
        </div>
        <div class="form-group col-md-6">
            <label for="tipoCertificacion">Tipo de Certificaci�n<span class="text-danger">*</span></label>
            <div class="controls">
                <select id="tipoCertificacion" class="selectpicker" data-style="btn-info" name="tipoCertificacion" required data-validation-required-message="Seleccione Tipo de Certificaci�n">
                    <option selected value="">Seleccione...</option>
                    <option value="1">NTC 6094</option>
                    <option value="2">NTC 5555</option>
                    <option value="3">ISO 9001</option>
                </select>
            </div>
        </div>
    </div>

    <div class="form-row">
        <!--        <div class="form-group col-md-6">
                    <label for="estado">Estado<span class="text-danger">*</span></label>
                    <div class="controls">
                        <select id="estado" class="selectpicker" data-style="btn-info" name="estado" required data-validation-required-message="Seleccione Estado">
                            <option selected value="">Seleccione...</option>
                            <option value="1">por confirmar</option>
                            <option value="2">por confirmar</option>
                            <option value="3">por confirmar</option>
                            <option value="4">por confirmar</option>
                            <option value="5">por confirmar</option>
                        </select>
                    </div>
                </div>-->
        <div class="form-group col-md-6">
            <label for="estadoAprobacion">Estado de Aprobaci�n<span class="text-danger">*</span></label>
            <div class="controls">
                <select id="estadoAprobacion" class="selectpicker" data-style="btn-info" name="estadoAprobacion" required data-validation-required-message="Seleccione Estado de Aprobaci�n">
                    <option selected value="">Seleccione...</option>
                    <option value="1">Aprobada</option>
                    <option value="2">No Aprobada</option>
                    <option value="3">Rechazada</option>
                </select>
            </div>
        </div>
    </div>
</div>
<div class="text-center">
    <button class="btn btn-danger align-content-center float-center" type="button" id="btn-Cancelar">Atr�s</button>
    <button type="button" id="btnRegistro" class="btn btn-success float-center">Guardar</button>    
</div>




<script src="${pageContext.request.contextPath}/resources/js/services/registroInstituciones.js" type="text/javascript"></script>
