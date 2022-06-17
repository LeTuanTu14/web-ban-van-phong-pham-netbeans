<%-- 
    Document   : loai-form
    Created on : May 15, 2021, 3:40:53 PM
    Author     : TUAN TU
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
<head>

<title>Loại Sản Phẩm</title>
<link type="text/css"
    rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/form-style.css">
</head>
</head>
<body>
<div id="wrapper">
        <div id="header">
                <h2>Quản lí Loại Sản Phẩm</h2>
        </div>
    </div>
<div id="container">
            <h3>Thêm Loại Sản Phẩm</h3>

<c:url var="saveUrl" value="/loai/saveLoai" />

<c:if test="${not empty errLoai}"> 
                    <h5 style="color: red">Nhập tên Loại Sản Phẩm !</h5>
</c:if>
<form:form modelAttribute="loai" method="POST" action="${saveUrl}">
     <form:hidden path="id" />
 
 <table>
  <tr>
   <td><form:label path="tenLoai">Tên Loại:</form:label></td>
   <td><form:input path="tenLoai" size="50"/></td>
  </tr>

  <tr>
   <td><form:label path="congDung">Công dụng</form:label></td>
   <td><form:textarea rows="3" cols="30" path="congDung" size="50"/></td>
  </tr>
 </table>
  <br>
  <br>
 <input type="submit" value="Save" style="width: 250px"/>
</form:form>
<div ></div>
    <p>
    <a href="${pageContext.request.contextPath}/loai/list">Back to List</a>
    </p>
 </div>
</body>
</html>

