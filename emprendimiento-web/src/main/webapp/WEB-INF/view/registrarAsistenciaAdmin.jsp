<%-- 
   Document   : registrarAsistenciaAdmin
   Created on : oct 31, 2018, 12:04:10 p.m.
   Author     : Andrés Felipe González Grow Data PC
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!-- Filtro -->
<h6>Buscar Funcionario</h6>
<hr />

<div class="row">
    <c:if test="${not empty cajasDTO}">    
        <div class="col-sm-6">
            <label>Caja de Compensación</label>
            <select id="idcajacompensacion" name="idcajacompensacion" class="selectpicker m-b-20 m-r-10" data-style="btn-info">
                <option value=""> -- seleccione -- </option>              
                <c:forEach items="${cajasDTO}" var="tempCajas" >
                    <c:if test="${idcajacompensacion == tempCajas.idcajacompensacion}">
                        <option value ="${tempCajas.idcajacompensacion}" selected>${tempCajas.nombrecajacompensacion}</option>
                    </c:if>
                    <c:if test="${idcajacompensacion != tempCajas.idcajacompensacion}"> 
                        <option value="${tempCajas.idcajacompensacion}" >${tempCajas.nombrecajacompensacion}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
    </c:if>    

    <div class="col-sm-6">
        <label>Funcionario</label>
        <select id="idfuncionario" name="idfuncionario" class="selectpicker m-b-20 m-r-10" data-style="btn-info" <c:if test="${empty funcionariosDTO}">disabled="true"</c:if>>
                <option value=""> -- seleccione -- </option>
            <c:if test="${not empty funcionariosDTO}">
                <c:forEach items="${funcionariosDTO}" var="temp" >
                    <c:if test="${idfuncionario == temp.idfuncionario}">
                        <option value="${temp.idfuncionario}" selected>${temp.primernombre} ${temp.segundonombre}
                            ${temp.primerapellido} ${temp.segundoapellido}</option>
                        </c:if>
                        <c:if test="${idfuncionario != temp.idfuncionario}">
                        <option value="${temp.idfuncionario}">${temp.primernombre} ${temp.segundonombre}
                            ${temp.primerapellido} ${temp.segundoapellido}</option>
                        </c:if>
                    </c:forEach>
                </c:if>
        </select>
    </div>

    <div class="col-md-12 form-actions m-t-20">
        <button type="button" id="btnConsulta" class="btn btn-primary float-right" <c:if test="${empty funcionariosDTO}">disabled="true"</c:if>> <i class="mdi mdi-magnify"></i> Consultar Funcionario</button>
        </div>                
    </div>

    <br /><hr />

    <script src="${pageContext.request.contextPath}/resources/js/services/registrarAsistenciaAdmin.js" type="text/javascript"></script>