<%-- 
    Document   : Layout Breadcrums
    Created on : 05/10/2018, 08:30:00 AM
    Author     : Juan C. Pulido to Grow Data PC
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

                <!-- ---------------------------------------------------- -->
                <!-- Titulo y Bread crumb -->
                <div class="row page-titles">

                    <div class="col-md-12 align-self-center">
                        <div class="d-flex justify-content-start align-items-center">
                            <ol class="breadcrumb">
                                <li class="breadcrumb-item"><a href="${pageContext.request.contextPath}">Principal</a></li>
                                <li class="breadcrumb-item active" id="idPage"><%= request.getParameter("titulo") %></li>
                            </ol>                       
                        </div>
                    </div>
              <!--
                    <div class="col-md-3 justify-content-end text-right">
                        <button type="button" class="btn btn-info d-none d-lg-block m-r-15"><i class="fa fa-plus-circle"></i> Botón Acción</button>
                    </div>
              -->
                    
                    
                </div>
                <!-- Fin Titulo y Bread crumb -->
                <!-- ---------------------------------------------------- -->