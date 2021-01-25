<!--
    Document   : login
    Created on : 16/11/2018, 07:40:32 AM
    Author     : Juan C Pulido-->


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="pagina" value="login" />
<c:set var="titulo" value="Login - Emprendimiento" />

<jsp:include page="../layouts/_header.jsp">
    <jsp:param name="pagina" value="${pagina}"/>
    <jsp:param name="titulo" value="${titulo}"/>
    <jsp:param name="cssItems" value="_dist/css/pages/login-register-lock.css" />
    <jsp:param name="cssItems" value="_assets/modules/sweetalert/sweetalert.css"/>
</jsp:include>

<div class="row">
    <div class="col-12">
        <div class="card">
            <div class="card-body collapse show">
                <h2 class="text-center m-b-0"><img src="${pageContext.request.contextPath}/resources/_assets/images/logo-mpc.png" alt="Mecanismo de Protección al Cesante" class="img-fluid"></h2>
            </div>
        </div>
    </div>
</div>

<div class="row login-register">
    <div class="login-box card">
        <div class="card-body">


            <c:if test="${param.error!= null}">
                <div class="alert alert-danger alert-rounded" id="Eerror"> ${error}
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>  
                </div>
                <%--  <c:choose>
                      <c:when test="${SPRING_SECURITY_LAST_EXCEPTION.message == 'Bad credentials'}">
                          <div class="alert alert-danger alert-rounded"> Usuario/Contraseña Incorrectos
                              <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>  
                          </div>
                      </c:when>
                       <c:when test="${SPRING_SECURITY_LAST_EXCEPTION.message == 'Maximum sessions of 1 for this principal exceeded'}">
                          <div class="alert alert-danger alert-rounded"> El usuario ya se encuentra en sesión, solo se permite una sesión simultanea
                              <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>  
                          </div>
                      </c:when>
                      <c:otherwise>
                          <div class="alert alert-danger alert-rounded"> Ocurrio un error desconocido, por favor contacte al administrador del sistema
                              <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>  
                          </div>
                      </c:otherwise>
                  </c:choose> --%>
                <hr>
            </c:if> 



            <c:if test="${param.logout!=null}">
                <div class="alert alert-info alert-rounded"> Sesión Cerrada 
                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
                </div>
                <hr>
            </c:if>

            <form:form action="${pageContext.request.contextPath}/autenticarUsuario" method="POST" id="loginform" class="form-horizontal" novalidate="novalidate">                    
                <h3 class="text-center m-b-20"><i class="fas fa-user"></i> Ingreso</h3>
                <div class="form-group ">
                    <div class="col-xs-12">
                        <div class="controls">
                            <input type="text" 
                                   name="username2" 
                                   class="form-control" 
                                   id="username2"
                                   placeholder="Ingrese su Usuario" 
                                   data-validation-required-message="Ingrese su usuario"
                                   required />
                            <input type="hidden" name="username" id="username"/> 
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-xs-12">
                        <div class="controls">
                            <input type="password" 
                                   name="password" 
                                   class="form-control"  
                                   placeholder="Ingrese su Contraseña" 
                                   data-validation-required-message="Ingrese su contraseña"
                                   required />
                        </div>
                    </div>
                </div>
                <div class="form-group row">
                    <div class="col-md-12">
                        <div class="d-flex no-block align-items-center">
<!--                            <div class="custom-control custom-checkbox">
                                <input type="checkbox" class="custom-control-input" id="customCheck1">
                                <label class="custom-control-label" for="customCheck1">Recordarme</label>
                            </div> -->
                            <div class="ml-auto">
                                <a href="javascript:void(0)" id="to-recover" class="text-muted"><i class="fas fa-lock m-r-5"></i> ¿Olvide mi contraseña?</a> 
                            </div>
                        </div>
                    </div>
                </div>
                <div class="/*form-group*/ text-center">
                    <div class="col-xs-12 p-b-20">
                        <button id="loginBtn" class="btn btn-block btn-lg btn-primary btn-rounded" type="submit">Ingresar</button>
                    </div>
                </div>

            </form:form>

            <form:form action="${pageContext.request.contextPath}/correoContrasena" method="get" id="recoverform" modelAttribute="Users" class="form-horizontal" novalidate="true">
                <div class="form-group ">
                    <div class="col-xs-12">
                        <h3>Recuperar Contraseña</h3>
                        <p class="text-muted">Ingresa tu email y enviaremos instrucciones para recuperar contraseña! </p>
                    </div>
                </div>
                <div class="form-group ">
                    <div class="col-xs-12">
                        <div class="controls">
                            <input type="email" 
                                   name="correo" 
                                   class="form-control" 
                                   placeholder="Email"
                                   data-validation-required-message="Ingrese un email válido"
                                   data-validation-email-message="Ingrese un email válido"
                                   required /> 
                        </div>
                    </div>
                </div>
                <div class="form-group text-center m-t-20">
                    <div class="col-xs-12">
                        <button id="recoveryBtn" class="btn btn-secondary btn-lg btn-block text-uppercase waves-effect waves-light" type="submit">Recuperar</button>
                    </div>
                </div>
                <div class="ml-auto">
                    <a href="javascript:void(0)" id="to-login" class="text-muted"><i class="fas fa-user m-r-5"></i> Volver</a> 
                </div>
            </form:form>
                
            <div class="collapse show">
                <h2 class="text-center m-b-0 m-t-10"><img src="${pageContext.request.contextPath}/resources/_assets/images/gobierno-logos.png" 
                                                       alt="Gobierno Colombia - Mintrabajo - MPC" class="img-fluid"></h2>
                    
            </div>    
        </div>
    </div>
</div>

<!--<div class="row">
    <div class="col-12 footer-login">
        <div class="card no-margin">
            <div class="card-body collapse show">
                <h2 class="text-center no-margin">
                    <img src="${pageContext.request.contextPath}/resources/_assets/images/gobierno-logos.png" alt="Gobierno Colombia - Mintrabajo - MPC" class="img-fluid"></h2>
            </div>
        </div>
    </div>
    
</div>-->

<div class="modal fade" id="modalObligatorio"  role="dialog"
     aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-md" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title">Actualice la contraseña para acceder a la aplicación</h5>
                <button class="close" type="button" data-dismiss="modal"
                        aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body col-md-11 ">
                <div class="form-group">


                    <form:form method="post" novalidate="novalidate">
                        <div id="valora" class="justify-content-md-center">
                            <div class="form-group col-md-12">
                                <div class="controls">
                                    <label  for="password">Contraseña actual<span class="text-danger">*</span></label>
                                    <input type="password" class="form-control mb-2" id="password" name="password" placeholder="Contraseña" required="required" data-validation-required-message="Ingrese la Contraseña">
                                </div>
                            </div>
                            <br/>
                            <div class="form-group col-md-12">
                                <div class="controls">
                                    <label  for="contrasenaN">Nueva Contraseña<span class="text-danger">*</span></label>
                                    <input type="password" class="form-control mb-2" id="contrasenaN" name="contrasenaN" placeholder="Nueva Contraseña" required="required" data-validation-required-message="Ingrese la Contraseña Nueva" minlength="8" data-validation-minlength-message="La contraseña debe tener mínimo 8 carácteres, una mayúscula, una minúscula, un número y un carácter especial">
                                    <span id="regggex1"></span>
                                </div>
                            </div>
                            <br/>
                            <div class="form-group col-md-12">
                                <div class="controls">
                                    <label  for="contrasenaN2">Confirmar Nueva Contraseña<span class="text-danger">*</span></label>
                                    <input type="password" class="form-control mb-2" id="contrasenaN2" name="contrasenaN2" placeholder="Confirmar Nueva Contraseña" required="required" data-validation-match-match="contrasenaN" data-validation-required-message="Ingrese la Contraseña Nueva" data-validation-match-message="Las contraseñas no coinciden" >
                                    <span id="regggex2"></span>
                                </div>
                            </div>
                        </div>
                    </form:form>
                </div>

            </div>
            <div class="text-center">
                <button class="btn btn-danger m-b-20" type="button" data-dismiss="modal">Cerrar</button>
                <button type="button" id="btnModificar" class="btn btn-success m-b-20">Guardar</button>
            </div>
        </div>
    </div>
</div>

<script>
    username = "${usuario}";
    var obligatorio = 0;
    <c:if test="${obligatorio!= null}">
    obligatorio = ${obligatorio};
    </c:if>
</script>
<jsp:include page="../layouts/_footer.jsp">
    <jsp:param name="pagina" value="${pagina}"/>
    <jsp:param name="jsItems" value="_dist/js/validation.min.js"/>
    <jsp:param name="jsItems" value="_dist/js/login.js"/>
    <jsp:param name="jsItems" value="_assets/modules/sweetalert/sweetalert.min.js"/>
    <jsp:param name="jsItems" value="_assets/modules/sweetalert/sweetalert-dev.js"/>
</jsp:include>
