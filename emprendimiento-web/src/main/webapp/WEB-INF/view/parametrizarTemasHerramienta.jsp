<%-- 
    Document   : parametrizarTemasHerramienta
    Created on : 13/10/2018, 01:38:02 PM
    Author     : Danny Fernando Guerrero Gelpud
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<input type="hidden" id="idHerramienta" name="idHerramienta" value="${herramientaValoracion.idHerramienta}" />
<input type="hidden" id="idCaja" name="idCaja" value="${idCajaCompensacion}" />

<h3>Herramientas de Evaluación</h3>
<hr />
<p>Lista de temas parametrizados en el sistema</p>

<div class="form-group row">
    <label for="descripcion" class="col-sm-2 col-form-label">Descripción: </label>
    <div class="col-sm-10">
        <input type="text" readonly class="form-control-plaintext" id="descripcion" name="descripcion" value="${herramientaValoracion.descripcion}">
    </div>
</div>


<th/>
<!--<h5>${mensaje}</h5>-->
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
<div class="table-responsive m-t-20" >
    <table id="tableData" class="table table-bordered table-striped">
        <thead>
            <tr>
                <th>Nombre Tema</th>
                <th>Descripción</th>
                <th>Fecha Registro</th>
                <th>Estado</th>
                <th>Acciones</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="tema" items="${temasEvaluacion}"> 
                <tr>
                    <td class="noOverflow">${tema.nombretema} </td>
                    <td class="noOverflow">${tema.descripcion} </td>
                    <td>${tema.fecharegistro} </td>
                    <td>
                        <c:if test="${tema.estado == '1'}">
                            Activo
                        </c:if>
                        <c:if test="${tema.estado == '0'}">
                            Inactivo
                        </c:if>
                    </td>
                    <td align='center'>
                        <button type="button" onclick="editarTema(${tema.idtema})" class="btn btn-sm btn-rounded btn-warning" data-toggle="tooltip" data-placement="top" title="Editar"><i class="fas fa-edit"></i></button>
                        <button type="button" onclick="verPreguntas(${tema.idtema})" class="btn btn-sm btn-rounded btn-info" data-toggle="tooltip" data-placement="top" title="Ver Preguntas"><i class="fas fa-eye"></i></button>
                        <button type="button" onclick="borrarTema(${tema.idtema})" class="btn btn-sm btn-rounded btn-danger" data-toggle="tooltip" data-placement="top" title="Borrar"><i class="fas fa-trash-alt"></i></button>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
<div class="row">
    <div class="col-md-12">
        <div class="text-center">
             <!--<a href="${pageContext.request.contextPath}/" class="btn waves-effect waves-light btn-danger" role="button">Cancelar</a>-->
            <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
            <button type="button" id="btnAgregarTema"class="btn waves-effect waves-light btn-success">Agregar Tema</button>   

        </div>
    </div>
</div>
<script src="${pageContext.request.contextPath}/resources/js/services/parametrizarTemasHerramientas.js" type="text/javascript"></script>