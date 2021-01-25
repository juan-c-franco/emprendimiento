<%-- 
    Document   : consultarAvanceAAT
    Created on : 26/11/2018, 09:45:23 PM
    Author     : Danny Fernando Guerrero Gelpud
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<h3>Consultar Avances Asistencia Técnica</h3>
<hr/>
<!--<h5>${mensaje}</h5>-->
<c:if test="${not empty mensaje}">
    <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
    </div>
</c:if>
<input type="hidden" id="idCajaCompensacion" name="idCajaCompensacion" value="${idCajaCompensacion}" />
<input type="hidden" id="idAsistenteTecnico" name="idAsistenteTecnico" value="${idAsistenteTecnico}" />
<input type="hidden" id="numeroDocumentoTmp" name="numeroDocumentoTmp" value="${numeroDocumentoTmp}" />
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

    <c:if test="${not empty mensaje}">
        <div id="mensajes" class="alert" style="display: none"> <i class="fa fa-check-circle"></i>
            <span></span>
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">${mensaje}</span> </button>
        </div>
    </c:if>
    <c:if test="${empty status}">
        <div id="consultaAAT" class="row col-sm-12 col-md-12 form-group">
            <label for="numeroDocumento">N° Documento</label>
            <div class="controls">
                <input type="text" id="numeroDocumento" class="m-l-20 form-control" required
                       data-validation-required-message="Campo Obligatorio" 
                       maxlength="18" data-validation-maxlength-message="Máximo 18 carácteres"/>
            </div>
            <div class="m-l-20 col-sm-2">
                <button type="submit" class="btn btn-primary" id="consultarEmprendimiento"> <i class="mdi mdi-magnify"></i> Consultar</button>        
            </div>
        </div>
    </c:if>
    <c:if test="${status=='beneficiario'}">
        <div id="divDatosEmprendimiento">
            <!--            <div class="form-group row">
                            <div class="col-sm-12">-->
            <h4>Datos del Empredimiento</h4>
            <br>
            <!--                </div>
                        </div>-->
            <div class="form-group row" style='display: none'>
                <input type="hidden" id="idemprendimiento" value="${emprendimiento.idemprendimiento}"/>
            </div>
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
                <label for="porEmprendimiento" class="col-sm-9 col-form-label"><b>Porcentaje de Avance General del emprendimiento</b></label>
                <div class="col-sm-3">
                    <fmt:formatNumber type = "number" minFractionDigits = "0" maxFractionDigits="0" value = "${porcentajeRealTemasAAT}" />%
                </div>
            </div>

            <!--            <div class="form-group row">
                            <div class="col-sm-12">-->
            <h4>Avance Grupal</h4>
            <!--                </div>
                        </div>-->
            <hr>
            <br>
            <table class="table table-bordered table-hover" id="idTblTemasRutaAAT">
                <thead>
                    <tr>
                        <th>Nombre tema</th>
                        <th>Cantidad horas planeadas</th>
                        <th>Cantidad horas ejecutadas</th>
                        <th>% Avance</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="temaRutaAAT" items="${temasRutasAAT}">
                        <tr>
                            <td class="noOverflow">${temaRutaAAT.temasevaluacion.nombretema}</td>
                            <td>${temaRutaAAT.cantidadhorasplaneadas}</td>
                            <td><fmt:formatNumber type = "number" minFractionDigits = "0" maxFractionDigits="0" value = "${temaRutaAAT.cantidadHorasEjecutadas}" /></td>
                            <c:if test="${((temaRutaAAT.cantidadHorasEjecutadas*100)/temaRutaAAT.cantidadhorasplaneadas) >= 100}">
                                <td><fmt:formatNumber type = "number" minFractionDigits = "0" maxFractionDigits="0" value = "100" />%
                                    <input type ="hidden" value="100" id="avanceGrupal"/></td>

                            </c:if>
                            <c:if test="${((temaRutaAAT.cantidadHorasEjecutadas*100)/temaRutaAAT.cantidadhorasplaneadas) < 100}">
                                <td><fmt:formatNumber type = "number" minFractionDigits = "0" maxFractionDigits="0" value = "${(temaRutaAAT.cantidadHorasEjecutadas*100)/temaRutaAAT.cantidadhorasplaneadas}"  />%
                                    <input type="hidden" value="${(temaRutaAAT.cantidadHorasEjecutadas*100)/temaRutaAAT.cantidadhorasplaneadas}" id="avanceGrupal"/>
                                </td>
                            </c:if>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>

            <!--            <div class="form-group row">
                            <div class="col-sm-12">-->
            <h4>Avance Individual</h4>
            <!--                </div>
                        </div>-->
            <hr>
            <br>
            <c:forEach var="beneficiario" items="${beneficiarios}">
                <table class="table table-bordered table-hover">
                    <thead>
                        <tr>
                            <th>Nombres Beneficiario</th>
                            <th>Apellidos Beneficiario</th>
                            <th>% Avance Global</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td class="noOverflow">${beneficiario.nombres}</td>
                            <td class="noOverflow">${beneficiario.apellidos}</td>
                            <td>${beneficiario.porcentajeAprobacion}%</td>
                        </tr>
                        <c:if test="${beneficiario.temasRutaCapacitacionDTO.size()>0}">
                            <tr>
                                <td colspan="3">Temas ruta capacitación</td>
                            </tr>
                            <tr>
                                <th>Nombres tema</th>
                                <th>Cantidad horas planeadas</th>
                                <th>% Avance</th>
                            </tr>
                            <c:forEach var="temaRutaCapacitacion" items="${beneficiario.temasRutaCapacitacionDTO}">
                                <tr>
                                    <td>${temaRutaCapacitacion.nombretema}</td>
                                    <td>${temaRutaCapacitacion.cantidadhorasplaneadas}</td>
                                    <td><c:if test="${temaRutaCapacitacion.porcentajeAprobacion < 0}">
                                            N/A
                                        </c:if>
                                        <c:if test="${temaRutaCapacitacion.porcentajeAprobacion >= 0}">
                                            ${temaRutaCapacitacion.porcentajeAprobacion}%
                                        </c:if>
                                    </td>
                                </tr>
                            </c:forEach>
                        </c:if>
                    </tbody>
                </table>
            </c:forEach>
            <div class="form-row">
                <div class="col-sm-12" style="text-align: center">
                    <a href="${pageContext.request.contextPath}/" class="btn btn-danger" role="button">Atrás</a>
                    <c:if test="${permiteAprobar=='1'}">
                        <button class="btn btn-success" type="button" id="btnAprobarAvance" >Aprobar avance</button>
                    </c:if>
                </div>
            </div>
            <!--            <div class="form-row">
            <c:if test="${permiteAprobar=='1'}">
                <div class="col-sm-6" style="text-align: center">
                    <button class="btn btn-primary" type="button" id="btnAprobarAvance">Aprobar avance</button>
                </div>
            </c:if>
            <div class="col-sm-6" style="text-align: center">
                <a href="${pageContext.request.contextPath}/" class="btn btn-danger" role="button">Cancelar</a>
            </div>                    
        </div>-->
        </div>
    </c:if>
</div>
<!--<div class="form-row">
    <div class="form-group col-sm-6" style="text-align: right">
<c:if test="${status=='adm'}">
    <button type="button" id="btnSeleccionarCaja" class="btn btn-primary">Seleccionar Caja de Compensación</button>
</c:if>
<c:if test="${status=='caja'}">
    <button type="button" id="btnSeleccionarAsistente" class="btn btn-primary">Seleccionar asistente técnico</button>
</c:if>
</div>
<div class="form-group col-sm-6">
<c:if test="${status=='adm'||status=='caja'}">
    <a href="${pageContext.request.contextPath}/" class="btn btn-danger" role="button">Cancelar</a>
</c:if>
</div>
</div>-->
<script src="${pageContext.request.contextPath}/resources/js/services/consultarAvanceAAT.js" type="text/javascript"></script>
<script>
    <c:if test="${not empty idFuncionario}">
    idfuncionario = ${idFuncionario};
    </c:if>
    <c:if test="${not empty idCajacompensacion}">
    idcajacompensacion = ${idCajacompensacion};
    </c:if>
    docSet = false;
    <c:if test="${not empty docSet}">
    docSet = ${docSet};
    </c:if>
</script>