<%-- 
    Document   : dondathang
    Created on : May 29, 2021, 10:09:29 AM
    Author     : TUAN TU
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<meta charset="UTF-8">
<title>Đặt hàng</title>
</head>
<body>
    <h3>Đơn đặt hàng</h3>
    <c:url var="saveUrl" value="/cart/saveDDH" />
    
    <form:form action="${saveUrl}" modelAttribute="dondh" method="POST">
        <form:hidden path="id" />
        <div class="control-group">
            <label class="control-label" >Họ tên</label>
            <div class="controls">
                <form:input class="span3" path="hoTen" placeholder="Nhập họ tên"/>
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" for="inputEmail">Email</label>
            <div class="controls">
                <form:input class="span3" type="email" path="user" placeholder="Nhập Email User" />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label" >Số điện thoại</label>
            <div class="controls">
                <form:input class="span3" path="sdt" pattern="[(+84)0][0-9]{9}" title="Nhập sai số điện thoại !" placeholder="Nhập số điện thoại" />
                <c:if test="${not empty errSDT}"> 
                    <h5 style="color: red">Nhập số điện thoại !</h5>
                </c:if>
            </div>
        </div>
            <div class="control-group">
            <label class="control-label" >Địa chỉ</label>
            <div class="controls">
                <form:textarea rows="3" cols="30" class="span3" path="diaChi" placeholder="Nhập địa chỉ" />
                <c:if test="${not empty errDC}"> 
                    <h5 style="color: red">Nhập địa chỉ giao hàng !</h5>
                </c:if>
            </div>
        </div>
            <div class="control-group">
            <label class="control-label" >Ghi chú</label>
            <div class="controls">
                <form:textarea rows="3" cols="30" class="span3" path="ghiChu" placeholder="Nhập ghi chú" />
            </div>
        </div>
            <div class="control-group">
            <div class="controls">
                <input type="submit" value="Đăng ký" style="width: 100px"/>
            </div>
        </div>
    </form:form>
</body>