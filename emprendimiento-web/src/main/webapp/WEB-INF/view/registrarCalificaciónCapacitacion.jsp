<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div id="registrar">
    <h3>Registrar Calificación Capacitación </h3>
    <hr/>
    <div id="calendar"></div>


    <div class="modal fade" id="modalSesion" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
        <div class="modal-dialog modal-lg" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="modalLabel">Registrar Calificación Capacitación</h5>
                    <button class="close" type="button" data-dismiss="modal"
                            aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                    <div id="informacion" class="row form-group">
                        <h5>Información</h5>
                        <table class="table table-sm table-bordered table-striped">
                            <tbody>
                                <tr>
                                    <th class="label-th">Capacitación:</th>
                                    <td><p id="nombreCapacitacion"></p></td>
                                </tr>
                                <tr>
                                    <th class="label-th">Sede</th>
                                    <td><p id="nombreSede"></p></td>
                                </tr>
                                <tr>
                                    <th class="label-th">Dirección:</th>
                                    <td><p id="direccionSede"></p></td>
                                </tr>
                                <tr>
                                    <th class="label-th">Ubicación:</th>
                                    <td><p id="ubicacion"></p></td>
                                </tr>
                                <tr>
                                    <th class="label-th">Fecha Inicio:</th>
                                    <td><p id="fechaInicio"></p></td>
                                </tr>
                                <tr>
                                    <th class="label-th">Fecha Fin:</th>
                                    <td><p id="fechaFin"></p></td>
                                </tr>
                                <tr>
                                    <th class="label-th">Horario:</th>
                                    <td><p id="horario"></p></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>

                    <div id="tabs">
                        <ul>
                            <li><a id="linkIndividual" href="#individual">Individual</a></li>
                            <li><a id="linkMasivo" href="#masiva">Masiva</a></li>
                        </ul>
                        <div id="individual">
                            <p><strong>Instrucciones:</strong> Por favor tilde los alumnos que han aprobado. Los que no estén
                                tildados serán reprobados.</p>

                            <div id="divListaBeneficiario" class="form-group row table-responsive m-t-20">
                                <table id="listaBeneficiarios" class="table table-bordered table-striped tablaData">
                                </table>
                            </div>
                        </div>
                        <div id="masiva">
                            <p><strong>Instrucciones:</strong> Por favor seleccione un archivo siguiendo el siguiente formato:<br>
                                tipo_documento|$|numero_documento|$|calificacion(1 ó 0 para Aprobado o Reprobado respectivamente)
                            </p>
                            <div class="upload">

                                <div class="form-group row">
                                    <div class="col-sm-9 controls">
                                        <label for="documento" class="col-sm-6 col-form-label">Adjuntar Documento<span class="text-danger">*</span></label>
                                        <input type="file" class="form-control" id="documento" accept="text/plain" required="true" data-validation-required-message='Campo Obligatorio' size="20"/>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer text-center">
                    <button class="btn btn-danger" type="button" data-dismiss="modal">Cerrar</button>
                    <button id="btnCalificar" type="submit" class="btn btn-success">Calificar</button>
                </div>
            </div>
        </div>
    </div>
</div>
<div id="resultados" style="display: none">
    <h3>Resultado Aprobación</h3>
    <hr/>
    <table id="tableData" class="table table-bordered table-striped">
        <thead>
            <tr>
                <th >Tipo Doc.</th>
                <th >Documento</th>
                <th >Nombres</th>
                <th >Apellidos</th>
                <th >% Asistencia</th>
                <th >Calificación Funcionario</th>
                <th >Calificación Final</th>
            </tr>
        </thead>
        <tbody>
        </tbody>
    </table>
    <div class="text-center">
        <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
    </div>
</div>
<div id="msgContainer">
    <div id="mensajes" class="alert" style="display: none"> <i class="fa fa-check-circle"></i>
        <span></span>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/_dist/js/services/capacitacion/registrarCalificaciónCapacitacion.js" type="text/javascript" charset="UTF-8"></script>

<script>
    <c:if test="${not empty idFuncionario}">
    idfuncionario = ${idFuncionario};
    </c:if>
</script>