<%-- 
    Document   : agendarSesionValoracion
    Created on : nov 7, 2018, 10:59:04 a.m.
    Author     : Andrés Felipe González M Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Agendar Sesión Valoración</h3>
<hr/>
<div class="form-row">
    <div id='calendar'></div>
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
                                    class="form-control" 
                                    data-validation-required-message="Ingrese Descripción" 
                                    required
                                    disabled/>
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
                                    class="form-control" 
                                    id="editUbicacion" 
                                    name="editUbicacion" 
                                    data-validation-required-message="Ingrese Ubicación" 
                                    required
                                    disabled/>
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
                                       required
                                       disabled/>
                            </div>
                        </div>
                    </div>                             
                </div>

                <div class="row">
                    <div class="col-sm-6 col-md-5">
                        <div class="form-group row">
                            <label for="editHoraInicio" class="control-label col-md-3">Hora Inicio <span class="text-danger">*</span></label>
                            <div class="col-md-9 controls">
                                <input type="text" class="form-control editHora" id="editHoraInicio" name="editHoraInicio" data-validation-required-message="Ingrese Hora" required disabled/>
                            </div>
                        </div>
                    </div>

                    <div class="col-sm-6 col-md-5">
                        <div class="form-group row">
                            <label for="editHoraFinal" class="control-label col-md-3">Hora Fin <span class="text-danger">*</span></label>
                            <div class="col-md-9 controls">
                                <input type="text" class="form-control editHora" id="editHoraFinal" name="editHoraFinal" data-validation-required-message="Ingrese Hora" required disabled/>
                            </div>
                        </div>
                    </div>  
                    <div class="col-md-12 m-l-10">
                        <div class="form-group row">
                            <div class="center">
                                <button type="button" class="btn waves-effect waves-light btn-primary" onclick="listaAsistentes()">Lista Asistentes</button>
                                <button type="button" class="btn waves-effect waves-light btn-primary liberar" onclick="liberarSesion()" disabled >Liberar Sesión</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer text-center">
                    <button type="button" class="btn waves-effect waves-light btn-danger" data-dismiss="modal" >Cerrar Ventana</button>                        
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
<script src="${pageContext.request.contextPath}/resources/js/services/agendarSesionValoracion.js" type="text/javascript"></script>