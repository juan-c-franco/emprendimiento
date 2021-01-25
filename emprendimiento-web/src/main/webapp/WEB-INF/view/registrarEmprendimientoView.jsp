<%-- 
    Document   : registrarEmprendimiento
    Created on : nov 13, 2018, 10:19:36 a.m.
    Author     : Andres Felipe Gonzalez M Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<link href="${pageContext.request.contextPath}/resources/_assets/modules/multiselect/css/multi-select.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/_assets/modules/bootstrap-tagsinput/dist/bootstrap-tagsinput.css" rel="stylesheet">


<h3 class="box-title">Registrar Emprendimiento</h3>
<hr />
<div id="basicos">

    <div class="row">
        <div class="col-sm-6 col-md-5">
            <div class="form-group">
                <label for="nombreEmprendimiento">Nombre Emprendimiento <span class="text-danger">*</span></label>
                <div class="controls">
                    <input type="text"
                           id="nombreEmprendimiento"
                           name="nombreEmprendimiento"
                           class="form-control"
                           placeholder="Nombre Emprendimiento"
                           data-validation-required-message="Ingrese Nombre del Emprendimiento"
                           required 
                           maxlength="200" data-validation-maxlength-message="Máximo 200 carácteres"
                           data-validation-maxlength-message="Máximo 200 carácteres"
                           tabindex="0"/>
                </div>
            </div>
        </div>

        <div class="col-sm-6 col-md-5 offset-md-1">
            <div class="form-group controls">    
                <label for="tEmprendimiento">Tipo Emprendimiento <span class="text-danger">*</span></label>
                <select 
                    id="tEmprendimiento" 
                    name="tEmprendimiento"
                    class="selectpicker" 
                    data-validation-required-message="Ingrese Tipo de Emprendimiento" 
                    required tabindex="0">
                    <c:if test="${empty tiposEmprendimiento}">
                        <option selected disabled>Error cargando tipos de emprendimiento</option>
                    </c:if>
                    <c:if test="${not empty tiposEmprendimiento}">
                        <c:forEach var="tiposAux" items="${tiposEmprendimiento}" varStatus="status">
                            <option name="tEmprendimiento_<c:out value="${tiposAux.idtipoemprendimiento}"/>" value="<c:out value="${tiposAux.idtipoemprendimiento}"/>">
                                <c:out value="${tiposAux.nombretipoemprendimiento}" escapeXml="false"/>
                            </option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>
        </div>
    </div><!-- row -->

    <div id="divSelector" class="row">
        <div class="col-md-6">
            <div class="form-group">
                <label>Formalizado <span class="text-danger">*</span></label>
                <fieldset class="controls">
                    <div class="custom-control custom-radio">
                        <input type="radio"
                               value="si"
                               name="formalizado"
                               id="siFormalizado"
                               class="custom-control-input"
                               data-validation-required-message="Seleccione una opción"
                               required tabindex="0"
                               checked/>
                        <label class="custom-control-label" for="siFormalizado">Si</label>
                    </div>
                </fieldset>
                <fieldset>
                    <div class="custom-control custom-radio">
                        <input type="radio"
                               value="no"
                               name="formalizado"
                               id="noFormalizado"
                               tabindex="0"
                               class="custom-control-input">
                        <label class="custom-control-label" for="noFormalizado">No</label>
                    </div>
                </fieldset>
            </div>
        </div>
    </div><!-- row -->

</div><!-- basicos -->


<div id='divFormalizado'>
    <h4 class="box-title m-t-40">Datos de Empresa</h4>
    <hr />
    <div class="row">
        <div class="col-sm-6 col-md-5">
            <div class="form-group">
                <label for="nombreEmpresa">Nombre Empresa <span class="text-danger">*</span></label>
                <div class="controls">
                    <input type="text"
                           id="nombreEmpresa"
                           name="nombreEmpresa"
                           class="form-control"
                           placeholder="Nombre Empresa"
                           maxlength="400" data-validation-maxlength-message="Máximo 400 carácteres"
                           data-validation-required-message="Ingrese Nombre de la Empresa"
                           required tabindex="0"/>
                </div>
            </div>
        </div>

        <div class="col-sm-6 col-md-5 offset-md-1">
            <div class="form-group">
                <label for="nit">NIT <span class="text-danger">*</span> (8 a 15 caracteres antes de validación)</label>
                <div class="controls">
                    <input type="text"
                           id="nit"
                           name="nit"
                           class="form-control"
                           placeholder="Número Identificación Tributaria"
                           data-validation-required-message="Ingrese NIT de la Empresa"
                           required
                           maxlength="15" data-validation-maxlength-message="Máximo 15 carácteres"
                           data-validation-regex-regex="\d{6,15}-\d{1}" 
                           data-validation-regex-message="NIT no válido. Ej. 123456789-1"
                           tabindex="0"/>
                </div>
            </div>
        </div>
    </div><!-- row -->


    <div class="row">
        <div class="col-sm-6 col-md-5">
            <div class="form-group">
                <label for="nRegistroMercantil">Número Registro Mercantil <span class="text-danger">*</span> (10 caracteres) </label>
                <div class="controls">
                    <input type="NumericTextBox"
                           id="nRegistroMercantil"
                           name="nRegistroMercantil"
                           class="form-control registroMercantil only-number"
                           placeholder="Número de Registro Mercantil de la Empresa"
                           data-validation-required-message="Ingrese Número de Registro Mercantil"
                           minlength="10" data-validation-minlength-message="El Número de Registro Mercantil debe tener 10 dígitos" 
                           maxlength="10" data-validation-maxlength-message="El Número de Registro Mercantil debe tener 10 dígitos"
                           data-validation-regex-regex="\d{10}" 
                           data-validation-regex-message="Registro Mercantil no válido. Ej. 0123456789"
                           required tabindex="0"/>
                </div>
            </div>
        </div>

        <div class="col-sm-6 col-md-5 offset-md-1">
            <div class="form-group">
                <label for="nombreRepresentante">Nombre Representante Legal <span class="text-danger">*</span></label>
                <div class="controls">
                    <input type="text"
                           id="nombreRepresentante"
                           name="nombreRepresentante"
                           class="form-control"
                           placeholder="Nombre Representante..."
                           maxlength="400" data-validation-maxlength-message="Máximo 400 carácteres"
                           data-validation-required-message="Ingrese Nombre del Representante Legal"
                           required tabindex="0"/>
                </div>
            </div>
        </div>
    </div><!-- row -->

    <div class="row">
        <div class="col-sm-6 col-md-5">
            <div class="form-group">
                <label for="direccion">Dirección <span class="text-danger">*</span></label>
                <div class="controls">
                    <input type="text"
                           id="direccion"
                           name="direccion"
                           class="form-control"
                           placeholder="Dirección de la Empresa"
                           maxlength="200" data-validation-maxlength-message="Máximo 200 carácteres"
                           data-validation-required-message="Ingrese Dirección de la Empresa"
                           required tabindex="0"/>
                </div>
            </div>
        </div>

        <div class="col-sm-6 col-md-5 offset-md-1">
            <div class="form-group">
                <label for="telefono">Teléfono <span class="text-danger">*</span></label>
                <div class="controls">
                    <input type="NumericTextBox"
                           id="telefono"
                           name="telefono"
                           class="form-control telefono only-number"
                           placeholder="Teléfono de la Empresa"
                           minlength="7" data-validation-minlength-message="El Número de Registro Mercantil debe tener 7 dígitos" 
                           maxlength="15" data-validation-maxlength-message="El Número de Registro Mercantil debe tener 15 dígitos"
                           data-validation-required-message="Ingrese Número de Teléfono de la Empresa"
                           required tabindex="0"/>
                </div>
            </div>
        </div>
    </div><!-- row -->

    <div class="row">
        <div class="col-sm-6 col-md-5">
            <div class="form-group">
                <label for="departamento">Departamento <span class="text-danger">*</span></label>
                <div class="controls">
                    <select 
                        id="departamento" 
                        name="departamento" 
                        class="selectpicker" 
                        data-validation-required-message="Ingrese Departamento" 
                        required tabindex="0">
                        <c:if test="${empty departamentos}">
                            <option selected value="">Error cargando departamentos</option>
                        </c:if>
                        <option selected value="">Seleccione un Departamento</option>
                        <c:if test="${not empty departamentos}">
                            <c:forEach var="departamentosAux" items="${departamentos}" varStatus="status">
                                <option name="departamento_<c:out value="${departamentosAux.id}"/>" value="<c:out value="${departamentosAux.id}"/>">
                                    <c:out value="${departamentosAux.nombre}" escapeXml="false"/>
                                </option>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
            </div>
        </div>

        <div class="col-sm-6 col-md-5 offset-md-1">
            <div class="form-group">
                <label for="municipio">Municipio <span class="text-danger">*</span></label>
                <div class="controls">
                    <select 
                        id="municipio" 
                        name="municipio"
                        class="selectpicker"                         
                        data-validation-required-message="Ingrese Municipio"
                        disabled="true"
                        required tabindex="0">
                        <option selected value="">Seleccione un Municipio</option>
                    </select>
                </div>
            </div>
        </div>
    </div><!-- row -->

    <div class="row">
        <div class="col-sm-6 col-md-5">
            <div class="form-group">
                <label for="email">Correo electrónico <span class="text-danger">*</span></label>
                <div class="controls">
                    <input 
                        type="email" 
                        id="email"
                        name="email"
                        class="form-control"
                        placeholder="Correo electrónico de la Empresa" 
                        data-validation-required-message="Ingrese Correo Electrónico de la Empresa" 
                        required
                        maxlength="200" data-validation-maxlength-message="Máximo 200 carácteres"
                        data-validation-regex-regex="([a-zA-Z0-9_\.-]+)@([\da-zA-Z\.-]+)\.([a-zA-Z\.]{2,6})" 
                        data-validation-regex-message="Email no válido. Ej. beneficiario@emprendimiento.com.co"
                        tabindex="0"/>
                </div>
            </div>
        </div>

        <div class="col-sm-6 col-md-5 offset-md-1">
            <div class="form-group">
                <label for="web">Sitio Web</label>
                <input 
                    type="url"
                    id="web" 
                    name="web" 
                    class="form-control" 
                    placeholder="Sitio Web de la Empresa"
                    maxlength="200" data-validation-maxlength-message="Máximo 200 carácteres"
                    tabindex="0"
                    />
            </div>
        </div>
    </div><!-- row -->

    <div class="row">
        <div class="col-sm-6 col-md-5">
            <div class="form-group">
                <label for="constitucionF">Tipo Constitución Legal <span class="text-danger">*</span></label>
                <div class="controls">
                    <select 
                        id="constitucionF"
                        name="constitucionF" 
                        class="selectpicker" 
                        data-validation-required-message="Ingrese Tipo de Constituci�n Legal" 
                        required tabindex="0">
                        <c:if test="${empty tiposConstitucion}">
                            <option selected disabled>Error cargando tipos de constitución legal</option>
                        </c:if>
                        <c:if test="${not empty tiposConstitucion}">
                            <c:forEach var="tiposAux" items="${tiposConstitucion}" varStatus="status">
                                <option name="constitucionF_<c:out value="${tiposAux.idtipoconstitucionlegal}"/>" value="<c:out value="${tiposAux.idtipoconstitucionlegal}"/>">
                                    <c:out value="${tiposAux.nombretipoconstitucionlegal}" escapeXml="false"/>
                                </option>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
            </div>
        </div>

        <div class="col-sm-6 col-md-5 offset-md-1">
            <div class="form-group">
                <label for="sectorF">Sector Productivo <span class="text-danger">*</span></label>
                <div class="controls">
                    <select 
                        id="sectorF" 
                        name="sectorF" 
                        class="selectpicker" 
                        data-validation-required-message="Ingrese Sector Productivo" 
                        required tabindex="0">
                        <c:if test="${empty sectoresProductivos}">
                            <option selected disabled>Error cargando sectores productivos</option>
                        </c:if>
                        <c:if test="${not empty sectoresProductivos}">
                            <c:forEach var="sectorAux" items="${sectoresProductivos}" varStatus="status">
                                <option name="sectorF_<c:out value="${sectorAux.idsectorproductivo}"/>" value="<c:out value="${sectorAux.idsectorproductivo}"/>">
                                    <c:out value="${sectorAux.nombresectorproductivo}" escapeXml="false"/>
                                </option>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
            </div>
        </div>
    </div><!-- row -->

    <div class="row">
        <div class="col-sm-6 col-md-5">
            <div class="form-group">
                <label for="fechaRenov">Fecha Renovación de Matrícula <span class="text-danger">*</span></label>
                <div class="controls">
                    <input
                        type="text" 
                        id="fechaRenov"
                        name="fechaRenov" 
                        class="form-control setDay"
                        placeholder="Fecha de Renovación de Matrícula de la Empresa" 
                        data-validation-required-message="Ingrese Fecha de Renovación de Matrícula"
                        autocomplete="off"
                        required tabindex="0"/>
                </div>
            </div>
        </div>
        <div class="col-sm-6 col-md-5 offset-md-1">
            <div class="form-group">
                <label for="fechaInicio">Fecha Inicio de Labores <span class="text-danger">*</span></label>
                <div class="controls">
                    <input 
                        type="text"
                        id="fechaInicio" 
                        name="fechaInicio"
                        class="form-control setDay" 
                        placeholder="Fecha de labores de la Empresa" 
                        data-validation-required-message="Ingrese Fecha de Inicio de Labores"
                        autocomplete="off"
                        required tabindex="0"/>
                </div>
            </div>
        </div>
    </div><!-- row -->

    <div class="row">
        <div class="col-sm-6 col-md-5">
            <div class="form-group">
                <label for="empDirectos">Empleados Directos <span class="text-danger">*</span></label>
                <div class="controls">
                    <input 
                        type="NumericTextBox"
                        id="empDirectos"
                        name="empDirectos"                         
                        class="form-control empleados only-number" 
                        placeholder="Empleados directos de la Empresa" 
                        data-validation-required-message="Ingrese Número de Empleados Directos"
                        min="1" data-validation-min-message="El mínimo de empleados es 1." 
                        max="9999" data-validation-max-message="El máximo de empleados es 9999."
                        required tabindex="0"/>
                </div>
            </div>
        </div>

        <div class="col-sm-6 col-md-5 offset-md-1">
            <div class="form-group">
                <label for="empIndirectos">Empleados Indirectos <span class="text-danger">*</span></label>
                <div class="controls">
                    <input 
                        type="NumericTextBox" 
                        id="empIndirectos"
                        name="empIndirectos"                                                
                        class="form-control empleados  only-number" 
                        placeholder="Empleados indirectos de la Empresa" 
                        data-validation-required-message="Ingrese Número de Empleados Indirectos"
                        min="1" data-validation-min-message="El mínimo de empleados es 1." 
                        max="9999" data-validation-max-message="El máximo de empleados es 9999." 
                        required tabindex="0">
                </div>
            </div>
        </div>
    </div><!-- row -->

    <div class="row">
        <div class="col-sm-6 col-md-5">
            <div class="form-group">
                <label for="actividad">Actividad Internacional</label>
                <div class="controls">
                    <select 
                        id="actividad" 
                        name="actividad"
                        class="selectpicker" 
                        data-validation-required-message="Ingrese Actividad Internacional" 
                        required tabindex="0">
                        <c:if test="${empty actividadesInternacionales}">
                            <option selected disabled>Error cargando actividades internacionales</option>
                        </c:if>
                        <c:if test="${not empty actividadesInternacionales}">
                            <c:forEach var="actividadAux" items="${actividadesInternacionales}" varStatus="status">
                                <option name="actividad_<c:out value="${actividadAux.idactividadinternacional}"/>" value="<c:out value="${actividadAux.idactividadinternacional}"/>">
                                    <c:out value="${actividadAux.nombreactividadinternacional}" escapeXml="false"/>
                                </option>
                            </c:forEach>
                        </c:if>
                    </select>
                </div>
            </div>
        </div>

        <div class="col-sm-6 col-md-5 offset-md-1">
            <div class="form-group">
                <label>Negocios Internet <span class="text-danger">*</span></label>
                <div class="controls">
                    <fieldset>
                        <div class="custom-control custom-radio">
                            <input type="radio"
                                   value="si"
                                   name="negInternet"
                                   id="siNegInternet"
                                   class="custom-control-input"
                                   data-validation-required-message="Seleccione opción"
                                   required tabindex="0"
                                   />
                            <label class="custom-control-label" for="siNegInternet">Si</label>
                        </div>
                    </fieldset>
                    <fieldset>
                        <div class="custom-control custom-radio">
                            <input type="radio"
                                   value="no"
                                   name="negInternet"
                                   id="noNegInternet"
                                   class="custom-control-input" tabindex="0">
                            <label class="custom-control-label" for="noNegInternet">No</label>
                        </div>
                    </fieldset>
                </div>
            </div>
        </div>
    </div><!-- row -->

    <div class="row">
        <div class="col-md-11 m-t-20 m-b-30">
            <label class="input-group-addon">Productos y Servicios Ofrecidos <span class="text-danger">*</span></label>
            <div class="controls">
                <div class="input-group">
                    <input 
                        type="text"
                        id="prodServF"
                        name="prodServF"                             
                        value="" 
                        data-role="tagsinput"
                        placeholder="Agregue Productos y/o Servicios"
                        data-validation-required-message="Ingrese los Productos y Servicios que ofrece" 
                        required
                        maxlength="400"
                        data-validation-maxlength-message="Máximo 400 carácteres"
                        tabindex="0" />
                </div>
            </div>
            <small>Escriba productos y/o servicios - use coma ',' para agregar varios.</small>
        </div>
    </div><!-- row -->

    <div class="row">
        <div class="col-lg-6 col-xlg-4  m-b-30">
            <label class="box-title">Países con los que Comercializa</label>
            <select 
                id='paises' 
                name="paises"
                multiple='multiple'
                tabindex="0">
                <c:if test="${empty paises}">
                    <option selected disabled>Error cargando paises</option>
                </c:if>
                <c:if test="${not empty paises}">
                    <c:forEach var="paisAux" items="${paises}" varStatus="status">
                        <option name="pais_<c:out value="${paisAux.idpais}"/>" value="<c:out value="${paisAux.idpais}"/>">
                            <c:out value="${paisAux.nombrepais}" escapeXml="false"/>
                        </option>
                    </c:forEach>
                </c:if>
            </select>
        </div>
    </div><!-- row -->
</div>

<div id='divNoEstablecido' style='display: none'>
    <div class="row">
        <div class="col-sm-6 col-md-5">
            <label for="constitucionN">Tipo Constitución Legal</label>
            <div class="controls">
                <select 
                    id="constitucionN" 
                    name="constitucionN"
                    class="selectpicker" 
                    data-validation-required-message="Ingrese Tipo de Constitución Legal" 
                    required tabindex="0">
                    <c:if test="${empty tiposConstitucion}">
                        <option selected disabled>Error cargando tipos de constitución legal</option>
                    </c:if>
                    <c:if test="${not empty tiposConstitucion}">
                        <c:forEach var="tiposAux" items="${tiposConstitucion}" varStatus="status">
                            <option name="constitucionN_<c:out value="${tiposAux.idtipoconstitucionlegal}"/>" value="<c:out value="${tiposAux.idtipoconstitucionlegal}"/>">
                                <c:out value="${tiposAux.nombretipoconstitucionlegal}" escapeXml="false"/>
                            </option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>
        </div>
        <div class="col-sm-6 col-md-5 offset-md-1">
            <label for="sectorN">Sector Productivo</label>
            <div class="controls">
                <select 
                    id="sectorN" 
                    name="sectorN"
                    class="selectpicker" 
                    data-validation-required-message="Ingrese Sector Productivo" 
                    required tabindex="0">
                    <c:if test="${empty sectoresProductivos}">
                        <option selected disabled>Error cargando sectores productivos</option>
                    </c:if>
                    <c:if test="${not empty sectoresProductivos}">
                        <c:forEach var="sectorAux" items="${sectoresProductivos}" varStatus="status">
                            <option name="sectorN_<c:out value="${sectorAux.idsectorproductivo}"/>" value="<c:out value="${sectorAux.idsectorproductivo}"/>">
                                <c:out value="${sectorAux.nombresectorproductivo}" escapeXml="false"/>
                            </option>
                        </c:forEach>
                    </c:if>
                </select>
            </div>
        </div>
    </div><!-- row -->

    <div class="row">
        <div class="col-sm-6 col-md-5 m-t-20 m-b-30">
            <label class="input-group-addon">Productos y Servicios Ofrecidos <span class="text-danger">*</span></label>        
            <div class="input-group">
                <div class="controls">
                    <input 
                        type="text"
                        id="prodServN"
                        name="prodServN"                             
                        value="" 
                        data-role="tagsinput"
                        placeholder="agregue productos y/o servicios"
                        data-validation-required-message="Ingrese Productos y Servicios que va a ofrecer" 
                        required tabindex="0"
                        maxlength="400" data-validation-maxlength-message="Máximo 400 carácteres"
                        data-validation-maxlength-message="Máximo 400 carácteres"
                        />
                </div>
            </div>
            <small>Escriba productos y/o servicios - use coma (,) para agregar varios.</small>
        </div>

        <div class="col-sm-6 col-md-5 offset-md-1 m-t-20 m-b-30">
            <div class="form-group">
                <label for="cuandoInicia">Cuándo Inicia? <span class="text-danger">*</span></label>
                <div class="controls">
                    <input 
                        type="text"
                        id="cuandoInicia" 
                        name="cuandoInicia"
                        class="form-control setDay" 
                        placeholder="Fecha de inicio de la actividad comercial" 
                        data-validation-required-message="Ingrese Fecha de Inicio"
                        autocomplete="off"
                        required tabindex="0"/>
                </div>
            </div>
        </div>
    </div><!-- row -->

    <div class="row">
        <div class="col-sm-11">
            <div class="form-group">
                <label for="observaciones">Observaciones <span class="text-danger">*</span></label>
                <div class="controls">
                    <textarea type="text" class="form-control" name="observaciones" id="observaciones" placeholder="Observaciones Adicionales" 
                              data-validation-required-message="Campo obligatorio" required 
                              maxlength="500"
                              data-validation-maxlength-message="Máximo 500 carácteres"
                              tabindex="0" /></textarea>
                    <span id="chars">500</span> carácteres restantes.
                </div>
            </div>
        </div>
    </div>  
</div>

<!-- Filtro -->
<h4 class="box-title m-t-40">Filtrar Beneficiarios</h4>
<hr />
<div class="row">

    <div class="col-md-5">                                          
        <label>Seleccione tipo de búsqueda</label>
        <div class="btn-group" data-toggle="buttons">
            <label class="btn btn-info">
                <div class="custom-control custom-radio">
                    <input type="radio" id="customRadio1" name="selectBeneficiario" value="1" class="custom-control-input" checked tabindex="0">
                    <label class="custom-control-label" for="customRadio1">Documento</label>
                </div>
            </label>
            <label class="btn btn-info">
                <div class="custom-control custom-radio">
                    <input type="radio" id="customRadio2" name="selectBeneficiario" value="2" class="custom-control-input" tabindex="0">
                    <label class="custom-control-label" for="customRadio2">Nombre/Apellido</label>
                </div>
            </label>
        </div>
    </div>

    <div class="col-md-7">
        <div class="row" id="filtroDocumento">                   
            <div class="col-sm-12 col-md-6 form-group">
                <label> Número documento</label>
                <div class="controls">                           
                    <input 
                        type="text" 
                        name="documento"
                        class="form-control" 
                        placeholder="Número de documento"
                        data-validation-required-message="Ingrese número documento"
                        required
                        tabindex="0" id="inputDocumento">
                </div>
            </div>                                    
        </div>

        <div id="filtroNombres" style="display: none;">
            <div class="row" >                   
                <div class="col-sm-12 col-md-6 form-group">
                    <label> Primer Nombre </label>
                    <div class="controls">                       
                        <input 
                            type="text" 
                            name="pNombre"
                            class="form-control" 
                            placeholder="Primer Nombre"
                            data-validation-required-message="Ingrese Nombre"
                            maxlength="200"
                            tabindex="0" id="inputNombre">                        
                    </div>
                </div>
                <div class="col-sm-12 col-md-6 form-group">
                    <label> Segundo Nombre </label>
                    <div class="controls">                       
                        <input 
                            type="text" 
                            name="sNombre"
                            class="form-control" 
                            placeholder="Segundo Nombre"
                            maxlength="200"
                            tabindex="0" id="inputNombre2">                        
                    </div>
                </div>
            </div>
            <div class="row" >
                <div class="col-sm-12 col-md-6 form-group">
                    <label> Primer Apellido </label>
                    <div class="controls">                           
                        <input 
                            type="text" 
                            name="pApellido"
                            class="form-control" 
                            placeholder="Primer Apellido" 
                            data-validation-required-message="Ingrese Apellido"
                            maxlength="200"
                            tabindex="0" id="inputApellido">                       
                    </div>
                </div>
                <div class="col-sm-12 col-md-6 form-group">
                    <label> Segundo Apellido </label>
                    <div class="controls">                           
                        <input 
                            type="text" 
                            name="sApellido"
                            class="form-control" 
                            placeholder="Segundo Apellido" 
                            maxlength="200"
                            tabindex="0" id="inputApellido2">                       
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div class="col-md-12 form-actions text-center">
        <button type="button" class="btn btn-primary" id="btnFiltroBeneficiario" tabindex="0"> <i class="mdi mdi-magnify"></i> Buscar Beneficiario</button>
    </div>

</div>

<div class="row">
    <div class="col-md-12">
        <br />
        <div id="msgContainer">
            <div id="mensajes" class="alert" style="display: none">
                <i class="fa fa-check-circle"></i>
                <span></span>
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
            </div>
        </div>

        <div class="table-responsive m-t-20">
            <h5 class=""m-b-20>Resultado Búsqueda de Beneficiario</h5>
            <table id="resultBeneficiarios" class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th width="10%">Documento</th>
                        <th width="5%">Tipo Documento</th>
                        <th width="20%">Nombres</th>
                        <th width="20%">Apellidos</th>
                        <th width="10%">Teléfono</th>
                        <th width="25%">Correo</th>
                        <th width="10%">Acción</th>
                    </tr>
                </thead>
                <tbody id="bodyBeneficiario">
                </tbody>
            </table>
        </div>

        <div class="table-responsive m-t-20">
            <h5 class=""m-b-20>Beneficiarios Integrantes del Emprendimiento</h5>
            <table class="table table-bordered table-striped" id="listaBeneficiarios">
                <thead>
                    <tr>
                        <th width="10%">Documento</th>
                        <th width="5%">Tipo Documento</th>
                        <th width="20%">Nombres</th>
                        <th width="20%">Apellidos</th>
                        <th width="10%">Teléfono</th>
                        <th width="20%">Correo</th>
                        <th width="5%">Líder</th>
                        <th width="10%">Acción</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>

<div class="form-group text-center m-t-20">
    <button type='submit' id="registrar" class='btn btn-primary'><i class="fas fa-calendar-check m-r-5"></i>Registrar Emprendimiento</button>
</div>

<script src="${pageContext.request.contextPath}/resources/_assets/modules/multiselect/js/jquery.multi-select.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/_assets/modules/bootstrap-tagsinput/dist/bootstrap-tagsinput.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/registrarEmprendimientoView.js" type="text/javascript"></script>
<script>
    <c:if test="${not empty idFuncionario}">
    idfuncionario = ${idFuncionario};
    </c:if>
    <c:if test="${not empty idCajacompensacion}">
    idcajacompensacion = ${idCajacompensacion};
    </c:if>
</script>