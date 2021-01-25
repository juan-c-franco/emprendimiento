<%-- 
    Document   : homepage
    Created on : 12/09/2018, 09:27:32 AM
    Author     : Andrés Felipe González Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<c:if test="${not empty cajasDTO}">
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <label class="input-group-text" for="idcajacompensacion">Caja de Compensación</label>
        </div>
        <select class="custom-select" id="idcajacompensacion" name="idcajacompensacion" onchange="cargarFuncionarios()">
            <c:forEach items="${cajasDTO}" var="tempCajas" >
                <option value="${tempCajas.idcajacompensacion}" >${tempCajas.nombrecajacompensacion}</option>
            </c:forEach>
        </select>
    </div>
</c:if>

<c:if test="${not empty funcionariosDTO}">
    <div class="input-group mb-3">
        <div class="input-group-prepend">
            <label class="input-group-text" for="idfuncionario">Caja de Compensación</label>
        </div>
        <select class="custom-select" id="idfuncionario" name="idfuncionario">
            <c:forEach items="${funcionariosDTO}" var="tempFuncionarios" >
                <c:if test="${idfuncionario == tempFuncionarios.idfuncionario}">
                    <option value="${tempFuncionarios.idfuncionario}" selected>${tempFuncionarios.primernombre} ${tempFuncionarios.segundonombre}
                        ${tempFuncionarios.primerapellido} ${tempFuncionarios.segundoapellido}</option>
                    </c:if>
                    <c:if test="${idfuncionario == tempFuncionarios.idfuncionario}">
                    <option value="${tempFuncionarios.idfuncionario}">${tempFuncionarios.primernombre} ${tempFuncionarios.segundonombre}
                        ${tempFuncionarios.primerapellido} ${tempFuncionarios.segundoapellido}</option>
                    </c:if>
                </c:forEach>
        </select>
    </div>
    <button type="button" id="btnConsulta" class="btn btn-primary float-right">Consultar</button>
</c:if>

<c:if test ="${not empty mensaje}">
    <c:if test="${status=='1'}">
        <div class="alert alert-success"> <i class="fa fa-check-circle"></i> ${mensaje}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
    <c:if test="${status=='0'}">
        <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
</c:if>

<c:if test ="${not empty sesiones}">
    <div class="table-responsive m-t-20">    
        <table id="tableData" class="table table-bordered table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Id Sesión</th>
                    <!--    <th>Id Tipo de Sesión</th>
                        <th>Id Estado de Sesión</th> -->
                    <th>Nombre Funcionario</th>
                    <th>Estado Sesión</th>
                    <th>Fecha de Inicio</th>
                    <th>Fecha Final</th>
                    <th>Fecha Registro</th>
                </tr>
            </thead>
            <tbody 
                <c:forEach var="tempSesiones" items="${sesiones}">
                    <tr>
                <div class="list-group">
                    <c:if test="${tempSesiones.estadosesion.idestadosesion!=4}">
                        <td> <a onclick="loadView('Registrar asistencia', '${pageContext.request.contextPath}/traerAsistentes?idsesion=${tempSesiones.idsesion}&fecha=${tempSesiones.fechafinal}&idfuncionario=${tempSesiones.funcionario.idfuncionario}&idestadosesion=${tempSesiones.estadosesion.idestadosesion}')" class="list-group-item list-group-item-action">${tempSesiones.idsesion}</a></td>       
                        <td  class="noOverflow"> <a href="#" class="list-group-item">${tempSesiones.funcionario.primernombre} ${tempSesiones.funcionario.primerapellido}</a></td>
                        <td> <a href="#" class="list-group-item"> ${tempSesiones.estadosesion.nombreestadosesion}</a></td>
                        <td> <a href="#" class="list-group-item">${tempSesiones.fechainicio}</a></td>
                        <td> <a href="#" class="list-group-item">${tempSesiones.fechafinal}</a></td>
                        <td> <a href="#" class="list-group-item">${tempSesiones.fecharegistro}</a></td>
                        </c:if>
                        <c:if test="${tempSesiones.estadosesion.idestadosesion==4}">
                        <td> <a href="#" class="list-group-item list-group-item-action">${tempSesiones.idsesion}</a></td>       
                        <td> <a href="#" class="list-group-item">${tempSesiones.funcionario.primernombre} ${tempSesiones.funcionario.primerapellido}</a></td>
                        <td> <a href="#" class="list-group-item"> ${tempSesiones.estadosesion.nombreestadosesion}</a></td>
                        <td> <a href="#" class="list-group-item">${tempSesiones.fechainicio}</a></td>
                        <td> <a href="#" class="list-group-item">${tempSesiones.fechafinal}</a></td>
                        <td> <a href="#" class="list-group-item">${tempSesiones.fecharegistro}</a></td>

                    </c:if>
                </div>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>    
</c:if>
