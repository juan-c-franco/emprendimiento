<%-- 
    Document   : homepage
    Created on : 12/09/2018, 09:27:32 AM
    Author     : Andrés Felipe González M Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!-- Contenido de la pagina  -->
<h3>Cajas de Compensación</h3>
<hr />
<p><i class="mdi mdi-view-headline"></i> Lista de las cajas de compensación parametrizadas en el sistema</p>

<c:if test="${not empty mensaje3}">
    <c:if test="${status3=='1'}">
        <div class="alert alert-success"> <i class="fa fa-check-circle"></i> ${mensaje3}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
    <c:if test="${status3=='0'}">
        <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje3}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
</c:if>
<c:if test="${status=='1'}">
    <table id="tableData" class="table table-bordered table-striped">
        <thead>
            <tr>
                <th >Nombre Caja Compensación</th>
                <th >Código</th>
                <th >Estado</th>
                <th>Fecha Registro</th>
                <th >Editar</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${cajasDTO}" var="tempCajas">
                <tr>
                    <td class="noOverflow">${tempCajas.nombrecajacompensacion}</td>
                    <td>${tempCajas.codigoccf}</td>
                    <td> ${tempCajas.estadocajacompensacion.nombreestadocaja}</td>
                    <td>${tempCajas.fecharegistro}</td>
                    <td align="center"><button type='button' data-index="${tempCajas.idcajacompensacion}" class='btn btn-sm btn-rounded btn-warning btn-modificar' data-toggle="tooltip" data-placement="top" title="Editar"><i class="fas fa-edit"></i></button></td>

                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div class="text-center">
        <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
        <button class="btn btn-success align-content-center" type="button" id="btn-agregar">Agregar</button>
    </div>

</c:if>
<c:if test="${status=='0'}">
    <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
    </div>
</c:if>

<script src="${pageContext.request.contextPath}/resources/js/services/cajasDeCompensacion.js" type="text/javascript"></script>
