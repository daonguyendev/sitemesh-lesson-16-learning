<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="dec" %>

<c:set var="baseUrl" value="${pageContext.request.contextPath}"/>
<c:set var="staticUrl" value="${baseUrl}/static"/>
<c:set var="layoutUrl" value="/WEB-INF/view/layout"/>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>
        <dec:title></dec:title>
    </title>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${staticUrl}/css/bootstrap.min.css">
    <link rel="stylesheet" href='${staticUrl}/css/style.css'>
</head>

<body>

    <div class="d-flex justify-content-between">
        <!-- SIDE BAR -->
        <jsp:include page="${layoutUrl}/sidebar.jsp"></jsp:include>

        <div id="admin-wrapper">
            <!-- HEADER -->
            <jsp:include page="${layoutUrl}/navbar.jsp"></jsp:include>

            <!-- CONTENT -->
            <!-- Include content of each site here -->
            <dec:body></dec:body>
        </div>
    </div>
    <script src="${staticUrl}/js/jquery.slim.min.js"></script>
    <script src="${staticUrl}/js/popper.min.js"></script>
    <script src="${staticUrl}/js/bootstrap.min.js"></script>
</body>

</html>