<%-- 
    Document   : consultarBeneficiarioRegistroSeguimiento
    Created on : 5/12/2018, 02:54:29 PM
    Author     : Juan Carlos Franco
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<link href="${pageContext.request.contextPath}/resources/_assets/modules/multiselect/css/multi-select.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/resources/_assets/modules/bootstrap-tagsinput/dist/bootstrap-tagsinput.css" rel="stylesheet">

<!-- Filtro -->
<h3>Buscar Beneficiario Registro Seguimiento</h3>
<hr />
<div id="msgContainer">
    <div id="mensajes" class="alert" style="display: none"> <i class="fa fa-check-circle"></i>
        <span></span>
        <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
    </div>
</div>
<div class="row">

    <div class="col-md-5">                                          
        <label>Seleccione tipo de búsqueda</label>
        <div class="btn-group" data-toggle="buttons">
            <label class="btn btn-info">
                <div class="custom-control custom-radio">
                    <input type="radio" id="customRadio1" name="selectBeneficiario" value="1" class="custom-control-input" checked>
                    <label class="custom-control-label" for="customRadio1">Documento</label>
                </div>
            </label>
            <label class="btn btn-info">
                <div class="custom-control custom-radio">
                    <input type="radio" id="customRadio2" name="selectBeneficiario" value="2" class="custom-control-input">
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
                        required maxlength="18" data-validation-maxlength-message="Máximo 18 carácteres"
                        id="inputDocumento">

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

<br /><hr />


<div class="row">
    <div class="col-md-12">
        <div class="table-responsive m-t-20">
            <table id="tableData" class="table table-bordered table-striped">
                <thead>
                    <tr>
                        <th >Documento</th>
                        <th >Tipo Doc.</th>
                        <th class="noOverflow">Nombres</th>
                        <th class="noOverflow">Apellidos</th>
                        <th >Teléfono</th>
                        <th class="noOverflow">Correo</th>
                        <th class="noOverflow">Nombre Emprendimiento</th>
                        <th >Acción</th>
                    </tr>
                </thead>
                <tbody id="bodyBeneficiario">
                </tbody>
            </table>
        </div>
    </div>
</div>
<div class="modal fade" id="modalVerEmprendimiento" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-md" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="editModalLabel">Vista Emprendimiento</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>                
            </div>

            <div class="modal-body">
                <h5>Datos del Emprendimiento</h5>
                <table class="table table-sm table-bordered table-striped">
                    <tbody>
                        <tr>
                            <th class="label-th">Nombre Emprendimiento:</th>
                            <td><p id="nombreEmprendimiento"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Tipo Emprendimiento:</th>
                            <td><p id="tEmprendimiento"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Beneficiarios Asociados:</th>
                            <td><ol id="asociados" class="ul-noPadding"></ol></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Formalizado:</th>
                            <td><p id="formalizado"></p></td>
                        </tr>   
                    </tbody>
                </table>

                <h5 class="m-t-40 formalizado" style="display: none;">Emprendimiento Formalizado</h5>
                <table class="table table-sm table-bordered table-striped formalizado" id="divFormalizado" style="display: none;">
                    <tbody>
                        <tr>
                            <th class="label-th">Nombre Empresa:</th>
                            <td><p id="nombreEmpresa"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">NIT:</th>
                            <td><p id="nit"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Número Registro Mercantil:</th>
                            <td><p id="nRegistroMercantil"></p></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Nombre Representante Legal:</th>
                            <td><p id="nombreRepresentante"></p></td>
                        </tr>   
                        <tr>
                            <th class="label-th">Dirección:</th>
                            <td><p id="dirección"></p></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Teléfono:</th>
                            <td><p id="telefono"></p></td>
                        </tr>    
                        <tr>
                            <th class="label-th">Municipio:</th>
                            <td><p id="municipio"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Correo electrónico:</th>
                            <td><p id="email"></p></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Sitio Web:</th>
                            <td><p id="web"></p></td>
                        </tr>    
                        <tr>
                            <th class="label-th">Países Comercializa:</th>
                            <td><ol id="paises" class="ul-noPadding"></ol></td>
                        </tr>
                        <tr>
                            <th class="label-th">Tipo Constitución Legal:</th>
                            <td><p id="constitucionF"></p></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Sector Productivo:</th>
                            <td><p id="sectorF"></p></td>
                        </tr>    
                        <tr>
                            <th class="label-th">Negocios Internet:</th>
                            <td><p id="negInternet"></p></td>
                        </tr>

                        <tr>
                            <th class="label-th">Productos y Servicios Ofrecidos:</th>
                            <td><ul id="prodServF" class="ul-noPadding"></ul></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Fecha Renovación de Matrícula:</th>
                            <td><p id="fechaRenov"></p></td>
                        </tr>    
                        <tr>
                            <th class="label-th">Fecha Inicio de Labores:</th>
                            <td><p id="fechaInicio"></p></td>
                        </tr>     

                        <tr>
                            <th class="label-th">Actividad Internacional:</th>
                            <td><p id="actividad"></p></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Empleados Directos:</th>
                            <td><p id="empDirectos"></p></td>
                        </tr>    
                        <tr>
                            <th class="label-th">Empleados Indirectos:</th>
                            <td><p id="empIndirectos"></p></td>
                        </tr>                                                                                                            
                    </tbody>
                </table>

                <h5 class="m-t-40 noEstablecido" style="display: none;">Emprendimiento No Formalizado</h5>
                <table class="table table-sm table-bordered table-striped noEstablecido" id='divNoEstablecido' style="display: none;">
                    <tbody>
                        <tr>
                            <th class="label-th">Tipo Constitución Legal:</th>
                            <td><p id="constitucionN"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Sector productivo:</th>
                            <td><p id="sectorN"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Productos y Servicios Ofrecidos:</th>
                            <td><ul id="prodServN" class="ul-noPadding"></ul></td>
                        </tr>       
                        <tr>
                            <th class="label-th">Cuando Inicia?:</th>
                            <td><p id="cuandoInicia"></p></td>
                        </tr>
                        <tr>
                            <th class="label-th">Observaciones:</th>
                            <td><p id="observaciones"></p></td>
                        </tr>                           
                    </tbody>
                </table>

            </div>
            <div class="text-center m-b-15">
                <button class="btn btn-danger" type="button" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="modalRegistrarSeguimiento" tabindex="-1" role="dialog" aria-labelledby="registreModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="registreModalLabel">Registrar Información Seguimiento</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>  
            </div>
            <div class="modal-body">

                <div id="emprendimiento">
                    <h5 class="m-t-40">Datos del Emprendimiento</h5>
                    <table class="table table-sm table-bordered table-striped">
                        <tbody>
                            <tr>
                                <th class="label-th">Nombre Emprendimiento:</th>
                                <td><p id="nombreEmprendimientoR"></p></td>
                            </tr>
                            <tr>
                                <th class="label-th">Tipo Emprendimiento:</th>
                                <td><p id="tEmprendimientoR"></p></td>
                            </tr>
                            <tr>
                                <th class="label-th">Beneficiarios Asociados:</th>
                                <td><ol id="asociadosR" class="ul-noPadding"></ol></td>
                            </tr>  
                        </tbody>
                    </table>

                    <div id="radioFormalizadoR" class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label>Formalizado: <span class="text-danger">*</span></label>
                                <fieldset class="controls">
                                    <div class="custom-control custom-radio">
                                        <input type="radio"
                                               value="si"
                                               name="formalizadoR"
                                               id="siFormalizadoR"
                                               class="custom-control-input"
                                               data-validation-required-message="Seleccione una opción"
                                               required/>
                                        <label class="custom-control-label" for="siFormalizadoR">Si</label>
                                    </div>
                                </fieldset>

                                <fieldset>
                                    <div class="custom-control custom-radio">
                                        <input type="radio"
                                               value="no"
                                               name="formalizadoR"
                                               id="noFormalizadoR"
                                               class="custom-control-input">
                                        <label class="custom-control-label" for="noFormalizadoR">No</label>
                                    </div>
                                </fieldset>
                            </div>
                        </div>
                    </div><!-- row radioFormalizadoR -->

                    <div id='divFormalizadoR' style='display: none'>
                        <h5 class="m-t-40">Emprendimiento Formalizado</h5>
                        <div class="row">
                            <div class="col-sm-6 col-md-5">
                                <div class="form-group">
                                    <label for="nombreEmpresaR">Nombre Empresa <span class="text-danger">*</span></label>
                                    <div class="controls">
                                        <input type="text"
                                               id="nombreEmpresaR"
                                               name="nombreEmpresaR"
                                               class="form-control"
                                               placeholder="Nombre Empresa"
                                               maxlength="400"
                                               data-validation-maxlength-message="Máximo 400 carácteres"
                                               data-validation-required-message="Ingrese Nombre"
                                               required 
                                               />
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6 col-md-5 offset-md-1">
                                <div class="form-group">
                                    <label for="nitR">NIT <span class="text-danger">*</span> (8 a 15 caracteres antes de validación)</label>
                                    <div class="controls">
                                        <input type="text"
                                               id="nitR"
                                               name="nitR"
                                               class="form-control"
                                               placeholder="Número Identificación Tributaria"
                                               maxlength="15"
                                               data-validation-required-message="Ingrese NIT de la Empresa"
                                               required 
                                               data-validation-regex-regex="\d{6,15}-\d{1}" 
                                               data-validation-regex-message="NIT no válido. Ej. 123456789-1"/>
                                    </div>
                                </div>
                            </div>                             
                        </div><!-- row -->

                        <div class="row">
                            <div class="col-sm-6 col-md-5">
                                <div class="form-group">
                                    <label for="nRegistroMercantilR">Número Registro Mercantil <span class="text-danger">*</span> (10 caracteres) </label>
                                    <div class="controls">
                                        <input type="NumericTextBox"
                                               id="nRegistroMercantilR"
                                               name="nRegistroMercantilR"
                                               class="form-control registroMercantil only-number"
                                               placeholder="Número de Registro Mercantil de la Empresa"
                                               data-validation-required-message="Ingrese Número de Registro Mercantil"
                                               data-validation-regex-regex="\d{10}" 
                                               data-validation-regex-message="Registro Mercantil no válido. Ej. 0123456789"
                                               required />
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6 col-md-5 offset-md-1">
                                <div class="form-group">
                                    <label for="nombreRepresentanteR">Nombre Representante Legal <span class="text-danger">*</span></label>
                                    <div class="controls">
                                        <input type="text"
                                               id="nombreRepresentanteR"
                                               name="nombreRepresentanteR"
                                               class="form-control"
                                               placeholder="Nombre Representante..."
                                               maxlength="400" data-validation-maxlength-message="Máximo 400 carácteres"
                                               data-validation-required-message="Ingrese Nombre del Representante Legal"
                                               required />
                                    </div>
                                </div>
                            </div>                             
                        </div><!-- row -->

                        <div class="row">
                            <div class="col-sm-6 col-md-5">
                                <div class="form-group">
                                    <label for="direccionR">Dirección <span class="text-danger">*</span></label>
                                    <div class="controls">
                                        <input type="text"
                                               id="direccionR"
                                               name="direccionR"
                                               class="form-control"
                                               maxlength="200" data-validation-maxlength-message="Máximo 200 carácteres"
                                               placeholder="Dirección de la Empresa"
                                               data-validation-required-message="Ingrese Dirección de la Empresa"
                                               required />
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6 col-md-5 offset-md-1">
                                <div class="form-group">
                                    <label for="telefonoR">Teléfono <span class="text-danger">*</span></label>
                                    <div class="controls">
                                        <input type="text"
                                               id="telefonoR"
                                               name="telefonoR"
                                               class="form-control telefono only-number"
                                               placeholder="Teléfono de la Empresa"
                                               minlength="7" data-validation-minlength-message="El Número de Registro Mercantil debe tener 7 dígitos" 
                                               maxlength="15" data-validation-maxlength-message="El Número de Registro Mercantil debe tener 15 dígitos"
                                               data-validation-required-message="Ingrese Número de Teléfono de la Empresa"
                                               required />
                                    </div>
                                </div>
                            </div>
                        </div> <!-- row -->

                        <div class="row">
                            <div class="col-sm-6 col-md-5">
                                <div class="form-group">
                                    <label for="departamentoR">Departamento <span class="text-danger">*</span></label>
                                    <div class="controls">
                                        <select 
                                            id="departamentoR" 
                                            name="departamentoR" 
                                            class="selectpicker" 
                                            data-validation-required-message="Ingrese Departamento" 
                                            required>
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6 col-md-5 offset-md-1">
                                <div class="form-group">
                                    <label for="municipioR">Municipio <span class="text-danger">*</span></label>
                                    <div class="controls">
                                        <select 
                                            id="municipioR" 
                                            name="municipioR"
                                            class="selectpicker"                         
                                            data-validation-required-message="Ingrese Municipio"
                                            required disabled>
                                            <option selected value="">Seleccione un Municipio</option>
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div><!-- row -->

                        <div class="row">
                            <div class="col-sm-6 col-md-5">
                                <div class="form-group">
                                    <label for="emailR">Correo electrónico <span class="text-danger">*</span></label>
                                    <div class="controls">
                                        <input 
                                            type="email" 
                                            id="emailR"
                                            name="emailR"
                                            class="form-control"
                                            placeholder="Correo electrónico de la Empresa"
                                            maxlength="200" data-validation-maxlength-message="Máximo 200 carácteres"
                                            data-validation-required-message="Ingrese Correo Electrónico de la Empresa"
                                            data-validation-regex-regex="([a-zA-Z0-9_\.-]+)@([\da-zA-Z\.-]+)\.([a-zA-Z\.]{2,6})" 
                                            data-validation-regex-message="Email no válido. Ej. beneficiario@emprendimiento.com.co"
                                            required />
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6 col-md-5 offset-md-1">
                                <div class="form-group">
                                    <label for="webR">Sitio Web</label>
                                    <input 
                                        type="url"
                                        id="webR" 
                                        name="webR" 
                                        class="form-control"
                                        maxlength="200" data-validation-maxlength-message="Máximo 200 carácteres"
                                        placeholder="Sitio Web de la Empresa" />
                                </div>
                            </div>
                        </div><!-- row -->

                        <div class="row">
                            <div class="col-sm-6 col-md-5">
                                <div class="form-group">
                                    <label for="constitucionFR">Tipo Constitución Legal <span class="text-danger">*</span></label>
                                    <div class="controls">
                                        <select 
                                            id="constitucionFR"
                                            name="constitucionFR"
                                            class="selectpicker"
                                            data-validation-required-message="Ingrese Tipo de Constitución Legal" 
                                            required>
                                            <!--                                                                                    <c:if test="${empty tiposConstitucion}">
                                                                                            <option selected disabled>Error cargando tipos de constituci�n legal</option>
                                            </c:if>
                                            <c:if test="${not empty tiposConstitucion}">
                                                <c:forEach var="tiposAux" items="${tiposConstitucion}" varStatus="status">
                                                    <option name="constitucionF_<c:out value="${tiposAux.idtipoconstitucionlegal}"/>" value="<c:out value="${tiposAux.idtipoconstitucionlegal}"/>">
                                                    <c:out value="${tiposAux.nombretipoconstitucionlegal}" escapeXml="false"/>
                                                </option>
                                                </c:forEach>
                                            </c:if>-->
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6 col-md-5 offset-md-1">
                                <div class="form-group">
                                    <label for="sectorFR">Sector Productivo <span class="text-danger">*</span></label>
                                    <div class="controls">
                                        <select 
                                            id="sectorFR" 
                                            name="sectorFR" 
                                            class="selectpicker" 
                                            data-validation-required-message="Ingrese Sector Productivo" 
                                            required>
                                            <!--                                                                                    <c:if test="${empty sectoresProductivos}">
                                                                                            <option selected disabled>Error cargando sectores productivos</option>
                                            </c:if>
                                            <c:if test="${not empty sectoresProductivos}">
                                                <c:forEach var="sectorAux" items="${sectoresProductivos}" varStatus="status">
                                                    <option name="sectorF_<c:out value="${sectorAux.idsectorproductivo}"/>" value="<c:out value="${sectorAux.idsectorproductivo}"/>">
                                                    <c:out value="${sectorAux.nombresectorproductivo}" escapeXml="false"/>
                                                </option>
                                                </c:forEach>
                                            </c:if>-->
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div><!-- row -->

                        <div class="row">
                            <div class="col-sm-6 col-md-5">
                                <div class="form-group">
                                    <label for="fechaRenovR">Fecha Renovación de Matrícula <span class="text-danger">*</span></label>
                                    <div class="controls">
                                        <input
                                            type="text" 
                                            id="fechaRenovR"
                                            name="fechaRenovR" 
                                            class="form-control setDay"
                                            placeholder="Fecha de Renovación de Matrícula de la Empresa" 
                                            data-validation-required-message="Ingrese Fecha de Renovación de Matrícula"
                                            autocomplete="off"
                                            required>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6 col-md-5 offset-md-1">
                                <div class="form-group">
                                    <label for="fechaInicioR">Fecha Inicio de Labores <span class="text-danger">*</span></label>
                                    <div class="controls">
                                        <input 
                                            type="text"
                                            id="fechaInicioR" 
                                            name="fechaInicioR"
                                            class="form-control setDay" 
                                            placeholder="Fecha de labores de la Empresa" 
                                            data-validation-required-message="Ingrese Fecha de Inicio de Labores"
                                            autocomplete="off"
                                            required>
                                    </div>
                                </div>
                            </div>
                        </div><!-- row -->

                        <div class="row">
                            <div class="col-sm-6 col-md-5">
                                <div class="form-group">
                                    <label for="empDirectosR">Empleados Directos <span class="text-danger">*</span></label>
                                    <div class="controls">
                                        <input 
                                            type="NumericTextBox"
                                            id="empDirectosR"
                                            name="empDirectosR"                         
                                            class="form-control empleados only-number" 
                                            placeholder="Empleados directos de la Empresa" 
                                            data-validation-required-message="Ingrese Número de Empleados Directos"
                                            min="1" data-validation-min-message="El mínimo de empleados es 1." 
                                            max="9999" data-validation-max-message="El máximo de empleados es 9999." 
                                            required>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6 col-md-5 offset-md-1">
                                <div class="form-group">
                                    <label for="empIndirectosR">Empleados Indirectos <span class="text-danger">*</span></label>
                                    <div class="controls">
                                        <input 
                                            type="NumericTextBox" 
                                            id="empIndirectosR"
                                            name="empIndirectosR"                                                
                                            class="form-control empleados  only-number" 
                                            placeholder="Empleados indirectos de la Empresa" 
                                            data-validation-required-message="Ingrese Número de Empleados Indirectos"
                                            min="1" data-validation-min-message="El mínimo de empleados es 1." 
                                            max="9999" data-validation-max-message="El máximo de empleados es 9999." 
                                            required>
                                    </div>
                                </div>
                            </div>
                        </div><!-- row -->

                        <div class="row">
                            <div class="col-sm-6 col-md-5">
                                <div class="form-group">
                                    <label for="actividadR">Actividad Internacional</label>
                                    <div class="controls">
                                        <select 
                                            id="actividadR" 
                                            name="actividadR"
                                            class="selectpicker" 
                                            data-validation-required-message="Ingrese Actividad Internacional" 
                                            required>
                                            <!--                                                                                    <c:if test="${empty actividadesInternacionales}">
                                                                                            <option selected disabled>Error cargando actividades internacionales</option>
                                            </c:if>
                                            <c:if test="${not empty actividadesInternacionales}">
                                                <c:forEach var="actividadAux" items="${actividadesInternacionales}" varStatus="status">
                                                    <option name="actividad_<c:out value="${actividadAux.idactividadinternacional}"/>" value="<c:out value="${actividadAux.idactividadinternacional}"/>">
                                                    <c:out value="${actividadAux.nombreactividadinternacional}" escapeXml="false"/>
                                                </option>
                                                </c:forEach>
                                            </c:if>-->
                                        </select>
                                    </div>
                                </div>
                            </div>

                            <div class="col-sm-6 col-md-5 offset-md-1">
                                <div class="form-group">
                                    <label>Negocios Internet <span class="text-danger">*</span></label>
                                    <fieldset class="controls">
                                        <div class="custom-control custom-radio">
                                            <input type="radio"
                                                   value="si"
                                                   name="negInternetR"
                                                   id="siNegInternetR"
                                                   class="custom-control-input"
                                                   />
                                            <label class="custom-control-label" for="siNegInternetR">Si</label>
                                        </div>
                                    </fieldset>
                                    <fieldset>
                                        <div class="custom-control custom-radio">
                                            <input type="radio"
                                                   value="no"
                                                   name="negInternetR"
                                                   id="noNegInternetR"
                                                   class="custom-control-input"
                                                   checked>
                                            <label class="custom-control-label" for="noNegInternetR">No</label>
                                        </div>
                                    </fieldset>
                                </div>
                            </div>
                        </div><!-- row -->

                        <div class="row">
                            <div class="col-sm-11">
                                <label class="input-group-addon">Productos y Servicios Ofrecidos <span class="text-danger">*</span></label>        
                                <div class="controls">
                                    <div class="input-group  m-t-20 m-b-30">                   
                                        <input 
                                            type="text"
                                            id="prodServFR"
                                            name="prodServFR"                             
                                            value="" 
                                            data-role="tagsinput"
                                            width="100%"
                                            placeholder="Agregue Productos y/o Servicios"
                                            maxlength="400" data-validation-maxlength-message="Máximo 400 carácteres"
                                            data-validation-required-message="Ingrese los Productos y Servicios que ofrece" 
                                            required />
                                    </div>
                                </div>

                            </div>
                        </div><!-- row -->

                        <div class="row">
                            <div class="col-lg-6 col-xlg-4  m-b-30">
                                <label>Países con los que Comercializa</label>
                                <select 
                                    id='paisesR' 
                                    name="paisesR[]"
                                    multiple='multiple'>
                                    <!--                                                                    <c:if test="${empty paises}">
                                                                            <option selected disabled>Error cargando paises</option>
                                    </c:if>
                                    <c:if test="${not empty paises}">
                                        <c:forEach var="paisAux" items="${paises}" varStatus="status">
                                            <option name="pais_<c:out value="${paisAux.idpais}"/>" value="<c:out value="${paisAux.idpais}"/>">
                                            <c:out value="${paisAux.nombrepais}" escapeXml="false"/>
                                        </option>
                                        </c:forEach>
                                    </c:if>-->
                                </select>
                            </div> 
                        </div><!-- row -->

                    </div><!-- divFormalizadoR -->
                    <div id='divNoEstablecidoR' style='display: none'>
                        <h5 class="m-t-40">Emprendimiento No Formalizado</h5>
                        <div class="row">
                            <div class="col-sm-6 col-md-5">
                                <div class="form-group">
                                    <label for="constitucionNR">Tipo Constitución Legal <span class="text-danger">*</span></label>
                                    <div class="controls">
                                        <select id="constitucionNR" class="selectpicker" 
                                                data-validation-required-message="Ingrese Tipo de Constitución Legal" 
                                                required >
                                            <!--                                                                                    <c:if test="${empty tiposConstitucion}">
                                                                                            <option selected disabled>Error cargando tipos de constituci�n legal</option>
                                            </c:if>
                                            <c:if test="${not empty tiposConstitucion}">
                                                <c:forEach var="tiposAux" items="${tiposConstitucion}" varStatus="status">
                                                    <option name="constitucionN_<c:out value="${tiposAux.idtipoconstitucionlegal}"/>" value="<c:out value="${tiposAux.idtipoconstitucionlegal}"/>">
                                                    <c:out value="${tiposAux.nombretipoconstitucionlegal}" escapeXml="false"/>
                                                </option>
                                                </c:forEach>
                                            </c:if>-->
                                        </select>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-5 offset-md-1">
                                <div class="form-group">
                                    <label for="sectorNR">Sector Productivo <span class="text-danger">*</span></label>
                                    <div class="controls">
                                        <select id="sectorNR" class="selectpicker" 
                                                data-validation-required-message="Ingrese Sector Productivo" 
                                                required >
                                            <!--                                                                                    <c:if test="${empty sectoresProductivos}">
                                                                                            <option selected disabled>Error cargando sectores productivos</option>
                                            </c:if>
                                            <c:if test="${not empty sectoresProductivos}">
                                                <c:forEach var="sectorAux" items="${sectoresProductivos}" varStatus="status">
                                                    <option name="sectorN_<c:out value="${sectorAux.idsectorproductivo}"/>" value="<c:out value="${sectorAux.idsectorproductivo}"/>">
                                                    <c:out value="${sectorAux.nombresectorproductivo}" escapeXml="false"/>
                                                </option>
                                                </c:forEach>
                                            </c:if>-->
                                        </select>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-sm-6 col-md-5">
                                <div class="form-group">
                                    <label for="prodServNR">Productos y Servicios Ofrecidos <span class="text-danger">*</span></label>
                                    <div class="controls">
                                        <input 
                                            type="text"
                                            id="prodServNR"
                                            name="prodServNR"                             
                                            value="" 
                                            data-role="tagsinput"
                                            width="100%"
                                            placeholder="Agregue Productos y/o Servicios"
                                            maxlength="400" data-validation-maxlength-message="Máximo 400 carácteres"
                                            data-validation-required-message="Ingrese los Productos y Servicios que ofrece" 
                                            required />
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6 col-md-5 offset-md-1">
                                <div class="form-group">
                                    <label for="cuandoIniciaR">Cuando Inicia? <span class="text-danger">*</span></label>
                                    <div class="controls">
                                        <input type="text" class="form-control setDay" id="cuandoIniciaR" placeholder="Fecha de inicio de la actividad comercial." 
                                               data-validation-required-message="Ingrese Fecha" 
                                               required />
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-md-12">
                                <div class="form-group">
                                    <label for="observacionesR">Observaciones <span class="text-danger">*</span></label>
                                    <div class="controls">
                                        <textarea class="form-control" id="observacionesR" placeholder="Observaciones Emprendimiento"
                                                  data-validation-required-message="Ingrese una observación" 
                                                  required maxlength="500" data-validation-maxlength-message="Máximo 500 carácteres"></textarea>
                                        <span id="charsR">500</span> carácteres restantes.
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div> 

                </div><!-- emprendimiento -->

                <div id="financiero">
                    <h5 class="m-t-40">Datos Financieros</h5>
                    <div class="row">
                        <div class="col-sm-6 col-md-5">
                            <div class="form-group">
                                <label for="rPropios">Recursos Propios: <span class="text-danger">*</span></label>
                                <div class="controls">
                                    <input 
                                        type="NumericTextBox"
                                        id="rPropios" 
                                        name="rPropios"
                                        class="form-control"
                                        min="0" data-validation-min-message="Valor mìnimo 0"
                                        maxlength="18" data-validation-maxlength-message="Máximo 18 carácteres"
                                        data-validation-required-message="Ingrese recursos propios" 
                                        required>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6 col-md-5 offset-md-1">
                            <div class="form-group">
                                <label for="mEquilibrio">Meses para Punto de Equilibrio: <span class="text-danger">*</span></label>
                                <div class="controls">
                                    <input 
                                        type="NumericTextBox"
                                        id="mEquilibrio" 
                                        name="mEquilibrio"
                                        class="form-control"
                                        min="0" data-validation-min-message="Valor mìnimo 0"
                                        maxlength="38" data-validation-maxlength-message="Máximo 388 carácteres"
                                        data-validation-required-message="Ingrese Meses para Punto de Equilibrio" 
                                        required>
                                </div>
                            </div>
                        </div>
                    </div><!-- row -->

                    <div class="row">                   
                        <div class="col-sm-6 col-md-5">
                            <div class="form-group">
                                <label for="empGenerados">Empleos Generados: <span class="text-danger">*</span></label>
                                <div class="controls">
                                    <input 
                                        type="NumericTextBox"
                                        id="empGenerados" 
                                        name="empGenerados"
                                        class="form-control"
                                        min="0" data-validation-min-message="Valor mìnimo 0"
                                        maxlength="38" data-validation-maxlength-message="Máximo 38 carácteres"
                                        data-validation-required-message="Ingrese Empleos Generados" 
                                        required>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6 col-md-5 offset-md-1">
                            <div class="form-group">
                                <label for="empPorGenerar">Empleos por Generar: <span class="text-danger">*</span></label>
                                <div class="controls">
                                    <input 
                                        type="NumericTextBox"
                                        id="empPorGenerar" 
                                        name="empPorGenerar"
                                        class="form-control"
                                        min="0" data-validation-min-message="Valor mìnimo 0"
                                        maxlength="38" data-validation-maxlength-message="Máximo 38 carácteres"
                                        data-validation-required-message="Ingrese Empleos por Generar" 
                                        required>
                                </div>
                            </div>
                        </div>                        
                    </div><!-- row -->

                    <div class="row">                   
                        <div class="col-sm-6 col-md-5">
                            <div class="form-group">
                                <label for="cTotal">Capital Total: <span class="text-danger">*</span></label>
                                <div class="controls">
                                    <input 
                                        type="NumericTextBox"
                                        id="cTotal" 
                                        name="cTotal"
                                        class="form-control"
                                        min="0" data-validation-min-message="Valor mìnimo 0"
                                        maxlength="38" data-validation-maxlength-message="Máximo 38 carácteres"
                                        data-validation-required-message="Ingrese Capital Total"
                                        disabled
                                        required>
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6 col-md-5 offset-md-1">
                            <div class="form-group">
                                <label for="cTrabajo">Capital de Trabajo: <span class="text-danger">*</span></label>
                                <div class="controls">
                                    <input 
                                        type="NumericTextBox"
                                        id="cTrabajo" 
                                        name="cTrabajo"
                                        class="form-control"
                                        min="0" data-validation-min-message="Valor mìnimo 0"
                                        maxlength="38" data-validation-maxlength-message="Máximo 38 carácteres"
                                        data-validation-required-message="Ingrese Capital de Trabajo" 
                                        required>
                                </div>
                            </div>
                        </div>                        
                    </div><!-- row -->

                    <div class="row">                   
                        <div class="col-sm-6 col-md-5">
                            <div class="form-group">
                                <label for="obSeguimiento">Observaciones <span class="text-danger">*</span></label>
                                <div class="controls">
                                    <textarea class="form-control" id="obSeguimiento" placeholder="Observaciones de Seguimiento"
                                              data-validation-required-message="Ingrese una observación" 
                                              required maxlength="500" data-validation-maxlength-message="Máximo 500 carácteres"></textarea>
                                    <span id="chars">500</span> carácteres restantes.
                                </div>
                            </div>
                        </div>

                        <div class="col-sm-6 col-md-5 offset-md-1">
                            <div class="row">
                                <div class="form-group col-md-6">
                                    <label>Requiere Plan de Acción: <span class="text-danger">*</span></label>
                                    <div class="controls">
                                        <fieldset>
                                            <div class="custom-control custom-radio">
                                                <input type="radio"
                                                       value="si"
                                                       name="plan"
                                                       id="siPlan"
                                                       class="custom-control-input"
                                                       data-validation-required-message="Seleccione una opción"
                                                       required maxlength="500"/>
                                                <label class="custom-control-label" for="siPlan">Si</label>
                                            </div>
                                        </fieldset>
                                        <fieldset>
                                            <div class="custom-control custom-radio">
                                                <input type="radio"
                                                       value="no"
                                                       name="plan"
                                                       id="noPlan"
                                                       class="custom-control-input">
                                                <label class="custom-control-label" for="noPlan">No</label>
                                            </div>
                                        </fieldset>
                                    </div>
                                </div>
                                <div class="form-group col-md-5">
                                    <label>Finalizar proyecto?</label>
                                    <div class="controls">
                                        <input type="checkbox" id="finalizado" name="finalizado" 
                                               disabled/>
                                    </div>
                                </div>
                            </div>
                        </div> 

                    </div><!-- row -->

                    <div class="row">

                    </div><!-- row -->

                    <div class="form-group text-center">
                        <button class="btn btn-danger" type="button" data-dismiss="modal">Cerrar</button>
                        <button type='submit' id="btnRegistrar" class='btn btn-success'><i class="fas fa-calendar-check m-r-5"></i>Registrar</button>
                    </div>
                </div><!-- financiero -->

            </div>

        </div>
    </div>
</div> <!-- modal -->

<script src="${pageContext.request.contextPath}/resources/_assets/modules/multiselect/js/jquery.multi-select.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/_assets/modules/bootstrap-tagsinput/dist/bootstrap-tagsinput.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/consultarBeneficiarioRegistroSeguimiento.js" type="text/javascript"></script>
<script>
    <c:if test="${not empty idFuncionario}">
    idfuncionario = ${idFuncionario};
    </c:if>
    <c:if test="${not empty idCajacompensacion}">
    idcajacompensacion = ${idCajacompensacion};
    </c:if>
</script>
