<%-- 
    Document   : programarValoracion
    Created on : 14/11/2018, 02:01:06 PM
    Author     : Juan Carlos Franco
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Programar Sesión Valoración</h3>
<hr/>
<div id='calendar'></div>
<div class="modal fade" id="modalProgramacion" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Programar Sesión</h5>
                <button class="close" type="button" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="form-group row">
                    <div class="col-sm-12">
                        <h5>Datos de la Sesión</h5>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-11">
                        <div class="form-group row">
                            <label for="descripValoracion" class="control-label col-md-3">Descripción <span class="text-danger">*</span></label>
                            <div class="col-sm-9 controls">
                                <input 
                                    type="text" 
                                    id="descripValoracion" 
                                    name="descripValoracion" 
                                    class="form-control" 
                                    required
                                    data-validation-required-message="Ingrese Descripción"
                                    maxlength="100"
                                    data-validation-maxlength-message="Máximo 100 carácteres"
                                    tabindex="0"/>
                            </div>
                        </div>
                    </div>                
                </div>

                <div class="row">
                    <div class="col-md-11">
                        <div class="form-group row">
                            <label for="ubicacionValoracion" class="control-label col-md-3">Ubicación <span class="text-danger">*</span></label>
                            <div class="col-sm-9 controls">
                                <input 
                                    type="text" 
                                    class="form-control" 
                                    id="ubicacionValoracion" 
                                    name="ubicacionValoracion" 
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
                            <label for="programDay" class="control-label col-md-3">Día <span class="text-danger">*</span></label>
                            <div class="col-md-9 controls">
                                <input type="text" 
                                       class="form-control" 
                                       id="programDay" 
                                       name="programDay" 
                                       disabled data-validation-required-message="Ingrese Día de la Sesión" 
                                       required/>
                            </div>
                        </div>
                    </div>                             
                </div>

                <div class="row">
                    <div class="col-sm-6 col-md-5">
                        <div class="form-group row">
                            <label for="horaInicio" class="control-label col-md-3">Hora Inicio<span class="text-danger">*</span></label>
                            <div class="col-md-9 controls">
                                <input type="text" class="form-control editHora" id="horaInicio" name="horaInicio" autocomplete="off" data-validation-required-message="Ingrese Hora" required/>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-5 offset-md-1">
                        <div class="form-group row">
                            <label for="horaFin" class="control-label col-md-3">Hora Fin<span class="text-danger">*</span></label>
                            <div class="col-md-9 controls">
                                <input type="text" class="form-control editHora" id="horaFin" name="horaFin" autocomplete="off" data-validation-required-message="Ingrese Hora" required/>
                            </div>
                        </div>
                    </div>                
                </div>                           

                <div class="modal-footer text-center">
                    <button class="btn btn-danger" type="button" data-dismiss="modal">Cerrar</button>
                    <button id="programar" type="submit" class="btn btn-success">Programar Sesión</button>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="modalOpciones" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Editar sesión de Valoración</h5>
                <button class="close" type="button" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="rangoTiempo modal-body">
                <div class="form-group row">
                    <div class="col-sm-12">
                        <h5>Datos de la Sesión</h5>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-11">
                        <div class="form-group row">
                            <label for="editDescripcion" class="control-label col-md-3">Descripción <span class="text-danger">*</span></label>
                            <div class="col-sm-9 controls">
                                <input 
                                    type="text" 
                                    id="editDescripcion" 
                                    name="editDescripcion" 
                                    class="form-control noCambios" 
                                    required
                                    data-validation-required-message="Ingrese Descripción"
                                    maxlength="100"
                                    data-validation-maxlength-message="Máximo 100 carácteres"
                                    />
                            </div>
                        </div>
                    </div>                
                </div>

                <div class="row">
                    <div class="col-md-11">
                        <div class="form-group row">
                            <label for="editUbicacion" class="control-label col-md-3">Ubicación <span class="text-danger">*</span></label>
                            <div class="col-sm-9 controls">
                                <input 
                                    type="text" 
                                    class="form-control noCambios" 
                                    id="editUbicacion" 
                                    name="editUbicacion" 
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
                                <input type="text" class="form-control editHora noCambios" id="editHoraInicio" name="editHoraInicio" data-validation-required-message="Ingrese Hora" required/>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-5">
                        <div class="form-group row">
                            <label for="editHoraFinal" class="control-label col-md-3">Hora Fin<span class="text-danger">*</span></label>
                            <div class="col-md-9 controls">
                                <input type="text" class="form-control editHora noCambios" id="editHoraFinal" name="editHoraFinal" data-validation-required-message="Ingrese Hora" required/>
                            </div>
                        </div>
                    </div>  
                    <div class="col-md-12 m-l-10">
                        <div class="form-group row">
                            <div class="center">
                                <button type="button" class="btn waves-effect waves-light btn-primary" onclick="listaAsistentes()">Lista Asistentes</button>
                                <button type="button" class="btn waves-effect waves-light btn-primary liberar noCambios" onclick="liberarSesion()" disabled >Liberar Sesión</button>
                                <button type="button" class="btn waves-effect waves-light btn-primary noCambios" onclick="eliminarSesion()">Cancelar Sesión</button>
                                <button type="button" class="btn waves-effect waves-light btn-primary registrarAsistencia" onclick="registrarAsistencia()">Registrar Asistencia</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer text-center">
                    <button type="button" class="btn waves-effect waves-light btn-danger" data-dismiss="modal" >Cerrar Ventana</button>                        
                    <button type="submit" id="btnActualizar" class="btn waves-effect waves-light btn-success noCambios">Guardar Cambios</button>
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
                <div class="row">
                    <div class="col-md-12">
                        <div class="table-responsive m-t-20">
                            <table id="listaBeneficiarios" class="table table-bordered table-striped tablaData">
                            </table>
                        </div>
                    </div>
                </div>
                <div class="modal-footer text-center">
                    <button type="button" class="btn btn-danger" onclick="cerrarLista()">Atrás</button>                        
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/services/programarValoracion.js" type="text/javascript"></script>
<script>
    <c:if test="${not empty idFuncionario}">
                        idfuncionario = ${idFuncionario};
    </c:if>
</script>
