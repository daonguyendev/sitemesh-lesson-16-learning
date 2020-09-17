<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="baseUrl" value="${pageContext.request.contextPath}"/>
<c:set var="staticUrl" value="${baseUrl}/static"/>
<c:set var="layoutUrl" value="${baseUrl}/WEB-INF/view/layout"/>

<title>Danh sách quyền</title>

<section id="admin-content" class="p-3">
    <h3 class="mb-3">Danh sách quyền</h3>
    <div class="row">
        <div class="col-md-8">
            <a href="${baseUrl}/role/add" class="btn btn-primary">Thêm mới</a>
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
                <th>Tên Quyền</th>
                <th>Mô tả</th>
                <th>#</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${roles}" var="role">
                <tr>
                    <td>${role.id}</td>
                    <td>${role.name}</td>
                    <td>${role.description}</td>
                    <td>
                        <a href="${baseUrl}/role/details?id=${role.id}" class="btn btn-sm btn-success">
                            <i class="fa fa-pencil-square-o"></i>Xem
                        </a>
                        <a href="${baseUrl}/role/edit?id=${role.id}" class="btn btn-sm btn-primary">
                            <i class="fa fa-pencil-square-o"></i>Sửa
                        </a>
                        <a href="${baseUrl}/role/remove?id=${role.id}" class="btn btn-sm btn-danger">
                            <i class="fa fa-trash-o"></i>Xóa
                        </a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</section>