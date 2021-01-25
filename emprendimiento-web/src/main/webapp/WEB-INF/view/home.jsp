<%-- 
    Document   : Template Page
    Created on : 31/10/2018, 23:50:00 AM
    Author     : Juan C. Pulido to Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<c:set var="pagina" value="index" />
<c:set var="titulo" value="Emprendimiento" />

<jsp:include page="../layouts/_header.jsp">
    <jsp:param name="pagina" value="${pagina}"/>
    <jsp:param name="titulo" value="${titulo}"/>
    <jsp:param name="cssItems" value="_assets/modules/bootstrap-select/bootstrap-select.min.css" />
    <jsp:param name="cssItems" value="_assets/modules/datatables/media/css/dataTables.bootstrap4.min.css" />
    <jsp:param name="cssItems" value="_assets/modules/fullcalendar/fullcalendar.min.css" />
    <jsp:param name="cssItems" value="_assets/modules/jquery-ui-1.12.1/jquery-ui.css" />
    <jsp:param name="cssItems" value="_assets/modules/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css" />
    <jsp:param name="cssItems" value="_assets/modules/toastr/toastr.min.css"/>
    <jsp:param name="cssItems" value="_assets/modules/sweetalert/sweetalert.css"/>
</jsp:include>

<jsp:include page="../layouts/_bar-top.jsp"/>

<jsp:include page="../layouts/_sidebar-left.jsp"/>

<!-- ---------------------------------------------------- -->
<!-- Page wrapper  -->
<div class="page-wrapper">

    <!-- ---------------------------------------------------- -->
    <!-- Container fluid  -->
    <div class="container-fluid">

        <jsp:include page="../layouts/_breadcrums.jsp">
            <jsp:param name="titulo" value="${titulo}"/>
        </jsp:include>

        <!-- ---------------------------------------------------- -->               
        <!-- Inicio contenido -->
        <form  novalidate="true" id="theForm">
            <div class="row">
                   
                    <div class="col-12">
                        <!-- Card -->
                        <div class="card">
                            <div class="card-body" id="body_content">
                                <div class="text-center" style="width: 380px; margin: 0 auto; padding: 0px">
                                    <img src="${pageContext.request.contextPath}/resources/_assets/images/dashboard-emprendimiento.jpg" alt="Emprendimiento - Mintrabajo - MPC" class="img-fluid">                 
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Card -->
            </div>                  
        </form>
        <!-- Fin contenido -->
        <!-- ---------------------------------------------------- -->

    </div>
    <!-- Fin Container fluid  -->
    <!-- ---------------------------------------------------- -->

</div>
<!-- Fin Page wrapper  -->
<!-- ---------------------------------------------------- -->

<jsp:include page="../layouts/_footer.jsp">
    <jsp:param name="pagina" value="${pagina}"/>
    <jsp:param name="jsItems" value="_dist/js/perfect-scrollbar.jquery.min.js"/>
    <jsp:param name="jsItems" value="_dist/js/waves.min.js"/>
    <jsp:param name="jsItems" value="_dist/js/sidebarmenu.js"/>
    <jsp:param name="jsItems" value="_dist/js/validation.min.js"/>
    <jsp:param name="jsItems" value="_assets/modules/bootstrap-select/bootstrap-select.min.js"/>
    <jsp:param name="jsItems" value="_assets/modules/jquery-mask/jquery.mask.js"/>
    <jsp:param name="jsItems" value="_assets/modules/jquery-ui-1.12.1/jquery-ui.js"/>
    <jsp:param name="jsItems" value="_assets/modules/datatables/datatables.min.js"/>
    <jsp:param name="jsItems" value="_assets/modules/datatables/media/js/dataTables.bootstrap4.min.js"/>
    <jsp:param name="jsItems" value="_assets/modules/moment/moment.min.js"/>
    <jsp:param name="jsItems" value="_assets/modules/fullcalendar/fullcalendar.min.js"/>
    <jsp:param name="jsItems" value="_assets/modules/fullcalendar/locales/es.js"/>
    <jsp:param name="jsItems" value="_assets/modules/bootstrap-datetimepicker/bootstrap-datetimepicker.min.js"/>
    <jsp:param name="jsItems" value="_assets/modules/toastr/toastr.min.js"/>
    <jsp:param name="jsItems" value="_assets/modules/sweetalert/sweetalert.min.js"/>
    <jsp:param name="jsItems" value="_dist/js/custom.js"/>
</jsp:include>
