<%-- 
    Document   : registroInfoFinanciera
    Created on : dic 5, 2018, 6:36:15 p.m.
    Author     : Andres Felipe Gonzalez M Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="row">
    <div class="col-12">
        <div class="card">
            <h3>Registro Información Financiera</h3>
            <p>Diligencie el siguiente formulario</p>
            <hr />

            <div class="card-body">
                <div id="valida">
                    <div class="form-row">
                        <div class="form-group col-md-5">
                            <div class="controls">
                                <label for="montoA">Monto a Financiar<span class="text-danger">*</span></label>
                                <input type="NumericTextBox" min="0" class="form-control only-number" 
                                       tabindex="0" id="montoA" value="${financiacion.montoa}" required data-validation-required-message="Ingrese el monto a financiar" min="0">
                            </div>
                        </div>
                        <div class="form-group col-md-5 offset-2">
                            <div class="controls">
                                <label for="tipoFinanciacion">Tipo de Financiacion<span class="text-danger">*</span></label>
                                <select id="tipoFinanciacion" class="selectpicker" data-style="btn-info" required data-validation-required-message='Seleccione una opción'>
                                    <option selected value="">Seleccione...</option>
                                    <c:forEach items="${tiposFinanciacion}" var="tempTipos">
                                        <c:if test="${tempTipos.idtipofinanciacion == financiacion.tipofinanciacionByIdtipofinanciaciona.idtipofinanciacion}">
                                            <option value="${tempTipos.idtipofinanciacion}" selected>${tempTipos.nombretipofinanciacion}</option>
                                        </c:if>
                                        <c:if test="${tempTipos.idtipofinanciacion != financiacion.tipofinanciacionByIdtipofinanciaciona.idtipofinanciacion}">
                                            <option value="${tempTipos.idtipofinanciacion}">${tempTipos.nombretipofinanciacion}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div> 
                    <div class="form-row">
                        <div class="form-group col-md-5">
                            <div class="controls">
                                <label for="cuotaspactadasa">Cuotas a Solicitar<span class="text-danger">*</span></label>
                                <input type="NumericTextBox" min="0" class="form-control only-number" 
                                       tabindex="0" id="cuotaspactadasa" placeholder="Numero de cuotas" value="${financiacion.cuotaspactadasa}" required data-validation-required-message="Ingrese las cuotas a solicitar" min="0">
                            </div>
                        </div>
                        <div class="form-group col-md-5 offset-2">
                            <div class="controls">
                                <label for="tasainteresa">Tasa de Interés<span class="text-danger">*</span></label>
                                <input type="NumericTextBox" min="0" class="form-control" 
                                       tabindex="0" id="tasainteresa" 
                                       placeholder="Tasa de interes"value="${financiacion.tasainteresa}" 
                                       required data-validation-required-message="Ingrese la tasa de interés" 
                                       min="0" max="100"
                                       data-validation-regex-regex="^[0-9]+([.][0-9]+)?$" 
                                       data-validation-regex-message="Use un punto(.) como separador decimal">
                            </div>
                        </div>
                    </div>

                    <div class="form-row">
                        <div class="form-group col-md-5 ">
                            <div class="controls">
                                <label for="identidadfinanciera">Entidad Financiera<span class="text-danger">*</span></label>
                                <select id="identidadfinanciera" class="selectpicker" data-style="btn-info" required data-validation-required-message='Seleccione una opción'>
                                    <option selected value="">Seleccione...</option>
                                    <c:forEach items="${entidadesFinancieras}" var="tempEntidades">
                                        <c:if test="${tempEntidades.identidadfinanciera == financiacion.entidadesfinancieras.identidadesfinanciera}">
                                            <option value="${tempEntidades.identidadfinanciera}" selected>${tempEntidades.nombreentidad}</option>
                                        </c:if>
                                        <c:if test="${tempEntidades.identidadfinanciera != financiacion.entidadesfinancieras.identidadesfinanciera}">
                                            <option value="${tempEntidades.identidadfinanciera}">${tempEntidades.nombreentidad}</option>
                                        </c:if>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>

                    </div>


                    <input type="hidden" value="${financiacion.idfinanciacion}" id="idfinanciacion">
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
<script src="${pageContext.request.contextPath}/resources/js/services/registroInfoFinanciera.js" type="text/javascript"></script>
