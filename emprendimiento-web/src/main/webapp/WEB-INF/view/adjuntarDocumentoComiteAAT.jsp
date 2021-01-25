<%-- 
    Document   : adjuntarDocumentoComiteAAT
    Created on : 30/11/2018, 12:32:15 AM
    Author     : Danny Fernando Guerrero Gelpud
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<h3>Adjuntar Plan de Negocios</h3>

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
        <div class="form-group col-sm-12" id="escogerEmprendimiento">
            <div class="controls">
                <select required="required"  class="selectpicker m-b-20 m-r-10" data-style="btn-info" name="emprendimientoId" id="emprendimientoId" data-validation-required-message="Escoja un Emprendimiento"> 
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
            <input type="hidden" id="idemprendimiento" value="${emprendimiento.idemprendimiento}"/>
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

            <div class="form-group row m-t-40">
                <div class="col-sm-12">
                    <h4>Lista de Temas Acompañamiento y Asistencia Técnica</h4>
                    <hr>

                    <table id="tableData" class="table table-bordered table-striped">
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
                                        <c:if test="${temaRutaAAT.urldocumentotema!=null and temaRutaAAT.urldocumentotema!=''}">
                                            <a class="btn btn-sm btn-rounded btn-info" data-toggle="tooltip" data-placement="top" title="Ver Documento" href="<c:url value='/verDocumentoTemaRutaAAT?id=${temaRutaAAT.idtemarutaacompanamientoat}'/>"><i class="fas fa-eye"></i></a>
                                            </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <!--<br>-->
            <div class="form-group row m-t-40">
                <div class="col-sm-12">
                    <h4>Lista de Planes de Negocio</h4>
                    <hr>


                    <table id="tableData2" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th class="noOverflow">Tipo documento</th>
                                <th class="noOverflow">Documento</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="documentoComite" items="${documentosComite}">
                                <tr>
                                    <td>${documentoComite.tipodocumentos.nombretipodocumento}</td>
                                    <td>${documentoComite.urlarchivo}</td>
                                    <td align="center">
                                        <c:if test="${soloConsulta and documentoComite.urlarchivo!=null and documentoComite.urlarchivo!=''}">
                                            <a class="btn btn-sm btn-rounded btn-info" data-toggle="tooltip" data-placement="top" title="Ver Plan de Negocios" href="<c:url value='/verDocumentoComiteAAT?id=${documentoComite.iddocumento}'/>"><i class="fas fa-eye"></i></a>
                                            </c:if>

                                        <c:if test="${!soloConsulta and documentoComite.urlarchivo!=null and documentoComite.urlarchivo!=''}">
                                            <a class="btn btn-sm btn-rounded btn-info" data-toggle="tooltip" data-placement="top" title="Ver Plan de Negocios" href="<c:url value='/verDocumentoComiteAAT?id=${documentoComite.iddocumento}'/>"><i class="fas fa-eye"></i></a>
                                            <a class="btn btn-sm btn-rounded btn-primary" onclick="actualizarDocumentoComite(${documentoComite.iddocumento})" data-toggle="tooltip" data-placement="top" title="Actualizar Plan de Negocios"><i class="fas fa-plus-circle"></i></a>
                                            <button class="btn btn-sm btn-rounded btn-danger" data-iddocumento="${documentoComite.iddocumento}"  data-toggle="tooltip" data-placement="top" title="Eliminar Plan de Negocios" id="btnEliminar"><i class="fas fa-times-circle"></i></button>
                                            </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <br>
            <div class="form-row text-center" style="alignment-adjust: central">

                <div class="form-group col-sm-6 text-center" style="text-align: center">
                    <a href="${pageContext.request.contextPath}/" class="btn btn-danger" role="button">Atrás</a>
                </div>
                <c:if test="${!soloConsulta}">
                    <div class="form-group col-sm-6 text-center" style="text-align: center">
                        <button type="button" class="btn btn-success" onclick="agregarDocumento()"><i class="fas fa-plus-circle"></i> Agregar documento</button>
                    </div>
                </c:if>
            </div>
        </div>
    </c:if>
</div>
<div class="modal fade" id="modalAdjuntarDocumento" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Adjuntar Plan de Negocios</h5>
                <button class="close" type="button" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <div id="divDatosDocumento">
                    <div class="form-group row">
                        <div class="col-sm-12">
                            <h5>Datos del Plan de Negocios</h5>
                            <input type="hidden" id="idDocumentoComiteAAT" name="idDocumentoComiteAAT"/>
                        </div>
                    </div>
                    <div class="form-group row">
                        <label for="documento" class="col-sm-3 col-form-label">Plan de Negocios</label>
                        <div class="col-sm-9">
                            <input type="file" class="form-control" id="documento" accept="application/pdf" required="true" size="20"/>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <a class="btn btn-primary" id="btnGuardarDocumento">Guardar Plan de Negocios</a>
                    <button class="btn btn-danger" type="button" data-dismiss="modal" >Cancelar</button>
                </div>
            </div>
        </div>
    </div>
</div>
<c:if test="${status=='adm'}">
    <div class="text-center">
        <div class="text-center">
            <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
            <button type="button" id="btnSeleccionarEmprendimiento" class="btn btn-success">Seleccionar</button>
            <!--        <div class="form-group col-sm-6" style="text-align: right">
                        <button type="button" id="btnSeleccionarEmprendimiento" class="btn btn-primary">Seleccionar Emprendimiento</button>
                    </div>
                    <div class="form-group col-sm-6">
                        <a href="${pageContext.request.contextPath}/" class="btn btn-danger" role="button">Cancelar</a>
                    </div>-->
        </div>
    </c:if>
    <script src="${pageContext.request.contextPath}/resources/js/services/adjuntarDocumentoComiteAAT.js" type="text/javascript"></script>