<%-- 
    Document   : consultarEmprendimientosCalificacionDefinitiva
    Created on : 9/12/2018, 09:28:34 AM
    Author     : Juan Carlos Franco
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Consultar Emprendimientos para Calificación Definitiva</h3>
<hr/>
<!--<div class="row">-->

<div class="col-12">
    <div id="main" class="card">
        <div id="msgContainer">
            <div id="mensajes" class="alert" style="display: none"> <i class="fa fa-check-circle"></i>
                <span></span>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
            </div>
        </div>
        <h4>Lista de Emprendimientos Agendados</h4>
        <div class="card-body">
            <div class="table-responsive m-t-20">
                <table id="tableData" class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>Id.</th>
                            <th>Nombre</th>
                            <th>Tipo</th>
                            <th>Fecha Registro</th>
                            <th align='center'>¿Aprobado?</th>
                            <th align='center'>Acción</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
        </div>
        <div class="card-footer">
            <div class="form-group row controls">
                <div id="doc" class="col-sm-9">
                    <label for="documentoActa" class="col-sm-6 col-form-label">Adjuntar Acta Comité Evaluación <span class="text-danger">*</span></label>
                    <input type="file" class="form-control" id="documentoActa" accept="application/pdf" required="true" data-validation-required-message='Campo Obligatorio' size="20"/>
                </div>
            </div>
            <div class="text-center">
                <button id ="btnGuardarDocumento" class="btn btn-primary" type="submit" data-dismiss="modal"> <i class="fas fa-check-circle"></i> Enviar</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modalVerEmprendimiento" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editModalLabel">Vista Emprendimiento</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>                
            </div>

            <div class="modal-body">
                <h5>Datos del Emprendimiento</h5>
                <table class="table table-sm table-bordered table-striped">
                    <tbody>
                        <tr>
                            <th class="label-th">Nombre Emprendimiento:</th>
                            <td><p id="nombreEmprendimiento"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Tipo Emprendimiento:</th>
                            <td><p id="tEmprendimiento"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Beneficiarios Asociados:</th>
                            <td><ol id="asociados" class="ul-noPadding"></ol></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Formalizado:</th>
                            <td><p id="formalizado"></p></td>
                        </tr>   
                    </tbody>
                </table>

                <h5 class="m-t-40 formalizado" style="display: none;">Emprendimiento Formalizado</h5>
                <table class="table table-sm table-bordered table-striped formalizado" id="divFormalizado" style="display: none;">
                    <tbody>
                        <tr>
                            <th class="label-th">Nombre Empresa:</th>
                            <td><p id="nombreEmpresa"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">NIT:</th>
                            <td><p id="nit"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Número Registro Mercantil:</th>
                            <td><p id="nRegistroMercantil"></p></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Nombre Representante Legal:</th>
                            <td><p id="nombreRepresentante"></p></td>
                        </tr>   
                        <tr>
                            <th class="label-th">Dirección:</th>
                            <td><p id="dirección"></p></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Teléfono:</th>
                            <td><p id="telefono"></p></td>
                        </tr>    
                        <tr>
                            <th class="label-th">Municipio:</th>
                            <td><p id="municipio"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Correo electrónico:</th>
                            <td><p id="email"></p></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Sitio Web:</th>
                            <td><p id="web"></p></td>
                        </tr>    
                        <tr>
                            <th class="label-th">Países Comercializa:</th>
                            <td><ol id="paises" class="ul-noPadding"></ol></td>
                        </tr>
                        <tr>
                            <th class="label-th">Tipo Constitución Legal:</th>
                            <td><p id="constitucionF"></p></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Sector Productivo:</th>
                            <td><p id="sectorF"></p></td>
                        </tr>    
                        <tr>
                            <th class="label-th">Negocios Internet:</th>
                            <td><p id="negInternet"></p></td>
                        </tr>

                        <tr>
                            <th class="label-th">Productos y Servicios Ofrecidos:</th>
                            <td><ul id="prodServF" class="ul-noPadding"></ul></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Fecha Renovación de Matrícula:</th>
                            <td><p id="fechaRenov"></p></td>
                        </tr>    
                        <tr>
                            <th class="label-th">Fecha Inicio de Labores:</th>
                            <td><p id="fechaInicio"></p></td>
                        </tr>     

                        <tr>
                            <th class="label-th">Actividad Internacional:</th>
                            <td><p id="actividad"></p></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Empleados Directos:</th>
                            <td><p id="empDirectos"></p></td>
                        </tr>    
                        <tr>
                            <th class="label-th">Empleados Indirectos:</th>
                            <td><p id="empIndirectos"></p></td>
                        </tr>                                                                                                            
                    </tbody>
                </table>

                <h5 class="m-t-40 noEstablecido" style="display: none;">Emprendimiento No Formalizado</h5>
                <table class="table table-sm table-bordered table-striped noEstablecido" id='divNoEstablecido' style="display: none;">
                    <tbody>
                        <tr>
                            <th class="label-th">Tipo Constitución Legal:</th>
                            <td><p id="constitucionN"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Sector productivo:</th>
                            <td><p id="sectorN"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Productos y Servicios ofrecidos:</th>
                            <td><ul id="prodServN" class="ul-noPadding"></ul></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Cuando Inicia?:</th>
                            <td><p id="cuandoInicia"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Observaciones:</th>
                            <td><p id="observaciones"></p></td>
                        </tr>                           
                    </tbody>
                </table>

                <h5 class="m-t-40">Lista de temas acompañamiento y asistencia técnica</h5>
                <table class="table table-bordered table-hover" id="idTblTemasRutaAAT">
                    <thead>
                        <tr>
                            <th>Nombre tema</th>
                            <th>Cantidad horas planeadas</th>
                            <th>Cantidad horas ejecutadas</th>
                            <th>% Avance</th>
                            <th>Documento</th>
                        </tr>
                    </thead>
                    <tbody>



                    </tbody>
                </table>

                <h5 class="m-t-40">Datos Financieros</h5>
                <table class="table table-sm table-bordered table-striped" id="idTblFinancieros">
                    <tbody>
                        <tr>
                            <th class="label-th">Monto a Financiar</th>
                            <td><p id="montoFinanciacion"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Tipo de Financiacion</th>
                            <td><p id="tipoFinanciacion"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Cuotas a Solicitar</th>
                            <td><p id="cuotasFinanciar"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Tasa de Interés</th>
                            <td><p id="tasaFinanciar"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Recursos Propios</th>
                            <td><p id="propiosFinanciar"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Empleos por Generar</th>
                            <td><p id="empleosFinanciar"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Capital de Trabajo</th>
                            <td><p id="capitalFinanciar"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Meses para el Punto de Equilibrio</th>
                            <td><p id="equilibrioFinanciar"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Capital Total</th>
                            <td><p id="totalFinanciar"></p></td>
                        </tr>
                    </tbody>
                </table>

                <h5 class="m-t-40">Documentos</h5>
                <table class="table table-bordered table-hover" id="tablaDocs">
                    <thead>
                        <tr>
                            <th>Documento</th>
                            <th>Descarga</th>

                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>

            </div>
            <div class="text-center m-b-15">
                <button class="btn btn-danger" type="button" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>

<!--<div class="modal fade" id="modalVerEmprendimiento" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Vista Emprendimiento</h5>
                <button class="close" type="button" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body text-center">
                <div class="form-group col-md-6">
                    <label for="nombreEmprendimiento">Nombre Emprendimiento</label>
                    <p id="nombreEmprendimiento"></p>
                </div>
                <div class="form-group col-md-6">
                    <label for="tEmprendimiento">Tipo Emprendimiento</label>
                    <p id="tEmprendimiento"></p>
                </div>
                <div class="form-group col-md-6">
                    <label for="asociados">Beneficiarios Asociados</label>
                    <ol id="asociados"></ol>
                </div>

                <div class="form-group col-md-4">
                    <label for="formalizado">Formalizado:</label>
                    <p id="formalizado"></p>
                </div>
                <div id='divFormalizado' style='display: none'>
                    <div class="form-group col-md-6">
                        <label for="nombreEmpresa">Nombre Empresa</label>
                        <p id="nombreEmpresa"></p>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="nit">NIT</label>
                        <p id="nit"></p>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="nRegistroMercantil">Numero Registro Mercantil</label>
                        <p id="nRegistroMercantil"></p>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="nombreRepresentante">Nombre Representante Legal </label>
                        <p id="nombreRepresentante"></p>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="direccion">Direccion</label>
                        <p id="direccion"></p>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="telefono">Telefono</label>
                        <p id="telefono"></p>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="municipio">Municipio</label>
                        <p id="municipio"></p>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="email">Correo electrónico</label>
                        <p id="email"></p>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="web">Sitio Web</label>
                        <p id="web"></p>
                    </div>

                    <div class="form-group col-md-6">
                        <label for="constitucionF">Tipo Constitución Legal</label>
                        <p id="constitucionF"></p>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="sectorF">Sector productivo</label>
                        <p id="sectorF"></p>
                    </div>
                    <div class="form-group col-md-4">
                        <label for="negInternet">Negocios Internet</label>
                        <p id="negInternet"></p>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="prodServ">Productos y Servicios ofrecidos</label>
                        <p id="prodServF"></p>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="fechaRenov">Fecha Renovacion de Matricula</label>
                        <p id="fechaRenov"></p>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="fechaInicio">Fecha Inicio de Labores</label>
                        <p id="fechaInicio"></p>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="actividad">Actividad Internacional</label>
                        <p id="actividad"></p>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="empDirectos">Empleados Directos</label>
                        <p id="empDirectos"></p>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="empIndirectos">Empleados Indirectos</label>
                        <p id="empIndirectos"></p>
                    </div>
                </div>

                <div id='divNoEstablecido' style='display: none'>
                    <div class="form-group col-md-6">
                        <label for="constitucionN">Tipo Constitución Legal</label>
                        <p id="constitucionN"></p>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="sectorN">Sector productivo</label>
                        <p id="sectorN"></p>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="prodServ">Productos y Servicios ofrecidos</label>
                        <p id="prodServN"></p>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="cuandoInicia">Cuando Inicia?</label>
                        <p id="cuandoInicia"></p>
                    </div>
                    <div class="form-group col-md-6">
                        <label for="observaciones">Observaciones</label>
                        <p id="observaciones"></p>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-sm-12">
                        <h5>Lista de temas acompañamiento y asistencia técnica</h5>
                    </div>
                </div>
                <table class="table table-bordered table-hover" id="idTblTemasRutaAAT">
                    <thead>
                        <tr>
                            <th>Nombre tema</th>
                            <th>Cantidad horas planeadas</th>
                            <th>Cantidad horas ejecutadas</th>
                            <th>% Avance</th>
                            <th>Documento</th>
                        </tr>
                    </thead>
                    <tbody>



                    </tbody>
                </table>
                <table class="table table-bordered table-hover" id="tablaDocs">
                    <thead>
                        <tr>
                            <th>Documento</th>
                            <th>Descarga</th>

                        </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>

        </div>
    </div>
</div>-->

<div id="modalCalificar" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalComprobarLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalComprobarLabel">Calificar</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="form-group col-md-6">
                <label for="nombreEmprendimientoCal">Nombre Emprendimiento</label>
                <p id="nombreEmprendimientoCal"></p>
            </div>
            <div class="modal-body">
                <div class="row">
                    <div class="col-sm-11">
                        <div class="form-group">
                            <label for="observa">Observaciones</label>
                            <div class="controls">
                                <textarea type="text" class="form-control" name="observa" id="observa" placeholder="Observaciones Adicionales" 
                                          cols="60" rows="5" 
                                          maxlength="500" data-validation-maxlength-message="Máximo 500 carácteres"></textarea>
                                <span id="chars">500</span> carácteres restantes.
                            </div>
                        </div>
                    </div>
                </div>  
                <br/>
            </div>
            <div class="text-center m-b-15">
                <button class="btn btn-danger" type="button" data-dismiss="modal">Atrás</button>
                <button id ="btnGuardar" class="btn btn-success" type="button" data-dismiss="modal">Guardar</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modalEvaluaciones" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-md" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Evaluaciones Integrantes Comité</h5>
                <button class="close" type="button" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body col-md-11 ">
                <div class="form-group">
                    <label for="nombreEmprendimientoEval">Nombre Emprendimiento</label>
                    <p id="nombreEmprendimientoEval"></p>
                </div>
                <div class="form-group row col-md-10 offset-1 text-center">
                    <table id="evaluacionesIntegrantes" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th>Nombre Funcionario:</th>
                                <th>Calificación</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="text-center">
                <button class="btn btn-danger m-b-20" type="button" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/_dist/js/services/evaluacion/consultarEmprendimientosCalificacionDefinitiva.js" type="text/javascript"></script>