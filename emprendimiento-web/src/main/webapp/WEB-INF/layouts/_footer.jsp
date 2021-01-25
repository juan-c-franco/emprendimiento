<%-- 
    Document   : Layout Footer
    Created on : 31/10/2018, 23:50:00 AM
    Author     : Juan C. Pulido to Grow Data PC
--%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<c:if test="${param.pagina!='login'}">
    <!-- ---------------------------------------------------- -->
    <!-- footer -->
    <footer class="<c:if test="${param.pagina=='encuesta'}"> footer-encuesta</c:if> <c:if test="${param.pagina!='encuesta'}"> footer</c:if>"> 

        <div class="row text-center">

            <div class="col-md-12 logo-gobierno-footer">
                <h2 class="text-center m-b-10"><img src="${pageContext.request.contextPath}/resources/_assets/images/gobierno-logos.png" alt="Gobierno Colombia - Mintrabajo - MPC" class="img-fluid"></h2>
            </div>

            
            <hr />
            <div class="col-md-12 copyright-top-border text-center">
                Mintrabajo - Derechos Reservados &copy; 2019 V.0.9.18
            </div>
        </div>
    </footer>
    <!-- Fin footer -->
    <!-- ---------------------------------------------------- -->
</c:if>     
<!--</div>-->
<!-- Fin Wrapper -->
<!-- ---------------------------------------------------- -->

<jsp:include page="../layouts/_modals.jsp"/>

<!-- ---------------------------------------------------- -->
<!-- Scripts js - Bootstrap, Jquery, Custom, Page, ...... -->

<script src="${pageContext.request.contextPath}/resources/_assets/modules/jquery/jquery-3.2.1.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/resources/_assets/modules/popper/popper.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/_assets/modules/bootstrap/dist/js/bootstrap.min.js"></script>


<c:if test="${param.jsItems!=''}">
    <c:set var="jsItems" value="${paramValues.jsItems}" />

    <!-- Page JavaScript -->
    <c:forEach items="${jsItems}" var="item">
        <script src="${pageContext.request.contextPath}/resources/${item}"></script>  
    </c:forEach>
</c:if> 

</body>
</html>
