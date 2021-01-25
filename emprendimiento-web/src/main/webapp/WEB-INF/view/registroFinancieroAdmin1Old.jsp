<%-- 
    Document   : registroFinancieroAdmin1
    Created on : dic 3, 2018, 10:50:51 a.m.
    Author     : Andres Felipe Gonzalez M. Grow Data PC
--%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<div class="form-row">
    <c:if test="${not empty cajasDTO}">
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <label class="input-group-text" for="idcajacompensacion">Caja de Compensación</label>
            </div>
            <select class="custom-select" id="idcajacompensacion" name="idcajacompensacion" >
                <c:forEach items="${cajasDTO}" var="tempCajas" >
                    <c:if test="${idcajacompensacion == tempCajas.idcajacompensacion}"> 
                        <option value="${tempCajas.idcajacompensacion}" selected>${tempCajas.nombrecajacompensacion}</option>
                    </c:if>
                    <c:if test="${idcajacompensacion != tempCajas.idcajacompensacion}"> 
                        <option value="${tempCajas.idcajacompensacion}" >${tempCajas.nombrecajacompensacion}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
        <button type="button" id="btnFuncionarios" class="btn btn-primary float-right">Consultar Funcionarios</button>
    </c:if>
    <c:if test="${not empty funcionariosDTO}">
        <div class="input-group mb-3">
            <div class="input-group-prepend">
                <label class="input-group-text" for="idfuncionario">Funcionario</label>
            </div>
            <select class="custom-select" id="idfuncionario" name="idfuncionario">
                <c:forEach items="${funcionariosDTO}" var="tempFuncionarios" >
                    <c:if test="${idfuncionario == tempFuncionarios.idfuncionario}">
                        <option value="${tempFuncionarios.idfuncionario}" selected>${tempFuncionarios.primernombre} ${tempFuncionarios.segundonombre}
                            ${tempFuncionarios.primerapellido} ${tempFuncionarios.segundoapellido}</option>
                        </c:if>
                        <c:if test="${idfuncionario != tempFuncionarios.idfuncionario}">
                        <option value="${tempFuncionarios.idfuncionario}">${tempFuncionarios.primernombre} ${tempFuncionarios.segundonombre}
                            ${tempFuncionarios.primerapellido} ${tempFuncionarios.segundoapellido}</option>
                        </c:if>
                    </c:forEach>
            </select>
        </div>
        <button type="button" id="btnConsulta" class="btn btn-primary float-right">Consultar</button>
    </c:if>
    <c:if test ="${not empty idfuncionario}">

        <div class="row">
            <div class="input-group">
                <select class="custom-select" id="buscarPor" aria-label="Example select with button addon">
                    <option selected value="0">Buscar por...</option>
                    <option value="1">Documento</option>
                    <option value="2">Nombre Emprendimiento</option>
                </select>
                <div class="input-group-append">

                    <button class="btn btn-outline-secondary" type="button" id ="btnDoc">Buscar</button>

                </div>
            </div>
        </div>
    </c:if>
    <div class="row">
        <div class="form-group mx-sm-3 col-4" >
            <label for="documento" class="sr-only">Documento</label>
            <input type="text" min="0" class="form-control" id="documento" placeholder="Documento" hidden="true">
        </div>
        <!--    <button type="button" id="btnDoc" class="btn btn-primary btn-sm col-2">Buscar</button>-->
    </div>
    <div class="row">
        <div class="form-group mx-sm-3 col-4">
            <label for="nombreEmprendimiento" class="sr-only">Nombre Emprendimiento</label>
            <input type="text" min="0" class="form-control " id="nombreEmprendimiento" placeholder="Nombre Emprendimiento" hidden="true" >
        </div>

    </div>
    <c:if test="${not empty mensaje}">
        <h4>${mensaje}</h4>
    </c:if>
    <table id="resultBeneficiarios" class="table table-striped">
        <thead>
            <tr>
                <th >Emprendimiento</th>
                <th >Estado Emprendimiento</th>
                <th >Tipo de Emprendimiento</th>
                <th >Accion</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${emprendimientos}" var="tempEmprendimientos">
                <tr>
                    <td class="noOverflow">${tempEmprendimientos.nombreemprendimiento}</td>
                    <td >${tempEmprendimientos.estadoemprendimiento.nombreestadoemprendimiento}</td>
                    <td >${tempEmprendimientos.tipoemprendimiento.nombretipoemprendimiento}</td>
                    <td ><a onclick="loadView('Registro de Información Financiera Básica', '${pageContext.request.contextPath}/registrarInfoFinancieraBasica?idEmprendimiento=${tempEmprendimientos.idemprendimiento}&idFuncionario=${idfuncionario}')">Registro</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<input type="hidden" id="idfuncionario" value="${idfuncionario}">
<input type="hidden" id="idcajacompensacion" value="${idcajacompensacion}">
<script src="${pageContext.request.contextPath}/resources/js/services/consultarEmprendimientoRegistroFinancierioBasico.js" type="text/javascript"></script>