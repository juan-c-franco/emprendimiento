<%-- 
    Document   : registrarAsistencia2E
    Created on : nov 29, 2018, 11:38:22 a.m.
    Author     : Andres Felipe Gonzalez M Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<h3>Registrar Asistencia</h3>
<hr />
<p>Registre asistencia de los beneficiarios de la sesión</p>

<a  var="tempidsesiones" item="idsesion" type="hidden"></a>
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
<c:if test="${not empty listaAsistencia}">
    <div id="valora">
        <table id="tableData" class="table table-bordered table-striped" >
            <thead
                <tr>
                    <th>Id Sesión</th>
                    <th>Tipo Documento</th>
                    <th>Número de Documento</th>
                    <th>Nombres Beneficiario</th>
                    <th>Apellidos Beneficiario</th>
                    <th>Asistencia</th>
                </tr>
            </thead>
            <c:set var="count" value="0" scope="page" />

            <tbody >

                <c:forEach var="tempListaAsistencia" items="${listaAsistencia}">
                    <tr>
                        <td >${tempListaAsistencia.sesiones.idsesion} </td>
                        <td>${tempListaAsistencia.beneficiario.tipodocumentoid.nombredocumento}</td>
                        <td>${tempListaAsistencia.beneficiario.numerodocumento}</td>
                        <td class="noOverflow">${tempListaAsistencia.beneficiario.primernombre} ${tempListaAsistencia.beneficiario.segundonombre}</td>
                        <td class="noOverflow">${tempListaAsistencia.beneficiario.primerapellido} ${tempListaAsistencia.beneficiario.segundoapellido}</td>
                        <td>
                            <a class="asistencia">

                                <div class="form-group">

                                    <div class="controls">
                                        <fieldset>
                                            <div class="custom-control custom-radio">
                                                <input type="radio"
                                                       value="1"
                                                       name="${tempListaAsistencia.idasistencia}"
                                                       id="a${tempListaAsistencia.beneficiario.idbeneficiario}"
                                                       class="custom-control-input"
                                                       data-validation-required-message="Seleccione alguna opción"
                                                       required />
                                                <label class="custom-control-label" for="a${tempListaAsistencia.beneficiario.idbeneficiario}">Si</label>
                                            </div>
                                        </fieldset>
                                        <fieldset>
                                            <div class="custom-control custom-radio">
                                                <input type="radio"
                                                       value="0"
                                                       name="${tempListaAsistencia.idasistencia}"
                                                       id="b${tempListaAsistencia.beneficiario.idbeneficiario}"
                                                       class="custom-control-input">
                                                <label class="custom-control-label" for="b${tempListaAsistencia.beneficiario.idbeneficiario}">No</label>
                                            </div>
                                        </fieldset>
                                    </div>
                                </div>

                            </a>
                        </td>

                        <%--                    <td> <a class="asistencia"> <div class="controls"> 
                                    
                                <div class="custom-control custom-radio custom-control-inline">
    
                                    <input type="radio" id="a${tempListaAsistencia.beneficiario.idbeneficiario}"  name="${tempListaAsistencia.idasistencia}" class="custom-control-input" value="1" data-validation-required-message="Seleccione una de las opciones" required="required" >
    
                                    <label class="custom-control-label" for="a${tempListaAsistencia.beneficiario.idbeneficiario}">Si</label>
                                </div>
                                <div class="custom-control custom-radio custom-control-inline">
                                    <input type="radio"  id="b${tempListaAsistencia.beneficiario.idbeneficiario}"  name="${tempListaAsistencia.idasistencia}" class="custom-control-input" value="0">
    
                                    <label class="custom-control-label" for="b${tempListaAsistencia.beneficiario.idbeneficiario}">No</label>
                                </div>
                                </div></a>
                        </td>--%>

                    </tr>
                </c:forEach>

            <input type="hidden" id ="idsesion" value="${idsesion}">
            <input type="hidden" id ="idfuncionario" value="${idfuncionario}">
            <input type="hidden" id ="idestadosesion" value="${idestadosesion}">
            </tbody>


        </table>
    </div>
    <div class="text-center">
        <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
        <button class="btn btn-success align-content-center" type="button" id="btnRegistro">Registrar</button>
    </div>


    <forEach>

    </forEach>
    <br/>
    <br/>

    <!--<button type="button" id="btnRegistro2" class="btn btn-primary"> Lista de Inasistentes </button>-->
</c:if>

<script src="${pageContext.request.contextPath}/resources/js/services/registrarAsistenciaE.js" type="text/javascript"></script>
<script>
    <c:if test="${not empty idFuncionario}">
    idfuncionario = ${idFuncionario};
    </c:if>
</script>