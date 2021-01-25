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
    <h3>Programar Capacitación</h3>
    <hr/>

    <c:if test="${not empty url}">
        <input type="hidden" id="url" value="${url}">
    </c:if>

    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label>Oferente / Institución</label>
                <c:if test="${empty oferentes}">
                    <div class="controls">
                        <select id="idoferente" name="idoferente" class="form-control selectpicker m-b-20 m-r-10" data-style="btn-info" disabled 
                                data-validation-required-message="Campo Obligatorio" required>
                            <option value="" >
                                -- No hay oferentes parametrizados --
                            </option>
                        </select>
                    </div>
                </c:if>
                <c:if test="${not empty oferentes}">
                    <div class="controls">
                        <select id="idoferente" name="idoferente" class="form-control selectpicker m-b-20 m-r-10" data-style="btn-info" 
                                data-validation-required-message="Campo Obligatorio" required>
                            <option value ="" selected>-- Seleccione Oferente -- </option>
                            <c:forEach items="${oferentes}" var="temp" >
                                <option value="${temp.id}" >${temp.nombreInstitucion}</option>
                            </c:forEach>
                        </select>
                    </div>
                </c:if>
            </div>
        </div>


        <div class="col-sm-6">
            <div class="form-group">
                <label>Sede</label>
                <div class="controls">
                    <select id="idsede" name="idsede" class="form-control selectpicker m-b-20 m-r-10" data-style="btn-info" disabled 
                            data-validation-required-message="Campo Obligatorio" required>
                        <option value ="" selected> -- Seleccione Sede -- </option>
                    </select>
                </div>
            </div>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-6">
            <div class="form-group">
                <label>Capacitación</label>


                <c:if test="${empty capacitaciones}">
                    <div class="controls">
                        <select id="idcapacitacion" name="idcapacitacion" class="form-control selectpicker m-b-20 m-r-10" data-style="btn-info" disabled 
                                data-validation-required-message="Campo Obligatorio" required>
                            <option value="" >
                                -- No hay Capacitaciones parametrizadas --
                            </option>
                        </select>
                    </div>
                </c:if>
                <c:if test="${not empty capacitaciones}">
                    <div class="controls">
                        <select id="idcapacitacion" name="idcapacitacion" class="form-control selectpicker m-b-20 m-r-10" data-style="btn-info" 
                                data-validation-required-message="Campo Obligatorio" required>
                            <option value ="" selected>-- Seleccione Capacitación -- </option>
                            <c:forEach items="${capacitaciones}" var="temp" >
                                <option value="${temp.idcapacitacionprograma}" >${temp.nombrecapacitacionprograma}</option>
                            </c:forEach>
                        </select>
                    </div>
                </c:if>
            </div>
        </div>


        <div class="col-sm-6">
            <div class="form-group">
                <label>Docente</label>


                <c:if test="${empty docentes}">
                    <div class="controls">
                        <select id="iddocente" name="iddocente" class="form-control selectpicker m-b-20 m-r-10" data-style="btn-info" disabled 
                                data-validation-required-message="Campo Obligatorio" required >
                            <option value="" >
                                -- No hay Docentes parametrizadas --
                            </option>
                        </select>
                    </div>
                </c:if>
                <c:if test="${not empty docentes}">
                    <div class="controls">
                        <select id="iddocente" name="iddocente" class="form-control selectpicker m-b-20 m-r-10" data-style="btn-info" 
                                data-validation-required-message="Campo Obligatorio" required>
                            <option value ="" selected>-- Seleccione Docente -- </option>
                            <c:forEach items="${docentes}" var="temp" >
                                <option value="${temp.iddocente}" >

                                    <c:if test="${not empty temp.primernombre}">
                                        ${temp.primernombre} 
                                    </c:if>
                                    <c:if test="${not empty temp.segundonombre}">
                                        ${temp.segundonombre} 
                                    </c:if>
                                    <c:if test="${not empty temp.primerapellido}">
                                        ${temp.primerapellido} 
                                    </c:if>
                                    <c:if test="${not empty temp.segundoapellido}">
                                        ${temp.segundoapellido} 
                                    </c:if>
                                </option>
                            </c:forEach>
                        </select>
                    </div>
                </c:if>
            </div>
        </div>
    </div>

    <br /><hr/>
    <div class="text-center">
        <button type="button" id="btnConsulta" class="btn btn-primary"> <i class="mdi mdi-magnify"></i> Ver disponibilidad </button>
    </div>

</div> <!-- End loadFrame -->

<script src="${pageContext.request.contextPath}/resources/_dist/js/services/capacitacion/setIdDocente.js" type="text/javascript"></script>
<script>
    <c:if test="${not empty idFuncionario}">
    idfuncionario = ${idFuncionario};
    </c:if>
</script>