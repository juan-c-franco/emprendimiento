<%-- 
    Document   : confirmarTemasRuta
    Created on : nov 19, 2018, 1:06:40 p.m.
    Author     : Andres Felipe Gonzalez Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!-- Contenido de la pagina  -->
<h3>Temas Ruta</h3>
<hr />
<p>Los siguientes son los temas y horas recomendadas</p>

<c:if test="${not empty mensaje}">
    <c:if test="${status == '1'}">
        <div class="alert alert-success"> <i class="fa fa-check-circle"></i> ${mensaje} 
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
    <c:if test="${status == '0'}">

        <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
</c:if>
<c:if test="${status=='1'}">
    <div id="valida">
        <div class="form-group">
            <table id="tableData" class="table table-bordered table-striped">

                <thead>
                    <tr>
                        <th >Tema</th>
                        <th >Cantidad de Horas</th>

                    </tr>
                </thead>

                <tbody>

                    <c:forEach items="${temasRuta}" var="tempTemas" >

                        <tr>
                            <td class="noOverflow"><a class="temasN">${tempTemas.nombretema}</a></td>

                            <td><div class="controls"><a class="temas"> <input type="NumericTextBox" min="0" class="form-control col-4 only-number" data-name="${tempTemas.nombretema}" name="${tempTemas.nombretema}" value="${tempTemas.cantidadhorasplaneadas}" required="required" data-validation-required-message="Ingrese la cantidad de horas" /></a></div></td>

                        </tr>
                    </c:forEach>

                </tbody>

            </table>
        </div>
    </div>
    <div class="text-center">
        <button class="btn btn-primary m-b-30" id="botonAgregar">Agregar Tema</button>
        <br/>
        <br/>
        <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
        <button class="btn btn-success" id="btnGuardar">Guardar Temas</button>
    </div>

    <input type="hidden" id="idruta" value="${idruta}">
    <input type="hidden" id="idBeneficiario" value="${idBeneficiario}">

</c:if>

<!-- Modal -->
<div id="modalComprobar" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalComprobarLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalComprobarLabel">label</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="row"  >
                    <div class="col-8">
                        <div class="form-group">
                            <c:if test="${statusindividuales == '1'}">
                                <label for="temaI">Temas</label>
                                <div class="controls">
                                    <select class="form-control selectpicker" data-style="btn-info" id="temaI" data-validation-required-message="Seleccione un Tema" required="required"> 
                                        <option selected value="">Seleccione...</option>
                                        <c:forEach items="${temasIndividuales}" var="tempTemasInd">
                                            <option value="${tempTemasInd.nombrecapacitacionprograma}">${tempTemasInd.nombrecapacitacionprograma}</option>   
                                        </c:forEach>
                                    </select>
                                </div>
                            </c:if>
                            <c:if test="${statusindividuales == '0'}">
                                <div class="controls">
                                    <select class="form-control selectpicker" data-style="btn-info" id="temaI" data-validation-required-message="Seleccione un Tema" required="required"> 
                                        <option selected value="">${mensajeIndividuales}</option>
                                    </select>
                                </div>
                            </c:if>
                        </div>
                    </div>
                    <div class="col-4">
                        <div class="form-group">
                            <label for="horaI">Horas</label>
                            <div class="controls">
                                <input class="form-control only-number" type="NumericTextBox" min="0" placeholder="Cantidad de Horas" 
                                       data-validation-required-message="Ingrese la cantidad de horas"
                                       required="required" id="horaI"/>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
            <div class="modal-footer">
                <div class="text-center">
                    <button class="btn btn-danger align-content-center" type="button" data-dismiss="modal" >Cancelar</button>
                    <button type="button" id="btnModalComprobar" class="btn btn-success">Agregar</button>
                </div>
                <!--                <button class="btn btn-alert" type="button" data-dismiss="modal">Cancelar</button>
                                <a class="btn btn-success" id="btnModalComprobar">Agregar Tema</a>-->
            </div>
        </div>
    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/services/confirmarTemasRuta.js" type="text/javascript"></script>
<script>
    $('#modalComprobar').modal("hide");
</script>


