<%-- 
    Document   : registrarAsistenciaV
    Created on : nov 13, 2018, 11:57:07 a.m.
    Author     : Andres Felipe Gonzalez M Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>



<table class="table" >
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
        <c:if test ="${not empty sesiones}">
            <c:forEach var="tempSesiones" items="${sesiones}">
                <tr>
            <div class="list-group">
                <c:if test="${tempSesiones.estadosesion.idestadosesion!=4}">
                    <td> <a onclick="loadView('Registrar asistencia valoración', '${pageContext.request.contextPath}/traerAsistentesV?idsesion=${tempSesiones.idsesion}&fecha=${tempSesiones.fechafinal}&idfuncionario=${tempSesiones.funcionario.idfuncionario}&idestadosesion=${tempSesiones.estadosesion.idestadosesion}')" class="list-group-item list-group-item-action">${tempSesiones.idsesion}</a></td>       
                    <td class="noOverflow"> <a href="#" class="list-group-item">${tempSesiones.funcionario.primernombre} ${tempSesiones.funcionario.primerapellido}</a></td>
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
</c:if>