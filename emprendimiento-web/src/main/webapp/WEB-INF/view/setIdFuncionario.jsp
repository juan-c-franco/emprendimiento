<%-- 
    Document   : homepage
    Created on : 09/11/2018
    Author     : Juan Carlos Franco
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<div id="loadFrame">

    <!-- Filtro -->
    <h3>Buscar Funcionario</h3>
    <hr/>

    <c:if test="${not empty url}">
        <input type="hidden" id="url" value="${url}">
    </c:if>
    <c:if test="${empty cajasDTO}">
        <input type="hidden" id="idcajacompensacion" value="${caja}">
    </c:if>
    <c:if test="${not empty grupo}">
        <input type="hidden" id="grupo" value="${grupo}">
    </c:if>
    <c:if test="${not empty idbeneficiario}">
        <input type="hidden" id="idbeneficiario" value="${idbeneficiario}">
    </c:if>

    <div class="row">


        <div class="col-sm-6">
            <label>Caja de Compensación</label>

            <c:if test="${empty cajasDTO}">  
                <select id="idcajacompensacion" name="idcajacompensacion" class="selectpicker m-b-20 m-r-10" data-style="btn-info" disabled >
                    <c:if test="${empty cajaN}">
                        <option value="" >
                            Seleccione Caja de Compensación
                        </option>
                    </c:if>
                    <c:if test="${not empty cajaN}">
                        <option value="${cajaID}" >
                            ${cajaN}
                        </option>
                    </c:if>
                </select>
            </c:if>
            <c:if test="${not empty cajasDTO}">
                <select id="idcajacompensacion" name="idcajacompensacion" class="selectpicker m-b-20 m-r-10" data-style="btn-info" >
                    <option value ="-1" selected>-- Seleccione Caja de Compensación -- </option>
                    <c:forEach items="${cajasDTO}" var="tempCajas" >
                        <option value="${tempCajas.idcajacompensacion}" >${tempCajas.nombrecajacompensacion}</option>
                        <!--<c:if test="${idcajacompensacion == tempCajas.idcajacompensacion}">
                            <option value ="${tempCajas.idcajacompensacion}" selected>${tempCajas.nombrecajacompensacion}</option>
                        </c:if> 
                        <c:if test="${idcajacompensacion != tempCajas.idcajacompensacion}"> 
                            
                        </c:if>-->
                    </c:forEach>
                </select>
            </c:if>
        </div>


        <div class="col-sm-6">
            <label>Funcionario</label>
            <select id="idfuncionario" name="idfuncionario" class="selectpicker m-b-20 m-r-10" data-style="btn-info" <c:if test="${empty sensibilizadores}">disabled="true"</c:if>>
                <c:if test="${not empty sensibilizadores}">
                    <c:forEach items="${sensibilizadores}" var="temp" >
                        <option value ="${temp.idfuncionario}">${temp.primernombre} ${temp.segundonombre} ${temp.primerapellido} ${temp.segundoapellido}</option>
                    </c:forEach>
                </c:if>
                <c:if test="${empty sensibilizadores}">
                    <option value ="-1" selected> -- Seleccione Funcionario -- </option>
                </c:if>
            </select>
        </div>

        <div class="col-md-12 form-actions m-t-20 text-center">
            <c:if test="${empty cajasDTO}">   
                <button type="button" id="btnConsulta" onclick="cargarDatosPagina()" class="btn btn-primary" > <i class="mdi mdi-magnify"></i> Consultar Funcionario</button>
            </c:if>
            <c:if test="${not empty cajasDTO}">
                <button type="button" id="btnConsulta" onclick="cargarDatosPagina()" class="btn btn-primary" disabled="true"> <i class="mdi mdi-magnify"></i> Consultar Funcionario</button>
            </c:if>
        </div>

    </div>

    <br /><hr />

</div> <!-- End loadFrame -->

<script src="${pageContext.request.contextPath}/resources/_dist/js/services/setIdFuncionario.js" type="text/javascript"></script>
<script>
                    var idBeneficiario = null;
    <c:if test="${not empty idBeneficiario}">
                    idBeneficiario = ${idBeneficiario};
    </c:if>
</script>