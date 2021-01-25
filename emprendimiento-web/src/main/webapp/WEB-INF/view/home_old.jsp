<%-- 
Document   : home
Created on : 30/09/2018, 04:51:12 PM
Author     : ALEJO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>

<!DOCTYPE html>
<html lang="en">
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

        <link href="${pageContext.request.contextPath}/resources/css/dataTables.bootstrap4.css" rel="stylesheet"
              type="text/css" />
        <link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/resources/css/sb-admin.css" rel="stylesheet" type="text/css" />
        <link href="${pageContext.request.contextPath}/resources/css/fullcalendar.min.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/resources/css/mdb.css" rel="stylesheet" type="text/css"/>
        <link href="${pageContext.request.contextPath}/resources/css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css"/>
        <style>
            .loader {
                border: 16px solid #f3f3f3;
                border-radius: 50%;
                border-top: 16px solid #3498db;
                width: 80px;
                height: 80px;
                -webkit-animation: spin 1s linear infinite; /* Safari */
                animation: spin 1s linear infinite;
            }

            /* Safari */
            @-webkit-keyframes spin {
                0% { -webkit-transform: rotate(0deg); }
                100% { -webkit-transform: rotate(360deg); }
            }

            @keyframes spin {
                0% { transform: rotate(0deg); }
                100% { transform: rotate(360deg); }
            }
        </style>
    </head>
    <script>
        var context = '${pageContext.request.contextPath}';
        var beneficiario;

    </script>
    <body class="fixed-nav sticky-footer bg-dark"  id="page-top">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top"
             id="mainNav">
            <a class="navbar-brand" href="home.html"> Emprendimiento </a>
            <button class="navbar-toggler navbar-toggler-right" type="button"
                    data-toggle="collapse" data-target="#navbarResponsive"
                    aria-controls="navbarResponsive" aria-expanded="false"
                    aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>



            <div class="collapse navbar-collapse" id="navbarResponsive" >
                <ul class="navbar-nav navbar-sidenav" id="menuPadre" style="overflow-y: auto;max-height: 600px">



                    <c:forEach items="${formularios}" var="form1">
                        <security:authorize access= "hasRole('${form1.authorities}')">
                            <c:if test="${form1.idformulariopadre==0 }">
                                <li class="nav-item" data-toggle="tooltip" data-placement="right" title="${form1.etiqueta }">
                                    <a class="nav-link nav-link-collapse collapsed" data-toggle="collapse" href="#${form1.posicion}a" data-parent="#menuPadre">
                                        <i class="${form1.iconomenu}"></i>
                                        <span class="nav-link-text">${form1.etiqueta }</span>
                                    </a>
                                    <ul class="sidenav-second-level collapse" id="${form1.posicion}a">
                                        <c:forEach items="${formularios}" var="form2">

                                            <security:authorize access= "hasRole('${form2.authorities}')">
                                                <c:if test="${form2.idformulariopadre==form1.idformulario }">
                                                    <li>
                                                        <a onclick="loadView('${form2.etiqueta }', '${pageContext.request.contextPath}/${form2.urlformulario}')">${form2.etiqueta }</a>
                                                    </li>
                                                </c:if>
                                            </security:authorize>
                                        </c:forEach>
                                    </ul>
                                </li>
                            </c:if>
                        </security:authorize>
                    </c:forEach>
                </ul>

                <ul class="navbar-nav sidenav-toggler">
                    <li class="nav-item"><a class="nav-link text-center"
                                            id="sidenavToggler"> <i class="fa fa-fw fa-angle-left"></i>
                        </a></li>
                </ul>
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item"><a class="nav-link" data-toggle="modal"
                                            data-target="#exampleModal"> <i class="fa fa-fw fa-sign-out"></i>Logout
                        </a></li>
                </ul>
            </div>
        </nav>
        <div class="content-wrapper">
            <div class="container-fluid">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}/">Home</a></li>
                    <li id="idPage" class="breadcrumb-item active">Blank Page</li>
                </ol>
                <div class="row">
                    <div id="body_content" class="col-12">

                    </div>
                </div>
            </div>

            <footer class="sticky-footer">
                <div class="container">
                    <div class="text-center">
                        <small>Copyright © GrowData 2018 V 0.7</small>
                    </div>
                </div>
            </footer>
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fa fa-angle-up"></i>
            </a> 
            <div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
                 aria-labelledby="exampleModalLabel" aria-hidden="true">
                <div class="modal-dialog" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLabel">Cerrar Sesión</h5>
                            <button class="close" type="button" data-dismiss="modal"
                                    aria-label="Close">
                                <span aria-hidden="true">×</span>
                            </button>
                        </div>
                        <div class="modal-body">Realmente deseas cerrar la sesión?</div>
                        <div class="modal-footer">
                            <button class="btn btn-secondary" type="button"
                                    data-dismiss="modal">Cancelar</button>
                            <a class="btn btn-primary" href="${pageContext.request.contextPath}/logout">Salir</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="modal fade" id="modalLoader" tabindex="-1" role="dialog"
                 aria-labelledby="modalLoader" aria-hidden="true">
                <div class="modal-dialog  " role="document">
                    <div class="row justify-content-center">
                        <div class="loader" style="margin-top:30%"></div>
                    </div>
                </div>

            </div>
            <script src="${pageContext.request.contextPath}/resources/js/jquery.js" type="text/javascript"></script>
            <script src="${pageContext.request.contextPath}/resources/js/bootstrap.bundle.min.js" type="text/javascript"></script>
            <script src="${pageContext.request.contextPath}/resources/js/jquery-easing/jquery.easing.min.js"
            type="text/javascript"></script>
            <script src="${pageContext.request.contextPath}/resources/js/fontawesome.js" type="text/javascript"></script>
            <script src="${pageContext.request.contextPath}/resources/js/sb-admin.min.js" type="text/javascript"></script>
            <script src="${pageContext.request.contextPath}/resources/js/services/home.js" type="text/javascript"></script>
            <script src="${pageContext.request.contextPath}/resources/js/fullcalendar.js" type="text/javascript"></script>
            <script src="${pageContext.request.contextPath}/resources/js/locales-all.js" type="text/javascript"></script>
            <script src="${pageContext.request.contextPath}/resources/js/plugins/moment.js" type="text/javascript"></script>
            <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js" type="text/javascript"></script>
            <script src="${pageContext.request.contextPath}/resources/js/mdb.js" type="text/javascript"></script>
            <script src="${pageContext.request.contextPath}/resources/js/bootstrap-datetimepicker.min.js" type="text/javascript"></script>
            <script src="${pageContext.request.contextPath}/resources/js/bootbox.min.js" type="text/javascript"></script>
            <script src="${pageContext.request.contextPath}/resources/js/jquery.mask.js" type="text/javascript"></script>

        </div>

    </body>

</html>