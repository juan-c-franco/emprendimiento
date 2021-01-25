<%-- 
    Document   : modificarInstituciones
    Created on : jun 26, 2019, 6:28:27 p.m.
    Author     : Andres Gonzalez
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Editar Institución / Oferente</h3>
<hr />
<p>Diligencie el siguiente formulario</p>

<c:if test="${status == '1'}">
    <div id="valora">

        <div class="form-row">
            <div class="form-group col-md-6">
                <div class="controls">
                    <label for="nombreInstitucion">Nombre Institución<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="nombreInstitucion" name="nombreInstitucion"
                           placeholder="Nombre Institución..." required="required" 
                           data-validation-required-message="Ingrese el nombre de la institución" maxlength="50" 
                           value="${institucion.nombreInstitucion}">
                </div>
            </div>
            <div class="form-group col-md-6">
                <div class="controls">
                    <label for="nit">NIT<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="nit" name="nit" placeholder="NIT..." 
                           required="required" data-validation-required-message="Ingrese el NIT" 
                           maxlength="15" value="${institucion.nit}">
                </div>
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <div class="controls">
                    <label for="email">Email<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="email"
                           name="email" placeholder="Email" required="required" 
                           data-validation-required-message="Ingrese Email"
                           data-validation-regex-regex="([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})"
                           data-validation-regex-message="Email no Valido" maxlength="180"
                           value="${institucion.correoElectronico}">
                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="naturalezaJuridica">Naturaleza Jurídica<span class="text-danger">*</span></label>
                <div class="controls">
                    <select id="naturalezaJuridica" class="selectpicker" data-style="btn-info" name="naturalezaJuridica" required data-validation-required-message="Seleccione Naturaleza Jurídica">
                        <option value="">Seleccione...</option>
                        <c:if test="${institucion.naturalezaJuridica == 0}">
                            <option value="0" selected>Persona Natural</option>
                            <option value="1">Persona Jurídica</option> 
                        </c:if>
                        <c:if test="${institucion.naturalezaJuridica == 1}">
                            <option value="0" >Persona Natural</option>
                            <option value="1" selected>Persona Jurídica</option> 
                        </c:if>
                    </select>
                </div>
            </div>
        </div>
        <div class="form-row">

            <div class="form-group col-md-6">
                <div class="controls">
                    <label for="telefono">Teléfono</label>
                    <input type="NumericTextBox" class="form-control only-number" id="telefono" name="telefono" placeholder="Teléfono" min="0"
                           minlength="7" maxlength="15" 
                           data-validation-maxlength-message="El número de teléfono debe tener máximo 15 caracteres" 
                           data-validation-minlength-message="El número de teléfono debe tener mínimo 7 caracteres"
                           value="${institucion.numeroTelefono}">
                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="origen">Origen<span class="text-danger">*</span></label>
                <div class="controls">
                    <select id="origen" class="selectpicker" data-style="btn-info" name="origen" required data-validation-required-message="Seleccione Origen">
                        <option value="">Seleccione...</option>
                        <option value="1" <c:if test="${institucion.origen=='1'}">selected</c:if>>Público</option>
                        <option value="2" <c:if test="${institucion.origen=='2'}">selected</c:if>>Privado</option>  
                        <option value="3" <c:if test="${institucion.origen=='3'}">selected</c:if>>Mixto</option>  
                        </select>
                    </div>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="tipoInstitucion">Tipo de Institución<span class="text-danger">*</span></label>
                    <div class="controls">
                        <select id="tipoInstitucion" class="selectpicker" data-style="btn-info" name="tipoInstitucion" required data-validation-required-message="Seleccione Tipo de Institución">
                            <option value="">Seleccione...</option>
                            <option value="1" <c:if test="${institucion.tipoInstitucionId==1}">selected</c:if>>CCF</option>
                        <option value="2" <c:if test="${institucion.tipoInstitucionId==2}">selected</c:if>>IETDH</option>
                        <option value="3" <c:if test="${institucion.tipoInstitucionId==3}">selected</c:if>>UVAES</option>
                        <option value="4" <c:if test="${institucion.tipoInstitucionId==4}">selected</c:if>>SENA</option>
                        <option value="5" <c:if test="${institucion.tipoInstitucionId==5}">selected</c:if>>OTRA</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-md-6">
                    <label for="tipoCertificacion">Tipo de Certificación<span class="text-danger">*</span></label>
                    <div class="controls">
                        <select id="tipoCertificacion" class="selectpicker" data-style="btn-info" name="tipoCertificacion" required data-validation-required-message="Seleccione Tipo de Certificación">
                            <option value="">Seleccione...</option>
                            <option value="1" <c:if test="${institucion.tipoCertificacion==1}">selected</c:if>>NTC 6094</option>
                        <option value="2" <c:if test="${institucion.tipoCertificacion==2}">selected</c:if>>NTC 5555</option>
                        <option value="3" <c:if test="${institucion.tipoCertificacion==3}">selected</c:if>>ISO 9001</option>
                        </select>
                    </div>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="estadoAprobacion">Estado de Aprobación<span class="text-danger">*</span></label>
                    <div class="controls">
                        <select id="estadoAprobacion" class="selectpicker" data-style="btn-info" name="estadoAprobacion" required data-validation-required-message="Seleccione Estado de Aprobación">
                            <option selected value="">Seleccione...</option>
                            <option value="1" <c:if test="${institucion.estadoAprobacion=='1'}">selected</c:if>>Aprobada</option>
                        <option value="2" <c:if test="${institucion.estadoAprobacion=='2'}">selected</c:if>>No Aprobada</option>
                        <option value="3" <c:if test="${institucion.estadoAprobacion=='3'}">selected</c:if>>Rechazada</option>
                        </select>
                    </div>
                </div>
                <div class="form-group col-md-6">
                    <label for="estado">Estado<span class="text-danger">*</span></label>
                    <div class="controls">
                        <select id="estado" class="selectpicker" data-style="btn-info" name="estado" required data-validation-required-message="Seleccione Estado">
                            <option selected value="">Seleccione...</option>
                            <option value="0" <c:if test="${institucion.estado=='0'}">selected</c:if>>Inactiva</option>
                        <option value="1" <c:if test="${institucion.estado=='1'}">selected</c:if>>Activa</option>       
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




<script src="${pageContext.request.contextPath}/resources/js/services/modificarInstituciones.js" type="text/javascript"></script>
<script>
    var id = ${institucion.id}
</script>
