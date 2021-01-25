<%-- 
    Document   : consultarEmprendimientoCalificacionIndividual
    Created on : dic 7, 2018, 11:10:19 a.m.
    Author     : Andres Felipe Gonzalez M Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Calificación de Proyectos</h3>
<hr />
<p><i class="mdi mdi-view-headline"></i>Lista de Emprendimientos Agendados para Sesion de comite</p>

<div class="row">
    <div class="col-12">
        <div class="card">


            <div class="card-body">

                <div class="table-responsive m-t-20">
                    <table id="tableData" class="table table-bordered table-striped">
                        <thead>
                            <tr>
                                <th scope="col">Id.</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Tipo</th>
                                <th scope="col">Fecha Registro</th>
                                <th scope="col">Acción</th>
                            </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>


            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modalVerEmprendimiento" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editModalLabel">Vista Emprendimiento</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>                
            </div>

            <div class="modal-body">

                <table class="table table-sm table-striped">
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
                            <td><ol class="ul-noPadding" id="asociados"></ol></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Formalizado:</th>
                            <td><p id="formalizado"></p></td>
                        </tr>   
                    </tbody>
                </table>

                <table class="table table-sm table-striped" id="divFormalizado" style="display: none;">
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
                            <td><ol id="paises"></ol></td>
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
                            <td><p id="prodServF"></p></td>
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

                <table class="table table-sm table-striped" id='divNoEstablecido' style="display: none;">
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
                            <td><p id="prodServN"></p></td>
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
                <div class="form-group row">
                    <div class="col-sm-12">
                        <h5>Lista de temas acompañamiento y asistencia técnica</h5>
                        <hr/>
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
            <div class="text-center m-b-15">
                <button class="btn btn-danger" type="button" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>

<!-- model viejo de ver -->
<!--<div class="modal fade" id="modalVerEmprendimiento" tabindex="-1" role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
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
            <!--            <div class="controls">-->
            <div id="radioAprobado" class="form-group col-md-6" >
                <label for="aprobado">Aprobado?</label>

                <div class="controls">
                    <fieldset>
                        <div class="custom-control custom-radio">
                            <input type="radio"
                                   value="1"
                                   name="aprobado"
                                   id="siAprobado"
                                   class="custom-control-input"
                                   data-validation-required-message="Seleccione alguna opción"
                                   required />
                            <label class="custom-control-label" for="siAprobado">Si</label>
                        </div>
                    </fieldset>
                    <fieldset>
                        <div class="custom-control custom-radio">
                            <input type="radio"
                                   value="0"
                                   name="aprobado"
                                   id="noAprobado"
                                   class="custom-control-input">
                            <label class="custom-control-label" for="noAprobado">No</label>
                        </div>
                    </fieldset>
                </div>


                <!--                    <div class="custom-control custom-radio custom-control-inline">
                                        <label><input id="siAprobado" type="radio" name="aprobado" value="1" required data-validation-required-message="Seleccione una opción">Si</label>
                                    </div>
                                    <div class="custom-control custom-radio custom-control-inline">
                                        <label><input id="noAprobado" type="radio" name="aprobado" value="0" >No</label>
                                    </div>-->
            </div>
            <!--            </div>-->
            <div class="modal-body">

                <label for="observa">Observaciones</label>
                <textarea type="text" class="form-control" name="observa" id="observa" placeholder="Observaciones Adicionales" 
                          cols="60" rows="5" 
                          maxlength="500" data-validation-maxlength-message="Máximo 500 carácteres"></textarea>
                <span id="chars">500</span> carácteres restantes.

                <br/>
                <!--<button type="button" class="btn waves-effect waves-light btn-success" id="btnAprobado">Aprobado</button>

                <button type="button" class="btn waves-effect waves-light btn-danger"id="btnNoAprobado">No Aprobado</button> -->
            </div>
            <div class="text-center m-b-15">
                <button class="btn btn-danger" type="button" data-dismiss="modal">Cancelar</button>
                <button id ="btnGuardar" class="btn btn-success" type="button">Guardar</button>
            </div>
        </div>
    </div>
</div>
<div class="text-center">
    <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
</div>
<!--<div id="modalCalificar" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalComprobarLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalComprobarLabel">Calificar</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <label for="observa">Observaciones</label>
                <textarea name="paragraph_text" id="observa" cols="60" rows="5"></textarea>
                <br/><br>
                <div class="text-center">
                    <button type="button" class="btn waves-effect waves-light btn-danger"id="btnNoAprobado">No Aprobado</button>

                    <button type="button" class="btn waves-effect waves-light btn-success" id="btnAprobado">Aprobado</button>
                </div>

            </div>
            <div class="modal-footer">
                <button class="btn btn-alert" type="button" data-dismiss="modal">Cancelar</button>
            </div>
        </div>
    </div>
</div>-->
<script src="${pageContext.request.contextPath}/resources/_dist/js/services/evaluacion/consultarEmprendimientosCalificacionIndividual.js" type="text/javascript"></script>
<script>
    <c:if test="${not empty idFuncionario}">
    idfuncionario = ${idFuncionario};
    </c:if>
    <c:if test="${not empty idcajacompensacion}">
    idcajacompensacion = ${idcajacompensacion};
    </c:if>
</script>
