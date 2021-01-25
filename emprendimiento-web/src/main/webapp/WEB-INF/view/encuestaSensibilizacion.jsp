<%-- 
    Document   : login
    Created on : 17/12/2018, 07:40:32 AM
    Author     : Juan C Pulido
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="pagina" value="encuesta" />
<c:set var="titulo" value="Encuesta Sensibilizaci&oacute;n" />

<jsp:include page="../layouts/_header.jsp">
    <jsp:param name="pagina" value="${pagina}"/>
    <jsp:param name="titulo" value="${titulo}"/>
    <jsp:param name="cssItems" value="_assets/modules/icheck/skins/all.css" />
    <jsp:param name="cssItems" value="_dist/css/pages/form-icheck.css" />   
    <jsp:param name="cssItems" value="_assets/modules/sweetalert/sweetalert.css"/>
</jsp:include>

<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-body collapse show">
                <h2 class="card-title text-center"><img src="${pageContext.request.contextPath}/resources/_assets/images/gobierno-logos.png" alt="Gobierno Colombia - Mintrabajo - MPC" class="img-fluid"></h2>
            </div>
        </div>
    </div>
</div>
<div class="col-8 offset-2">
    <div class="card">
        <div class="card-body collapse show">
            <div class="row align-items-center">
                <div class="col-12">

                    <c:if test="${not empty respuesta}">
                        <c:if test="${respuesta == '1'}">
                            <div class="alert alert-success"> <i class="fa fa-check-circle"></i> ${mensaje3}
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
                            </div>
                        </c:if>
                        <c:if test="${respuesta == '0'}">
                            <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje3}
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
                            </div>
                        </c:if>

                    </c:if>

                    <div id="mensajes" class="alert" style="display: none"> <i id="i" class="fa fa-check-circle"></i>
                        <span></span>
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
                    </div>

                </div>
            </div>
        </div>
    </div>
</div>

<c:if test="${empty respuesta}">
    <div id="divEncuesta" class="row">
        <div class="col-8 offset-2">
            <div class="card">
                <div class="card-body collapse show">
                    <h2 class="card-title text-center">Encuesta Sensibilización</h2>
                    <hr />
                    <div id="mensajes" class="alert" style="display: none"> <i class="fa fa-check-circle"></i>
                        <span></span>
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
                    </div>
                    <form:form method="post" novalidate="novalidate">
                        <input type="hidden" name="idBeneficiario" id="idBeneficiario" value="${idBeneficiario}" />  
                        <input type="hidden" name="idEncuesta" id="idEncuesta" value="${idEncuesta}" />
                        <!--                        <input type="hidden" name="isTest" id="isTest" value="1"/>-->

                        <!--                    <div class="alert alert-info" id="messageTest" style="display: none;">Estamos en modo Test.</div>-->

                        <div class="row">
                            <div class="col-6 offset-2">
                                <h4><strong>Preguntas</strong></h4>
                            </div>

                            <div class="col-2">
                                <h4><strong>Respuestas</strong></h4>
                            </div>
                        </div>
                        <br />
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
                        <div class='text-center'>
                            <button type="button" class="btn btn-sm btn-success" data-toggle="modal" data-target="#terminosEncuesta"> <i class="fas fa-eye"></i> Ver términos</button>
                            <br><br>
                            <!-- CheckBox Terminos -->
                            <div class="form-group row justify-content-md-center">
                                <div class="icheck-list">
                                    <div class="custom-control custom-checkbox">
                                        <div class="controls">
                                            <input type="checkbox" 
                                                   class="check" 
                                                   id="terminos" 
                                                   name="terminos" 
                                                   data-checkbox="icheckbox_square-blue"
                                                   data-validation-required-message="Para continuar es necesario aceptar los términos y condiciones"
                                                   required />
                                        </div>
                                        <label for="terminos">Acepto términos y condiciones </label> 
                                    </div>
                                </div>
                            </div>
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
</c:if>

<!-- Modal -->
<div class="modal fade" id="terminosEncuesta" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h4 class="modal-title">Términos y condiciones</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
            </div>
            <div class="modal-body">
                <p>
                    Declaro bajo la gravedad del juramento que:<br>
                    <br>
                    Autorizo de manera voluntaria, explicita, previamente informada e inequívoca, de acuerdo a lo dispuesto en los artículos 1, 2, 4, 15, 17 de la Ley 1581 de 2012 decretada por el Congreso de Colombia, el artículo 3, 4, 5, 10 y 24 del Decreto 1377 de 2013 del Ministerio de Tecnologías de la Información y las Comunicaciones y el Decreto 886 de 2012 emanado por la Oficina de Presidencia, los artículos 4, 5, 6 y 10 de la Ley 1780 de 2016 decretada por el Congreso de Colombia, para tratar mi información personal y protección de Datos Personales; información que será utilizada en el desarrollo de las funciones propias de la plataforma SI-MPC y ser beneficiario al Componente de Promoción de Emprendimiento y Desarrollo Empresarial, como:<br>
                    <br>
                    •Cruces de datos básicos, idiomas y otros conocimientos registrados en la hoja de vida del Sistema de Información del Servicio Público de Empleo.<br>
                    •Cruces de datos del Sistema de Información del Servicio de Empleo - SISE.<br>
                    •Cruces de datos de maestro FOSFEC (Fondo de Solidaridad de Fomento al Empleo y Protección al Cesante).<br>
                    •Cruces de datos de dependientes económicos, de instituciones, sedes y de datos PILA (Planilla Integral de Liquidación de Aportes).<br>
                    •La realización de estudios internos sobre fines estadísticos y analíticos de los datos, para mejoras de nuestros servicios; información sobre la cual podré, en cualquier momento, ejercer mis derechos de Habeas Data, para solicitar que no se me envíe información de los servicios en los casos que sea pertinente.<br>
                    <br>
                    Como titular de la información personal sobre la que el Ministerio de Trabajo ejerce el tratamiento, se me informa sobre los canales a través de los cuales puedo ejercer mis derechos a conocer, actualizar, rectificar, suprimir mis datos personales, entre ellos el correo electrónico.<br>
                    La protección de datos personales efectuada por Sistema de Información del Componente de Emprendimiento y Desarrollo Empresarial, cumple con los principios de finalidad, necesidad, circulación restringida, confidencialidad y seguridad señalados en la Ley 1581 de 2012 decretada por el Congreso de Colombia y manifiesto expresamente que conozco dónde consultar la información sobre protección de datos personales, así como los efectos y alcance de la presente autorización y que no he sido coaccionado en el momento de otorgarla.<br>
                    <br>
                    Uso de la Plataforma: La utilización de la Plataforma por parte del usuario se ceñirá estrictamente a lo establecido en el presente documento de términos y condiciones de uso; a través del portal, el usuario podrá acceder y utilizar los servicios allí contenidos y puestos a su disposición por parte del Ministerio del Trabajo a través del Componente de Promoción de Emprendimiento y Desarrollo Empresarial.<br>
                    La Plataforma eventualmente podrá negar, restringir o condicionar el acceso y uso del Portal Transaccional al usuario, total o parcialmente a su entera discreción y en los casos que así lo considere, y de la misma manera, tendrá el derecho de modificar y/o todo o parte del contenido del portal en cualquier momento y sin necesidad de previo aviso.<br>
                    <br>
                    Cookies: El usuario acepta recibir las cookies que le transmita la Plataforma y las cuales pueden contener, entre otros, información sobre identificación proporcionada por el usuario o información para rastrear las páginas que el usuario o cliente ha visitado.<br>
                    <br>
                    Autorizaciones: El usuario autoriza de forma permanente al sistema de información del Componente de Promoción de Emprendimiento y Desarrollo Empresarial para enviar a mi correo electrónico mensajes con información transaccional, de productos, de seguridad, servicio o cualquier otro concepto que considere necesaria y/o apropiada para la prestación de los servicios.<br>
                </p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-danger" data-dismiss="modal">Cerrar</button>
            </div>
        </div>
        <!-- /.modal-content -->
    </div>
    <!-- /.modal-dialog -->
</div>
<!-- /.modal -->                  

<jsp:include page="../layouts/_footer.jsp">
    <jsp:param name="pagina" value="${pagina}"/>
    <jsp:param name="jsItems" value="_dist/js/waves.min.js"/> 
    <jsp:param name="jsItems" value="_dist/js/validation.min.js"/>
    <jsp:param name="jsItems" value="_assets/modules/icheck/icheck.min.js"/>
    <jsp:param name="jsItems" value="_assets/modules/icheck/icheck.init.js"/>    
    <jsp:param name="jsItems" value="_dist/js/general.js"/>    
    <jsp:param name="jsItems" value="js/services/registrarEncuesta.js"/>
    <jsp:param name="jsItems" value="_assets/modules/sweetalert/sweetalert.min.js"/>
</jsp:include>
