<%-- 
    Document   : sanpham-form
    Created on : May 15, 2021, 3:40:13 PM
    Author     : TUAN TU
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html >
<html>
<head>

<title>Thêm Sản Phẩm</title>
<link type="text/css"
    rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/style.css">
    <link type="text/css" rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/form-style.css">
</head>
<body>

<div id="wrapper">
        <div id="header">
                <h2>Quản lí Sản Phẩm</h2>
        </div>
    </div>
<div id="container">
            <h3>Thêm Sản Phẩm</h3>

<c:url var="saveUrl" value="/sanpham/saveSanPham" />

<c:if test="${not empty errSP}"> 
                    <h5 style="color: red">Nhập đầy đủ thông tin Sản Phẩm !</h5>
</c:if>
<form:form modelAttribute="sanpham" method="POST" action="${saveUrl}" enctype="multipart/form-data">
     <form:hidden path="maSP" />
 
 <table>
  <tr>
   <td><form:label path="tenSP">Tên Sản Phẩm:</form:label></td>
   <td><form:input path="tenSP" size="50"/></td>
  </tr>
  
  <tr>
   <td><form:label path="image">Hình ảnh:</form:label></td>
   <td><input type="file" name="photo" size="50"/></td>
  </tr>

  <tr>
   <td><form:label path="loai">Loại</form:label></td>
  <td>
      <form:select path="loai">  
          <c:forEach items="${loais}" var="loai">
              <form:option value="${loai.tenLoai}" label="${loai.tenLoai}"/> 
          </c:forEach>
      </form:select>
  </td>
  </tr>
  
  <tr>
   <td><form:label path="soLuong">Số Lượng</form:label></td>
   <td><form:input path="soLuong" size="50" pattern="[0-9]+" title="Nhập sai số lượng !"/></td>
  </tr>
  
  <tr>
   <td><form:label path="moTa">Mô tả</form:label></td>
   <td><form:textarea rows="3" cols="30" path="moTa" size="50"/></td>
  </tr>
  
  <tr>
   <td><form:label path="gia">Giá</form:label></td>
   <td><form:input path="gia" size="50" pattern="[0-9]+(.0)*" title="Nhập sai giá !"/></td>
  </tr>
  
  <tr>
   <td><form:label path="spHot">Sản phẩm Hot</form:label></td>
   <td>Bán chạy <form:radiobutton path="spHot" value="True"/>  
       Không bán chạy <form:radiobutton path="spHot" value="False"/>  </td>
  </tr>
  
  <tr>
   <td><form:label path="spNew">Sản phẩm</form:label></td>
   <td>Mới <form:radiobutton path="spNew" value="True"/>  
        Cũ <form:radiobutton path="spNew" value="False"/></td>
  </tr>
 </table>
  <br>
        <input type="submit" value="Save" style="width: 250px"/>
</form:form>
<div ></div>
    <p>
    <a href="${pageContext.request.contextPath}/sanpham/list">Back to List</a>
    </p>
 </div>
</body>
</html>
