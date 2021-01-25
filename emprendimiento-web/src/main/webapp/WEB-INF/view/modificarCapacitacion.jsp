<%-- 
    Document   : modificarCapacitacion
    Created on : jul 4, 2019, 10:24:50 a.m.
    Author     : Andres Gonzalez
--%>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Editar Capacitación / Programa</h3>
<hr />
<p>Diligencie el siguiente formulario</p>
<c:if test="${status == '1'}">
    <div id="valora">

        <div class="form-row">
            <div class="form-group col-md-6">
                <div class="controls">
                    <label for="nombreCapacitacion">Nombre Capacitación<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="nombreCapacitacion" name="nombreCapacitacion"
                           placeholder="Nombre Capacitación..." required="required" tabindex="0"
                           data-validation-required-message="Ingrese el nombre de la institución" maxlength="200" value="${capacitacion.nombrecapacitacionprograma}">
                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="idOferenteInstitucion">Institución / Oferente<span class="text-danger">*</span></label>
                <div class="controls">
                    <select id="idOferenteInstitucion" class="selectpicker" data-style="btn-info" name="idOferenteInstitucion" required data-validation-required-message="Seleccione Institución/Oferente">
                        <option value="">Seleccione...</option>
                        <c:forEach items="${instituciones}" var="tempInst">
                            <c:if test="${tempInst.id == capacitacion.idoferenteinstitucion}">
                                <option value="${tempInst.id}" selected>${tempInst.nombreInstitucion}</option>
                            </c:if>
                            <c:if test="${tempInst.id != capacitacion.idoferenteinstitucion}">
                                <option value="${tempInst.id}">${tempInst.nombreInstitucion}</option>
                            </c:if>

                        </c:forEach> 

                    </select>
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="categorias">Categoría<span class="text-danger">*</span></label>
                <div class="controls">

                    <select id="categorias" class="selectpicker" data-style="btn-info" name="categorias" required data-validation-required-message="Seleccione Categoría">
                        <option value="">Seleccione...</option>
                        <c:forEach items="${categorias}" var="tempCat">
                            <c:if test="${tempCat.idcategoria == capacitacion.categoria.idcategoria}">
                                <option value="${tempCat.idcategoria}" selected>${tempCat.nombrecategoria}</option>
                            </c:if>
                            <c:if test="${tempCat.idcategoria != capacitacion.categoria.idcategoria}">
                                <option value="${tempCat.idcategoria}">${tempCat.nombrecategoria}</option>
                            </c:if>
                        </c:forEach> 
                    </select>




                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="estados">Estado<span class="text-danger">*</span></label>
                <div class="controls">

                    <select id="estados" class="selectpicker" data-style="btn-info" name="estados" required data-validation-required-message="Seleccione Estado">
                        <option value="">Seleccione...</option>
                        <c:forEach items="${estados}" var="tempEstados">
                            <c:if test="${tempEstados.idestadocapacitacionprograma == capacitacion.estadocapacitacionprograma.idestadocapacitacionprograma}">
                                <option value="${tempEstados.idestadocapacitacionprograma}" selected>${tempEstados.nombreestadocapacitacionprog}</option>
                            </c:if>
                            <c:if test="${tempEstados.idestadocapacitacionprograma != capacitacion.estadocapacitacionprograma.idestadocapacitacionprograma}">
                                <option value="${tempEstados.idestadocapacitacionprograma}">${tempEstados.nombreestadocapacitacionprog}</option>
                            </c:if>
                        </c:forEach> 
                    </select>
                </div>
            </div>

        </div>
    </div>
    <div class="text-center">
        <button class="btn btn-danger align-content-center float-center" type="button" id="btn-Cancelar">Atrás</button>
        <button type="button" id="btnRegistro" class="btn btn-success float-center">Guardar</button>    
    </div>
</c:if>           
<c:if test="${status == '0'}">
    <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje}
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
    </div>

    <div class="text-center">
        <button class="btn btn-danger align-content-center float-center" type="button" id="btn-Cancelar">Atrás</button>   
    </div>
</c:if>            

<script src="${pageContext.request.contextPath}/resources/js/services/modificarCapacitacion.js" type="text/javascript"></script>
<script>
    var idcapacitacionprograma = ${capacitacion.idcapacitacionprograma}
</script>