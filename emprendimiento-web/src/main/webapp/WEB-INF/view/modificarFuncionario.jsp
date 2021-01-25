<%-- 
    Document   : homepage
    Created on : 12/09/2018, 09:27:32 AM
    Author     : Andrés Felipe González Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<h3>Editar Funcionario</h3>
<hr />
<p>Diligencie el siguiente formulario</p>
<c:if test="${status=='1'}">


    <div id="valora">
        <div class="form-row">
            <div class="form-group col-md-6">
                <div class="controls">
                    <label for="primernombre">Primer Nombre<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="primernombre" name="primernombre" 
                           tabindex="0" placeholder="Primer Nombre" required="required" value="${funcionarioDTO.primernombre}" data-validation-required-message="Ingrese Primer Nombre" maxlength="180">
                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="segundonombre">Segundo Nombre</label>
                <input type="text" class="form-control" id="segundonombre" name="segundonombre"
                       tabindex="0" placeholder="Segundo Nombre" value="${funcionarioDTO.segundonombre}" maxlength="180">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <div class="controls">
                    <label for="primerapellido">Primer Apellido<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="primerapellido" name="primerapellido" 
                           tabindex="0" placeholder="Primer Apellido" required="required" value="${funcionarioDTO.primerapellido}" data-validation-required-message="Ingrese Primer Apellido" maxlength="180">
                </div>
            </div>
            <div class="form-group col-md-6">
                <label for="segundoapellido">Segundo Apellido</label>
                <input type="text" class="form-control" id="segundoapellido" name="segundoapellido"
                       tabindex="0" placeholder="Segundo Apellido" value="${funcionarioDTO.segundoapellido}" maxlength="180">
            </div>
        </div>
        <div class="form-row">
            <div class="form-group col-md-6">
                <div class="controls">
                    <label for="email">Email<span class="text-danger">*</span></label>
                    <input type="email" class="form-control" id="email" name="email" placeholder="email"
                            tabindex="0" required="required" value="${funcionarioDTO.email}" disabled data-validation-required-message="Ingrese Email" maxlength="180">
                    <span id='validacionEmail'></span>
                </div>
            </div>
            <div class="form-group col-md-6">
                <div class="controls">
                    <label for="telefono">Teléfono<span class="text-danger">*</span></label>
                    <input type="NumericTextBox" class="form-control only-number" id="telefono" name="telefono" placeholder="telefono" required="required" value="${funcionarioDTO.telefono}" data-validation-required-message="Ingrese Teléfono"
                           minlength="7" maxlength="15" tabindex="0"
                           data-validation-maxlength-message="El número de teléfono debe tener máximo 15 carácteres" data-validation-minlength-message="El número de teléfono debe tener mínimo 7 carácteres">
                </div>
            </div>
        </div>


        <div class="form-row">
            <div class="form-group col-md-6">
                <label for="idtipodocumento">Tipo de Documento<span class="text-danger">*</span></label>
                <select id="idtipodocumento" class="selectpicker" data-style="btn-info" name="idtipodocumento">
                    <c:forEach items="${tiposDTO}" var="tempTipos">
                        <c:if test="${funcionarioDTO.tipodocumentoid.idtipodocumento == tempTipos.idtipodocumento}">
                            <option value="${tempTipos.idtipodocumento}" selected="">${tempTipos.nombredocumento}</option>
                        </c:if>
                        <c:if test="${funcionarioDTO.tipodocumentoid.idtipodocumento != tempTipos.idtipodocumento}">
                            <option value="${tempTipos.idtipodocumento}">${tempTipos.nombredocumento}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-md-6">
                <div class="controls">
                    <label for="numerodocumento">Número de Documento<span class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="numerodocumento" name="numerodocumento" 
                           tabindex="0" value="${funcionarioDTO.numerodocumento}" data-validation-required-message="Ingrese Número de Documento" maxlength="18" data-validation-maxlength-message="El número de documento debe tener máximo 18 carácteres">
                    <span id="spanNumeroDocumento"></span>
                </div>
            </div>

            <div class="form-group col-md-2">
                <label for="id">Tipo de Funcionario</label>
                <select id="id" class="selectpicker" data-style="btn-info" name="id">
                    <c:forEach items="${groupsDTO}" var="tempGroups">
                        <c:if test="${gmDTO.groups.id==tempGroups.id}">
                            <option value="${tempGroups.id}" selected>${tempGroups.groupName}</option>
                        </c:if>
                        <c:if test="${gmDTO.groups.id!=tempGroups.id}">
                            <option value="${tempGroups.id}" >${tempGroups.groupName}</option>
                        </c:if>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group col-md-2">
                <label for="idestadofuncionario">Estado Funcionario</label>

                <select id="idestadofuncionario" class="selectpicker" data-style="btn-info" name="idestadofuncionario">
                    <c:if test="${funcionarioDTO.estadofuncionario.idestadofuncionario==1}">
                        <option value="1" selected>Activo</option>
                        <option value="0">Inactivo</option>
                    </c:if>
                    <c:if test="${funcionarioDTO.estadofuncionario.idestadofuncionario==0}">
                        <option value="1">Activo</option>
                        <option value="0" selected>Inactivo</option>
                    </c:if>
                </select>
            </div>

        </div>
        <div class="contrasena">

            <div class="form-group">
                <label for="contrasenas">Reestablecer Contraseña<span class="text-danger">*</span></label>
                <div class="controls">
                    <fieldset>
                        <div class="custom-control custom-radio">
                            <input type="radio"
                                   value="1"
                                   name="contrasenas"
                                   id="contrasenaS"
                                   class="custom-control-input"
                                   data-validation-required-message="Seleccione alguna opción"
                                   required />
                            <label class="custom-control-label" for="contrasenaS">Si</label>
                        </div>
                    </fieldset>
                    <fieldset>
                        <div class="custom-control custom-radio">
                            <input type="radio"
                                   value="0"
                                   name="contrasenas"
                                   id="contrasenaN"
                                   class="custom-control-input">
                            <label class="custom-control-label" for="contrasenaN">No</label>
                        </div>
                    </fieldset>
                </div>
            </div>

        </div>
    </div>

    <!-- --->
    <!--        <div class="contrasena">
                <div  class="form-row">
                    <label class="custom-control-label" for="encabezado">Reestablecer Contrasena  </label>
                </div>
                <div  class="form-row">
                       <div class="controls">
                    <div class="custom-control custom-radio custom-control-inline" id="encabezado">
                        <input type="radio" id="contrasenaS" name="contrasenas" class="custom-control-input" value="1"  required="required" data-validation-required-message="Seleccione alguna opción">
        
                        <label class="custom-control-label" for="contrasenaS">Si</label>
                    </div>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" id="contrasenaN" name="contrasenas" class="custom-control-input" value="0"  >
        
                        <label class="custom-control-label" for="contrasenaN">No</label>
                    </div>
                       </div>
                                                                    <td> <input type="checkbox" id="contrasena" name="contrasena" > Reestablecer Contraseña</td>
                </div>
            </div>-->
    <br/>

    <div class="text-center">
        <button type="button" id="btn-Cancelar" class="btn btn-danger">Atrás</button>
        <button type="button" id="btnModificar" class="btn btn-success">Guardar</button>
    </div>
    <input type="hidden" value="${funcionarioDTO.idfuncionario}"  id="idfuncionario">
    <input type="hidden" value="${funcionarioDTO.email}" name="email" id="email">

</c:if>
<c:if test="${status=='0'}">
    <h5>${mensaje}</h5>
</c:if>
<script src="${pageContext.request.contextPath}/resources/js/services/modificarFuncionario.js" type="text/javascript"></script>
