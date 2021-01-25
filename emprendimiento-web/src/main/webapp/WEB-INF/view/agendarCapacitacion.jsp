<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<h3>Agendar Programación </h3>
<hr/>
<div id="calendar"></div>


<div class="modal fade" id="modalSesion" tabindex="-1" role="dialog" aria-labelledby="modalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalLabel">Agendar Capacitación</h5>
                <button class="close" type="button" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
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
                <h4 class="box-title m-t-40">Agendar Beneficiario</h4>
                <hr />
                <div id="msgContainer">
                    <div id="mensajes" class="alert" style="display: none"> <i class="fa fa-check-circle"></i>
                        <span></span>
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-5">                                          
                        <label>Seleccione tipo de búsqueda</label>
                        <div class="btn-group" data-toggle="buttons">
                            <label class="btn btn-info">
                                <div class="custom-control custom-radio">
                                    <input type="radio" id="customRadio1" name="selectBeneficiario" value="1" class="custom-control-input" checked>
                                    <label class="custom-control-label" for="customRadio1">Documento</label>
                                </div>
                            </label>
                            <label class="btn btn-info">
                                <div class="custom-control custom-radio">
                                    <input type="radio" id="customRadio2" name="selectBeneficiario" value="2" class="custom-control-input">
                                    <label class="custom-control-label" for="customRadio2">Nombre/Apellido</label>
                                </div>
                            </label>
                        </div>
                    </div>

                    <div class="col-md-7">
                        <div class="row" id="filtroDocumento">                   
                            <div class="col-sm-12 col-md-6 form-group">
                                <label> Número documento</label>
                                <div class="controls">                           
                                    <input 
                                        type="text" 
                                        name="documento"
                                        class="form-control formInput" 
                                        placeholder="Número de documento"
                                        data-validation-required-message="Ingrese número documento"
                                        required id="inputDocumento"> 
                                </div>
                            </div>                                    
                        </div>

                        <div id="filtroNombres" style="display: none;">
                            <div class="row" >                   
                                <div class="col-sm-12 col-md-6 form-group">
                                    <label> Primer Nombre </label>
                                    <div class="controls">                       
                                        <input 
                                            type="text" 
                                            name="pNombre"
                                            class="form-control formInput" 
                                            placeholder="Primer Nombre"
                                            data-validation-required-message="Ingrese Nombre"
                                            maxlength="200" id="inputPrimerNombre">                        
                                    </div>
                                </div>
                                <div class="col-sm-12 col-md-6 form-group">
                                    <label> Segundo Nombre </label>
                                    <div class="controls">                       
                                        <input 
                                            type="text" 
                                            name="sNombre"
                                            class="form-control formInput" 
                                            placeholder="Segundo Nombre"
                                            maxlength="200" id="inputSegundoNombre">                        
                                    </div>
                                </div>
                            </div>
                            <div class="row" >
                                <div class="col-sm-12 col-md-6 form-group">
                                    <label> Primer Apellido </label>
                                    <div class="controls">                           
                                        <input 
                                            type="text" 
                                            name="pApellido"
                                            class="form-control formInput" 
                                            placeholder="Primer Apellido" 
                                            data-validation-required-message="Ingrese Apellido"
                                            maxlength="200" id="inputPrimerApellido">                       
                                    </div>
                                </div>
                                <div class="col-sm-12 col-md-6 form-group">
                                    <label> Segundo Apellido </label>
                                    <div class="controls">                           
                                        <input 
                                            type="text" 
                                            name="sApellido"
                                            class="form-control formInput" 
                                            placeholder="Segundo Apellido" 
                                            maxlength="200"id="inputSegundoApellido">                       
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-md-12 form-actions text-center">
                        <button type="button" class="btn btn-primary" id="btnFiltroBeneficiario"> <i class="mdi mdi-magnify"></i> Buscar Beneficiario</button>
                    </div>

                </div>

                <div class="row">
                    <div class="col-md-12">
                        <br />
                        <div id="mensajes" class="alert" style="display: none">
                            <i class="fa fa-check-circle"></i>
                            <span></span>
                            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
                        </div>

                        <div class="table-responsive m-t-20">
                            <h5 class=""m-b-20>Resultado Búsqueda de Beneficiario</h5>
                            <table id="resultBeneficiarios" class="table table-bordered table-striped">
                                <thead>
                                    <tr>
                                        <th width="10%">Documento</th>
                                        <th width="5%">Tipo Documento</th>
                                        <th width="20%">Nombres</th>
                                        <th width="20%">Apellidos</th>
                                        <th width="10%">Teléfono</th>
                                        <th width="25%">Correo</th>
                                        <th width="10%">Acción</th>
                                    </tr>
                                </thead>
                                <tbody id="bodyBeneficiario">
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal-footer text-center">
                <button class="btn btn-danger" type="button" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>
</div>
<script src="${pageContext.request.contextPath}/resources/_dist/js/services/capacitacion/agendarCapacitacion.js" type="text/javascript" charset="UTF-8"></script>
<script>
    <c:if test="${not empty idFuncionario}">
    idfuncionario = ${idFuncionario};
    </c:if>
</script>