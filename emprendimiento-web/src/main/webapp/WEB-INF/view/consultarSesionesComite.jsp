<%-- 
    Document   : consultarSesionesComite
    Created on : 9/12/2018, 10:51:38 AM
    Author     : Juan Carlos Franco
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Consultar Sesiónes Comité de Evaluación</h3>
<hr/>
<div class="row">
    <div class="col-12">
        <div class="card">
            <div id="msgContainer">
                <div id="mensajes" class="alert" style="display: none"> <i class="fa fa-check-circle"></i>
                    <span></span>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
                </div>
            </div>
            <div id="calendar"></div>
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
                    <!--                        <div class="col-sm-6 col-md-5 offset-md-1">
                                                <div class="form-group row">
                                                    <label class="control-label col-md-4">Estado</label>
                                                    <p class="col-md-8">Agendada</p>
                                                </div>
                                            </div>-->
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
                                    data-validation-required-message="Ingrese Ubicación" 
                                    required/>
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
                                       data-validation-required-message="Ingrese Hora" required/>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-6 col-md-5 offset-md-1">
                        <div class="form-group row">
                            <label for="editHoraFinal" class="control-label col-md-4">Hora Fin <span class="text-danger">*</span></label>
                            <div class="col-md-8 controls">
                                <input type="text" class="form-control editHora noCambios" id="editHoraFinal" 
                                       data-validation-required-message="Ingrese Hora" required/>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="center">
                        <!--<button type="button" class="btn waves-effect waves-light btn-primary" onclick="listaAsistentes()">Lista de Emprendimientos</button>-->
                        <!--                        <button type="button" class="btn waves-effect waves-light btn-primary liberar noCambios" onclick="liberarSesion()" disabled >Liberar Sesión</button>-->
                        <button type="button" class="btn waves-effect waves-light btn-primary liberar" onclick="eliminarSesion()">Cancelar Sesión</button>                        
                    </div>
                </div>
            </div>
            <div class="modal-footer text-center">
                <button type="button" class="btn waves-effect waves-light btn-danger" data-dismiss="modal" >Cerrar Ventana</button>                        
                <!--<button type="submit" id="btnActualizar" class="btn waves-effect waves-light btn-success noCambios">Guardar Cambios</button>-->
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/_dist/js/services/evaluacion/consultarSesionesComite.js" type="text/javascript"></script>
<script>
    <c:if test="${not empty idFuncionario}">
                            idfuncionario = ${idFuncionario};
    </c:if>
    <c:if test="${not empty idcajacompensacion }">
                            idcajacompensacion = ${idcajacompensacion };
    </c:if>
</script>