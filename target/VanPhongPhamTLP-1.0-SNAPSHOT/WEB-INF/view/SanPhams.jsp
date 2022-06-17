<%-- 
    Document   : SanPhams
    Created on : May 22, 2021, 3:46:48 PM
    Author     : TUAN TU
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<head>
<title>Sản - phẩm</title>
<style>
.pagination {
	display: flex;
	justify-content: center;
}

.pagination a {
	color: black;
	float: left;
	padding: 8px 16px;
	text-decoration: none;
	transition: background-color .3s;
	border: 1px solid #ddd;
}

.pagination a.active {
	background-color: #4CAF50;
	color: white;
	border: 1px solid #4CAF50;
}

.pagination a:hover:not (.active ) {
	background-color: #ddd;
}
</style>
</head>
<body>
	<div class="well well-small">
		<div class="row">
                    <h3><span style="margin-left: 25px;">Danh sách sản phẩm</span> </h3>
		</div>

		<c:if test="${sanphams.size() > 0}">
			<div class="row-fluid">
                            <ul class="thumbnails" >

					<c:forEach var="sp" items="${sanphams}" varStatus="loop">
						<li class="span4" style="width: 280px">
							<div class="thumbnail">
								<a href="<c:url value="/chitietsanpham/${sp.maSP}"/>" class="overlay"></a> <a
									class="zoomTool" href="<c:url value="/chitietsanpham/${sp.maSP}"/>"
									title="add to cart"> Xem chi tiết
									 </a> <a href="<c:url value="/chitietsanpham/${sp.maSP}"/>"> <img
                                                                                src="<c:url value="${sp.image}"/>" alt="" style="height: 300px; width: 300px"></a>
								<div class="caption cntr">
									<p>${sp.tenSP}</p>
									<p>
										<strong><p>${sp.gia} đ</p></strong>
									</p>
									<h4>
										<a class="shopBtn" href="<c:url value="/cart/add/${sp.maSP}"/>" title="add to cart"> Thêm giỏ hàng </a>
									</h4>
									
									<br class="clr">
								</div>
							</div>
						</li>

                                    </c:forEach>
                                </ul>
		</c:if>
                <c:if test="${sanphams.size() <= 0}">
                    Không có sản phẩm
                </c:if>
	</div>
        </div>
</body>
</html>