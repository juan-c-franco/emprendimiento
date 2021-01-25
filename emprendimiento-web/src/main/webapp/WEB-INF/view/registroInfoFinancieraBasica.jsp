<%-- 
    Document   : registroInfoFinancieraBasica
    Created on : dic 3, 2018, 11:06:19 a.m.
    Author     : Andres Felipe Gonzalez M Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="row">
    <div class="col-12">
        <div class="card">
            <h3>Registro Información Financiera Inicial</h3>
            <p>Diligencie el siguiente formulario</p>
            <hr />

            <div class="card-body" >
                <div id="valida">
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <div class="controls">
                                <label for="montoAFinanciar">Monto a Financiar<span class="text-danger">*</span></label>
                                <input type="NumericTextBox" class="form-control only-number" id="montoAFinanciar" 
                                       tabindex="0" value="${financiacion.montofinanciacions}" required data-validation-required-message="Ingrese el monto a financiar" min='0'>
                            </div>
                        </div>
                        <div class="form-group col-md-4">
                            <div class='controls'>
                                <label for="tipoFinanciacion">Tipo de Financiacion<span class="text-danger">*</span></label>
                                <select id="tipoFinanciacion" class="selectpicker" data-style="btn-info" required data-validation-required-message='Seleccione una opción'>
                                    <option selected value="">Seleccione...</option>
                                    <c:forEach items="${tiposFinanciacion}" var="tempTipos">
                                        <c:if test="${tempTipos.idtipofinanciacion == financiacion.tipofinanciacionByIdtipofinanciacions.idtipofinanciacion}">
                                            <option value="${tempTipos.idtipofinanciacion}" selected>${tempTipos.nombretipofinanciacion}</option>
                                        </c:if>
                                        <c:if test="${tempTipos.idtipofinanciacion != financiacion.tipofinanciacionByIdtipofinanciacions.idtipofinanciacion}">
                                            <option value="${tempTipos.idtipofinanciacion}">${tempTipos.nombretipofinanciacion}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div> 
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <div class="controls">
                                <label for="cuotasPactadas">Cuotas a Solicitar<span class="text-danger">*</span></label>
                                <input type="NumericTextBox" min="0" tabindex="0"
                                       class="form-control only-number maxAsistentesProgramarSensibilizacion" id="cuotasPactadas" placeholder="Numero de cuotas" value="${financiacion.cuotaspactadass}" required data-validation-required-message="Ingrese las cuotas a solicitar" min="0">
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <div class="controls">
                                <label for="interes">Tasa de Interés<span class="text-danger">*</span></label>
                                <input type="NumericTextBox" min="0" class="form-control" id="interes" 
                                       tabindex="0" placeholder="Tasa de interes"
                                       value="${financiacion.tasaintertess}"required 
                                       data-validation-required-message="Ingrese la tasa de interés" 
                                       min='0' max='100'
                                       data-validation-regex-regex="^[0-9]+([.][0-9]+)?$" 
                                       data-validation-regex-message="Use un punto(.) como separador decimal">
                            </div>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <div class="controls">
                                <label for="recursosPropios">Recursos Propios<span class="text-danger">*</span></label>
                                <input type="NumericTextBox" min="0" class="form-control only-number" id="recursosPropios" 
                                       tabindex="0" placeholder="Recursos propios"value="${financiacion.recursospropiosae}" required data-validation-required-message="Ingrese los recursos propios" min='0'>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <div class="controls">
                                <label for="empleosXGenerar">Empleos por Generar<span class="text-danger">*</span></label>
                                <input type="NumericTextBox" min="0" class="form-control only-number" id="empleosXGenerar" 
                                       tabindex="0" placeholder="Cantidad de empleos por generar"value="${financiacion.empleosporgenerar}" required data-validation-required-message="Ingrese los empleos por generar" min='0'>
                            </div>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <div class="controls">
                                <label for="capitalTrabajo">Capital de Trabajo<span class="text-danger">*</span></label>
                                <input type="NumericTextBox" min="0" class="form-control only-number" id="capitalTrabajo" 
                                       tabindex="0" placeholder="Capital de trabajo" value="${financiacion.capitaltrabajo}" required data-validation-required-message="Ingrese el capital de trabajo" min='0'>
                            </div>
                        </div>
                        <div class="form-group col-md-6">
                            <div class="controls">
                                <label for="mesesEquilibrio">Meses para el Punto de Equilibrio<span class="text-danger">*</span></label>
                                <input type="NumericTextBox" min="0" tabindex="0"
                                       class="form-control only-number maxAsistentesProgramarSensibilizacion" id="mesesEquilibrio" placeholder="Cantidad de meses para el punto de equilibrio" value="${financiacion.mesespuntoequilibrio}" required data-validation-required-message="Ingrese los meses para el punto de equilibrio" min="0">
                            </div>
                        </div>
                    </div> 
                    <div class="form-row">
                        <div class="form-group col-md-6">
                            <label for="capitalTotal">Capital Total<span class="text-danger">*</span></label>
                            <input type="NumericTextBox" min="0" class="form-control" id="capitalTotal" 
                                   tabindex="0" placeholder="Capital Total" value="" disabled="true" value="${financiacion.capitaltotal}">
                        </div>
                        <br>
                        <div class="form-group">
                            <h6><b>¿Aprueba continuar a evaluación de comité?<span class="text-danger">*</span></b></h6>
                            <div class="controls">
                                <div class="custom-control custom-radio controls">
                                    <input data-radio="iradio_square-blue"  class="custom-control-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="1" required data-validation-required-message="Seleccione una opción">
                                    <label class="custom-control-label" for="inlineRadio1">Si</label>
                                </div>
                                <div class="custom-control custom-radio controls">
                                    <input  data-radio="iradio_square-blue"  class="custom-control-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="0">
                                    <label class="custom-control-label" for="inlineRadio2">No </label>
                                </div>
                            </div>
                        </div>
                    </div>
                    <input type="hidden" value="${idEmprendimiento}" id="idEmprendimiento">
                    <input type="hidden" value ="${idFuncionario}" id="idFuncionario">
                    <div class="text-center">
                        <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
                        <button type="button" id="btnRegistro" class="btn btn-success">Guardar</button>
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/services/registroInfoFinancieraBasica.js" type="text/javascript"></script>
