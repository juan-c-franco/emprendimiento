<%-- 
    Document   : encuestaValoracion
    Created on : ene 21, 2019, 12:09:01 p.m.
    Author     : Andres Gonzalez Grow Data PC
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="pagina" value="encuesta" />
<c:set var="titulo" value="Encuesta Valoraci&oacute;n" />

<jsp:include page="../layouts/_header.jsp">
    <jsp:param name="pagina" value="${pagina}"/>
    <jsp:param name="titulo" value="${titulo}"/>
    <jsp:param name="cssItems" value="_assets/modules/icheck/skins/all.css" />
    <jsp:param name="cssItems" value="_dist/css/pages/form-icheck.css" />   
    <jsp:param name="cssItems" value="_assets/modules/sweetalert/sweetalert.css" /> 
</jsp:include>

<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-body collapse show">
                <h2 class="card-title text-center"><img src="${pageContext.request.contextPath}/resources/_assets/images/logo-mpc.png" alt="Mintrabajo - MPC" class="img-fluid"></h2>
            </div>
        </div>
    </div>
</div>

<div class="row m-b-footer">
    <div class="col-8 offset-2">
        <div class="card">
            <div class="card-body collapse show">
                <h2 class="card-title text-center">Encuesta Valoración</h2>
                <hr />

                <form:form method="post" novalidate="novalidate">
                    <input type="hidden" name="idBeneficiario" id="idBeneficiario" value="${idBeneficiario}" />  
                    <input type="hidden" name="idEncuesta" id="idEncuesta" value="${idEncuesta}" />




                    <div class="row">
                        <div class="col-6 offset-2">
                            <h4><strong>Preguntas</strong></h4>
                        </div>

                        <div class="col-2">
                            <h4><strong>Respuestas</strong></h4>
                        </div>
                    </div>
                    <br />
                    <div id="valora">
                        <c:forEach var="temppreguntas" items="${preguntasDTO}">

                            <div class="row align-items-center">
                                <div class="col-6 offset-2">
                                    <p>${temppreguntas.textopregunta}</p>
                                </div>

                                <div class="col-4 preguntas">

                                    <div class="form-group row">

                                        <div class="icheck-list">

                                            <div class="custom-control custom-radio">
                                                <input type="radio" 
                                                       class="check" 
                                                       id="a${temppreguntas.idpregunta}" 
                                                       name="${temppreguntas.idpregunta}" 
                                                       value="1" 
                                                       data-radio="iradio_square-blue" 
                                                       data-validation-required-message="Seleccione una opción"
                                                       required="required" />
                                                <label for="a${temppreguntas.idpregunta}">Si</label>
                                            </div>

                                            <div class="custom-control custom-radio controls">
                                                <input type="radio" 
                                                       class="check" 
                                                       id="b${temppreguntas.idpregunta}" 
                                                       name="${temppreguntas.idpregunta}" 
                                                       value="0" 
                                                       data-radio="iradio_square-blue"/>
                                                <label for="b${temppreguntas.idpregunta}">No</label>
                                            </div>

                                        </div>

                                    </div>

                                </div>
                            </div>
                            <hr />             
                        </c:forEach>
                    </div>



                    <div class="form-group text-center">
                        <button type="submit" id="btnRegistro" class="btn btn-primary waves-effect waves-light">Enviar Encuesta</button>
                    </div>

                </form:form>

                <div class="alert alert-success" id="encuestaGracias" style="display: none;">
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
                    <h3 class="text-success"><i class="fa fa-check-circle"></i> Usuario Creado</h3> 
                    <p>Gracias por sus respuestas.</p>
                </div>                    

            </div>
        </div>
    </div>
</div>
<!--<script src="${pageContext.request.contextPath}/resources/js/services/encuestaValoracion.js" type="text/javascript"></script>-->                              
<script>
    <c:if test="${not empty idEncuesta}">
    idencuesta = ${idEncuesta};
    </c:if>
</script>                             
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<jsp:include page="../layouts/_footer.jsp">
    <jsp:param name="pagina" value="${pagina}"/>
    <jsp:param name="jsItems" value="_dist/js/waves.min.js"/> 
    <jsp:param name="jsItems" value="_dist/js/validation.min.js"/>
    <jsp:param name="jsItems" value="_assets/modules/icheck/icheck.min.js"/>
    <jsp:param name="jsItems" value="_assets/modules/icheck/icheck.init.js"/>    
    <jsp:param name="jsItems" value="_dist/js/general.js"/>    
    <jsp:param name="jsItems" value="js/services/encuestaValoracion.js"/>
    <jsp:param name="jsItems" value="_assets/modules/sweetalert/sweetalert.min.js"/>
</jsp:include>