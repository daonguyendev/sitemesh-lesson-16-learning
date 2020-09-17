<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="baseUrl" value="${pageContext.request.contextPath}"/>
<c:set var="staticUrl" value="${baseUrl}/static"/>
<c:set var="layoutUrl" value="${baseUrl}/WEB-INF/view/layout"/>

<title>Thêm mới quyền</title>

<section id="admin-content" class="p-3">
    <h3 class="mb-4 text-center">Thêm mới quyền</h3>
    <form method="post" action="">
        <div class="row">
            <div class="col-md-6 m-auto">
                <div class="form-group">
                    <label>Tên quyền</label>
                    <input type="text" name="name" class="form-control" placeholder="name" />
                </div>
                <div class="form-group">
                    <label>Mô tả</label>
                    <input type="text" name="description" class="form-control" placeholder="description" />
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success">Lưu lại</button>
                    <a class="btn btn-secondary" href="${baseUrl}/role">Quay lại</a>
                </div>
            </div>
        </div>
    </form>
</section>