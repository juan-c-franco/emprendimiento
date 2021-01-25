<%-- 
    Document   : Layout Header
    Created on : 31/10/2018, 23:50:00 AM
    Author     : Juan C. Pulido to Grow Data PC
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- Para que el navegador responda al ancho de la pantalla -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title><%= request.getParameter("titulo") %></title>
    
    <!-- Favicon icon -->
    <link rel="icon" type="image/png" sizes="16x16" href="${pageContext.request.contextPath}/resources/_assets/images/favicon.png">

<c:if test="${param.cssItems!=''}">
    <c:set var="cssItems" value="${paramValues.cssItems}" />
    
    <!-- Page CSS -->
    <c:forEach items="${cssItems}" var="item">
        <link href="${pageContext.request.contextPath}/resources/${item}" rel="stylesheet">
    </c:forEach>
</c:if>
    
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resources/_dist/css/style.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->

</head>

<body class="fixed-layout skin-blue-half" id="page-top">
    <script>
        var context = '${pageContext.request.contextPath}';
        var beneficiario;
    </script>
    <!-- ---------------------------------------------------- -->
    <!-- Preloader - spinners.css -->
    <div class="preloader">
        <div class="loader">
            <div class="loader__figure"></div>
            <p class="loader__label">EMPRENDE</p>
        </div>
    </div>

    <!-- ---------------------------------------------------- -->
    <!-- Main wrapper - pages.scss -->
    <div id="main-wrapper">
  