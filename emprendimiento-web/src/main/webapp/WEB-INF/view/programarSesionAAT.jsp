<%-- 
    Document   : programarSesionAAT
    Created on : 5/11/2018, 10:28:13 AM
    Author     : Danny Fernando Guerrero Gelpud
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h3>Programar Sesión Asistencia Técnica</h3>
<hr/>
<h5>${mensaje}</h5>
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
    <div class="modal fade" id="modalProgramacion" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Programar Sesión de Acompañamiento Asistencia Técnica</h5>
                    <button class="close" type="button" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div id="divDatosProgramacion">
                        <div class="form-group row">
                            <div class="col-sm-12">
                                <h5>Datos de la Sesión</h5>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-11">
                                <div class="form-group row">
                                    <label for="ubicacionSesion" class="control-label col-md-3">Ubicación <span class="text-danger">*</span></label>
                                    <div class="col-sm-9 controls">
                                        <input 
                                            type="text" 
                                            class="form-control" 
                                            id="ubicacionSesion" 
                                            name="ubicacionSesion" 
                                            required
                                            data-validation-required-message="Ingrese Ubicación"
                                            maxlength="100"
                                            data-validation-maxlength-message="Máximo 100 carácteres"
                                            tabindex="0" />
                                    </div>
                                </div>
                            </div>                
                        </div>

                        <div class="row">
                            <div class="col-sm-6 col-md-5">
                                <div class="form-group row">
                                    <label for="fechaSesion" class="control-label col-md-3">Día <span class="text-danger">*</span></label>
                                    <div class="col-md-9 controls">
                                        <input type="text" 
                                               class="form-control" 
                                               id="fechaSesion" 
                                               name="fechaSesion" 
                                               disabled data-validation-required-message="Ingrese Día de la Sesión" 
                                               required/>
                                    </div>
                                </div>
                            </div>                             
                        </div>

                        <div class="row">
                            <div class="col-sm-6 col-md-5">
                                <div class="form-group row">
                                    <label for="horaInicio" class="control-label col-md-3">Hora Inicio <span class="text-danger">*</span></label>
                                    <div class="col-md-9 controls">
                                        <input type="text" class="form-control editHora" 
                                               id="horaInicio" name="horaInicio" 
                                               autocomplete="off" data-validation-required-message="Ingrese Hora" 
                                               required tabindex="0"/>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6 col-md-5 offset-md-1">
                                <div class="form-group row">
                                    <label for="horaFin" class="control-label col-md-3">Hora Fin<span class="text-danger">*</span></label>
                                    <div class="col-md-9 controls">
                                        <input type="text" class="form-control editHora" 
                                               id="horaFin" name="horaFin" autocomplete="off" 
                                               data-validation-required-message="Ingrese Hora" 
                                               required tabindex="0"/>
                                    </div>
                                </div>
                            </div>                
                        </div>
                    </div>
                    <div class="modal-footer text-center">
                        <button class="btn btn-danger" type="button" data-dismiss="modal">Cerrar</button>
                        <button id="programarSesionAAT" type="submit" class="btn btn-success">Programar Sesión</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="modal fade" id="modalEditar" tabindex="-1" role="dialog"
         aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Editar Sesión de Acompañamiento Asistencia Técnica</h5>
                    <button class="close" type="button" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="rangoTiempo modal-body">
                    <div id="divDatosProgramacion">
                        <div class="form-group row">
                            <div class="col-sm-12">
                                <h5>Datos de la Sesión</h5>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-md-11">
                                <div class="form-group row">
                                    <label for="editUbicacionSesion" class="control-label col-md-3">Ubicación <span class="text-danger">*</span></label>
                                    <div class="col-sm-9 controls">
                                        <input 
                                            type="text" 
                                            class="form-control noCambios" 
                                            id="editUbicacionSesion" 
                                            name="editUbicacionSesion" 
                                            required
                                            data-validation-required-message="Ingrese Ubicación"
                                            maxlength="100"
                                            data-validation-maxlength-message="Máximo 100 carácteres"
                                            />
                                    </div>
                                </div>
                            </div>                
                        </div>

                        <div class="row">
                            <div class="col-sm-6 col-md-5">
                                <div class="form-group row">
                                    <label for="editDay" class="control-label col-md-3">Día <span class="text-danger">*</span></label>
                                    <div class="col-md-9 controls">
                                        <input type="text" 
                                               class="form-control" 
                                               id="editDay" 
                                               name="editDay" 
                                               disabled data-validation-required-message="Ingrese Día de la Sesión" 
                                               required/>
                                    </div>
                                </div>
                            </div>                             
                        </div>

                        <div class="row">
                            <div class="col-sm-6 col-md-5">
                                <div class="form-group row">
                                    <label for="editHoraInicio" class="control-label col-md-3">Hora Inicio <span class="text-danger">*</span></label>
                                    <div class="col-md-9 controls">
                                        <input type="text" class="form-control editHora noCambios" id="editHoraInicio" name="editHoraInicio" autocomplete="off" data-validation-required-message="Ingrese Hora" required/>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6 col-md-5">
                                <div class="form-group row">
                                    <label for="editHoraFinal" class="control-label col-md-3">Hora Fin<span class="text-danger">*</span></label>
                                    <div class="col-md-9 controls">
                                        <input type="text" class="form-control editHora noCambios" id="editHoraFinal" name="editHoraFinal" autocomplete="off" data-validation-required-message="Ingrese Hora" required/>
                                    </div>
                                </div>
                            </div>  
                        </div>
                        <div class="form-group row m-l-5">
                            <div class="center">
                                <button type="button" class="btn waves-effect waves-light btn-primary" onclick="listaAsistentes()">Lista Asistentes</button>
                                <button type="button" class="btn waves-effect waves-light btn-primary liberar noCambios" onclick="liberarSesion()" disabled >Liberar Sesión</button>
                                <button type="button" id="btnCancelarSesion" class="btn waves-effect waves-light btn-primary noCambios">Cancelar Sesión</button>
                            </div>
                        </div>

                    </div>
                    <div class="modal-footer text-center">
                        <button type="button" class="btn waves-effect waves-light btn-danger" data-dismiss="modal" >Cerrar Ventana</button>                        
                        <button type="button" class="btn waves-effect waves-light btn-success noCambios" id="btnActualizar" >Guardar Cambios</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="modalListaAsistencia" tabindex="-1" role="dialog" aria-labelledby="modalLabelLista" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Lista de Asistentes</h5>
                <button class="close" type="button" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="form-group col-md-6">
                    <label for="nEmprendimiento">Nombre del Emprendimiento</label>
                    <p id="nEmprendimiento"></p>
                </div>
                <div class="table-responsive m-t-20">
                    <table class="table table-striped tablaData" id="listaBeneficiarios">
                    </table>
                </div>
                <div class="modal-footer text-center">
                    <button type="button" class="btn btn-danger" onclick="cerrarLista()">Atrás</button>                        
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

<script src="${pageContext.request.contextPath}/resources/js/services/programarSesionAAT.js" type="text/javascript"></script>
<script>
    <c:if test="${not empty idFuncionario}">
                        idfuncionario = ${idFuncionario};
    </c:if>
    <c:if test="${not empty idCajacompensacion}">
                        idcajacompensacion = ${idCajacompensacion};
    </c:if>
</script>