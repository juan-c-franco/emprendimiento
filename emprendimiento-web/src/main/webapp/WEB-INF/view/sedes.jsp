<%-- 
    Document   : sedes
    Created on : jul 19, 2019, 12:06:20 p.m.
    Author     : Andres Gonzalez
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!-- Contenido de la pagina  -->
<h3> Sedes </h3>
<hr />
<p><i class="mdi mdi-view-headline"></i> Lista de sedes parametrizadas en el sistema</p>

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
            <th >Nombre Sede</th>
            <th >Código</th>
            <th >Dirección</th>
            <th >Estado</th>
            <th >Ver</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${sedes}" var="tempSedes">
            <tr>
                <td class="noOverflow"> ${tempSedes.nombre} </td>
                <td> ${tempSedes.codigo} </td>
                <td class="noOverflow"> ${tempSedes.direccion} </td>
                <td>
                    <c:if test="${tempSedes.estado == 'A'}">
                        Activa
                    </c:if> 
                    <c:if test="${tempSedes.estado != 'A'}">
                        Inactiva
                    </c:if> 
                </td>
                <td align="center"><button type='button' data-index="${tempSedes.id}" class='btn btn-sm btn-rounded btn-info btn-modificar' data-toggle="tooltip" data-placement="top" title="Ver"><i class="fas fa-eye"></i></button></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<div class="text-center">
    <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
</div>

<%--</c:if>--%>
<c:if test="${status=='0'}">

    <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
    </div>
</c:if>

<div class="modal fade" id="modalVerSede" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-md" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editModalLabel">Vista Sede</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>                
            </div>

            <div class="modal-body">
                <h5>Datos de la Sede</h5>
                <table class="table table-sm table-bordered table-striped">
                    <tbody>
                        <tr>
                            <th class="label-th">Nombre Sede:</th>
                            <td><p id="nombre"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">codigo:</th>
                            <td><p id="codigo"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Dirección:</th>
                            <td><p id="direccion"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Estado:</th>
                            <td><p id="estado"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">¿Es Sede Principal?</th>
                            <td><p id="principal"></p></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Institución:</th>
                            <td><p id="idInstitucion"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Municipio:</th>
                            <td><p id="idMunicipio"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Departamento:</th>
                            <td><p id="idDepartamento"></p></td>
                        </tr>

                    </tbody>
                </table>
            </div>
            <div class="text-center m-b-15">
                <button class="btn btn-danger" type="button" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/services/sedes.js" type="text/javascript"></script>


