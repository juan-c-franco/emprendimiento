<%-- 
    Document   : encuestaValoracionGruapal
    Created on : nov 21, 2018, 12:46:47 a.m.
    Author     : Grow Data PC
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>



<div id="body_content" class="m-b-footer">
    <h3>Valoración Grupal</h3>
    <hr />
    <p>Diligencie la siguiente encuesta</p>

    <div class="row">
        <div class="col-6 offset-2">
            <h4>Preguntas</h4>
        </div>

        <div class="col-2">
            <h4>Respuestas</h4>
        </div>
    </div>
    <br />
    <div id="valora">
        <c:forEach var="temppreguntas" items="${preguntasDTO}" varStatus="loop">

            <div class="row align-items-center">
                <div class="col-6 offset-2">
                    <p>${temppreguntas.textopregunta}</p>
                </div>

                <div class="col-4">


                    <div class="form-group row">

                        <div class="icheck-list" >
                            <input type="hidden" id="idtema${loop.index}" value="${temppreguntas.temasevaluacion.idtema}">
                            <a class="preguntas">
                                <div class="controls"> 
                                    <div class="custom-control custom-radio">
                                        <input type="radio" 
                                               class="custom-control-input" 
                                               id="a${temppreguntas.idpregunta}" 
                                               name="${temppreguntas.idpregunta}" 
                                               value="1" 
                                               data-radio="iradio_square-blue" 
                                               data-validation-required-message="Seleccione una opción"
                                               required="required" />
                                        <label class="custom-control-label" for="a${temppreguntas.idpregunta}">Si</label>
                                    </div>

                                    <div class="custom-control custom-radio">
                                        <input type="radio" 
                                               class="custom-control-input" 
                                               id="b${temppreguntas.idpregunta}" 
                                               name="${temppreguntas.idpregunta}" 
                                               value="0" 
                                               data-radio="iradio_square-blue"/>
                                        <label class="custom-control-label" for="b${temppreguntas.idpregunta}">No</label>
                                    </div>
                                </div>
                            </a>
                        </div>

                    </div>



                </div>
            </div>
            <hr />             
        </c:forEach>
    </div>
    <!--tabla vieja********************************************-->

    <!--            <table class="table  table-bordered table-hover" >
                    <thead
                        <tr>
    
                            <th>Pregunta</th>
                            <th>Respuesta</th>
                        </tr>
                    </thead>
                    <tbody 
    <c:if test="${not empty mensajeError}">
<h4>${mensajeError}</h4>
    </c:if>
    <c:if test ="${not empty preguntasDTO}">
        <c:forEach var="temppreguntas" items="${preguntasDTO}" varStatus="loop">
            <tr>
            <div class="list-group">

                <td> <a >${temppreguntas.textopregunta}</a> <input type="hidden" id="idtema${loop.index}" value="${temppreguntas.temasevaluacion.idtema}"></td>       
                <td> <a class="preguntas">
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="a${temppreguntas.idpregunta}"  name="${temppreguntas.idpregunta}" class="custom-control-input" value="1" required="required" >

                            <label class="custom-control-label" for="a${temppreguntas.idpregunta}">Si</label>
                        </div>
                        <div class="custom-control custom-radio custom-control-inline">
                            <input type="radio" id="b${temppreguntas.idpregunta}"  name="${temppreguntas.idpregunta}" class="custom-control-input" value="0" required="required" >

                            <label class="custom-control-label" for="b${temppreguntas.idpregunta}"> No </label>
                        </div>
                    </a></td>

            </div>

            </tr>

        </c:forEach>
    </c:if>
    </tbody>
</table>-->
    <br/>
    <div class="text-center">


        <input type="hidden" name="idEmprendimiento" id="idEmprendimiento" value='${idEmprendimiento}'/>  
        <button class="btn btn-danger align-content-center" type="button" id="btn-Cancelar">Atrás</button>
        <button class="btn btn-success align-content-center" type="button" id="btnRegistro">Enviar</button>


    </div>
</div>

<script src="${pageContext.request.contextPath}/resources/js/services/registrarEncuestaValoracionGrupal.js" type="text/javascript"></script>
