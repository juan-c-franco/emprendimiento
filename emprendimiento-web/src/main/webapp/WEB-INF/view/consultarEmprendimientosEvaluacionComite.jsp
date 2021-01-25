<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Consultar Emprendimientos para Evaluación de Comité</h3>
<hr/>

<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-body">
                <p><i class="mdi mdi-view-headline"></i>Lista de Emprendimientos en etapa de Evaluación</p>
                <div id="msgContainer">
                    <div id="mensajes" class="alert" style="display: none"> <i class="fa fa-check-circle"></i>
                        <span></span>
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
                    </div>
                </div>
                <div class="table-responsive">
                    <table id="tableData" class="table table-bordered table-striped dataTabla">
                    </table>
                </div>
                <div class="table-responsive m-t-20">
                    <p><i class="mdi mdi-view-headline"></i>Lista de Emprendimientos Agendados</p>
                    <table id="tbAgendados" class="table table-bordered table-striped dataTabla">
                        <thead>
                            <tr>
                                <th width="8%">Id.</th>
                                <th width="41%">Nombre</th>
                                <th width="17%">Tipo</th>
                                <th width="17%">Fecha Registro</th>
                                <th width="17%">Acción</th>
                            </tr>
                        </thead>
                        <tbody>
                        </tbody>
                    </table>
                </div>
                <div class="text-center">
                    <button type="button" onclick="agendar()" id="btnConsulta" class="btn btn-primary" ><i class='fas fa-calendar-check'></i> Agendar</button>
                </div>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modalVerEmprendimiento" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-md" role="document">
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
                            <td class="noOverflow"><p id="nombreEmprendimiento"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Tipo Emprendimiento:</th>
                            <td class="noOverflow"><p id="tEmprendimiento"></p></td class="noOverflow">
                        </tr>
                        <tr>
                            <th class="label-th">Beneficiarios Asociados:</th>
                            <td class="noOverflow"><ol class="ul-noPadding" id="asociados"></ol></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Formalizado:</th>
                            <td class="noOverflow"><p id="formalizado"></p></td>
                        </tr>   
                    </tbody>
                </table>

                <h5 class="m-t-40 formalizado" style="display: none;">Emprendimiento Formalizado</h5>
                <table class="table table-sm table-bordered table-striped formalizado" id="divFormalizado" style="display: none;">
                    <tbody>
                        <tr>
                            <th class="label-th">Nombre Empresa:</th>
                            <td class="noOverflow"><p id="nombreEmpresa"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">NIT:</th>
                            <td class="noOverflow"><p id="nit"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Número Registro Mercantil:</th>
                            <td class="noOverflow"><p id="nRegistroMercantil"></p></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Nombre Representante Legal:</th>
                            <td class="noOverflow"><p id="nombreRepresentante"></p></td>
                        </tr>   
                        <tr>
                            <th class="label-th">Dirección:</th>
                            <td class="noOverflow"><p id="dirección"></p></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Teléfono:</th>
                            <td class="noOverflow"><p id="telefono"></p></td>
                        </tr>    
                        <tr>
                            <th class="label-th">Municipio:</th>
                            <td class="noOverflow"><p id="municipio"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Correo electrónico:</th>
                            <td class="noOverflow"><p id="email"></p></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Sitio Web:</th>
                            <td class="noOverflow"><p id="web"></p></td>
                        </tr>    
                        <tr>
                            <th class="label-th">Países Comercializa:</th>
                            <td class="noOverflow"><ol id="paises" class="ul-noPadding"></ol></td>
                        </tr>
                        <tr>
                            <th class="label-th">Tipo Constitución Legal:</th>
                            <td class="noOverflow"><p id="constitucionF"></p></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Sector Productivo:</th>
                            <td class="noOverflow"><p id="sectorF"></p></td>
                        </tr>    
                        <tr>
                            <th class="label-th">Negocios Internet:</th>
                            <td class="noOverflow"><p id="negInternet"></p></td>
                        </tr>

                        <tr>
                            <th class="label-th">Productos y Servicios Ofrecidos:</th>
                            <td class="noOverflow"><ul id="prodServF" class="ul-noPadding"></ul></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Fecha Renovación de Matrícula:</th>
                            <td class="noOverflow"><p id="fechaRenov"></p></td>
                        </tr>    
                        <tr>
                            <th class="label-th">Fecha Inicio de Labores:</th>
                            <td class="noOverflow"><p id="fechaInicio"></p></td>
                        </tr>     

                        <tr>
                            <th class="label-th">Actividad Internacional:</th>
                            <td class="noOverflow"><p id="actividad"></p></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Empleados Directos:</th>
                            <td class="noOverflow"><p id="empDirectos"></p></td>
                        </tr>    
                        <tr>
                            <th class="label-th">Empleados Indirectos:</th>
                            <td class="noOverflow"><p id="empIndirectos"></p></td>
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
            </div>
            <div class="text-center m-b-15">
                <button class="btn btn-danger" type="button" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/_dist/js/services/evaluacion/consultarEmprendimientosEvaluacionComite.js" type="text/javascript"></script>
<script>
    <c:if test="${not empty idFuncionario}">
                        idfuncionario = ${idFuncionario};
    </c:if>
    <c:if test="${not empty idCajacompensacion}">
                        idcajacompensacion = ${idCajacompensacion};
    </c:if>
</script>