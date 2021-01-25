<%-- 
    Document   : Layout Sidebar
    Created on : 05/10/2018, 08:00:00 AM
    Author     : Juan C. Pulido para Grow Data PC
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>                                                  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

        <!-- ---------------------------------------------------- -->
        <!-- Left Sidebar - style puede ser encontrado en sidebar.scss  -->
        <aside class="left-sidebar">
            <!-- Sidebar scroll-->
            <div class="scroll-sidebar">
                <!-- Sidebar navigation-->
                <nav class="sidebar-nav">
                    <ul id="menuPadre">                      
                        <li class="nav-big-cap"><i class="mdi mdi-developer-board"></i><span class="hide-menu"> MENÚ</span></li>

                        <c:forEach items="${formularios}" var="form1">
                            <security:authorize access= "hasRole('${form1.authorities}')">
                               
                                <c:if test="${form1.idformulariopadre==0 }">

                                <li>

                                    <a class="has-arrow waves-effect waves-dark" href="#${form1.posicion}a" aria-expanded="false" data-parent="#menuPadre" data-toggle="tooltip" data-placement="top" title="${form1.tooltip}">
                                        <i class="mdi ${form1.iconomenu}"></i>
                                        <span class="hide-menu">${form1.etiqueta } </span>
                                    </a>
                                    <ul aria-expanded="false" class="collapse" id="${form1.posicion}a">

                                        <c:forEach items="${formularios}" var="form2">
                                            <security:authorize access= "hasRole('${form2.authorities}')">
                                                <c:if test="${form2.idformulariopadre==form1.idformulario }">
                                                    <li data-toggle="tooltip" title="${form2.tooltip}">
                                                        <a class="option-menu" data-etiqueta="${form2.etiqueta }" data-ruta="${pageContext.request.contextPath}/${form2.urlformulario}">
                                                            <i class="mdi ${form2.iconomenu}"></i> ${form2.etiqueta }
                                                        </a>
                                                    </li>
                                                </c:if>
                                            </security:authorize>
                                        </c:forEach>

                                    </ul>
                                </li>
                            </c:if>
                            </security:authorize>
                        </c:forEach>
                        <!--<li> <a class="waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false"><i class="mdi mdi-help-circle"></i><span class="hide-menu">Documentación</span></a></li>-->
                        <li> <a class="waves-effect waves-dark" href="javascript:void(0)" aria-expanded="false" data-toggle="modal" data-target="#mCerrarSession"><i class="fa fa-power-off"></i><span class="hide-menu">Cerrar Sesión</span></a></li>
                    </ul>
                    
                </nav>
                <!-- End Sidebar navigation -->
            </div>
            <!-- End Sidebar scroll-->
<!--            <div class="col-md-4 logo-gobierno-footer">
                <h2 class="text-center no-margin"><img src="${pageContext.request.contextPath}/resources/_assets/images/gobierno-logos-footer.png" alt="Gobierno Colombia - Mintrabajo - MPC" class="img-fluid"></h2>
            </div>-->
        </aside>
        <!-- End Left Sidebar - style you can find in sidebar.scss  -->
        <!-- ---------------------------------------------------- -->


