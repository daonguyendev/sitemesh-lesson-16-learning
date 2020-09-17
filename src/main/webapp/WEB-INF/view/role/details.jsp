<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:set var="baseUrl" value="${pageContext.request.contextPath}"/>
<c:set var="staticUrl" value="${baseUrl}/static"/>
<c:set var="layoutUrl" value="${baseUrl}/WEB-INF/view/layout"/>

<title>Thông tin quyền</title>

<section id="admin-content" class="p-3">
    <h3 class="mb-4 text-center">Thông tin quyền</h3>
    <form>
        <div class="row">
            <div class="col-md-6 m-auto">
                <div class="form-group">
                    <label>Tên quyền</label>
                    <input type="text" name="name" value="${role.name}" class="form-control" placeholder="name" />
                </div>
                <div class="form-group">
                    <label>Mô tả</label>
                    <input type="text" name="description" value="${role.description}" class="form-control" placeholder="description" />
                </div>
                <div class="form-group">
                    <a class="btn btn-secondary" href="${baseUrl}/role">Quay lại</a>
                </div>
            </div>
        </div>
    </form>
</section>