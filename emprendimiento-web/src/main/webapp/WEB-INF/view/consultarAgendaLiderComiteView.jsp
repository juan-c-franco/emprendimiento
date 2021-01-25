<%-- 
    Document   : consultarAgendaLiderComite
    Created on : 4/12/2018, 03:05:41 PM
    Author     : Juan Carlos Franco
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Agendar Sesión Comité Evaluación</h3>
<hr/>
<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-header">
                <i class="mdi mdi-view-headline"></i> Agendar Sesión Comité
            </div>

            <div class="card-body">
                <div id="calendar"></div>
            </div>

        </div>
    </div>
</div>

<div class="modal fade" id="modalProgramacion" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Programar Sesión Comité</h5>
                <button class="close" type="button" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-sm-6 col-md-5">
                        <div class="form-group row">
                            <label for="programDay" class="control-label col-md-4">Día <span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type="text" 
                                       class="form-control" 
                                       id="programDay" 
                                       name="programDay" 
                                       disabled data-validation-required-message="Ingrese Fecha" 
                                       required/>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-5 offset-md-1">
                        <div class="form-group row">
                            <label class="control-label col-md-4">Estado</label>
                            <p class="col-md-8">Disponible</p>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6 col-md-5">
                        <div class="form-group row">
                            <label for="ubicacionComite" class="control-label col-md-4">Ubicación <span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input 
                                    type="text" 
                                    class="form-control" 
                                    id="ubicacionComite" 
                                    name="ubicacionComite" 
                                    required
                                    data-validation-required-message="Ingrese Ubicación"
                                    maxlength="100"
                                    data-validation-maxlength-message="Máximo 100 carácteres"
                                    />
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-5 offset-md-1">
                        <div class="form-group row">
                            <label for="emprendimientosComite" class="control-label col-md-5">Emprendimientos a revisar</label>
                            <div class="col-md-7 controls">
                                <ol id="emprendimientosComite"></ol>
                            </div>
                        </div>
                    </div>                             
                </div>
                <div  class="row">
                    <div class='col-sm-6 col-md-5'>
                        <div class="form-group row">
                            <label for="horaInicio" class="col-md-4 col-form-label">Hora Inicio <span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type="text" class="form-control editHora" id="horaInicio" name="horaInicio" autocomplete="off" data-validation-required-message="Ingrese Hora" required/>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-5 offset-md-1">
                        <div class="form-group row">
                            <label for="horaFin" class="control-label col-md-4">Hora Fin <span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
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
                <h5 class="modal-title" id="exampleModalLabel">Editar Sesión Comité Evaluación</h5>
                <button class="close" type="button" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-sm-6 col-md-5">
                        <div class="form-group row">
                            <label for="editDay" class="control-label col-md-4">Día <span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type="text" class="form-control" id="editDay" disabled 
                                       data-validation-required-message="Ingrese Día de la Sesión" required/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6 col-md-5">
                        <div class="form-group row">
                            <label for="editUbicacionComite" class="control-label col-md-4">Ubicación <span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input 
                                    type="text" 
                                    class="form-control noCambios" 
                                    id="editUbicacionComite" 
                                    name="editUbicacionComite" 
                                    required
                                    data-validation-required-message="Ingrese Ubicación"
                                    maxlength="100"
                                    data-validation-maxlength-message="Máximo 100 carácteres"
                                    />
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-5 offset-md-1">
                        <div class="form-group row">
                            <label for="editEmprendimientosComite" class="control-label col-md-5">Emprendimientos a revisar</label>
                            <div class="col-md-7 controls">
                                <ol id="editEmprendimientosComite"></ol>
                            </div>
                        </div>
                    </div>                             
                </div>

                <div  class="row">
                    <div class='col-sm-6 col-md-5'>
                        <div class="form-group row">
                            <label for="editHoraInicio" class="col-md-4 col-form-label">Hora Inicio <span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type="text" class="form-control editHora noCambios" id="editHoraInicio" 
                                       autocomplete="off" data-validation-required-message="Ingrese Hora" required/>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-5 offset-md-1">
                        <div class="form-group row">
                            <label for="editHoraFinal" class="control-label col-md-4">Hora Fin <span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type="text" class="form-control editHora noCambios" id="editHoraFinal" 
                                       autocomplete="off" data-validation-required-message="Ingrese Hora" required/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <div>
                        <button type="button" class="btn waves-effect waves-light btn-primary noCambios m-l-10" onclick="eliminarSesion()">Cancelar Sesión</button>                        
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
<div class="modal fade" id="modalListaAsistencia" tabindex="-1" role="dialog"
     aria-labelledby="modalLabelLista" aria-hidden="true">
    <div class="modal-dialog modal-lg " role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalLabelLista">Lista de Emprendimientos</h5>
                <button class="close" type="button" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <ol id="emprendimientos"></ol>
            </div>
            <div class="modal-footer text-center">
                <button type="button" class="btn btn-danger" onclick="cerrarLista()">Atrás</button>                        
            </div>
        </div>

    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/_dist/js/services/evaluacion/consultarAgendaLiderComiteView.js" type="text/javascript"></script>
