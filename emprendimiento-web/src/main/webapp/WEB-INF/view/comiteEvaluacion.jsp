<%-- 
    Document   : comiteEvaluacion
    Created on : 17/10/2018, 10:30:06 PM
    Author     : Danny Fernando Guerrero Gelpud
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<link href="${pageContext.request.contextPath}/resources/_assets/modules/multiselect/css/multi-select.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/_assets/modules/bootstrap-tagsinput/dist/bootstrap-tagsinput.css" rel="stylesheet">


<!--<h5>${mensaje}</h5>-->
<h3>Parametrizar Comité de Evaluación</h3>
<hr />
<c:if test="${status=='adm'}">
    <p>Seleccione la caja de compensación</p>   
</c:if>
<c:if test="${idComite!=null}">
    <p>Seleccione los funcionarios que harán parte del comité de evaluación</p>
</c:if>


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
<input type="hidden" id="idComite" name="idComite" value="${idComite}" />
<input type="hidden" id="idCajaCompensacion" name="idCajaCompensacion" value="${idCajaCompensacion}" />
<div class="form-row row justify-content-md-center">
    <c:if test="${status=='adm'}">
        <div id="divCaja" class="form-group col-sm-12">
            <div class="controls">
                <select required="required" class="selectpicker m-b-20 m-r-10" data-style="btn-info" name="cajaId" id="cajaId"
                        data-validation-required-message="Campo Obligatorio" required> 
                    <option value="" label="Seleccione ..." selected="selected">Seleccione ...</option>
                    <c:forEach items="${cajas}" var="caja">
                        <c:if test="${cajaId == caja.idcajacompensacion}">
                            <option style=" heigth : 1px" value="${caja.idcajacompensacion}" selected>${caja.nombrecajacompensacion}</option>
                        </c:if>
                        <c:if test="${cajaId != caja.idcajacompensacion}">
                            <option style=" heigth : 1px" value="${caja.idcajacompensacion}">${caja.nombrecajacompensacion}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
        </div>
    </c:if>
    <c:if test="${idComite!=null}">
        <!--        <div class="row text-center">-->

        <div class="col-sm-12 row justify-content-md-center m-b-20">
            <!--                <label for ="usuarioComiteId" class="box-title">Integrantes Del Comité</label>-->
            <select 
                id='usuarioComiteId' 
                name="usuarioComiteId"
                multiple='multiple'>
                <c:if test="${empty usuariosComiteDTO}">
                    <option selected disabled>No hay integrantes de comité parametrizados, contacte al administrador del sistema</option>
                </c:if>
                <c:if test="${not empty usuariosComiteDTO}">
                    <c:forEach var="usuarioComite" items="${usuariosComiteDTO}" varStatus="status">
                        <option name="usuarioComiteId_<c:out value="${usuarioComite.idFuncionario}"/>" value="<c:out value="${usuarioComite.idFuncionario}"/>">
                            <c:out value="${usuarioComite.nombres} ${usuarioComite.apellidos} - ${usuarioComite.groupName}" escapeXml="false"/>
                        </option>
                    </c:forEach>
                </c:if>
            </select>
        </div>
        <!--        </div>-->
    </c:if>
    <!-- row -->
    <%-- Seleccionador de integrantes comite viejo 
    <c:if test="${idComite!=null}">
        <table class="table">
            <tr>
                <td>
                    <label for="usuarioComiteId">Funcionarios</label>
                    <select name="usuarioComiteId" multiple="multiple"
                            id="usuarioComiteId" size="5">
        <c:if test="${usuariosComiteDTO != null}">
            <c:forEach var="usuarioComite" items="${usuariosComiteDTO}" varStatus="status">
                <option name="usuarioComiteId_<c:out value="${usuarioComite.idFuncionario}"/>" value="<c:out value="${usuarioComite.idFuncionario}"/>">
                <c:out value="${usuarioComite.nombres} ${usuarioComite.apellidos} - ${usuarioComite.groupName}" escapeXml="false"/>
            </option>
            </c:forEach>
        </c:if>
    </select>
</td>
<td class="moveOptions">
    <button name="moverDerBtn" id="moverDerBtn" type="button" 
            onclick="moverOpcionesSeleccionada('usuarioComiteId', 'integrantesComiteId')">
        &gt;&gt;</button><br />
    <button name="moverIzqBtn" id="moverIzqBtn" type="button"
            onclick="moverOpcionesSeleccionada('integrantesComiteId', 'usuarioComiteId')">
        &lt;&lt;</button><br />
</td>
<td>
    <label for="integrantesComiteId">Integrantes del Comite</label>
    <select name="integrantesComiteId" multiple="multiple"
            id="integrantesComiteId" size="5">
        <c:if test="${integrantesComiteDTO != null}">
            <c:forEach var="integranteComite" items="${integrantesComiteDTO}" varStatus="status">
                <option name="integrantesComiteId_<c:out value="${integranteComite.idFuncionario}"/>" value="<c:out value="${integranteComite.idFuncionario}"/>">
                <c:out value="${integranteComite.nombres} ${integranteComite.apellidos} - ${integranteComite.groupName}" escapeXml="false"/>
            </option>
            </c:forEach>
        </c:if>
    </select>
</td>
</tr>
</table>
    </c:if>
     fin del seleccionador de integrantes viejo --%>
</div>

<div class="text-center">
    <a href="${pageContext.request.contextPath}/" class="btn btn-danger" role="button">Atrás</a>
    <c:if test="${status=='adm'}">
        <button type="submit" id="btnParametrizarComite" class="btn btn-success">Parametrizar</button>
    </c:if>
    <c:if test="${idComite!=null}">
        <button type="button" id="btnGuardar" class="btn btn-success" >Guardar</button>
    </c:if>
</div>
<script>
    var integrantes = [];
    <c:forEach var="integranteComite" items="${integrantesComiteDTO}">
    integrantes.push("${integranteComite.idFuncionario}");
    </c:forEach>

</script>
<script src="${pageContext.request.contextPath}/resources/js/services/comiteEvaluacion.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/_assets/modules/multiselect/js/jquery.multi-select.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/_assets/modules/bootstrap-tagsinput/dist/bootstrap-tagsinput.min.js" type="text/javascript"></script>
