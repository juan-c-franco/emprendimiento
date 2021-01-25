<%-- 
    Document   : Layout Modals
    Created on : 08/11/2018, 11:00:00 AM
    Author     : Juan C. Pulido to Grow Data PC
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<div class="modal fade" id="mCerrarSession" tabindex="-1" role="dialog" aria-labelledby="mCerrarSessionLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
       <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="mCerrarSessionLabel">Cerrar Sesión</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">¿Realmente desea cerrar la sesión?</div>
            <div class="modal-footer">
                <button class="btn btn-danger" type="button" data-dismiss="modal">Cancelar</button>
                <a class="btn btn-success" href="${pageContext.request.contextPath}/logout">Salir</a>

            </div>
        </div>
    </div>
</div>



<div class="modal fade" id="modalLoader" tabindex="-1" role="dialog" aria-labelledby="modalLoader" aria-hidden="true">
    <div class="modal-dialog  " role="document">
        <div class="row justify-content-center">
            <div class="loader" style="margin-top:30%"></div>
        </div>
    </div>
</div>

<div id="modalComprobar" class="modal fade" tabindex="-1" role="dialog" aria-labelledby="modalComprobarLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="modalComprobarLabel">label</h5>
                <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">×</span>
                </button>
            </div>
            <div class="modal-body">mensaje</div>
            <div class="modal-footer">
                <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancelar</button>
                <a class="btn btn-primary" id="btnModalComprobar">Enviar</a>
            </div>
        </div>
    </div>
</div>