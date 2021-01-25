<%-- 
    Document   : encuestaValoracion
    Created on : nov 14, 2018, 9:49:59 a.m.
   Author     : Andrés Felipe González Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<div class="m-b-footer">
    <h3>Valoración Individual</h3>
    <hr />
    <p>Diligencie la siguiente encuesta</p>

    <%--<c:if test="${not empty mensajeError}">--%>
    <c:if test ="${empty preguntasDTO}">
        <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensajeError}
            <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
        </div>
    </c:if>
    <c:if test ="${not empty preguntasDTO}">


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

                <div class="row align-items-center" >
                    <div class="col-6 offset-2">
                        <p>${temppreguntas.textopregunta}</p>
                        <input type="hidden" id="idtema${loop.index}" value="${temppreguntas.temasevaluacion.idtema}">
                    </div>

                    <div class="col-4 preguntas">

                        <div class="form-group row">

                            <div class="icheck-list">

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

                                <div class="custom-control custom-radio controls">
                                    <input type="radio" 
                                           class="custom-control-input" 
                                           id="b${temppreguntas.idpregunta}" 
                                           name="${temppreguntas.idpregunta}" 
                                           value="0" 
                                           data-radio="iradio_square-blue"/>
                                    <label class="custom-control-label" for="b${temppreguntas.idpregunta}">No</label>
                                </div>

                            </div>

                        </div>

                    </div>
                </div>
                <hr />             
            </c:forEach>
        </div>
        <!-- tabla vieja -->
        <!--    <table class="table  table-bordered table-hover" >
                <thead>
                    <tr>
        
                        <th>Pregunta</th>
                        <th>Respuesta</th>
                    </tr>
                </thead>
                <tbody> 
        
        
        <c:forEach var="temppreguntas" items="${preguntasDTO}" varStatus="loop">
            <tr>
        <div class="list-group">
    
            <td> <a >${temppreguntas.textopregunta}</a> <input type="hidden" id="idtema${loop.index}" value="${temppreguntas.temasevaluacion.idtema}"></td>       
            <td> <a class="preguntas">  <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio" id="a${temppreguntas.idpregunta}"  name="${temppreguntas.idpregunta}" class="custom-control-input" value="1" required="required" >
    
                        <label class="custom-control-label" for="a${temppreguntas.idpregunta}">Si</label>
                    </div>
                    <div class="custom-control custom-radio custom-control-inline">
                        <input type="radio"  id="b${temppreguntas.idpregunta}"  name="${temppreguntas.idpregunta}" class="custom-control-input" value="0"  required="required" >
    
                        <label class="custom-control-label" for="b${temppreguntas.idpregunta}"> No </label>
                    </div></a></td>
    
        </div>
    
    </tr>
    
        </c:forEach>
    
    </tbody>
    </table>-->
        <br/>
        <div class="form-group text-center">
            <button type="submit" id="btnRegistro" class="btn btn-primary waves-effect waves-light">Enviar Encuesta</button>
        </div>

        <!--    <button  class="btn btn-primary" type="button" id="btnRegistro">-->

        <input type="hidden" name="idBeneficiario" id="idBeneficiario" value='${idBeneficiario}'/>  


        <!--    Enviar Encuesta
        </button>-->
    </c:if>
</div>

<script src="${pageContext.request.contextPath}/resources/js/services/registrarEncuestaValoracionInd.js" type="text/javascript"></script>