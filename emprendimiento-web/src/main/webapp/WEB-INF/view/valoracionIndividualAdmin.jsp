<%-- 
    Document   : valoracionIndividualAdmin
    Created on : ene 14, 2019, 3:58:12 p.m.
    Author     : Andres Felipe Gonzalez Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!-- Filtro -->
<h3>Buscar Beneficiario</h3>
<hr />
<div id="msgContainer">
    <div id="mensajes" class="alert" style="display: none"> <i class="fas fa-exclamation-circle"></i>
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
                        class="form-control" 
                        placeholder="Número de documento"
                        data-validation-required-message="Ingrese número documento"
                        required maxlength="18" id="inputDocumento">

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
                            maxlength="200" id="inputNombre">                        
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
                            maxlength="200" id="inputNombre2">                        
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
                            maxlength="200" id="inputApellido">                       
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
                            maxlength="200" id="inputApellido2">                       
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-md-12 text-center">
        <button type="submit" class="btn btn-primary" id="btnFiltroBeneficiario"> <i class="mdi mdi-magnify"></i> Buscar Beneficiario</button>
    </div>

</div>

<br /><hr />


<div class="row">
    <div class="col-md-12">

        <!--        <div id="mensajes" class="alert" style="display: none"> <i class="fa fa-check-circle"></i>
                    <span></span>
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
                </div>-->

        <table id="resultBeneficiarios" class="table table-bordered table-striped tablaData">
            <thead>
                <tr>
                    <th width="10%">Documento</th>
                    <th width="5%">Tipo Documento</th>
                    <th width="20%">Nombres</th>
                    <th width="20%">Apellidos</th>
                    <th width="10%">Telefono</th>
                    <th width="25%">Correo</th>
                    <th width="10%">Accion</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>         

    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/services/consultarBeneficiarioValoracionInd.js" type="text/javascript"></script>
<script>
    <c:if test="${not empty idFuncionario}">
    idfuncionario = ${idFuncionario};
    </c:if>
    <c:if test="${not empty idCajacompensacion}">
    idcajacompensacion = ${idCajacompensacion};
    </c:if>
</script>
