<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="baseUrl" value="${pageContext.request.contextPath}"/>
<c:set var="staticUrl" value="${baseUrl}/static"/>
<c:set var="layoutUrl" value="${baseUrl}/WEB-INF/view/layout"/>

<title>Danh sách thành viên</title>

<section id="admin-content" class="p-3">
    <h3 class="mb-3">Danh sách thành viên</h3>
    <div class="row">
        <div class="col-md-8">
            <a href="${baseUrl}/user/add" class="btn btn-primary">Thêm mới</a>
        </div>
        <div class="col-md-4">
            <div class="input-group">
                <input type="text" class="form-control" placeholder="Tìm kiếm...">
                <div class="input-group-append">
                    <span class="input-group-text" id="basic-addon2"><i class="fa fa-search"></i></span>
                </div>
            </div>
        </div>
    </div>
    <table class="table table-bordered table-hover mt-3">
        <thead>
            <tr>
                <th>ID</th>
                <th>Email</th>
                <th>Password</th>
                <th>FullName</th>
                <th>Address</th>
                <th>Phone</th>
                <th>Avatar</th>
                <th>RoleId</th>
                <th>#</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${users}" var="user">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.email}</td>
                    <td>${user.password}</td>
                    <td>${user.fullName}</td>
                    <td>${user.address}</td>
                    <td>${user.phone}</td>
                    <td>${user.avatar}</td>
                    <td>${user.roleId}</td>
                    <td>
                        <a href="${baseUrl}/user/details?id=${user.id}" class="btn btn-sm btn-success">Xem</a>
                        <a href="${baseUrl}/user/edit?id=${user.id}" class="btn btn-sm btn-primary">Sửa</a>
                        <a href="${baseUrl}/user/remove?id=${user.id}" class="btn btn-sm btn-danger">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>