<%-- 
    Document   : confirmarTemasRutaAComp
    Created on : nov 21, 2018, 2:24:06 a.m.
    Author     : Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!-- Contenido de la pagina  -->
<h3>Temas de Acompañamiento</h3>
<hr />
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
<c:if test="${status=='1'}">

    <div id="valida">
        <div class="form-group">
            <table  id="tableData" class="table table-bordered table-striped">
                <thead >
                    <tr>
                        <th >Tema</th>
                        <th >Cantidad de Horas</th>

                    </tr>
                </thead>
                <tbody>
                    <!--        <div id="valora">-->
                    <c:forEach items="${temasRuta}" var="tempTemas" varStatus="loop">

                        <tr>
                            <td class="noOverflow">${tempTemas.temasevaluacion.nombretema}</td>
                            <td><div class="controls"> 
                                    <a class="temas">
                                        <input type="NumericTextBox" id="${loop.index}" min="0" class="form-control col-4" data-id${loop.index}="${tempTemas.temasevaluacion.idtema}" data-name${loop.index}="${tempTemas.temasevaluacion.nombretema}" value="${tempTemas.cantidadhorasplaneadas}" required="required" data-validation-required-message="Ingrese la cantidad de horas" />

                                    </a>
                                </div>
                            </td>

                        </tr>

                    </c:forEach>
                    <!--        </div>-->
                </tbody>
            </table>
        </div>
    </div>
    <div id="validaSalto">



        <div class="row">
            <div class="col-md-6">
                <div class="form-group">
                    <h6>Use esta opción si considera que el beneficiario no debe asistir a sesiones de capacitación</h6>
                    <div class="controls">
                        <div class="custom-control custom-checkbox">
                            <input type="checkbox"
                                   value="single"
                                   class="custom-control-input"
                                   id="saltarFases"
                                   />
                            <label class="custom-control-label" for="saltarFases">Saltar Fases</label>
                        </div>
                    </div>
                </div>
            </div>

        </div>


        <!--            <div class="form-group col-md-6 ">
                        <div class="controls">
                            <label for="saltarFases">Saltar Fases</label><br>
                            <input type="checkbox" id="saltarFases" name="saltarFases">
                        </div>
                    </div>-->
        <div class="form-group col-md-4 ">
            <div class="controls">
                <label for="idEstadoASaltar">Fases</label><br>
                <select id="idEstadoASaltar" name="idEstadoASaltar" class="selectpicker m-b-20 m-r-10" data-style="btn-info" data-validation-required-message="Seleccione una fase a la cual avanzar"> 
                    <option value="" selected> -- seleccione -- </option>
                    <option value="10"> Evaluación y Financiación</option>
                    <option value="7"> Finalizado</option>
                </select>
            </div>
        </div>

    </div>
    <div class="text-center">
        <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
        <button class="btn btn-success" id="btnGuardar">Guardar</button>
    </div>
    <input type="hidden" id="idEmprendimiento" value="${idEmprendimiento}">
    <input type="hidden" id="idruta" value="${idruta}">
</c:if>


<script src="${pageContext.request.contextPath}/resources/js/services/confirmarTemasRutaAcomp.js" type="text/javascript"></script>
