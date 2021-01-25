<%-- 
    Document   : configuracion
    Created on : 8/05/2019, 11:56:39 AM
    Author     : Juan Franco
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!-- Contenido de la pagina  -->
<h3>Configuración</h3>
<hr />
<p><i class="mdi mdi-view-headline"></i> Lista de parámetros de configuración</p>

<c:if test="${not empty mensaje}">
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
<c:if test="${status=='1'}">
    <table id="tableData" class="table table-bordered table-striped">
        <thead>
            <tr>
                <th>Identificador</th>
                <th>Configuración</th>
                <th>Fecha Última Modificación</th>
                <th>Valor Actual</th>
                <th align="center">Activar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${configuraciones}" var="temp">
                <tr>
                    <td>${temp.idconfiguracion}</td>
                    <td class="noOverflow">${temp.nombreconfiguracion}</td>
                    <td>${temp.fechamodificacion}</td>
                    <td align="center"><c:if test="${temp.valor=='1'}">Activado</c:if><c:if test="${temp.valor=='0'}">Desactivado</c:if></td>
                    <td align="center"><input type="checkbox" id="activo${temp.idconfiguracion}" name="activo${temp.idconfiguracion}" value="${temp.valor}" <c:if test="${temp.valor=='1'}">checked</c:if> ></td>
                    </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="text-center">
        <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
        <button class="btn btn-success align-content-center" type="button" id="btn-guardar">Guardar</button>
    </div>

</c:if>
<script src="${pageContext.request.contextPath}/resources/js/services/configuracion.js" type="text/javascript"></script>