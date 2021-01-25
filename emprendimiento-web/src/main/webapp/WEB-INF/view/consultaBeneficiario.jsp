<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!-- Filtro -->
<h3>Buscar Beneficiario</h3>
<hr/>
<c:if test="${not empty mensaje}">
    <c:if test="${status == '1'}">
        <div class="alert alert-success" id="botonMensaje"> <i class="fa fa-check-circle"></i> ${mensaje}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close" > <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
    <c:if test="${status == '0'}">
        <div class="alert alert-danger" id="botonMensaje"> <i class="fas fa-exclamation-circle"></i> ${mensaje}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close" > <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
</c:if>
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
                        class="form-control" 
                        placeholder="Número de documento"
                        data-validation-required-message="Ingrese número documento"
                        required maxlength="20"
                        tabindex="0">

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
                            class="form-control" 
                            placeholder="Primer Nombre"
                            data-validation-required-message="Ingrese Nombre"
                            maxlength="200"
                            tabindex="0">                        
                    </div>
                </div>
                <div class="col-sm-12 col-md-6 form-group">
                    <label> Segundo Nombre </label>
                    <div class="controls">                       
                        <input 
                            type="text" 
                            name="sNombre"
                            class="form-control" 
                            placeholder="Segundo Nombre"
                            maxlength="200"
                            tabindex="0">                        
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
                            class="form-control" 
                            placeholder="Primer Apellido" 
                            data-validation-required-message="Ingrese Apellido"
                            maxlength="200"
                            tabindex="0">                       
                    </div>
                </div>
                <div class="col-sm-12 col-md-6 form-group">
                    <label> Segundo Apellido </label>
                    <div class="controls">                           
                        <input 
                            type="text" 
                            name="sApellido"
                            class="form-control" 
                            placeholder="Segundo Apellido" 
                            maxlength="200"
                            tabindex="0">                       
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-md-12 text-center">
        <button type="submit" class="btn btn-primary" id="btnFiltroBeneficiario" tabindex="0"> <i class="mdi mdi-magnify"></i> Buscar Beneficiario</button>
    </div>

</div>

<br /><hr />


<div class="row">
    <div class="col-md-12">



        <c:if test="${not empty beneficiarios}">
            <div class="table-responsive m-t-20">
                <table id="tableData" class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th scope="col">Documento</th>
                            <th scope="col">Tipo Doc.</th>
                            <th scope="col">Nombres</th>
                            <th scope="col">Apellidos</th>
                            <th scope="col">Teléfono</th>
                            <th scope="col">Correo</th>
                            <th scope="col">Acción</th>
                        </tr>
                    </thead>
                    <tbody id="bodyBeneficiario">
                        <c:forEach items="${beneficiarios}" var="tempbeneficiarios" varStatus="loop">
                            <tr id="beneficiariosTabla">
                                <td id="numerodocumento${loop.index}">${tempbeneficiarios.numerodocumento}</td>
                                <td id="nombredocumento${loop.index}" class="noOverflow">${tempbeneficiarios.tipodocumentoid.nombredocumento}</td>
                                <td id="nombres${loop.index}" class="noOverflow">${tempbeneficiarios.primernombre} ${tempbeneficiarios.segundonombre}</td>
                                <td id="apellidos${loop.index}" class="noOverflow">${tempbeneficiarios.primerapellido} ${tempbeneficiarios.segundoapellido}</td>
                                <c:if test="${tempbeneficiarios.telefono != '0'}">
                                    <td id="telefono${loop.index}">${tempbeneficiarios.telefono}</td>
                                </c:if>
                                <c:if test="${tempbeneficiarios.telefono == '0'}">
                                    <td id="telefono${loop.index}"></td>
                                </c:if>
                                <td id="email${loop.index}" class="noOverflow">${tempbeneficiarios.email}</td>
                                <td align="center" >
                                    <button type='button' data-index="${loop.index}" class='btn btn-sm btn-rounded btn-secondary btn-validaciones' data-toggle="tooltip" data-placement="top" title="Validar Beneficiario"><i class="fas fa-clipboard-list"></i></button></td>
                                </td>
                            </tr>
                        </c:forEach>

                    </tbody>
                </table>
            </div>
        </c:if>            

    </div>
</div>
<div class="modal fade" id="modalVerificacion" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-md" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editModalLabel">Verificación de Requisitos</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>                
            </div>

            <div class="modal-body">
                <h5>Validaciones Restrictivas</h5>
                <table class="table table-sm table-bordered table-striped">
                    <tbody>
                        <tr>
                            <th class="label-th">¿Beneficiario registrado en SI-MPC?</th>
                            <td><p id="simpc"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">¿Beneficiario es actualmente cesante?</th>
                            <td><p id="cesante"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">¿Realiza aportes a Caja de Compensación?</th>
                            <td><p id="aportes"></p></td>
                        </tr>       
                    </tbody>
                </table>

                <h5 class="m-t-40">Requisitos Informativos</h5>
                <table class="table table-sm table-bordered table-striped">
                    <tbody>
                        <tr>
                            <th class="label-th">¿Beneficiario posee recobro activo?</th>
                            <td><p id="recobro"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Último pago de prestaciones económicas:</th>
                            <td><p id="prestaciones"></p></td>
                        </tr>
                    </tbody>
                </table>
            </div>
            <div class="text-center m-b-15">
                <button class="btn btn-danger" type="button" data-dismiss="modal">Cerrar</button>
                <button type='button' class='btn btn-success btn-secondary btn-registrar' data-toggle="tooltip" data-placement="top" title="Registrar Beneficiario">Registrar</button></td>
            </div>
        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/_dist/js/services/consultaBeneficiario.js" type="text/javascript"></script>
