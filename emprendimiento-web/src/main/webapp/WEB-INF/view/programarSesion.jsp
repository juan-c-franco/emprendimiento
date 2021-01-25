<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<h3>Programar Sesión Sensibilización</h3>
<hr/>
<div id="calendar"></div>

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
                            <label for="descripSensibilizacion" class="control-label col-md-3">Descripción <span class="text-danger">*</span></label>
                            <div class="col-sm-9 controls">
                                <input 
                                    type="text" 
                                    id="descripSensibilizacion" 
                                    name="descripSensibilizacion" 
                                    class="form-control"
                                    required
                                    data-validation-required-message="Ingrese Descripción"
                                    maxlength="100"
                                    data-validation-maxlength-message="Máximo 100 carácteres"
                                    min="0"
                                    data-validation-min-message="Mínimo 0 asistentes"
                                    />
                            </div>
                        </div>
                    </div>                
                </div>

                <div class="row">
                    <div class="col-md-11">
                        <div class="form-group row">
                            <label for="ubicacionSensibilizacion" class="control-label col-md-3">Ubicación <span class="text-danger">*</span></label>
                            <div class="col-sm-9 controls">
                                <input 
                                    type="text" 
                                    class="form-control" 
                                    id="ubicacionSensibilizacion" 
                                    name="ubicacionSensibilizacion" 
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
                            <label for="maximoAsistentes" class="control-label col-md-4">Máximo Asistentes <span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type='NumericTextBox'
                                       id='maximoAsistentes' 
                                       name="maximoAsistentes" 
                                       placeholder="Maximo de Asistentes" 
                                       value=""
                                       class="form-control only-number maxAsistentesProgramarSensibilizacion" 
                                       min="1" data-validation-min-message="El mínimo de asistentes es 1." 
                                       maxlength="3" data-validation-maxlength-message="El máximo de asistentes es 999." 
                                       data-validation-required-message="Ingrese Máximo Asistentes" 
                                       required />
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-5 offset-md-1">
                        <div class="form-group row">
                            <label for="programDay" class="control-label col-md-4">Día <span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
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
                            <label for="horaInicio" class="control-label col-md-4">Hora Inicio <span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type="text" class="form-control editHora" id="horaInicio" name="horaInicio" data-validation-required-message="Ingrese Hora" autocomplete="off" required/>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-5 offset-md-1">
                        <div class="form-group row">
                            <label for="horaFin" class="control-label col-md-4">Hora Fin<span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type="text" class="form-control editHora" id="horaFin" name="horaFin" data-validation-required-message="Ingrese Hora" autocomplete="off" required/>
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

<div class="modal" id="modalOpciones" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Editar sesión de Sensibilización</h5>
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
                            <label for="editMaxAsistentes" class="control-label col-md-4">Máximo Asistentes <span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type='NumericTextBox'
                                       id='editMaxAsistentes' 
                                       name="editMaxAsistentes" 
                                       placeholder="Maximo de Asistentes" 
                                       value=""
                                       class="form-control only-number noCambios maxAsistentesProgramarSensibilizacion" 
                                       min="1" data-validation-min-message="El mínimo de asistentes es 1." 
                                       maxlength="3" data-validation-maxlength-message="El máximo de asistentes es 999." 
                                       data-validation-required-message="Ingrese Máximo Asistentes" 
                                       required />
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-5 offset-md-1">
                        <div class="form-group row">
                            <label for="editDay" class="control-label col-md-4">Día <span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
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
                            <label for="editHoraInicio" class="control-label col-md-4">Hora Inicio <span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type="text" class="form-control editHora noCambios" id="editHoraInicio" name="editHoraInicio" autocomplete="off" data-validation-required-message="Ingrese Hora" required/>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-5 offset-md-1">
                        <div class="form-group row">
                            <label for="editHoraFinal" class="control-label col-md-4">Hora Fin<span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type="text" class="form-control editHora noCambios" id="editHoraFinal" name="editHoraFinal" autocomplete="off" data-validation-required-message="Ingrese Hora" required/>
                            </div>
                        </div>
                    </div>                
                </div>                           
                <div class="form-group row">
                    <div class="center">
                        <button type="button" class="btn waves-effect waves-light btn-primary" onclick="listaAsistentes()">Lista Asistentes</button>
                        <button type="button" class="btn waves-effect waves-light btn-primary noCambios" onclick="eliminarSesion()">Cancelar Sesión</button>                        
                        <button type="button" class="btn waves-effect waves-light btn-primary registrarAsistencia" onclick="registrarAsistencia()">Registrar Asistencia</button>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-danger" type="button" data-dismiss="modal">Cerrar</button>
                    <button id="btnActualizar" type="submit" class="btn btn-success noCambios">Programar Sesión</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modalListaAsistencia" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editModalLabel">Lista de Asisitentes</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>                
            </div>

            <div class="modal-body">
                <div class="table-responsive m-t-20">
                    <table id="listaBeneficiarios" class="table table-bordered table-striped tablaData">
                    </table>
                </div>
                <div class="modal-footer text-center">
                    <button type="button" class="btn btn-danger" data-dismiss="modal" onclick="cerrarLista()">Atrás</button>                        
                </div>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/services/programasesion.js" type="text/javascript"></script>
<script>
    <c:if test="${not empty idFuncionario}">
                        idfuncionario = ${idFuncionario};
    </c:if>
</script>
