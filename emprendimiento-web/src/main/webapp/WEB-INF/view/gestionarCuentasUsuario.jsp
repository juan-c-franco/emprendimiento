<%-- 
    Document   : homepage
    Created on : 12/09/2018, 09:27:32 AM
    Author     : Andrés Felipe González Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Cuentas de Usuario</h3>
<hr />
<p><i class="mdi mdi-view-headline"></i>Lista de usuarios parametrizados en el sistema</p>

<c:if test="${not empty mensaje2}">
    <c:if test="${status2 == '1'}">
        <div class="alert alert-success"> <i class="fa fa-check-circle"></i> ${mensaje2} 
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
    <c:if test="${status2 == '0'}">

        <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje2}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
</c:if>
<c:if test="${not empty mensaje3}">
    <c:if test="${status3 == '1'}">
        <div class="alert alert-success"> <i class="fa fa-check-circle"></i> ${mensaje3} 
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
    <c:if test="${status3 == '0'}">
        <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje3}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>


</c:if>

<div class="col-sm-12 mb-3" id="valora">
    <h6>Caja de Compensación</h6>
    <div class="form-group">
        <div class="controls">
            <select id="idcajacompensacion" name="idcajacompensacion" class="selectpicker m-b-20 m-r-10" data-style="btn-info" data-validation-required-message="Seleccione una Caja de Compensación">
                <option value=""> -- seleccione -- </option>
                <c:forEach items="${funcisDTO}" var="tempFunci" >
                    <c:if test="${idcajacompensacion2 == tempFunci.idcajacompensacion}">
                        <option value="${tempFunci.idcajacompensacion}" selected>${tempFunci.nombrecajacompensacion}</option>
                    </c:if>
                    <c:if test="${idcajacompensacion2 != tempFunci.idcajacompensacion}">
                        <option value="${tempFunci.idcajacompensacion}" >${tempFunci.nombrecajacompensacion}</option>
                    </c:if>
                </c:forEach>
            </select>
        </div>
    </div>

</div>


<button type="button" id="btnConsulta" class="btn btn-primary float-right">Consultar</button>


<br><br>
<br><br>

<!-- tabla-->

<c:if test="${not empty funcionariosDTO}">
    <c:if test="${status=='1'}">
        <table id="tableData" class="table table-bordered table-striped">
            <thead >
                <tr>
                    <th>Documento</th>
                    <th class="noOverflow">Nombres</th>
                    <th class="noOverflow">Apellidos</th>
                    <th >Perfil</th>
                    <th>Estado</th>
                    <th >Editar</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${funcionariosDTO}" var="tempFuncionarios">
                    <tr>
                        <th >${tempFuncionarios.numerodocumento}</th>
                        <td>${tempFuncionarios.primernombre} ${tempFuncionarios.segundonombre}</td>
                        <td>${tempFuncionarios.primerapellido} ${tempFuncionarios.segundoapellido}</td>
                        <td>${tempFuncionarios.groupName}</td>
                        <td>${tempFuncionarios.estadofuncionario.nombreestado}</td>
                        <td align="center"><button type='button' data-index="${tempFuncionarios.idfuncionario}" class='btn btn-sm btn-rounded btn-warning btn-modificar' data-toggle="tooltip" data-placement="top" title="Editar"><i class="fas fa-edit"></i></button></td>

                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </c:if>
</c:if>
<hr />
<div class="text-center">
    <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
    <button type="button" id="btn-agregar" class="btn btn-success">Registrar</button>
</div>

<script src="${pageContext.request.contextPath}/resources/js/services/consultarFuncionarios.js" type="text/javascript"></script>