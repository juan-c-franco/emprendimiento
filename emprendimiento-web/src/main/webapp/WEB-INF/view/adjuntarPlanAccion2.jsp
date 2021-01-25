<%-- 
    Document   : adjuntarPlanAccion2
    Created on : dic 11, 2018, 3:44:45 p.m.
    Author     : Andres Felipe Gonzalez M Grow Data PC
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<div id="divDatosEmprendimiento">
    <h3>Adjuntar Plan de Acción</h3>
    <hr />
    <!--    <div class="form-group row">
            <div class="col-sm-12">-->
    <h4>Datos del Empredimiento</h4>
    <!--        </div>
        </div>-->
    <!--<div class="form-group row">-->
    <input type="hidden" id="idemprendimiento" value="${emprendimiento.idemprendimiento}"/>
    <!--</div>-->
    <div class="form-group row">
        <label for="nombreEmprendimiento" class="col-sm-3 col-form-label">Nombre emprendimiento</label>
        <div class="col-sm-3">
            <input type="text" readonly class="form-control-plaintext" id="nombreEmprendimiento" value="${emprendimiento.nombreemprendimiento}"/>
        </div>
        <label for="tipoEmprendimiento" class="col-sm-3 col-form-label">Tipo emprendimiento</label>
        <div class="col-sm-3">
            <input type="text" readonly class="form-control-plaintext" id="tipoEmprendimiento" value="${emprendimiento.tipoemprendimiento.nombretipoemprendimiento}"/>
        </div>
    </div>
    <div class="form-group row">
        <label for="estadoEmprendimiento" class="col-sm-3 col-form-label">Estado emprendimiento</label>
        <div class="col-sm-3">
            <input type="text" readonly class="form-control-plaintext" id="estadoEmprendimiento" value="${emprendimiento.estadoemprendimiento.nombreestadoemprendimiento}"/>
        </div>
        <label for="fechaRegistroEmprendimiento" class="col-sm-3 col-form-label">Fecha de registro</label>
        <div class="col-sm-3">
            <input type="text" readonly class="form-control-plaintext" id="fechaRegistroEmprendimiento" value="${emprendimiento.fecharegistro}"/>
        </div>
    </div>
    <!--    <hr>
        <div class="form-group row">
            <div class="col-sm-12">-->
    <h4>Lista de temas acompañamiento y asistencia técnica</h4>
    <!--        </div>
        </div>-->
    <table class="table table-bordered table-hover" id="idTblTemasRutaAAT">
        <thead>
            <tr>
                <th>Nombre tema</th>
                <th>Cantidad horas planeadas</th>
                <th>Cantidad horas ejecutadas</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="temaRutaAAT" items="${temasRutaAAT}">
                <tr>
                    <td class="noOverflow">${temaRutaAAT.temasevaluacion.nombretema}</td>
                    <td>${temaRutaAAT.cantidadhorasplaneadas}</td>
                    <td>${temaRutaAAT.cantidadHorasEjecutadas}</td>
                    <td align="center">
                        <c:if test="${lider =='0' || empty lider}">
                            <a class="btn btn-sm btn-rounded btn-info" data-toggle="tooltip" data-placement="top" title="Ver Documento" href="<c:url value='/verDocumentoTemaRutaAAT?id=${temaRutaAAT.idtemarutaacompanamientoat}'/>"><i class="fas fa-eye"></i></a>
                            </c:if>

                        <c:if test="${lider == '1'}">
                            <c:if test="${temaRutaAAT.urldocumentotema!=null and temaRutaAAT.urldocumentotema!=''}">
                                <a class="btn btn-sm btn-rounded btn-info" data-toggle="tooltip" data-placement="top" title="Ver Documento" href="<c:url value='/verDocumentoTemaRutaAAT?id=${temaRutaAAT.idtemarutaacompanamientoat}'/>"><i class="fas fa-eye"></i></a>
                                </c:if>
                            <button type="button" class="btn btn-sm btn-rounded btn-success" data-toggle="tooltip" data-placement="top" title="Adjuntar Documento" onclick="adjuntarDocumento(${temaRutaAAT.idtemarutaacompanamientoat}, '${temaRutaAAT.temasevaluacion.nombretema}', '${temaRutaAAT.descripciondocumento}')"><i class="fas fa-plus-circle"></i></button>
                            </c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <!--    <hr>
        <div class="form-group row">
            <div class="col-sm-12">-->
    <h4>Plan de Acción</h4>
    <!--        </div>
        </div>-->
    <table  class="table table-bordered table-striped">
        <thead>
            <tr>
                <th>Tipo documento</th>
                <th>Documento</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <%--   <c:forEach var="documentoPlan" items="${documentoPlan}"> --%>
            <tr>
                <td class="noOverflow">${documentoPlan.tipodocumentos.nombretipodocumento}</td>
                <td class="noOverflow">${documentoPlan.urlarchivo}</td>
                <td align="center">
                    <c:if test="${(lider == '0' and documentoPlan.urlarchivo!=null and documentoPlan.urlarchivo!='') || (empty lider and documentoPlan.urlarchivo!=null and documentoPlan.urlarchivo!='')}">
                        <a class="btn btn-sm btn-rounded btn-info" data-toggle="tooltip" data-placement="top" title="Ver Plan de Acción" href="<c:url value='/verPlanAccion?id=${documentoPlan.iddocumento}'/>"><i class="fas fa-eye"></i></a>
                        </c:if>

                    <c:if test="${lider == '1'}">
                        <c:if test="${documentoPlan.urlarchivo!=null and documentoPlan.urlarchivo!=''}">
                            <a class="btn btn-sm btn-rounded btn-info" data-toggle="tooltip" data-placement="top" title="Ver Plan de Acción" href="<c:url value='/verPlanAccion?id=${documentoPlan.iddocumento}'/>"><i class="fas fa-eye"></i></a>
                            </c:if>
                        <a class="btn btn-sm btn-rounded btn-primary" onclick="adjuntarDocumento3('${idEmprendimiento}', '${documentoPlan.iddocumento}')" data-toggle="tooltip" data-placement="top" title="Adjuntar Plan de Acción"><i class="fas fa-plus-circle"></i></a>
                    <!--<button type="button" class="btn btn-primary" onclick="actualizarDocumentoComite(${documentoPlan.iddocumento})">Actualizar documento comité</button>-->
                    <!--<button type="button" class="btn btn-danger" onclick="eliminarDocumentoComite(${documentoPlan.iddocumento})">Eliminar documento comité</button>-->
                        <!--<button class="btn btn-sm btn-rounded btn-danger" onclick="eliminarDocumentoComite(${documentoPlan.iddocumento})" data-toggle="tooltip" data-placement="top" title="Eliminar Documento Comité" id="btnEliminar"><i class="fas fa-times-circle"></i></button>-->
                    <!--<button type="submit" class="btn btn-sm btn-rounded btn-danger" data-toggle="tooltip" data-placement="top" title="Eliminar Documento Comité" id="btnEliminar" data-idDocumento="${documentoPlan.iddocumento}"><i class="fas fa-times-circle"></i></button>-->   
                    </c:if>
                </td>
            </tr>
            <%--  </c:forEach> --%>
        </tbody>
    </table>

    <%-- <c:if test="${lider == '1'}">
         <button type="button" class="btn-success"  onclick="adjuntarDocumento2(${idEmprendimiento})"><i class="fas fa-plus-circle"></i>Adjuntar Plan Acción</button>
     </c:if> --%>

    <div class="form-row">
        <div class="form-group col-sm-12" style="text-align: center">
            <a href="${pageContext.request.contextPath}/" class="btn btn-danger" role="button">Cancelar</a>
        </div>
    </div>
</div>

</div>
<div class="modal fade" id="modalAdjuntarDocumento" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Adjuntar Documento Tema</h4>
                    <button class="close" type="button" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
            </div>
            <div class="modal-body">
                <div id="divDatosDocumento">
                    <div class="form-group row">
                        <div class="col-sm-12">
                            <h4>Datos del documento </h4>
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
                    <button class="btn btn-warning" type="button" data-dismiss="modal">Cancelar</button>
                    <a class="btn btn-primary" id="btnGuardarDocumento">Guardar documento</a>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modalAdjuntarDocumento3" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Adjuntar Plan de Acción</h4>
                    <button class="close" type="button" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
            </div>
            <div class="modal-body">
                <div id="divDatosDocumento">
                    <div class="form-group row">
                        <div class="col-sm-12">
                            <h4>Datos del documento </h4>
                            <input type="hidden" id="emprendimientoId" name="emprendimientoId" value="${emprendimiento.idemprendimiento}"/>
                            <input type="hidden" id="idBeneficiario" name="idBeneficiario" value="${idBeneficiario}"/>
                            <input type="hidden" id="idPlanAccion" name="idPlanAccion"/>
                            <input type="hidden" id="idestadoEmprendimiento" name="idestadoEmprendimiento" value="${emprendimiento.estadoemprendimiento.idestadoemprendimiento}"/>

                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="documentoTema" class="col-sm-3 col-form-label">Documento</label>
                        <div class="col-sm-9">
                            <input type="file" class="form-control" id="documentoPlan" accept="application/pdf" required="true" size="20"/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-danger" type="button" data-dismiss="modal">Cancelar</button>
                    <a class="btn btn-primary" id="btnGuardarDocumento3">Guardar documento</a>
                </div>
            </div>
        </div>
    </div>
</div>



<!--<div class="modal fade" id="modalAdjuntarDocumento2" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Adjuntar Plan de Accion</h4>
                <button class="close" type="button" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <h5>Si guarda el documento, este sobreescribira los documentos que haya cargado anteriormente,
                    Desea Guardar el documento?</h5>
                <div class="modal-footer">
                    <button class="btn btn-warning" type="button" data-dismiss="modal">Cancelar</button>
                    <a class="btn btn-primary" id="btnGuardarDocumento2">Guardar documento</a>
                </div>
            </div>
        </div>
    </div>
</div>-->
<script src="${pageContext.request.contextPath}/resources/js/services/adjuntarPlanAccion2.js" type="text/javascript"></script>