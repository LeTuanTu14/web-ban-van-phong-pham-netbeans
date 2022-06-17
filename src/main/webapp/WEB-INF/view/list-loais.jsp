<%-- 
    Document   : list-loais
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
        <title>Danh sách loại sản phẩm</title>
        <link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
    </head>
    <body>
        <div class="row">
	<div class="span12">
            
	<div class="well well-small">
		<h2>Quản lí Loại Sản Phẩm</h2>
                
                	<!--  add a search box -->
			<form:form action="search" method="GET">
				Tìm Kiếm Loại Sản Phẩm: <input type="text" name="theSearchName" />
				
				<input type="submit" value="Tìm kiếm" class="add-button" />
			</form:form>
			<!-- put new button: Add SP -->
			<input type="button" value="Thêm Loại Sản Phẩm Mới"
				   onclick="window.location.href='showFormForAdd'; return false;"
                                   class="add-button" style="width: 180px"
			/>
                
	<hr class="soften"/>	

	<table class="table table-bordered table-condensed">
              <thead>
                <tr>
                    <th>Mã Loại</th>
                    <th>Tên Loại</th>
                    <th>Công dụng</th>
                    <th></th>
				</tr>
              </thead>
              <tbody>
			<c:forEach var="loai" items="${loais}">
					<tr>
	                  <td>${loai.id}</td>
	                  <td>${loai.tenLoai}</td>
                          <td>${loai.congDung}</td>
                          <c:url var="editUrl" value="/loai/showFormForUpdate">
                            <c:param name="loaiId" value="${loai.id}" />
                            </c:url>					
                             <!-- construct an "delete" link with customer id -->
                            <c:url var="deleteUrl" value="/loai/delete">
                            <c:param name="loaiId" value="${loai.id}" />
                            </c:url>
   
                            <c:url var="editCcUrl" value="/loai/showFormForUpdate?id=${loai.id}" />
                            <c:url var="deleteCcUrl" value="/loai/delete?id=${loai.id}" />
	                  <td>  
                                <!-- display the update link -->
                                <a href="<c:url value="/loai/showFormForUpdate/${ loai.id }"/>">Cập nhật</a>
							|
                                <a href="${deleteUrl}"
                                onclick="if (!(confirm('Bạn có muốn xóa Loại Sản Phẩm không?'))) return false">Xóa</a>
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
