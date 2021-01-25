<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<h3>Agendar Sesión </h3>
<hr/>
<div id="calendar"></div>


<div class="modal fade" id="modalSesion" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog  " role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalLabel">Agendar Sesión</h5>
                <button class="close" type="button" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class=" modal-body">
                <div class="form-group row">
                    <div class="col-xl-6">
                        <label for="idBeneficiario" class="form-label">Número Documento Beneficiario <span class="text-danger">*</span></label>

                        <input class="form-control" id="numerodocumento" type="text" disabled 
                               data-validation-required-message="Ingrese Número de Documento" required>


                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-xl-6">
                        <label for="nombres" class="col-form-label"> Nombres <span class="text-danger">*</span></label>
                        <input class="form-control" id="nombres" type="text" disabled
                               data-validation-required-message="Ingrese Nombres del Beneficiario" required>
                    </div>
                    <div class="col-xl-6">
                        <label for="apellidos" class="col-form-label">Apellidos <span class="text-danger">*</span></label>
                        <input class="form-control" id="apellidos" type="text" disabled
                               data-validation-required-message="Ingrese Apellidos del Beneficiario" required>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-xl-6">
                        <label for="email">Email <span class="text-danger">*</span></label>
                        <input class="form-control" id="email" type="text" disabled
                               data-validation-required-message="Ingrese Email del Beneficiario" required>
                    </div>
                    <div class="col-xl-6">
                        <label for="fechaInicio">Fecha<span class="text-danger">*</span></label>
                        <input class="form-control" id="fecha" type="text" disabled
                               data-validation-required-message="Ingrese Fecha de la Sesión" required>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-xl-6">
                        <label for="fechaInicio">Hora Inicio <span class="text-danger">*</span></label>
                        <input class="form-control" id="fechaInicio" type="text" disabled
                               data-validation-required-message="Ingrese Hora de la Sesión" required>
                    </div>
                    <div class="col-xl-6">
                        <label for="fechaFinal">Hora Final <span class="text-danger">*</span></label>
                        <input class="form-control" id="fechaFinal" type="text" disabled
                               data-validation-required-message="Ingrese Hora de la Sesión" required>
                    </div>
                    <input type="hidden" id="idSesion">
                </div>
            </div>
            <div class="modal-footer text-center">
                <button class="btn btn-danger" type="button" data-dismiss="modal">Cerrar</button>
                <button class="btn btn-success" id="btnAgendar">Agendar</button>
            </div>
        </div>
    </div>

</div>
</div>
<script src="${pageContext.request.contextPath}/resources/_dist/js/services/sensibilizacion/agendarSensibilizacion.js" type="text/javascript" charset="UTF-8"></script>
<script>
    <c:if test="${not empty idFuncionario}">
    idfuncionario = ${idFuncionario};
    </c:if>
</script>