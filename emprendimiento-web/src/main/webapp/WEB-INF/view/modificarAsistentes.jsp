<%-- 
    Document   : homepage
    Created on : 12/09/2018, 09:27:32 AM
    Author     : Andrés Felipe González Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<a  var="tempidsesiones" item="idsesion" type="hidden"></a>

<table class="table  table-bordered table-hover" >
    <thead
        <tr>
            <th>Id Sesión</th>
            <th>Nombres Beneficiario</th>
            <th>Apellidos Beneficiario</th>
            <th>Asistencia</th>
        </tr>
    </thead>
    <tbody 
        <c:forEach var="tempListaAsistencia" items="${listaAsistencia}">
            <tr>
                <td>${tempListaAsistencia.sesiones.idsesion} </td>
                <td class="noOverflow">${tempListaAsistencia.beneficiario.primernombre} ${tempListaAsistencia.beneficiario.segundonombre}</td>
                <td class="noOverflow">${tempListaAsistencia.beneficiario.primerapellido} ${tempListaAsistencia.beneficiario.segundoapellido}</td>
                <td> <a class="asistencia">  <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="a${tempListaAsistencia.beneficiario.idbeneficiario}"  name="${tempListaAsistencia.idasistencia}" class="custom-control-input" value="1" required="required" >

                            <label class="custom-control-label" for="a${tempListaAsistencia.beneficiario.idbeneficiario}">Si</label>
                        </div>
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio"  id="b${tempListaAsistencia.beneficiario.idbeneficiario}"  name="${tempListaAsistencia.idasistencia}" class="custom-control-input" value="0"  required="required" >

                            <label class="custom-control-label" for="b${tempListaAsistencia.beneficiario.idbeneficiario}">No</label>
                        </div></a></td>
            </tr>
        </c:forEach>

    </tbody>
</table>

<input type="hidden" id="idfuncionario" value="${idfuncionario}">
<button class="btn btn-primary" type="button" id="btnRegistro"  >Registrar Asistencia</button>



<script src="${pageContext.request.contextPath}/resources/js/services/modificarAsistencia.js" type="text/javascript"></script>

