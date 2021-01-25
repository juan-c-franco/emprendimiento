<%-- 
    Document   : valoracionGrupalAdmin
    Created on : ene 15, 2019, 10:26:28 a.m.
    Author     : Andres Felipe Gonzalez Grow Data PC
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!-- Filtro -->
<h3>Buscar Emprendimiento</h3>
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
                    <label class="custom-control-label" for="customRadio2">Nombre Emprendimiento</label>
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

        <div class="row" id="filtroNombres" style="display: none;">                   
            <div class="col-sm-12 col-md-6 form-group">
                <label> Nombre Emprendimiento </label>
                <div class="controls">                       
                    <input 
                        type="text" 
                        name="nombre"
                        class="form-control" 
                        placeholder="Nombre"
                        data-validation-required-message="Ingrese nombre"
                        maxlength="200" id="inputEmprendimiento">                        
                </div>
            </div>                    
        </div>
    </div>

    <div class="col-md-12 text-center">
        <button type="submit" class="btn btn-primary" id="btnFiltroBeneficiario"> <i class="mdi mdi-magnify"></i> Buscar Emprendimiento</button>
    </div>

</div>

<br /><hr />


<div class="row">
    <div class="col-md-12">



        <table id="resultBeneficiarios" class="table table-bordered table-striped tablaData">
            <thead>
                <tr>
                    <th >Emprendimiento</th>
                    <th >Estado Emprendimiento</th>
                    <th >Tipo de Emprendimiento</th>
                    <th >Acción</th>
                </tr>
            </thead>
            <tbody>
            </tbody>
        </table>         

    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/services/consultarEmprendimientoValoracionGrupal.js" type="text/javascript"></script>
<script>
    <c:if test="${not empty idFuncionario}">
    idfuncionario = ${idFuncionario};
    </c:if>
    <c:if test="${not empty idCajaCompensacion}">
    idcajacompensacion = ${idCajaCompensacion};
    </c:if>
</script>

