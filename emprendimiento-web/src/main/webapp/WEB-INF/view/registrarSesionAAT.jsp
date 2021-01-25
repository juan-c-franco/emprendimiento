<%-- 
    Document   : registrarSesionAAT
    Created on : 12/11/2018, 04:23:11 PM
    Author     : Danny Fernando Guerrero Gelpud
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>Registrar Asistencia</h3>

<hr />
<!--<h5>${mensaje}</h5>-->
<c:if test="${not empty mensaje}">
    <c:if test="${status=='1'}">
        <div class="alert alert-success"> <i class="fa fa-check-circle"></i> ${mensaje}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
    <c:if test="${status=='0'}">
        <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
</c:if>
<input type="hidden" id="idCajaCompensacion" name="idCajaCompensacion" value="${idCajaCompensacion}" />
<input type="hidden" id="idAsistenteTecnico" name="idAsistenteTecnico" value="${idAsistenteTecnico}" />
<div class="form-row" id='valora'>
    <%--c:if test="${status=='adm'}">
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
     </c:if> --%>
    <%--  <c:if test="${status=='asistente'}"> --%>
    <!--        <div id='calendar' style="max-width: 100%;max-height: 400px" ></div>-->
    <c:if test="${status!='admAsistencia'}">
        <div id='calendar'></div>
    </c:if>
    <%--    </c:if> --%>
    <c:if test="${status=='admAsistencia'}">
        <div id="divDatosAgendamiento">
            <div class="form-group row">
                <div class="col-sm-12">
                    <h5>Datos del Empredimiento</h5>
                </div>
            </div>
            <div class="form-group row">
                <input type="hidden" id="idemprendimiento" value="${sesionAATComplex.sesionacompanamientoatDTO.rutaacompanamientoat.emprendimiento.idemprendimiento}"/>
            </div>
            <div class="form-group row">
                <label for="nombreEmprendimiento" class="col-sm-3 col-form-label"><b>Nombre emprendimiento</b></label>
                <div class="col-sm-3">
                    <input type="text" readonly class="form-control-plaintext" id="nombreEmprendimiento" value="${sesionAATComplex.sesionacompanamientoatDTO.rutaacompanamientoat.emprendimiento.nombreemprendimiento}"/>
                </div>
                <label for="tipoEmprendimiento" class="col-sm-3 col-form-label"><b>Tipo emprendimiento</b></label>
                <div class="col-sm-3">
                    <input type="text" readonly class="form-control-plaintext" id="tipoEmprendimiento" value="${sesionAATComplex.sesionacompanamientoatDTO.rutaacompanamientoat.emprendimiento.tipoemprendimiento.nombretipoemprendimiento}"/>
                </div>
            </div>
            <div class="form-group row">
                <label for="estadoEmprendimiento" class="col-sm-3 col-form-label"><b>Estado emprendimiento</b></label>
                <div class="col-sm-3">
                    <input type="text" readonly class="form-control-plaintext" id="estadoEmprendimiento" value="${sesionAATComplex.sesionacompanamientoatDTO.rutaacompanamientoat.emprendimiento.estadoemprendimiento.nombreestadoemprendimiento}"/>
                </div>
                <label for="fechaRegistroEmprendimiento" class="col-sm-3 col-form-label"><b>Fecha de registro</b></label>
                <div class="col-sm-3">
                    <input type="text" readonly class="form-control-plaintext" id="fechaRegistroEmprendimiento" value="${sesionAATComplex.sesionacompanamientoatDTO.rutaacompanamientoat.emprendimiento.fecharegistro}"/>
                </div>
            </div>

            <div class="form-group row">
                <div class="col-sm-12">
                    <h5>Tema acompañamiento asistencia técnica</h5>
                    <hr>
                </div>
            </div>
            <div class="form-group row">
                <label for="nombreTema" class="col-sm-3 col-form-label"><b>Nombre tem</b></label>
                <div class="col-sm-3">
                    <input type="text" readonly class="form-control-plaintext" id="nombreTema" value="${sesionAATComplex.sesionacompanamientoatDTO.temasrutaacompanamientoat.temasevaluacion.nombretema}"/>
                </div>
                <label for="cantidadHP" class="col-sm-3 col-form-label"><b>Cantidad horas planeadas</b></label>
                <div class="col-sm-3">
                    <input type="text" readonly class="form-control-plaintext" id="cantidadHP" value="${sesionAATComplex.sesionacompanamientoatDTO.temasrutaacompanamientoat.cantidadhorasplaneadas}"/>
                </div>
            </div>
            <div class="form-group row">
                <label for="nombreTema" class="col-sm-3 col-form-label"><b>Descripción documento</b></label>
                <div class="col-sm-3">
                    <input type="text" readonly class="form-control-plaintext" id="nombreTema" value="${sesionAATComplex.sesionacompanamientoatDTO.temasrutaacompanamientoat.descripciondocumento}"/>
                </div>
                <c:if test="${sesionAATComplex.sesionacompanamientoatDTO.temasrutaacompanamientoat.urldocumentotema!=null and sesionAATComplex.sesionacompanamientoatDTO.temasrutaacompanamientoat.urldocumentotema!=''}">
                    <label for="verDocumento" class="col-sm-3 col-form-label">Ver documento</label>
                    <div class="col-sm-3">
                        <a id="verDocumento" class="btn btn-primary" href="<c:url value='/verDocumentoTemaRutaAAT?id=${sesionAATComplex.sesionacompanamientoatDTO.temasrutaacompanamientoat.idtemarutaacompanamientoat}'/>">Ver Documento</a>
                    </div>
                </c:if>
            </div>

            <div class="form-group row">
                <div class="col-sm-12">
                    <h5>Beneficiarios acompañamiento asistencia técnica</h5>
                    <hr>
                </div>
            </div>
            <table class="table table-bordered table-hover" id="idTblBeneficiarios">
                <thead>
                    <tr>
                        <th>Id Sesión</th>
                        <th>Nombres Beneficiario</th>
                        <th>Apellidos Beneficiario</th>
                        <th>Asistencia</th>
                        <th>Justificación Inasistencia</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="listaAAT" items="${sesionAATComplex.listaAATDTO}" varStatus="listaATTIndex">
                        <tr class="fila">
                            <td>
                                ${listaAAT.sesionacompanamientoat.idsesionacompanamientoat} 
                                <input type="hidden" id="beneficiarioId_${listaATTIndex.index}" value="${listaAAT.beneficiario.idbeneficiario}" />
                                <input type="hidden" id="listaAATId_${listaATTIndex.index}" value="${listaAAT.idasistacompanamientoat}" />
                            </td>
                            <td class="noOverflow">${listaAAT.beneficiario.primernombre} ${listaAAT.beneficiario.segundonombre}</td>
                            <td class="noOverflow">${listaAAT.beneficiario.primerapellido} ${listaAAT.beneficiario.segundoapellido}</td>
                            <td id="asistenciaRow${listaATTIndex.index}">
                                <a class="asistencia">
                                    <div class="form-group row">
                                        <div class="custom-control custom-radio custom-control-inline">
                                            <div class="controls">
                                                <input type="radio" id="idRadioAsistenciaSi_${listaATTIndex.index}" name="radioAsistencia_${listaATTIndex.index}" onclick="showJusInasistencia(false, ${listaATTIndex.index})" class="custom-control-input" value="1" required="required" data-validation-required-message="Seleccione una opción" >
                                                <label class="custom-control-label" for="idRadioAsistenciaSi_${listaATTIndex.index}">Si</label>
                                            </div>
                                        </div>
                                        <div class="custom-control custom-radio custom-control-inline">

                                            <input type="radio" id="idRadioAsistenciaNo_${listaATTIndex.index}" name="radioAsistencia_${listaATTIndex.index}" onclick="showJusInasistencia(true, ${listaATTIndex.index})" class="custom-control-input" value="0" required="required" data-validation-required-message="Seleccione una opción">
                                            <label class="custom-control-label" for="idRadioAsistenciaNo_${listaATTIndex.index}">No</label>

                                        </div>
                                    </div>
                                </a>
                            </td>
                            <td id="justificacionRow${listaATTIndex.index}">
                                <div class="asistencia" id="idDivJustInasistencias_${listaATTIndex.index}" hidden="true">
                                    <div class="form-group row">
                                        <div class="custom-control custom-radio custom-control-inline">
                                            <div class="controls">
                                                <input type="radio" id="idJustInAsistenciaSi_${listaATTIndex.index}" name="radioJustInAsistencia_${listaATTIndex.index}" class="custom-control-input" value="1" required="required" data-validation-required-message="Seleccione una opción" >
                                                <label class="custom-control-label" for="idJustInAsistenciaSi_${listaATTIndex.index}">Si</label>
                                            </div>
                                        </div>
                                        <div class="custom-control custom-radio custom-control-inline">
                                            <input type="radio" id="idJustInAsistenciaNo_${listaATTIndex.index}" name="radioJustInAsistencia_${listaATTIndex.index}" class="custom-control-input" value="0" required="required" data-validation-required-message="Seleccione una opción" >
                                            <label class="custom-control-label" for="idJustInAsistenciaNo_${listaATTIndex.index}">No</label>
                                        </div>
                                    </div>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <div id="divObservaciones" class="form-group row">
                <label for="observacionesSesion" class="col-sm-3 col-form-label">Observaciones</label>
                <div class="col-sm-9">
                    <div class='controls'>
                        <input type="text" class="form-control" id="observacionesSesion" required="true" required data-validation-required-message='Ingrese las observaciones'/>
                    </div>
                </div>
            </div>
            <hr>
            <div class="form-group row text-center">
                <div class="col-sm-6">
                    <button type="button" id="btnCancelarRegistrarAsistencia" class="btn btn-danger">Cancelar</button>
                </div>
                <div class="col-sm-6">
                    <button type="button" id="btnRegistrarAsistencia" class="btn btn-success">Guardar sesión</button>
                </div>
            </div>
        </div>        
    </c:if>
</div>
<div class="form-row">
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
</div>

<script src="${pageContext.request.contextPath}/resources/js/services/registrarSesionAAT.js" type="text/javascript"></script>
<script>

    <c:if test="${not empty idFuncionario}">
                                                idfuncionario = ${idFuncionario};
    </c:if>
    <c:if test="${not empty idCajacompensacion}">
                                                idcajacompensacion = ${idCajacompensacion};
    </c:if>
</script>