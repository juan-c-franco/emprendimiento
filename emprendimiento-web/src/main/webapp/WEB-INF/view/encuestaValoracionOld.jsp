<%-- 
    Document   : encuestaValoracionInd
    Created on : nov 15, 2018, 12:27:12 a.m.
    Author     : Andrés Felipe González M Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<html>
    <head>
        <meta charset="utf-8">
        <!--        <meta http-equiv="X-UA-Compatible" content="IE=edge">-->
        <!--        <link rel="icon" th:href="@{images/Escuelapp.png}">-->
        <meta name="viewport"
              content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        <title>Emprendimiento-Home</title>

        <link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel="stylesheet"
              type="text/css" />

        <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet" type="text/css" />

        <link href="${pageContext.request.contextPath}/resources/css/mdb.css" rel="stylesheet" type="text/css"/>

    </head>

    <body>

        <c:if test="${not empty mensajeError}">
            <h4>${mensajeError}   </h4>
        </c:if> 

        <c:if test="${not empty preguntasDTO}">
            <table class="table  table-bordered table-hover" >
                <thead
                    <tr>

                        <th>Pregunta</th>
                        <th>Respuesta</th>
                    </tr>
                </thead>
                <tbody 
                    <c:forEach var="temppreguntas" items="${preguntasDTO}">
                        <tr>
                    <div class="list-group">

                        <td> <a >${temppreguntas.textopregunta}</a></td>       
                        <td> <a class="preguntas">  <div class="custom-control custom-radio custom-control-inline">
                                    <input type="radio" id="a${temppreguntas.idpregunta}"  name="${temppreguntas.idpregunta}" class="custom-control-input" value="1" required="required" >

                                    <label class="custom-control-label" for="a${temppreguntas.idpregunta}">Si</label>
                                </div>
                                <div class="custom-control custom-radio custom-control-inline">
                                    <input type="radio"  id="b${temppreguntas.idpregunta}"  name="${temppreguntas.idpregunta}" class="custom-control-input" value="0"  required="required" >

                                    <label class="custom-control-label" for="b${temppreguntas.idpregunta}">No</label>
                                </div></a></td>
                    </div>

                </tr>

            </c:forEach>
        </tbody>
    </table>

    <br/>
    <button  class="btn btn-primary" type="button" id="btnRegistro">

        <input type="hidden" name="idBeneficiario" id="idBeneficiario" value='${idBeneficiario}'/>  
        <input type="hidden" name="idEncuesta" id="idEncuesta" value='${idEncuesta}'/>  

        Enviar Encuesta
    </button>
</c:if>
</div>

<script src="${pageContext.request.contextPath}/resources/js/jquery.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery-easing/jquery.easing.min.js"
type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/fontawesome.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/sb-admin.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins/moment.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/mdb.js" type="text/javascript"></script>
<script src="${pageContext.request.contextPath}/resources/js/services/registrarEncuestaValoracion.js" type="text/javascript"></script>
</body>

</html>

