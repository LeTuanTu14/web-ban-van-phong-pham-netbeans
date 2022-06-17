<%-- 
    Document   : admin
    Created on : May 29, 2021, 11:35:08 AM
    Author     : TUAN TU
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<head>
<title>Trang ADMIN</title>
</head>
<body>
    <h3>Trang quản lý của Admin</h3>
    <br/>
    <div>
        <a href="<c:url value="/user/list"/>">Quản lí tài khoản</a>
    </div>
    <br/>
    <div>
        <a href="<c:url value="/dondathang/list"/>">Quản lí đơn đặt hàng</a>
    </div>
    <br/>
    <div>
        <a href="<c:url value="/loai/list"/>">Quản lí loại sản phẩm</a>
    </div>
    <br/>
    <div>
        <a href="<c:url value="/sanpham/list"/>">Quản lí sản phẩm</a>
    </div>
    <br/>
</body>