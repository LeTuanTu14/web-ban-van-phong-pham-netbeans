<%-- 
    Document   : list-sanphams
    Created on : May 15, 2021, 3:41:13 PM
    Author     : TUAN TU
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Danh sách sản phẩm</title>
        <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
    </head>
    <body>
        <div class="row">
	<div class="span12">
            
	<div class="well well-small">
		<h2>Quản lí Sản Phẩm</h2>
                
                	<form:form action="search" method="GET">
				Tìm Kiếm Sản Phẩm: <input type="text" name="theSearchName" />
				
				<input type="submit" value="Tìm kiếm" class="add-button" />
			</form:form>
                        <!-- put new button: Add SP -->
			<input type="button" value="Thêm Sản Phẩm Mới"
				   onclick="window.location.href='showFormForAdd'; return false;"
                                   class="add-button" style="width: 150px"
			/>
                
	<hr class="soften"/>	

	<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                    <th>Mã SP</th>
                    <th>Hình ảnh</th>
                    <th>Tên SP</th>
                    <th>Loại</th>
                    <th>Số lượng</th>
                    <th>Giá</th>
                    <th></th>
                  
		</tr>
              </thead>
              <tbody>
				<c:forEach var="sanpham" items="${sanphams}">
					<tr>
	                  <td>${sanpham.maSP}</td>
	                  <td><img width="100" src="<c:url value="${sanpham.image}"/>" alt=""></td>
	                  <td>${sanpham.tenSP}</td>
                          <td>${sanpham.loai}</td>
                          <td>${sanpham.soLuong}</td>
                          <td>${sanpham.gia}</td>
                          <c:url var="editUrl" value="/sanpham/showFormForUpdate">
                            <c:param name="maSP" value="${sanpham.maSP}" />
                            </c:url>					
                            <!-- construct an "delete" link with customer id -->
                            <c:url var="deleteUrl" value="/sanpham/delete">
                            <c:param name="maSP" value="${sanpham.maSP}" />
                            </c:url>
                            <c:url var="editCcUrl" value="/sanpham/showFormForUpdate?sanphamId=${sanpham.maSP}" />
                            <c:url var="deleteCcUrl" value="/sanpham/delete?sanphamId=${sanpham.maSP}" />
	                  <td>  
                                <a href="${editUrl}">Cập nhật</a>
							|
                                <a href="${deleteUrl}"
                                onclick="if (!(confirm('Bạn có muốn xóa Sản Phẩm không?'))) return false">Xóa</a>
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
