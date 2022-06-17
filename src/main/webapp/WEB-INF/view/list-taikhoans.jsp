<%-- 
    Document   : list-taikhoans
    Created on : May 28, 2021, 11:03:37 AM
    Author     : TUAN TU
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách tài khoản</title>
        <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
    </head>
    <body>
        <div class="row">
	<div class="span12">
    
	<div class="well well-small">
		<h2>Quản lí Tài Khoản</h2><!--  add a search box -->
			<form:form action="search" method="GET">
				Tìm Kiếm Tài Khoản: <input type="text" name="email" />
				
				<input type="submit" value="Tìm kiếm" class="add-button" />
			</form:form></h2>
	<hr class="soften"/>	

	<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                  <th>ID</th>
                  <th>Email</th>
                  <th>Họ và tên</th>
                  <th>Địa chỉ </th>
                  <th>Xóa </th>
                  
				</tr>
              </thead>
              <tbody>
                  <c:url var="update" value="/resources/img/update.jpg" />
                  <c:url var="delete" value="/resources/img/delete.jpg" />
				<c:forEach var="item" items="${ taikhoans }">
					<tr>
	                  <td>${ item.id }</td>
	                  
	                  <td>${item.email}</td>
                          <td>${item.hoTen}</td>
                          <td>${item.diaChi}</td>
	                  <td>
	                  	<a href="<c:url value="/user/delete/${ item.id }"/>" onclick="if (!(confirm('Bạn có muốn xóa Loại Sản Phẩm không?'))) return false" class="btn btn-mini btn-danger" type="button">
	                  		<img src="${delete}" style="height: 35px; width: 35px"/>
	                  	</a>
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
