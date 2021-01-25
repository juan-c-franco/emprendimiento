<%-- 
    Document   : registrarAsistenciaAdminV
    Created on : nov 13, 2018, 11:59:11 a.m.
    Author     : Andres Felipe Gonzalez M Grow Data PC
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
</div>
<div class="form-row">
    <input type="hidden" id="url" value="${url}">
    <script src="${pageContext.request.contextPath}/resources/js/services/registrarAsistenciaAdminV.js" type="text/javascript"></script>
