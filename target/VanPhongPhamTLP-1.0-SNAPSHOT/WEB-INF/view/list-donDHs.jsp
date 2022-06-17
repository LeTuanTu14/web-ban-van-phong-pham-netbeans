<%-- 
    Document   : list-donDHs
    Created on : May 29, 2021, 12:00:36 PM
    Author     : TUAN TU
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách đơn đặt hàng</title>
        <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
    </head>
    <body>
        <div class="row">
	<div class="span12">
    
	<div class="well well-small">
		<h2>Quản lí Đơn Đặt Hàng</h2><!--  add a search box -->
			<form:form action="search" method="GET">
				Tìm Kiếm Đơn Đặt Hàng: <input type="text" name="theSearchName" />
				
				<input type="submit" value="Tìm kiếm" class="add-button" />
			</form:form></h2>
	<hr class="soften"/>	

	<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>User</th>
                  <th>Họ và tên</th>
                  <th>Số điện thoại </th>
                  <th>Số lượng </th>
                  <th>Tổng tiền </th>
                  
				</tr>
              </thead>
              <tbody>
			<c:forEach var="ddh" items="${dondathangs}">
                        <tr>
	                  <td>${ddh.id}</td>
	                  <td>${ddh.user}</td>
                          <td>${ddh.hoTen}</td>
                          <td>${ddh.sdt}</td>
                          <td>${ddh.soLuong}</td>
                          <td>${ddh.tongTien}</td>
                          			
	                  <td>  
                                <!-- display the update link -->
                                <a href="<c:url value="/dondathang/xem/${ ddh.id }"/>">Xem chi tiết</a>
							|
                                <a href="<c:url value="/dondathang/delete/${ ddh.id }"/>"
                                onclick="if (!(confirm('Bạn có muốn xóa không?'))) return false">Xóa</a>
	                  </td>
	                </tr>
				</c:forEach>
                        <br/>
                        
		</tbody>
            </table><br/>

</div>
</div>
</div>
    </body>
</html>
