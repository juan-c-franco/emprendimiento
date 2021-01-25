<%-- 
    Document   : cambio clave
    Created on : 16/11/2018, 07:40:32 AM
    Author     : Juan C Pulido
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="pagina" value="login" />
<c:set var="titulo" value="Cambio Clave - Emprendimiento" />

<jsp:include page="../layouts/_header.jsp">
    <jsp:param name="pagina" value="${pagina}"/>
    <jsp:param name="titulo" value="${titulo}"/>
    <jsp:param name="cssItems" value="_dist/css/pages/login-register-lock.css" />
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

<div class="login-register">
    <div class="login-box card">
        <div class="card-body">

            <form:form action="${pageContext.request.contextPath}/restaurarContra" modelAttribute="Users" method="POST" class="form-horizontal" novalidate="novalidate">                       
                <h3 class="text-center m-b-20"><i class="fas fa-user"></i> Recuperar contraseña</h3>
                <br />
                <c:if test="${not empty user}" >
                    <div class="alert alert-info">Usuario: ${user.username}</div>
                    <input type="hidden" name="username" value="${user.username}">
                    <input type="hidden" name="password" value="${user.password}">
                    <input type="hidden" name="enabled" value="${user.enabled}">
                    <input type="hidden" name="id" value="${user.iduser}">


                    <br />
                    <div class="form-group text-center">
                        <div class="col-xs-12 p-b-20">
                            <button class="btn btn-block btn-lg btn-primary btn-rounded" type="submit">Restaurar Clave</button>
                        </div>
                    </div>  
                </c:if>
                <c:if test="${caducado != null}">
                    <div class="alert alert-danger alert-rounded"> ${caducado}
                        <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>  
                    </div>
                </c:if>
            </form:form>

        </div>
    </div>
</div>

<jsp:include page="../layouts/_footer.jsp">
    <jsp:param name="pagina" value="${pagina}"/>
    <jsp:param name="jsItems" value="_dist/js/login.js"/>
</jsp:include>