<%-- 
    Document   : agendarSesionAAT
    Created on : 30/10/2018, 10:05:14 PM
    Author     : Danny Fernando Guerrero Gelpud
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>Agendar Sesión Asistencia Técnica</h3>
<hr/>
<h6>${mensaje}</h6>
<input type="hidden" id="idCajaCompensacion" name="idCajaCompensacion" value="${idCajaCompensacion}" />
<input type="hidden" id="idAsistenteTecnico" name="idAsistenteTecnico" value="${idAsistenteTecnico}" />
<div class="form-row">
    <!--<c:if test="${status=='adm'}">
        <div class="form-group col-sm-12">
            <select required="required" class="form-control" name="cajaId" id="cajaId"> 
                <option value="" label="Seleccione ..." selected="selected">Seleccione ...</option>
        <c:forEach items="${cajas}" var="caja">
            <option style=" heigth : 1px" name="cajaId" value="${caja.idcajacompensacion}"> ${caja.nombrecajacompensacion} </option>
        </c:forEach>
    </select>
</div>
    </c:if>
    <c:if test="${status=='caja'}">
        <div class="form-group col-sm-12">
            <select required="required" class="form-control" name="asistenteTecnicoId" id="asistenteTecnicoId"> 
                <option value="" label="Seleccione ..." selected="selected">Seleccione ...</option>
        <c:forEach items="${asistentesTecnicos}" var="asistenteTecnico">
            <option style=" heigth : 1px" value="${asistenteTecnico.idfuncionario}"> ${asistenteTecnico.primernombre} ${asistenteTecnico.primerapellido} </option>
        </c:forEach>
    </select>
</div>
    </c:if>-->
    <div id='calendar'></div>
    <div class="modal fade" id="modalAgendamiento" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Agendar Sesión de Acompañamiento Asistencia Técnica</h5>
                    <button class="close" type="button" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body" style="overflow-y: scroll">
                    <div class="form-group row">
                        <label for="numeroDocumento" class="col-xl-2 col-form-label">N° Documento <span class="text-danger">*</span> </label>
                        <div id="divConsulta" class="controls col-xl-6">
                            <input type="NumericTextBox" id="numeroDocumento" name="numeroDocumento" class="form-control only-number"
                                   min="0"
                                   data-validation-min-message="No puede ser negativo."
                                   maxlength="18"
                                   data-validation-maxlength-message="Máximo 18 dígitos"
                                   data-validation-required-message="Campo Obligatorio"
                                   required />
                        </div>
                        <div class="col-xl-4">
                            <button type="submit" class="btn btn-primary" id="consultarBeneficiario"> <i class="mdi mdi-magnify"></i> Consultar Beneficiario</button>
                            <!--                            <a class="btn btn-primary" id="consultarBeneficiario"><i class="mdi mdi-magnify"></i> Consultar Beneficiario</a>        -->
                        </div>
                    </div>
                    <div id="divDatosAgendamiento" hidden="true">
                        <h6>Datos del Beneficiario</h6>
                        <div class="form-group row">
                            <label for="nombreBeneficiario" class="col-sm-3 col-form-label"><b>Nombre beneficiario</b></label>
                            <div class="col-sm-3">
                                <input type="text" readonly class="form-control-plaintext" id="nombreBeneficiario"
                                       data-validation-required-message="Ingrese Hora" required/>
                            </div>
                            <label for="emailBeneficiario" class="col-sm-3 col-form-label"><b>Correo electrónico</b></label>
                            <div class="col-sm-3">
                                <input type="text" readonly class="form-control-plaintext" id="emailBeneficiario"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="celularBeneficiario" class="col-sm-3 col-form-label"><b>Número celular</b></label>
                            <div class="col-sm-3">
                                <input type="text" readonly class="form-control-plaintext" id="celularBeneficiario"/>
                            </div>
                            <label for="fechaRegistroBeneficiario" class="col-sm-3 col-form-label"><b>Fecha de registro</b></label>
                            <div class="col-sm-3">
                                <input type="text" readonly class="form-control-plaintext" id="fechaRegistroBeneficiario"/>
                            </div>
                        </div>
                        <h6>Datos del Empredimiento</h6>
                        <div class="form-group row">
                            <input type="hidden" id="idEmprendimiento"/>
                            <label for="nombreEmprendimiento" class="col-sm-3 col-form-label"><b>Nombre emprendimiento</b></label>
                            <div class="col-sm-3">
                                <input type="text" readonly class="form-control-plaintext" id="nombreEmprendimiento"/>
                            </div>
                            <label for="tipoEmprendimiento" class="col-sm-3 col-form-label"><b>Tipo emprendimiento</b></label>
                            <div class="col-sm-3">
                                <input type="text" readonly class="form-control-plaintext" id="tipoEmprendimiento"/>
                            </div>
                        </div>
                        <div class="form-group row">
                            <label for="estadoEmprendimiento" class="col-sm-3 col-form-label"><b>Estado emprendimiento</b></label>
                            <div class="col-sm-3">
                                <input type="text" readonly class="form-control-plaintext" id="estadoEmprendimiento"/>
                            </div>
                            <label for="fechaRegistroEmprendimiento" class="col-sm-3 col-form-label"><b>Fecha de registro</b></label>
                            <div class="col-sm-3">
                                <input type="text" readonly class="form-control-plaintext" id="fechaRegistroEmprendimiento"/>
                            </div>
                        </div>
                        <h6>Selección tema acompañamiento asistencia técnica</h6>
                        <div class="form-group row">
                            <div class="col-sm-12 controls">
                                <select class="form-control" id="temaAATId" 
                                        data-validation-required-message="Ingrese Tema" required></select>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer text-center">
                        <button class="btn btn-danger" type="button" data-dismiss="modal">Cancelar</button>
                        <button class="btn btn-success" type="submit" id="agendarSesionAAT" hidden="true">Agendar Sesión</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!--<div class="form-row">
    <div class="form-group col-sm-6" style="text-align: right">
<c:if test="${status=='adm'}">
    <button type="button" id="btnSeleccionarCaja" class="btn btn-primary">Seleccionar Caja de Compensación</button>
</c:if>
<c:if test="${status=='caja'}">
    <button type="button" id="btnValidarDisponibilidad" class="btn btn-primary">Validar disponibilidad</button>
</c:if>
</div>
<div class="form-group col-sm-6">
<c:if test="${status=='adm'||status=='caja'}">
    <a href="${pageContext.request.contextPath}/" class="btn btn-danger" role="button">Cancelar</a>
</c:if>
</div>
</div>-->

<script src="${pageContext.request.contextPath}/resources/js/services/agendarSesionAAT.js" type="text/javascript"></script>
<script>
    <c:if test="${not empty idFuncionario}">
    idfuncionario = ${idFuncionario};
    </c:if>
    <c:if test="${not empty idCajacompensacion}">
    idcajacompensacion = ${idCajacompensacion};
    </c:if>
</script>