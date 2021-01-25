<%-- 
    Document   : Layout Bar Top
    Created on : 05/10/2018, 08:15:00 AM
    Author     : Juan C. Pulido to Grow Data PC
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!-- ---------------------------------------------------- -->
<!-- Topbar header - style puede ser encontrado en pages.scss -->
<header class="topbar">
    <nav class="navbar top-navbar navbar-expand-md">

        <!-- ---------------------------------------------------- -->
        <!-- Logo -->
        <div class="navbar-header">
            <a class="navbar-brand" href="${pageContext.request.contextPath}">

                <!-- Logo icon -->
                <b>
                    <img src="${pageContext.request.contextPath}/resources/_assets/images/logo-mpc-thumb.png" alt="Emprende homepage" class="dark-logo" />
                </b>
               
                <!-- Logo text -->
                <span>
                    <img src="${pageContext.request.contextPath}/resources/_assets/images/logo-text.png" alt="Emprende homepage" class="dark-logo" />
                </span> 
            </a>
        </div>
        <!-- End Logo -->
        <!-- ---------------------------------------------------- -->

        <div class="navbar-collapse">

            <!-- ---------------------------------------------------- -->
            <!-- toggle and nav items -->
            <ul class="navbar-nav mr-1">
                <!-- This is  -->
                <li class="nav-item"> <a class="nav-link nav-toggler d-block d-md-none waves-effect waves-dark" href="javascript:void(0)"><i class="ti-menu"></i></a> </li>
                <li class="nav-item"> <a class="nav-link sidebartoggler d-none waves-effect waves-dark" href="javascript:void(0)"><i class="icon-menu"></i></a> </li>           
            </ul>

            <a href="javascript:void(0)" class="logo-gobierno mr-auto" title="Gobierno Colombia - Mintrabajo - MPC">
                <img src="${pageContext.request.contextPath}/resources/_assets/images/logo-mpc.png" alt="Mintrabajo - MPC" class="img-fluid">
                <!--<img src="${pageContext.request.contextPath}/resources/_assets/images/logo-mpc-small.png" alt="Mintrabajo - MPC" class="img-fluid d-block d-md-none">-->
            </a>

            <!-- toggle and nav items -->
            <!-- ---------------------------------------------------- -->

            <ul class="navbar-nav my-lg-0">                                           

                <b class="mt-2 text-primary" style="font-size:15px"><security:authorize access="isAuthenticated()">
                        <security:authentication property="principal.username" /> 
                    </security:authorize></b>

                <li class="nav-item">
                    <a href="javascript:void(0)" class="dropdown-item" aria-expanded="false" data-toggle="modal" data-target="#mCerrarSession" title="Cerrar Sesión"><i class="fa fa-power-off"></i></a>

                </li>
            </ul>
        </div>
    </nav>
</header>
<!-- End Topbar header -->
<!-- ---------------------------------------------------- -->
