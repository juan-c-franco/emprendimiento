<%-- 
    Document   : programarValoracion
    Created on : 14/11/2018, 02:01:06 PM
    Author     : Juan Carlos Franco
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<style>
.datepicker,
.table-condensed {
    width: 220px;
    font-size: x-small; 
}
</style>
<h3>Programar Capacitación</h3>
<hr/>
<div id='calendar'></div>
<div class="modal fade" id="modalProgramacion" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Programar Capacitación</h5>
                <button class="close" type="button" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="form-group row">
                    <div class="col-sm-12">
                        <h5>Datos de la Capacitación</h5>
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
                                       required tabindex="0" />
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-5 offset-md-1">
                        <div class="form-group row">
                            <label for="aula" class="control-label col-md-4">Ubicación <span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type='text'
                                       id='aula' 
                                       name="aula" 
                                       placeholder="Ubicación" 
                                       value=""
                                       class="form-control"
                                       maxlength="50" data-validation-maxlength-message="Máximo 50 caracteres" 
                                       data-validation-required-message="Campo Obligatorio" 
                                       required tabindex="0" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6 col-md-5">
                        <div class="form-group row">
                            <label for="startDay" class="control-label col-md-4">Día de Inicio<span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type="text" 
                                       class="form-control editDate" 
                                       id="startDay" 
                                       name="startDay" 
                                       data-validation-required-message="Campo Obligatorio" 
                                       required tabindex="0" />
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-5 offset-md-1">
                        <div class="form-group row">
                            <label for="endDay" class="control-label col-md-4">Día de Fin<span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type="text" 
                                       class="form-control editDate" 
                                       id="endDay" 
                                       name="endDay" 
                                       data-validation-required-message="Campo Obligatorio" 
                                       required tabindex="0" />
                            </div>
                        </div>
                    </div>                             
                </div>

                <div class="row">
                    <div class="col-sm-6 col-md-5">
                        <div class="form-group row">
                            <label for="horaInicio" class="control-label col-md-4">Hora Inicio<span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type="text" class="form-control editHora" 
                                       id="horaInicio" name="horaInicio" 
                                       autocomplete="off" 
                                       data-validation-required-message="Ingrese Hora" 
                                       required tabindex="0" />
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-5 offset-md-1">
                        <div class="form-group row">
                            <label for="horaFin" class="control-label col-md-4">Hora Fin<span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type="text" class="form-control editHora" 
                                       id="horaFin" name="horaFin" autocomplete="off" 
                                       data-validation-required-message="Ingrese Hora" 
                                       required tabindex="0" />
                            </div>
                        </div>
                    </div>                
                </div>                           

                <div class="modal-footer text-center">
                    <button class="btn btn-danger" type="button" data-dismiss="modal">Cerrar</button>
                    <button id="programar" type="submit" class="btn btn-success">Programar</button>
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
                <h5 class="modal-title" id="exampleModalLabel">Editar programación</h5>
                <button class="close" type="button" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="rangoTiempo modal-body">
                <div class="form-group row">
                    <div class="col-sm-12">
                        <h5>Datos de la Programación</h5>
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
                                       required tabindex="0" />
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-5 offset-md-1">
                        <div class="form-group row">
                            <label for="editAula" class="control-label col-md-4">Ubicación <span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type='text'
                                       id='editAula' 
                                       name="editAula" 
                                       placeholder="Ubicación" 
                                       value=""
                                       class="form-control noCambios" 
                                       maxlength="50" data-validation-maxlength-message="Máximo 50 caracteres" 
                                       data-validation-required-message="Campo Obligatorio" 
                                       required tabindex="0" />
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-6 col-md-5">
                        <div class="form-group row">
                            <label for="editStartDay" class="control-label col-md-4">Día de Inicio<span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type="text" 
                                       class="form-control editDate noCambios" 
                                       id="editStartDay" 
                                       name="editStartDay" 
                                       data-validation-required-message="Campo Obligatorio" 
                                       required tabindex="0" />
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-5 offset-md-1">
                        <div class="form-group row">
                            <label for="editEndDay" class="control-label col-md-4">Día de Fin<span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type="text" 
                                       class="form-control editDate noCambios" 
                                       id="editEndDay" 
                                       name="editEndDay" 
                                       data-validation-required-message="Campo Obligatorio" 
                                       required tabindex="0" />
                            </div>
                        </div>
                    </div>                             
                </div>

                <div class="row">
                    <div class="col-sm-6 col-md-5">
                        <div class="form-group row">
                            <label for="editHoraInicio" class="control-label col-md-4">Hora Inicio <span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type="text" class="form-control editHora noCambios" 
                                       id="editHoraInicio" name="editHoraInicio" 
                                       data-validation-required-message="Ingrese Hora" 
                                       required tabindex="0" />
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-5 offset-md-1">
                        <div class="form-group row">
                            <label for="editHoraFinal" class="control-label col-md-4">Hora Fin<span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type="text" class="form-control editHora noCambios" 
                                       id="editHoraFinal" name="editHoraFinal" 
                                       data-validation-required-message="Ingrese Hora" 
                                       required tabindex="0" />
                            </div>
                        </div>
                    </div>  
                    <div class="col-md-12 m-l-10">
                        <div class="form-group row">
                            <div class="center">
                                <button type="button" class="btn waves-effect waves-light btn-primary" onclick="listaAsistentes()">Lista Asistentes</button>
                                <button type="button" class="btn waves-effect waves-light btn-primary noCambios" onclick="eliminarSesion()">Cancelar Programación</button>
                                <!--<button type="button" class="btn waves-effect waves-light btn-primary registrarAsistencia" onclick="registrarAsistencia()">Registrar Asistencia</button>-->
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
<script src="${pageContext.request.contextPath}/resources/_dist/js/services/capacitacion/programarCapacitacion.js" type="text/javascript"></script>
<script>
    <c:if test="${not empty idFuncionario}">
                        idfuncionario = ${idFuncionario};
    </c:if>
</script>