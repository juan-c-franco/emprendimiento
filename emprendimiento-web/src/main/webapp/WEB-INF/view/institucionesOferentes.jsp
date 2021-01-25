<%-- 
    Document   : institucionesOferentes
    Created on : jun 26, 2019, 3:39:43 p.m.
    Author     : Andres Gonzalez
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!-- Contenido de la pagina  -->
<h3>Instituciones / Oferentes </h3>
<hr />
<p><i class="mdi mdi-view-headline"></i> Lista de instituciones parametrizadas en el sistema</p>

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
            <th >Nombre Institución</th>
            <th >Estado</th>
            <th >NIT</th>
            <th >Naturaleza Jurídica</th>
            <th >Ver</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${instituciones}" var="tempInst">
            <tr>
                <td class="noOverflow">${tempInst.nombreInstitucion}</td>
                <td>
                    <c:if test="${tempInst.estado !='A'}">
                        Inactiva
                    </c:if>
                    <c:if test="${tempInst.estado =='A'}">
                        Activa
                    </c:if>
                </td>
                <td> ${tempInst.nit}</td>
                <td>
                    <c:if test="${tempInst.naturalezaJuridica ==0}">
                        Persona Natural
                    </c:if>
                    <c:if test="${tempInst.naturalezaJuridica ==1}">
                        Persona Jurídica
                    </c:if>
                </td>
                <td align="center"><button type='button' data-index="${tempInst.id}" class='btn btn-sm btn-rounded btn-info btn-modificar' data-toggle="tooltip" data-placement="top" title="Ver Institución"><i class="fas fa-eye"></i></button></td>
            </tr>
        </c:forEach>
    </tbody>
</table>
<div class="text-center">
    <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
    <!--    <button class="btn btn-success align-content-center" type="button" id="btn-agregar">Agregar</button>-->
</div>

<%--</c:if>--%>
<c:if test="${status=='0'}">

    <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
    </div>
</c:if>

<div class="modal fade" id="modalVerInstitucion" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-md" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editModalLabel">Vista Institución</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>                
            </div>

            <div class="modal-body">
                <h5>Datos de la Institución</h5>
                <table class="table table-sm table-bordered table-striped">
                    <tbody>
                        <tr>
                            <th class="label-th">Nombre Institución:</th>
                            <td><p id="nombreInstitución"></p></td>
                        </tr>
                        <!--                        <tr>
                                                    <th class="label-th">Tipo Institución:</th>
                                                    <td><p id="tipoInstitucion"></p></td>
                                                </tr>-->
                        <tr>
                            <th class="label-th">Correo Electrónico:</th>
                            <td><p id="correoElectronico"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Teléfono Contácto:</th>
                            <td><p id="telefonoContacto"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Estado Aprobación:</th>
                            <td><p id="estadoAprobacion"></p></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Estado:</th>
                            <td><p id="estado"></p></td>
                        </tr>
                        <!--                        <tr>
                                                    <th class="label-th">Tipo Documento:</th>
                                                    <td><p id="tipoDocumento"></p></td>
                                                </tr>-->
                        <tr>
                            <th class="label-th">Documento:</th>
                            <td><p id="documento"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Digito Verificación:</th>
                            <td><p id="digitoVerificacion"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Tipo Certificación:</th>
                            <td><p id="tipoCertificacion"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Vencimiento Certificación:</th>
                            <td><p id="vencimientoCertificacion"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Origen:</th>
                            <td><p id="origen"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Naturaleza Jurídica:</th>
                            <td><p id="naturalezaJuridica"></p></td>
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

<script src="${pageContext.request.contextPath}/resources/js/services/institucionesOferentes.js" type="text/javascript"></script>

