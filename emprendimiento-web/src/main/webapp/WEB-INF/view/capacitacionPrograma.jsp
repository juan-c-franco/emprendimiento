<%-- 
    Document   : capacitacionPrograma
    Created on : jul 2, 2019, 3:29:46 p.m.
    Author     : Andres Gonzalez
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!-- Contenido de la pagina  -->
<h3>Capacitación / Programas </h3>
<hr />
<p><i class="mdi mdi-view-headline"></i> Lista de programas parametrizados en el sistema</p>

<c:if test="${not empty mensaje2}">
    <c:if test="${status2=='1'}">
        <div class="alert alert-success"> <i class="fa fa-check-circle"></i> ${mensaje2}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
    <c:if test="${status2=='0'}">
        <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje2}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
</c:if>
<%--<c:if test="${status=='1'}">--%>
<table id="tableData" class="table table-bordered table-striped">
    <thead>
        <tr>
            <th >Nombre Programa</th>
            <th >Institución / Oferente</th>
            <th >Categoría</th>
            <th >Estado</th>
            <th >Editar</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${capacitaciones}" var="tempCap">
            <tr>
                <td class="noOverflow">${tempCap.nombrecapacitacionprograma}</td>

                <td class="noOverflow">
                    <c:forEach items="${instituciones}" var="tempInst">
                        <c:if test="${tempInst.id == tempCap.idoferenteinstitucion}">
                            ${tempInst.nombreInstitucion}
                        </c:if>
                    </c:forEach>
                </td>
                <td class="noOverflow"> ${tempCap.categoria.nombrecategoria} </td>
                <td>
                    <c:if test="${tempCap.estadocapacitacionprograma.idestadocapacitacionprograma =='0'}">
                        Inactiva
                    </c:if>
                    <c:if test="${tempCap.estadocapacitacionprograma.idestadocapacitacionprograma =='1'}">
                        Activa
                    </c:if>
                </td>
                <td align="center"><button type='button' data-index="${tempCap.idcapacitacionprograma}" class='btn btn-sm btn-rounded btn-warning btn-modificar' data-toggle="tooltip" data-placement="top" title="Editar"><i class="fas fa-edit"></i></button></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<div class="text-center">
    <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
    <button class="btn btn-success align-content-center" type="button" id="btn-agregar">Agregar</button>
</div>

<%--</c:if>--%>
<c:if test="${status=='0'}">

    <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
    </div>
</c:if>

<script src="${pageContext.request.contextPath}/resources/js/services/capacitacionPrograma.js" type="text/javascript"></script>


