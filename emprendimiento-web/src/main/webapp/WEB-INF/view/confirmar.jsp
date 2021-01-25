<%-- 
    Document   : homepage
    Created on : 12/09/2018, 09:27:32 AM
    Author     : Andrés Felipe González Grow Data PC
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<h3>${mensajeTitulo}</h3>
<hr />



<div class="card-body">
    <c:if test="${not empty mensaje}">
        <c:if test="${status=='1'}">
            <div class="alert alert-success"> <i class="fa fa-check-circle"></i> ${mensaje}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
            </div>
        </c:if>
        <c:if test="${status=='0'}">
            <div class="alert alert-danger"> <i class="fas fa-exclamation-circle"></i> ${mensaje}
                <button type="button" class="close" data-dismiss="alert" aria-label="Close"> <span aria-hidden="true">&times;</span> </button>
            </div>
        </c:if>
    </c:if>


</div>

