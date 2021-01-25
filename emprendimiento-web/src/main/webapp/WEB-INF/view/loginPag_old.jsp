<%-- 
    Document   : homepage
    Created on : 12/09/2018, 09:27:32 AM
    Author     : André Felipe González Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <title>Homepage - Emprendimiento</title>
    </head>
    <body>
        <!-- header -->
        <div>
            <nav class="navbar navbar-light" style="background-color: #000099;">
                <h2 Style="color: #ffffff">Bienvenido a Emprendimiento</h2>
            </nav>
        </div> 


        <!--Form de login -->
        <span class="border border-primary">
            <div align="center" >
                <form:form action="${pageContext.request.contextPath}/autenticarUsuario" method="POST">				
                    <div class="container loggin" >
                        <h3>Ingreso</h3><br/>
                        <div class="form-group">
                            <div >
                                <c:if test="${param.error!= null}">
                                    <div class="alert alert-danger" role="alert" style="width : 400px; heigth : 1px" >
                                        <i style="color: #ff0000"> Usuario O contraseña Incorrectos </i>
                                    </div>
                                </c:if>

                                <c:if test="${param.logout!=null}">
                                    <div class="alert alert-success" role="alert" style="width : 400px; heigth : 1px">
                                        <i>Sesión Cerrada</i>
                                    </div>
                                </c:if>
                            </div>  
                            <input  type="text" name="username" class="form-control" placeholder="Ingrese su Usuario"  required="required" style="width : 400px; heigth : 1px" />
                        </div>
                        <div class="form-group">

                            <input type="password" name="password" class="form-control"  placeholder="Ingrese su Contraseña" required="required" style="width : 400px; heigth : 1px"/>

                        </div>

                        <div class="form-group">
                            <div class="checkbox">
                                <label> 
                                    <a href="${pageContext.request.contextPath}/olvidoContrasena" onclick="lockedModal()" style="color: rgba(252,178,20,1.10); text-decoration:none; font-weight: bold;">Olvidé mi contraseña</a>
                                </label>
                            </div>
                        </div>

                        <div class="form-group">
                            <button id="loginBtn" class="btn btn-lg btn-primary btn-block" type="submit" style="width : 400px; heigth : 1px">Entrar</button>
                        </div>
                    </div>  

                </form:form>
            </div>
        </span>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>