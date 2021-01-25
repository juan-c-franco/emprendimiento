<%-- 
    Document   : adjuntarDocumentoAAT
    Created on : 18/11/2018, 09:19:27 PM
    Author     : Danny Fernando Guerrero Gelpud
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>Adjuntar Documento</h3>

<hr />
<c:if test="${not empty mensaje}">
    <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
    </div>
</c:if>
<input type="hidden" id="idBeneficiario" name="idBeneficiario" value="${idBeneficiario}" />
<input type="hidden" id="idEmprendimiento" name="idEmprendimiento" value="${idEmprendimiento}" />
<div class="form-row">
    <c:if test="${status=='adm'}">
        <div class="form-group col-sm-12" id="valora">
            <div class="controls">
                <select class="selectpicker m-b-20 m-r-10" data-style="btn-info" name="emprendimientoId" id="emprendimientoId" data-validation-required-message="Seleccione un emprendimiento" required="required"> 
                    <option value="" label="Seleccione ..." selected="selected">Seleccione ...</option>
                    <c:forEach items="${emprendimientos}" var="emprendimiento">
                        <option style=" heigth : 1px" value="${emprendimiento.idemprendimiento}"> ${emprendimiento.nombreemprendimiento} </option>
                    </c:forEach>
                </select>
            </div>
        </div>
    </c:if>
    <c:if test="${status=='beneficiario'}">
        <div id="divDatosEmprendimiento">
            <div class="form-group row">
                <div class="col-sm-12">
                    <h4>Datos del Empredimiento</h4>
                </div>
            </div>
            <!--            <div class="form-group row">-->
            <input type="hidden" id="idemprendimiento" value="${emprendimiento.idemprendimiento}" style="display: none"/>
            <!--            </div>-->
            <div class="form-group row">
                <label for="nombreEmprendimiento" class="col-sm-3 col-form-label"><b>Nombre emprendimiento</b></label>
                <div class="col-sm-3">
                    <input type="text" readonly class="form-control-plaintext" id="nombreEmprendimiento" value="${emprendimiento.nombreemprendimiento}"/>
                </div>
                <label for="tipoEmprendimiento" class="col-sm-3 col-form-label"><b>Tipo emprendimiento</b></label>
                <div class="col-sm-3">
                    <input type="text" readonly class="form-control-plaintext" id="tipoEmprendimiento" value="${emprendimiento.tipoemprendimiento.nombretipoemprendimiento}"/>
                </div>
            </div>
            <div class="form-group row">
                <label for="estadoEmprendimiento" class="col-sm-3 col-form-label"><b>Estado emprendimiento</b></label>
                <div class="col-sm-3">
                    <input type="text" readonly class="form-control-plaintext" id="estadoEmprendimiento" value="${emprendimiento.estadoemprendimiento.nombreestadoemprendimiento}"/>
                </div>
                <label for="fechaRegistroEmprendimiento" class="col-sm-3 col-form-label"><b>Fecha de registro</b></label>
                <div class="col-sm-3">
                    <input type="text" readonly class="form-control-plaintext" id="fechaRegistroEmprendimiento" value="${emprendimiento.fecharegistro}"/>
                </div>
            </div>

            <div class="form-group row">
                <div class="col-sm-12">
                    <h4>Lista de temas acompañamiento y asistencia técnica</h4>
                    <hr>
                </div>
            </div>
            <!--            <table id="tableData" class="table table-bordered table-striped">-->
            <table class="table table-bordered table-striped dataTablas">
                <thead>
                    <tr>
                        <th>Nombre tema</th>
                        <th>Cantidad horas planeadas</th>
                        <th>Cantidad horas ejecutadas</th>
                        <th>Acción</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="temaRutaAAT" items="${temasRutaAAT}">
                        <tr>
                            <td class="noOverflow">${temaRutaAAT.temasevaluacion.nombretema}</td>
                            <td>${temaRutaAAT.cantidadhorasplaneadas}</td>
                            <td>${temaRutaAAT.cantidadHorasEjecutadas}</td>
                            <td align="center">
                                <c:if test="${soloConsulta and temaRutaAAT.urldocumentotema!=null and temaRutaAAT.urldocumentotema!=''}">
                                    <a class="btn btn-sm btn-rounded btn-info" data-toggle="tooltip" data-placement="top" title="Ver Documento" href="<c:url value='/verDocumentoTemaRutaAAT?id=${temaRutaAAT.idtemarutaacompanamientoat}'/>"><i class="fas fa-eye"></i></a>
<!--                                    <button type="button" class="btn btn-sm btn-rounded btn-info" data-toggle="tooltip" data-placement="top" title="Ver Documento" onclick="verDocumento(${temaRutaAAT.idtemarutaacompanamientoat})"><i class="fas fa-eye"></i></button>-->

                                </c:if>

                                <c:if test="${!soloConsulta}">
                                    <c:if test="${temaRutaAAT.urldocumentotema!=null and temaRutaAAT.urldocumentotema!=''}">
                                        <a class="btn btn-sm btn-rounded btn-info" data-toggle="tooltip" data-placement="top" title="Ver Documento" href="<c:url value='/verDocumentoTemaRutaAAT?id=${temaRutaAAT.idtemarutaacompanamientoat}'/>"><i class="fas fa-eye"></i></a>
                                        <!--<a type="button" class="btn btn-sm btn-rounded btn-info" data-toggle="tooltip" data-placement="top" title="Ver Documento" onclick="verDocumento(${temaRutaAAT.idtemarutaacompanamientoat})"><i class="fas fa-eye"></i></a>-->

                                    </c:if>
<!--                                    <button type="button" class="btn btn-primary" onclick="adjuntarDocumento(${temaRutaAAT.idtemarutaacompanamientoat}, '${temaRutaAAT.temasevaluacion.nombretema}', '${temaRutaAAT.descripciondocumento}')">Adjuntar Documento</button>-->
                                    <a class="btn btn-sm btn-rounded btn-primary" data-toggle="tooltip" data-placement="top" title="Adjuntar Documento" onclick="adjuntarDocumento(${temaRutaAAT.idtemarutaacompanamientoat}, '${temaRutaAAT.temasevaluacion.nombretema}', '${temaRutaAAT.descripciondocumento}')"><i class="fas fa-plus-circle"></i></a>

                                </c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div class="form-row">
                <div class="form-group col-sm-12" style="text-align: center">
                    <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
<!--                    <a href="${pageContext.request.contextPath}/" class="btn btn-danger" role="button">Cancelar</a>-->
                </div>
            </div>
        </div>
    </c:if>
</div>
<div class="modal fade" id="modalAdjuntarDocumento" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Adjuntar documento acompañamiento y asistencia técnica</h5>
                <button class="close" type="button" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <div id="divDatosDocumento">
                    <div class="form-group row">
                        <div class="col-sm-12">
                            <h5>Datos del documento acompañamiento y asistencia técnica</h5>
                            <input type="hidden" id="idTemaRutaAAT" name="idTemaRutaAAT"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="nombreTemaModalAdjuntar" class="col-sm-3 col-form-label">Nombre del tema</label>
                        <div class="col-sm-9">
                            <input type="text" readonly class="form-control-plaintext" id="nombreTemaModalAdjuntar"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="descripcionDocumento" class="col-sm-3 col-form-label">Descripción documento</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="descripcionDocumento" required="true"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="documentoTema" class="col-sm-3 col-form-label">Documento</label>
                        <div class="col-sm-9">
                            <input type="file" class="form-control" id="documentoTema" accept="application/pdf" required="true" size="20"/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="text-center">
                        <button class="btn btn-danger" type="button" data-dismiss="modal">Cancelar</button>
                        <button type="button" class="btn btn-success" id="btnGuardarDocumento">Guardar documento</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<c:if test="${status=='adm'}">
    <div class="text-center">
        <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
        <button type="button" id="btnSeleccionarEmprendimiento" class="btn btn-success">Seleccionar</button>

        <!--        <div class="form-group col-sm-6" >
                    <button type="button" id="btnSeleccionarEmprendimiento" class="btn btn-primary">Seleccionar Emprendimiento</button>
                </div>
                <div class="form-group col-sm-6">
                    <a href="${pageContext.request.contextPath}/" class="btn btn-danger" role="button">Cancelar</a>
                </div>-->
    </div>
</c:if>
<script src="${pageContext.request.contextPath}/resources/js/services/adjuntarDocumentoAAT.js" type="text/javascript"></script>